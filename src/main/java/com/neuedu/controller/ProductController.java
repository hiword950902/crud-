package com.neuedu.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.neuedu.pojo.Product;
import com.neuedu.service.IproductService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

@Controller
public class ProductController {
	
	@Resource
	private IproductService service;
	
    @RequestMapping("/list.do") 
	public String list(ModelMap map) {
    	List<Product> products=service.getProducts();
    	map.addAttribute("products", products);
    	return "list";
     }
    @RequestMapping(value="/add.do",method=RequestMethod.GET)
    public String goAdd() {
		
    	return "add";	
    }
    @RequestMapping(value="/add.do",method=RequestMethod.POST)
    public String doAdd(HttpServletRequest request, Product product,MultipartFile logo) throws IllegalStateException, IOException {
    	String path= "http://192.168.80.132/static/resource/img/";
    	Date date=new Date();
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
    	StringBuilder fileName =new StringBuilder(sdf.format(date));
    	for(int i=0;i<4;i++) {
    		Random r=new Random();
    		String str=String.valueOf(r.nextInt(10));
    		fileName.append(str);
    	}
    	fileName.append(".").append(FilenameUtils.getExtension(logo.getOriginalFilename()));
    	String url=path+fileName.toString();
    	Client client=new Client();
    	WebResource resource = client.resource(url);
    	resource.put(String.class, logo.getBytes());
    	product.setImgurl(fileName.toString());
    	service.add(product);
//    	File file=new File(path+logo.getOriginalFilename());
//    	logo.transferTo(file);
//    	product.setImgurl("img/"+logo.getOriginalFilename());
//		service.add(product);
    	return "redirect:list.do";	
    }
    
    @RequestMapping(value="/update.do",method=RequestMethod.GET)
    public String goUpdate(int id,ModelMap map) {
    	Product product=service.getProductById(id);
    	map.addAttribute("product", product);
		return "edit";    	
    }
    @RequestMapping(value="/update.do",method=RequestMethod.POST)
    public String goUpdate(Product product,HttpServletRequest request,MultipartFile logo) throws IllegalStateException, IOException {
    	String path= request.getServletContext().getRealPath("/img/");
    	File file=new File(path+logo.getOriginalFilename());
    	logo.transferTo(file);
    	product.setImgurl("img/"+logo.getOriginalFilename());
		service.update(product);
    	return "redirect:list.do";	   	
    }
    
    @RequestMapping(value="/del.do")
    public String del(int id) {
    	service.del(id);
		return "redirect:list.do";    	
    }
    
}
