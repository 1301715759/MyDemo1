package service.before;

import dao.ShopCartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

@Service("cartService")
@Transactional
public class ShopCartServicempl implements ShopCartService {
    @Autowired
    private ShopCartDao shopCartDao;

    @Override
    public String focus(Model model, Integer id, HttpSession session) {
        return null;
    }

    @Override
    public String addCart(Model model, Integer buyCount, Integer id, HttpSession session) {
        return null;
    }

    @Override
    public String selectCart(Model model, HttpSession session) {
        return null;
    }

    @Override
    public String deleteAgoods(Integer id, HttpSession session) {
        return null;
    }

    @Override
    public String deleteAllGoods(HttpSession session) {
        return null;
    }
}
