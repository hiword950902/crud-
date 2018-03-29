package com.neuedu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.ProductDao;
import com.neuedu.pojo.Product;

@Service
public class ProductServiceImpl implements IproductService{

	@Autowired
	private ProductDao dao;
	
	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return dao.getProducts();
	}

	@Override
	public int add(Product product) {
		// TODO Auto-generated method stub
		return dao.add(product);
	}

	@Override
	public int update(Product product) {
		// TODO Auto-generated method stub
		return dao.update(product);
	}

	@Override
	public int del(int id) {
		// TODO Auto-generated method stub
		return dao.del(id);
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return dao.getProductById(id);
	}

}
