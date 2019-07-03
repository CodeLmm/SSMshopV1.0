package cn.gdcp.core.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.gdcp.core.po.Product;

public interface ProductDao {

	public List<Product> findHotProducts();

	public List<Product> findNewProducts();

	//public List<Product> findAllProductByCid(int cid);

	public int findProductNumByCid(int cid);

	public List<Product> findAllProductByCid(@Param("cid")int cid, @Param("i")int i, @Param("j") int j);

}
