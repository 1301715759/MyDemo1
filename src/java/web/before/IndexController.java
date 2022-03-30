package web.before;

import entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.before.IndexService;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @Autowired
    private IndexService indexService;

    @RequestMapping("/before")
    public String before(Model model, HttpSession session, Goods goods) {
        return indexService.before(model, session, goods);
    }

    @RequestMapping("/goodsDetail")
    public String goodsDetail(Model model,Integer id) {
        return indexService.goodsDetail(model, id);
    }

    @RequestMapping("/search")
    public String search(Model model,String key) {
        return indexService.search(model, key);
    }
}
