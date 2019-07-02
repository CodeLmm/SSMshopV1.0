package cn.gdcp.core.service;

import java.util.List;

import cn.gdcp.core.po.Product;

public interface ProductService {

	public List<Product> findHotProducts();

	public List<Product> findNewProducts();

}
