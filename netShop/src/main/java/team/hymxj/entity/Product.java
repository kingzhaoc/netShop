package team.hymxj.entity;

import java.util.Date;

public class Product {
	private Integer id;
	private Integer categoryId;
	private String name;
	private String subTitle;
	private String mainImage;
	private String subImages;
	private String detail;
	private Double price;
	private Integer stock;
	private Integer status;
	private Date createTime;
	private Date updateTime;
	public Product(){}
	public Product(Integer id, Integer categoryId, String name, String subTitle, String mainImage, String subImages,
			String detail, Double price, Integer stock, Integer status, Date createTime, Date updateTime) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.subTitle = subTitle;
		this.mainImage = mainImage;
		this.subImages = subImages;
		this.detail = detail;
		this.price = price;
		this.stock = stock;
		this.status = status;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getSubImages() {
		return subImages;
	}
	public void setSubImages(String subImages) {
		this.subImages = subImages;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", categoryId=" + categoryId + ", name=" + name + ", subTitle=" + subTitle
				+ ", mainImage=" + mainImage + ", subImages=" + subImages + ", detail=" + detail + ", price=" + price
				+ ", stock=" + stock + ", status=" + status + ", createTime=" + createTime + ", updateTime="
				+ updateTime + "]";
	}
	
	
}
