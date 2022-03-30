package service.before;

import entity.Goods;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface IndexService {
    public String before(Model model,HttpSession session, Goods goods);
    public String search(Model model,String key);

    public String goodsDetail(Model model,Integer id);
}
