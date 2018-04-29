package team.hymxj.service;

import java.util.List;
import org.springframework.web.multipart.MultipartRequest;

import team.hymxj.displayEntity.CategoryItem;
import team.hymxj.displayEntity.DetailProduct;
import team.hymxj.displayEntity.PageData;
import team.hymxj.entity.Product;

public interface ProductService {
	public List<CategoryItem> findProductsToHomePage();
	public DetailProduct findProductToDetailPage(Integer id);
	public PageData findProductsByWordsOrCategory(Integer categroyId,String words,Integer currentPage);
	public List<String> findPromptByWords(String words);
	public Boolean insertProduct(Product product);
	public Boolean updateProduct(Product product);
	public Boolean uploadPictrue(String filePath,MultipartRequest pictures);
}
