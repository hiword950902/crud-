package com.neuedu.service;

import java.util.List;

import com.neuedu.pojo.Product;

public interface IproductService {
	   public List<Product> getProducts();
	   public int add(Product product);
	   public int update(Product product);
	   public int del(int id);
	   public Product getProductById(int id);
}
