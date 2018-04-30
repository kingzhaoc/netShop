package team.hymxj.service;

import java.util.List;
import team.hymxj.displayEntity.DisplayCart;

public interface CartService {
	public Boolean addCart(Integer userId,Integer productId,Integer quantity);
	public List<DisplayCart> findCartByUserId(Integer userId);
	public Integer changeQuantity(Integer id,Integer changeCount,Boolean isAdd);
	public Boolean deleteCart(Integer id);
	public Boolean deleteCartByUser(Integer userId);
	public Boolean  changeCheck(Integer id);
	public Boolean changeAllCheck(Integer userId,Boolean isSelectAll);
}
