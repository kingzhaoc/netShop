package team.hymxj.controller;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import team.hymxj.displayEntity.DisplayCart;
import team.hymxj.entity.User;
import team.hymxj.service.CartService;

@Controller
public class CartController {
	
	@Autowired
	public CartService cartService;
	
	/**
	 * 添加到购物车
	 * @param session
	 * @param productId
	 * @return
	 */
	@RequestMapping("addCart.do")
	@ResponseBody
	public String addCart(HttpSession session,@RequestParam("productId")Integer productId,@RequestParam("quantity")Integer quantity){
		User user=(User) session.getAttribute("loginUser");
		if(user==null){
			return "错误，请先登录";
		}
		Boolean isOk=cartService.addCart(user.getId(), productId,quantity);
		if(isOk){
			return "";
		}else{
			return "添加购物车失败";
		}
	}
	/**
	 * 查看购物车
	 * @param request
	 * @return
	 */
	@RequestMapping("lookCart.do")
	public String lookCart(HttpServletRequest request){
		User user=(User) request.getSession().getAttribute("loginUser");
		if(user==null){
			request.setAttribute("loginFail","亲爱的用户,请先登录！");
			return "user/login.jsp";
		}
		List<DisplayCart> list=cartService.findCartByUserId(user.getId());
		request.setAttribute("cartData",list);
		return "cart/cartDetail.jsp";
	}
	
	/**
	 * 更新购物车中商品数量
	 * @param session
	 * @param cartId
	 * @param newQuantity
	 * @return
	 */
	@RequestMapping("updateQuantity.do")
	@ResponseBody
	public String updateQuantity(HttpSession session,Integer cartId,Integer newQuantity){
		User user=(User)session.getAttribute("loginUser");
		if(user==null){
			return "用户未登陆";
		}else{
			Boolean isOk=cartService.changeQuantity(cartId,newQuantity);
			if(isOk)
				return "";
			else
				return "操作失败,请稍后再试";
		}
	}
}
