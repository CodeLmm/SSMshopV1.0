package cn.gdcp.core.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.io.SegmentedStringWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.gdcp.core.po.Page;
import cn.gdcp.core.po.Product;
import cn.gdcp.core.service.ProductService;

@Controller

public class ProductController {
	@Autowired
    private ProductService productService;
	
	@RequestMapping("/findHotNewProduct")
	public String findHotNewProduct(HttpServletRequest request) {
		System.out.println(1);
		List<Product> hotProducts = this.productService.findHotProducts();
		List<Product> newProducts = this.productService.findNewProducts();
		request.setAttribute("HOT_PRODUCT_LIST",hotProducts);
		request.setAttribute("NEW_PRODUCT_LIST", newProducts);
		/*redirectAttributes.addFlashAttribute("HOT_PRODUCT_LIST",hotProducts);
		redirectAttributes.addFlashAttribute("NEW_PRODUCT_LIST", newProducts);*/
		return "index";
//		return "redirect:/product/findHotNewProduct";
	}
	
	@RequestMapping("/findAllProductByCid")
	public String findAllProductByCid(String cid , String currPageNO , HttpServletRequest request) {
		
		int currPageNOBase;
		if(currPageNO==null){
			currPageNOBase = 1;
		}else{
			currPageNOBase = Integer.parseInt(currPageNO);
		}
		System.out.println(currPageNOBase);
		Page<Product> pageBean = this.productService.findAllProductByCid(cid , currPageNOBase);
		request.setAttribute("PAGE_BEAN", pageBean);
		return "product_list";
	}
	
	@RequestMapping("/findProductByPid")
	public String findProductByPid(int pid , Model model){
		Product product = this.productService.findProductByPid(pid);
	    model.addAttribute("PRODUCT", product);
		return "product_info";
	}
	
}
