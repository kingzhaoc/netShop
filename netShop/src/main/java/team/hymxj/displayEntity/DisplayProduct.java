package team.hymxj.displayEntity;

public class DisplayProduct {
	private Integer id;
	private Integer categoryId;
	private String name;
	private String subTitle;
	private String mainImage;
	private Double price;
	public DisplayProduct(){}
	public DisplayProduct(Integer id, Integer categoryId, String name,String subTitle, String mainImage,
			double price) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.subTitle = subTitle;
		this.mainImage = mainImage;
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "DisplayProduct [id=" + id + ", categoryId=" + categoryId + ", name=" + name + ", subTitle=" + subTitle
				+ ", mainImage=" + mainImage + ", price=" + price + "]";
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public String getMainImage() {
		return mainImage;
	}
	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
