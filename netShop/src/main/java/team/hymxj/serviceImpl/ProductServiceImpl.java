package team.hymxj.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import team.hymxj.dao.CategoryDao;
import team.hymxj.dao.ProductDao;
import team.hymxj.displayEntity.CategoryItem;
import team.hymxj.displayEntity.DetailProduct;
import team.hymxj.displayEntity.DisplayProduct;
import team.hymxj.displayEntity.PageData;
import team.hymxj.entity.Category;
import team.hymxj.entity.Product;
import team.hymxj.service.ProductService;
import team.hymxj.utils.ProductUtil;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	public ProductDao productDao;
	@Autowired
	public CategoryDao categoryDao;
	public static final Integer MAX_CURRENT_NUMBER=8;
	/**
	 * 为主页加载数据
	 */
	public List<CategoryItem> findProductsToHomePage() {
		List<CategoryItem> items=new ArrayList<CategoryItem>();
		List<Category> categories=categoryDao.findAllCategory();
		CategoryItem hotItem=new CategoryItem();
		hotItem.setCategoryId(-1);
		hotItem.setCategoryName("");
		List<Product> hotProduct=productDao.getHotProduct();
		for (Product product : hotProduct) {
			DisplayProduct displayProduct=ProductUtil.covertToDisplayProduct(product);
			hotItem.products.add(displayProduct);
		}
		items.add(hotItem);
		for (Category category : categories) {
			CategoryItem newItem=new CategoryItem();
			newItem.setCategoryId(category.getId());
			newItem.setCategoryName(category.getName());
			List<Product> products=productDao.getLimitProductByCategoryId(category.getId());
			for (Product product : products) {
				DisplayProduct displayProduct=ProductUtil.covertToDisplayProduct(product);
				newItem.products.add(displayProduct);
			}
			items.add(newItem);
		}
		return items;
	}
	
	/**
	 * 为产品详情准备数据
	 */
	public DetailProduct findProductToDetailPage(Integer id) {
		Product product=productDao.getProductById(id);
		if(product==null){
			return null;
		}else{
			String[] images=product.getSubImages().split(",");
			DetailProduct detailProduct;
			if(images.length>=0)
				detailProduct=new DetailProduct(images[0],images,product);
			else 
				detailProduct=new DetailProduct("",images,product);
			return detailProduct;
		}
	}
	
	/**
	 * 按照关键字/类型查询,返回分页数据。
	 */
	public PageData findProductsByWordsOrCategory(Integer categroyId,String words,Integer currentPage) {
		Integer size=0;//满足条件的商品数量
		if(categroyId==-1){
			 size=productDao.getCountByWords(words);
		}else{
			 size=productDao.getCountByCategoryId(categroyId);
		}
		Integer maxPageNumber=0;//该数量可以最多可以放多少页
		if(size%MAX_CURRENT_NUMBER==0){
			maxPageNumber=size/MAX_CURRENT_NUMBER;
		}else{
			maxPageNumber=size/MAX_CURRENT_NUMBER+1;
		}
		if(maxPageNumber==0){//说明没数据直返回
			return null;
		}
		//越界处理
		if(currentPage>maxPageNumber){
			currentPage=maxPageNumber;
		}else if(currentPage<=0&&currentPage>-2){
			currentPage=1;
		}
		//第一次请求数据，只需将第一页的东西返回。
		if(currentPage==-5){
			Integer currentProductCount=0;
			if(MAX_CURRENT_NUMBER>size){
				currentProductCount=size;
			}else{
				currentProductCount=MAX_CURRENT_NUMBER;
			}
			String categoryName=categoryDao.getNameById(categroyId);
			PageData page=new PageData(1, maxPageNumber,currentProductCount,categroyId,categoryName);
			List<Product> productList=null;
			if(categroyId==-1){
				productList=productDao.getProductByWordsHelper(words,0,currentProductCount);
			}else{
				productList=productDao.getProductByCategoryHelper(categroyId,0,currentProductCount);
			}
			page.productList=ProductUtil.covertToDisplayProductList(productList);
			return page;
		}else{//响应用户跳页操作，把第n页的数据返回
			Integer startNumber=(currentPage-1)*MAX_CURRENT_NUMBER;
			Integer currentProductCount=0;
			if(startNumber+MAX_CURRENT_NUMBER>size){
				currentProductCount=size-startNumber;		
			}else{
				currentProductCount=MAX_CURRENT_NUMBER;
			}
			PageData page=null;
			List<Product> productList=null;
			if(categroyId==-1){
				 page=new PageData(currentPage, maxPageNumber,currentProductCount,-1,words);
				 productList=productDao.getProductByWordsHelper(words,startNumber,currentProductCount);
			}else{
				String categoryName=categoryDao.getNameById(categroyId);
				page=new PageData(currentPage, maxPageNumber,currentProductCount,categroyId,categoryName);
				productList=productDao.getProductByCategoryHelper(categroyId,startNumber,currentProductCount);
			}
			page.productList=ProductUtil.covertToDisplayProductList(productList);
			return page;
		}
	}
	
	/*
	 *获取智能搜索提示
	 */
	public List<String> findPromptByWords(String words) {
		if(words==null||words.equals("")){
			return null;
		}
		else{
			Set<String> promtSet=productDao.getPromtByWords(words);
			return new ArrayList<String>(promtSet);
		}
	}
	
	public Boolean insertProduct(Product product) {
		product.setStatus(1);
		Boolean isOk=productDao.insertProduct(product);
		return isOk;
	}
	public Boolean updateProduct(Product product) {
		Boolean isOk=productDao.updateProduct(product);
		return isOk;
	}

	/**
	 * 上传图片
	 */
	public Boolean uploadPictrue(String filePath,MultipartRequest pictures) {
		HashMap<String, MultipartFile> map=(HashMap<String, MultipartFile>)pictures.getFileMap();
		Set<String> keys=map.keySet();
		try {
			for(String thisKey:keys){
				MultipartFile picture=map.get(thisKey);
				String OriginalFilename=picture.getOriginalFilename();
				String newFileName=UUID.randomUUID()+OriginalFilename;
				File newFile=new File(filePath+"\\"+newFileName);
				picture.transferTo(newFile);
			}
		} catch (IllegalStateException e) {
			return false; 
		} catch (IOException e) {
			return false;
		}
		return true;
	}
}
