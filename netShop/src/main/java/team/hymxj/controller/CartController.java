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
	 * 添加到购物车(首页+1/详情页+n)
	 * @param session
	 * @param productId
	 * @return
	 */
	@RequestMapping(value="addCart.do",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String addCart(HttpSession session,@RequestParam("productId")Integer productId,@RequestParam("quantity")Integer quantity){
		User user=(User) session.getAttribute("loginUser");
		if(user==null){
			return "错误，请先登录";
		}
		Boolean isOk=cartService.addCart(user.getId(),productId,quantity);
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
		return "order/cart.jsp";
	}
	
	/**
	 * 更新购物车中商品数量(+/-按钮,每次变1)
	 * @param session
	 * @param cartId
	 * @param newQuantity
	 * @return
	 */
	@RequestMapping(value="updateQuantity.do",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String updateQuantity(HttpSession session,Integer cartId,Boolean isAdd){
		User user=(User)session.getAttribute("loginUser");
		if(user==null){
			return "用户未登陆";
		}else{
			Integer number=cartService.changeQuantity(cartId,1,isAdd);
			return number.toString();
		}
	}
	/**
	 * 删除当前行
	 * @param cartId
	 * @return
	 */
	@RequestMapping("deleteCart.do")
	@ResponseBody
	public String delelteCart(Integer cartId){
		Boolean isOk=cartService.deleteCart(cartId);
		if(isOk){
			return "";
		}else{
			return "删除失败"; 
		}
	}
	/**
	 * 删除选中的项
	 * @param request
	 * @return
	 */
	@RequestMapping(value="deleteSelectedItem.do")
	public String deleteSelectedItem(HttpServletRequest request){
		User user=(User) request.getSession().getAttribute("loginUser");
		if(user==null){
			request.setAttribute("loginError","亲爱的用户，您刚才掉线了。");
			return "user/login.jsp";
		}
		cartService.deleteCartByUser(user.getId());
		List<DisplayCart> list=cartService.findCartByUserId(user.getId());
		request.setAttribute("cartData",list);
		return "order/cart.jsp";
	}
	
	@RequestMapping("changeSelect.do")
	@ResponseBody
	public String changeSelect(Integer cartId){
		System.out.println(cartId);
		cartService.changeCheck(cartId);
		return "";
	}
	
	/**
	 * 全选/全不选
	 * @param request
	 * @param isSelectAll
	 * @return
	 */
	@RequestMapping("selectAllOrNot.do")
	@ResponseBody
	public String selectAll(HttpServletRequest request,Boolean isSelectAll){
		User user=(User) request.getSession().getAttribute("loginUser");
		cartService.changeAllCheck(user.getId(),isSelectAll);
		if(isSelectAll){
			return "1";
		}else{
			return "0";
		}
	}
}
