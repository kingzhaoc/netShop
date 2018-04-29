package team.hymxj.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.hymxj.dao.CartDao;
import team.hymxj.dao.ProductDao;
import team.hymxj.displayEntity.DisplayCart;
import team.hymxj.entity.Cart;
import team.hymxj.entity.Product;
import team.hymxj.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	public CartDao cartDao;
	@Autowired
	public ProductDao productDao;
	
	public Boolean addCart(Integer userId, Integer productId,Integer quatity) {
		Cart cartExists=cartDao.getCartByUserAndProduct(userId, productId);
		Boolean isSuccess=false;
		if(cartExists==null){
			Cart cart=new Cart();
			cart.setUserId(userId);
			cart.setProductId(productId);
			cart.setQuantity(quatity);
			cart.setChecked(1);
			isSuccess=cartDao.insertCart(cart);
		}else{
			Integer quantity=cartExists.getQuantity();
			quantity+=quantity;
			isSuccess=cartDao.updateQuantityById(cartExists.getId(),quantity);
		}
		return isSuccess;
	}

	public List<DisplayCart> findCartByUserId(Integer userId) {
		List<Cart> carts=cartDao.getCartsByUserId(userId);
		List<DisplayCart> cartsTemp=new ArrayList<DisplayCart>();
		for (Cart cart : carts) {
			Product product=productDao.getProductById(cart.getProductId());
			DisplayCart newCart=new DisplayCart(product.getName(),product.getMainImage(),cart);;
			cartsTemp.add(newCart);
		}
		return cartsTemp;
	}

	public Boolean changeQuantity(Integer id, Integer newQuantity) {
		Boolean isSuccess=cartDao.updateQuantityById(id,newQuantity);
		return isSuccess;
	}

	public Boolean deleteCart(Integer id) {
		Boolean isSuccess=cartDao.deleteCartById(id);
		return isSuccess;
	}
	public Boolean  changeCheck(Integer id,Integer check){
		Boolean isSuccess=cartDao.updateCheck(id, check);
		return isSuccess;
	}

}
