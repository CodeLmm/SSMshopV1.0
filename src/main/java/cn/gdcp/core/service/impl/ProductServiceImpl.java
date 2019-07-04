package cn.gdcp.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gdcp.core.mapping.ProductDao;
import cn.gdcp.core.po.Page;
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

	public int findProductNumByCid(int cid){
		return this.productDao.findProductNumByCid(cid);
	}

	@Override
	public Page<Product> findAllProductByCid(String baseCid , int currPageNO) {
		int cid = Integer.parseInt(baseCid);
		Page page = new Page();
		int allNum = this.productDao.findProductNumByCid(cid);
		System.out.println(allNum);
		int perNum = 6 ;
		int allPageNO = allNum/perNum;
		
		/*int currPageNO = */
		List<Product> products= this.productDao.findAllProductByCid(cid , currPageNO*6+1 , 6);		
		System.out.println(products);
		page.setList(products);
		page.setCurrPageNO(currPageNO);
		page.setAllPageNO(allPageNO);
		page.setPerNum(perNum);
		
		return page;
	}

	@Override
	public Product findProductByPid(int pid) {
		return this.productDao.findProductByPid(pid);
	}
	

}
