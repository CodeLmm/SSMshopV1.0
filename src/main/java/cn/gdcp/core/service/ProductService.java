package cn.gdcp.core.service;

import java.util.List;

import cn.gdcp.core.po.Page;
import cn.gdcp.core.po.Product;

public interface ProductService {

	public List<Product> findHotProducts();

	public List<Product> findNewProducts();

	public int findProductNumByCid(int cid);

	public Page<Product> findAllProductByCid(String cid , int currPageNO);

	public Product findProductByPid(int pid);
	
	

}
