package team.hymxj.service;

import java.util.List;
import team.hymxj.displayEntity.DisplayCart;

public interface CartService {
	public Boolean addCart(Integer userId,Integer productId,Integer quantity);
	public List<DisplayCart> findCartByUserId(Integer userId);
	public Boolean changeQuantity(Integer id,Integer newQuantity);
	public Boolean deleteCart(Integer id);
}
