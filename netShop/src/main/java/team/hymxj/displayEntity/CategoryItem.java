package team.hymxj.displayEntity;

import java.util.ArrayList;
import java.util.List;

public class CategoryItem {
	private Integer categoryId;
	private String categoryName;
	public List<DisplayProduct> products;
	public List<DisplayProduct> getProducts() {
		return products;
	}
	public CategoryItem(){
		products=new ArrayList<DisplayProduct>();
	}
	public CategoryItem(Integer categoryId,String categoryName){
		this.categoryId=categoryId;
		this.categoryName=categoryName;
		products=new ArrayList<DisplayProduct>();
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
