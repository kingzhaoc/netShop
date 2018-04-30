package team.hymxj.displayEntity;

import java.text.DecimalFormat;

import team.hymxj.entity.Cart;

public class DisplayCart {
	private String name;
	private String subTitle;
	private String mainImage;
	private Double singlePrice;
	private Double sumPrice;
	private Cart cart;
	public DisplayCart(){}
	public DisplayCart(String name, String subTitle, String mainImage, Double singlePrice, Double sumPrice, Cart cart) {
		super();
		this.name = name;
		this.subTitle = subTitle;
		this.mainImage = mainImage;
		this.singlePrice = singlePrice;
		this.sumPrice = sumPrice;
		this.cart = cart;
	}
	public Double getSinglePrice() {
		DecimalFormat format=new DecimalFormat("##.00");
		return Double.valueOf(format.format(singlePrice));
	}
	public void setSinglePrice(Double singlePrice) {
		this.singlePrice = singlePrice;
	}
	public Double getSumPrice() {
		DecimalFormat format=new DecimalFormat("##.00");
		return Double.valueOf(format.format(sumPrice));
	}
	public void setSumPrice(Double sumPrice) {
		this.sumPrice = sumPrice;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	@Override
	public String toString() {
		return "DisplayCart [mainImage=" + mainImage + ", name=" + name + ", cart=" + cart + "]";
	}
	
}
