package team.hymxj.displayEntity;

import team.hymxj.entity.Cart;

public class DisplayCart {
	private String name;
	private String mainImage;
	private Cart cart;
	public DisplayCart(){}
	public DisplayCart(String name,String mainImage,Cart cart) {
		super();
		this.mainImage = mainImage;
		this.name = name;
		this.cart = cart;
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
