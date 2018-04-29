package team.hymxj.serviceTest;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import team.hymxj.displayEntity.CategoryItem;
import team.hymxj.displayEntity.DetailProduct;
import team.hymxj.displayEntity.PageData;
import team.hymxj.entity.Product;
import team.hymxj.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"}) 
public class ProductServiceImplTest {

	@Autowired
	public ProductService productService;
	@Test
	public void testFindProductsToHomePage() {
		List<CategoryItem> lists=productService.findProductsToHomePage();
		System.out.println(lists.get(0).getProducts());
		for (CategoryItem categoryItem : lists) {
			System.out.println(categoryItem.getProducts().size());
		}
	}

	@Test
	public void testFindProductToDetailPage() {
		DetailProduct product=productService.findProductToDetailPage(26);
		System.out.println(product);
	}

	@Test
	public void testFindProductsByWordsOrCategory() {
		/*PageData page1=productService.findProductsByWordsOrCategory(1,"",0,0);
		System.out.println("current:"+page1.getCurrentPage()+"  max:"+page1.getMaxPage()+"  currentnum:"+page1.getCurrentProductCount()+"  size:"+page1.productList.size());*/
		/*PageData page3=productService.findProductsByWordsOrCategory(-1,"水",0,0);
		System.out.println("current:"+page3.getCurrentPage()+"  max:"+page3.getMaxPage()+"  currentnum:"+page3.getCurrentProductCount()+"  size:"+page3.productList.size());*/
		PageData page1=productService.findProductsByWordsOrCategory(1,"",4);
		System.out.println("current:"+page1.getCurrentPage()+"  max:"+page1.getMaxPage()+"  currentnum:"+page1.getCurrentProductCount()+"  size:"+page1.productList.size());
		PageData page3=productService.findProductsByWordsOrCategory(-1,"水",0);
		System.out.println("current:"+page3.getCurrentPage()+"  max:"+page3.getMaxPage()+"  currentnum:"+page3.getCurrentProductCount()+"  size:"+page3.productList.size());
		
	}

	@Test
	public void testFindPromptByWords() {
		List<String> list=productService.findPromptByWords("u");
		for (String string : list) {
			System.out.println(string);
		}
	}

	@Test
	public void testInsertProduct() {

		Product product=new Product();
		product.setCategoryId(100003);
		product.setName("小米max2s");
		product.setSubTitle("为发烧而生");
		product.setMainImage("hello.jpg");
		product.setSubImages("hello.jpg");
		product.setDetail("<a>只要2999<a>");
		product.setPrice(2999.0);
		product.setStock(700);
		product.setStatus(1);
		Boolean ok=productService.insertProduct(product);
		System.out.println(ok);
	}

	@Test
	public void testUpdateProduct() {
		Product product=new Product();
		product.setId(30);
		product.setCategoryId(100003);
		product.setName("小米max2s");
		product.setSubTitle("为发烧而生!");
		product.setMainImage("hello.jpg");
		product.setSubImages("hello.jpg");
		product.setDetail("<a>只要2999<a>");
		product.setPrice(2999.0);
		product.setStock(700);
		product.setStatus(1);
		Boolean ok=productService.updateProduct(product);
		System.out.println(ok);
	}

	
	
	

}
