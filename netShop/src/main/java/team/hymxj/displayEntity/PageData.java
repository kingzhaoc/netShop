package team.hymxj.displayEntity;

import java.util.List;

public class PageData {
	private Integer currentPage;
	private Integer maxPage;
	private Integer currentProductCount;
	private Integer categoryId;
	private String name;
	public List<DisplayProduct> productList;
	
	
	public PageData(Integer currentPage, Integer maxPage,Integer currentProductCount,Integer categoryId,String name){
		super();
		this.currentPage = currentPage;
		this.maxPage = maxPage;
		this.categoryId = categoryId;
		this.name = name;
		this.currentProductCount = currentProductCount;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public List<DisplayProduct> getProductList() {
		return productList;
	}
	
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public void setProductList(List<DisplayProduct> productList) {
		this.productList = productList;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(Integer maxPage) {
		this.maxPage = maxPage;
	}
	public Integer getCurrentProductCount() {
		return currentProductCount;
	}
	public void setCurrentProductCount(Integer currentProductCount) {
		this.currentProductCount = currentProductCount;
	}
	
	
}
