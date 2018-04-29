package team.hymxj.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import team.hymxj.entity.Product;

public interface ProductDao {

	public List<Product> getLimitProductByCategoryId(Integer id);
	public Set<String> getPromtByWords(String keywords); 
	public List<Product> getHotProduct();
	public Product getProductById(Integer id);
	public List<Product> getProductByWordsHelper(@Param("words")String words,@Param("start")Integer start,@Param("length")Integer length);
	public List<Product> getProductByCategoryHelper(@Param("categoryId")Integer categoryId,@Param("start")Integer start,@Param("length")Integer length);
	public Integer getCountByWords(String words);
	public Integer getCountByCategoryId(Integer id);
	public boolean deleteProductById(Integer id);
	public boolean updateProduct(Product product);
	public boolean insertProduct(Product product);
}
