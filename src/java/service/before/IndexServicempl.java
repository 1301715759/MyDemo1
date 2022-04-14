package service.before;

import dao.AdminTypeDao;
import dao.IndexDao;
import entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service("indexService")
@Transactional
public class IndexServicempl implements IndexService{
    @Autowired
    private IndexDao indexDao;
    @Autowired
    private AdminTypeDao adminTypeDao;

    @Override
    public String before(Model model, HttpSession session, Goods goods) {
        session.setAttribute("goodsType", adminTypeDao.selectGoodsType());
        if(goods.getId() == null)
            goods.setId(0);
        if(goods.getStatus() == 1) {
            model.addAttribute("lastedlist", indexDao.getLastedGoods(goods));
        }
        return "before/index";
    }

    @Override
    public String search(Model model, String key) {
        List<Goods> list = indexDao.search(key);
        model.addAttribute("searchlist", list);
        return "before/searchResult";
    }

    @Override
    public String goodsDetail(Model model, Integer id) {
        Goods goods = indexDao.selectGoodsById(id);
        model.addAttribute("goods", goods);
        return "before/goodsdetail";
    }
}
