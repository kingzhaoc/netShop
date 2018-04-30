package team.hymxj.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartRequest;
import team.hymxj.displayEntity.CategoryItem;
import team.hymxj.displayEntity.DetailProduct;
import team.hymxj.displayEntity.PageData;
import team.hymxj.entity.Product;
import team.hymxj.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	public ProductService productService;
	
	/**
	 * 为首页提供商品集合
	 * @param request
	 * return 主页
	 */
	@RequestMapping(value="listProduct.do")
	public String listProduct(HttpServletRequest request) {
		List<CategoryItem> items=productService.findProductsToHomePage();
		request.setAttribute("homePageData",items);
		return "home.jsp";
	}
	@RequestMapping(value="productDetail.do")
	public String productDetail(HttpServletRequest request,Integer productId) {
		DetailProduct product=productService.findProductToDetailPage(productId);
		request.setAttribute("detailData",product);
		return "product/product_detail.jsp";
	}
	/**
	 * 进入商品分类列表页面
	 * @param request
	 * @param categoryId
	 * @return
	 */
	@RequestMapping(value="showMore.do")
	public String showMore(HttpServletRequest request,Integer categoryId) {
		PageData categoryPageData=productService.findProductsByWordsOrCategory(categoryId,"",-5);
		request.setAttribute("pageData",categoryPageData);
		if(categoryPageData!=null){
		String categoryName=categoryPageData.getName();
		request.setAttribute("name",categoryName);
		}
		return "product/product_list.jsp";
	}
	
	@RequestMapping(value="changePageWithCategory.do")
	public String changePageWithCategory(HttpServletRequest request,Integer categoryId,Integer newPage) {
		PageData categoryPageData=productService.findProductsByWordsOrCategory(categoryId,"",newPage);
		request.setAttribute("pageData",categoryPageData);
		if(categoryPageData!=null){
		String categoryName=categoryPageData.getName();
		request.setAttribute("name",categoryName);
		}
		return "product/product_list.jsp";
	}
	
	/**
	 * 按照关键字搜索。
	 * @param request
	 * @param keyword
	 * @return
	 */
	@RequestMapping(value="searchProducts.do")
	public String showSearchProducts(HttpServletRequest request,String keyword) {
		PageData categoryPageData=productService.findProductsByWordsOrCategory(-1,keyword,-5);
		request.setAttribute("pageData",categoryPageData);
		request.setAttribute("name",keyword);
		return "product/product_list.jsp";
	}
	
	@RequestMapping(value="changePageWithKeyword.do")
	public String changePageWithKeyword(HttpServletRequest request,String keyword,Integer newPage) {
		PageData categoryPageData=productService.findProductsByWordsOrCategory(-1,keyword,newPage);
		request.setAttribute("pageData",categoryPageData);
		request.setAttribute("name",keyword);
		return "product/product_list.jsp";
	}
	
	/**
	 * 搜索框智能提醒
	 * @param keyword
	 * @return 数组 json
	 */
	@RequestMapping(value="returnTips.do",produces="application/json")
	@ResponseBody
	public List<String> returnTips(String keyword) {
		List<String> list=productService.findPromptByWords(keyword);
		return list;
	}
	
	/**
	 * 添加产品
	 * @param product
	 * @return
	 */
	@RequestMapping(value="addProduct.do")
	public String addProduct(Product product) {
		productService.insertProduct(product);
		return "insertProduct_success.jsp";
	}
	
	@RequestMapping(value="uploadPictrue.do",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String uploadPictrue(HttpServletRequest request,MultipartRequest pictrues){
		String filepath=request.getServletContext().getRealPath("/upload");
		Boolean isSuccess=productService.uploadPictrue(filepath,pictrues);
		if(isSuccess)
			return "";
		else
			return "文件上传失败";
	}
}
