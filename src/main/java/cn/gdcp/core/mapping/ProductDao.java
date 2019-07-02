package cn.gdcp.core.mapping;

import java.util.List;

import cn.gdcp.core.po.Product;

public interface ProductDao {

	public List<Product> findHotProducts();

	public List<Product> findNewProducts();

}
