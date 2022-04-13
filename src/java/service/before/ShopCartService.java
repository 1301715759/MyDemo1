package service.before;

import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface ShopCartService {
    public String focus(Model model, Integer id, HttpSession session);

    public String addCart(Model model, Integer buyCount, Integer id, HttpSession session);
    public String selectCart(Model model, HttpSession session);
    public String deleteAgoods(Integer id,HttpSession session);
    public String deleteAllGoods(HttpSession session);
}
