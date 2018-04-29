package team.hymxj.utils;

import java.util.ArrayList;
import java.util.List;

import team.hymxj.displayEntity.DisplayProduct;
import team.hymxj.entity.Product;

public class ProductUtil {
	public static final DisplayProduct covertToDisplayProduct(Product product){
		Integer id=product.getId();
		Integer categoryId=product.getCategoryId();
		String name=product.getName();
		String subTitle=product.getSubTitle();
		String mainImage=product.getMainImage();
		Double price=product.getPrice();
		DisplayProduct displayProduct=new DisplayProduct(id,categoryId,name,subTitle,mainImage,price);
		return displayProduct;
	}
	public static final List<DisplayProduct> covertToDisplayProductList(List<Product> products){
		List<DisplayProduct> newProducts=new ArrayList<DisplayProduct>();
		for (Product product : products) {
			DisplayProduct newProduct=covertToDisplayProduct(product);
			newProducts.add(newProduct);
		}
		return newProducts;
	}
}
