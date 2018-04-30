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
	
	/**
	 * 添加商品到购物车
	 */
	public Boolean addCart(Integer userId, Integer productId,Integer quantity) {
		Cart cartExists=cartDao.getCartByUserAndProduct(userId,productId);
		Boolean isSuccess=false;
		if(cartExists==null){
			Cart cart=new Cart();
			cart.setUserId(userId);
			cart.setProductId(productId);
			cart.setQuantity(quantity);
			cart.setChecked(0);
			isSuccess=cartDao.insertCart(cart);
		}else{
			Integer newQuantity=cartExists.getQuantity();
			quantity+=newQuantity;
			isSuccess=cartDao.updateQuantityById(cartExists.getId(),quantity);
		}
		return isSuccess;
	}

	/**
	 * 增加/减少数量
	 */
	public Integer changeQuantity(Integer id,Integer changeCount,Boolean isAdd) {
		Cart cart=cartDao.getCartById(id);
		if(cart==null){
			return 0;
		}
		//Product product=productDao.getProductById(cart.getProductId());
		//System.out.println(product);
		//Integer stock=product.getStock();
		/*与库存做越界处理*/
		/*if(stock<cart.getQuantity()+changeCount&&isAdd==true){
			return false;
		}else*/
		Integer newQuantity=cart.getQuantity();
		if(isAdd){
			newQuantity+=changeCount;
		}else{
			newQuantity-=changeCount;
		}
		if(newQuantity<1&&isAdd==false){
			newQuantity=1;
		}
		cartDao.updateQuantityById(id,newQuantity);
		return newQuantity;
	}
	
	/**
	 * 查看购物车
	 */
	public List<DisplayCart> findCartByUserId(Integer userId) {
		List<Cart> carts=cartDao.getCartsByUserId(userId);
		List<DisplayCart> cartsTemp=new ArrayList<DisplayCart>();
		for (Cart cart : carts) {
			Product product=productDao.getProductById(cart.getProductId());
			DisplayCart newCart=new DisplayCart(product.getName(),product.getSubTitle(),product.getMainImage(),product.getPrice(),product.getPrice()*cart.getQuantity(),cart);
			cartsTemp.add(newCart);
		}
		return cartsTemp;
	}
	
	/**
	 * 删除一项
	 */
	public Boolean deleteCart(Integer id) {
		Boolean isSuccess=cartDao.deleteCartById(id);
		return isSuccess;
	}
	/**
	 * 删除用户选中的项
	 */
	public Boolean deleteCartByUser(Integer userId){
		Boolean isSuccess=cartDao.deleteCartByUserId(userId);
		return isSuccess;
	}
	
	/*改变选中状态*/
	public Boolean  changeCheck(Integer id){
		Cart cart=cartDao.getCartById(id);
		if(cart==null){
			return false;
		}
		Integer check=cart.getChecked();
		if(check==1){
			check=0;
		}else{
			check=1;
		}
		Boolean isSuccess=cartDao.updateCheck(id,check);
		return isSuccess;
	}
	
	/**
	 * 全选/全反选
	 * @param userId
	 * @param isSelectAll
	 * @return
	 */
	public Boolean changeAllCheck(Integer userId,Boolean isSelectAll){
		Integer check=0;
		if(isSelectAll){
			check=1;
		}
		Boolean isSuccess=cartDao.updateAllCheckByUserId(userId,check);
		return isSuccess;
	}
	

}
