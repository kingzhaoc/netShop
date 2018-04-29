package team.hymxj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import team.hymxj.entity.Cart;

public interface CartDao {
	public Boolean insertCart(Cart cart);
	public Cart getCartByUserAndProduct(@Param("userId")Integer userId,@Param("ProductId")Integer productId);
	public List<Cart> getCartsByUserId(Integer id);
	public Boolean updateQuantityById(@Param("id")Integer id,@Param("quantity")Integer quantity);
	public Boolean deleteCartById(Integer id);
	public Boolean updateCheck(@Param("id")Integer id,@Param("check")Integer check);
}
