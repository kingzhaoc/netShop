package team.hymxj.displayEntity;

import java.util.Arrays;
import java.util.Date;

import team.hymxj.entity.Product;

public class DetailProduct {
	private String mainImage;
	private String[] subImages;
	private Product product;
	public DetailProduct(){}
	public DetailProduct(String mainImage,String[] subImages, Product product) {
		super();
		this.mainImage=mainImage;
		this.subImages=subImages;
		this.product = product;
	}
	public Product getProduct() {
		return product;
	}
	public Integer getId() {
		return product.getId();
	}
	public Integer getCategoryId() {
		return product.getCategoryId();
	}
	public String getName() {
		return product.getName();
	}
	public String getSubTitle() {
		return product.getSubTitle();
	}
	public String getMainImage() {
		return mainImage;
	}
	public String getDetail() {
		return product.getDetail();
	}
	public Double getPrice() {
		return product.getPrice();
	}
	public Integer getStock() {
		return product.getStock();
	}
	public Integer getStatus() {
		return product.getStatus();
	}
	public Date getCreateTime() {
		return product.getCreateTime();
	}
	public Date getUpdateTime() {
		return product.getUpdateTime();
	}
	public String[] getSubImages() {
		return subImages;
	}
	public void setSubImages(String[] subImages) {
		this.subImages = subImages;
	}
	@Override
	public String toString() {
		return "DetailProduct [mainImage=" + mainImage + ", subImages=" + Arrays.toString(subImages) + ", product="
				+ product + "]";
	}
	
}
