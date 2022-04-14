package web.before;

import dao.ShopCartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.before.ShopCartService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class ShopCartController {
    @Autowired
    private ShopCartService shopCartService;
    //关注商品
    @RequestMapping("/focus")
    public String focus(Model model, Integer id, HttpSession session) {
        return shopCartService.focus(model, id, session);
    }
    //购物车添加商品
    @RequestMapping("/addCart")
    public String putCart(Model model,Integer shoppingnum, Integer id, HttpSession session) {
        return shopCartService.addCart(model, shoppingnum, id, session);
    }
    //查询购物车
    @RequestMapping("/selectCart")
    public String selectCart(Model model, HttpSession session) {
        return shopCartService.selectCart(model, session);
    }
    //清空指定商品
    @RequestMapping("/deleteAgoods")
    public String deleteAgoods(Integer id,HttpSession session) {
        return shopCartService.deleteAgoods(id, session);
    }
    //清空所有商品
    @RequestMapping("/deleteAllGoods")
    public String deleteAllGoods(HttpSession session) {
        return shopCartService.deleteAllGoods(session);
    }
}
