package cn.gdcp.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gdcp.core.mapping.ProductDao;
import cn.gdcp.core.po.Product;
import cn.gdcp.core.service.ProductService;
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
	private ProductDao productDao;
	
	@Override
	public List<Product> findHotProducts() {
		List<Product> hotProducts = this.productDao.findHotProducts();
		return hotProducts;
	}

	@Override
	public List<Product> findNewProducts() {
		List<Product> newProducts = this.productDao.findNewProducts();
		return newProducts;
	}

}
