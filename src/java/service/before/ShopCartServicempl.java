package service.before;

import dao.ShopCartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import util.MyUtil;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("cartService")
@Transactional
public class ShopCartServicempl implements ShopCartService {
    @Autowired
    private ShopCartDao shopCartDao;

    @Override
    //关注
    public String focus(Model model, Integer id, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uid", MyUtil.getUserId(session));
        map.put("gid",id);
        List<Map<String, Object>> list = shopCartDao.isFocus(map);
        if(list.size() > 0) {
            model.addAttribute("msg", "已关注过了!");
        }else {
            int n = shopCartDao.focus(map);
            if(n > 0)
                model.addAttribute("msg", "成功关注该商品！");
            else
                model.addAttribute("msg", "关注失败！");
        }
        return "forward:/goodsDetail?id=" + id;
    }

    @Override
    //添加购物车
    public String addCart(Model model, Integer buyCount, Integer id, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uid", MyUtil.getUserId(session));
        map.put("gid", id);
        map.put("buyCount", buyCount);

        List<Map<String, Object>> list = shopCartDao.isAddCart(map); //购物车list
        List<Map<String, Object>> goodsCount = shopCartDao.goodsCount(map); //商品库存量Count

        if((Integer)goodsCount.get(0).get("gstore") < buyCount) { //比较库存数量和购买数量
            model.addAttribute("msg", "购买数量不能大于库存最大值");
            return "forward:/goodsDetail?id=" + id;
        }
        else {
            if(list.size() > 0) //如果购物车里已经有该商品，则增加对应数量
                shopCartDao.updateCart(map);
            else
                shopCartDao.addCart(map);
            return "forward:/cart/selectCart";
        }
        //return null;
    }

    @Override
    //购物车界面 总计
    public String selectCart(Model model, HttpSession session) {
        List<Map<String, Object>> list = shopCartDao.selectCart(MyUtil.getUserId(session));
        double sum = 0;
        //统计购物车总价格
        for (Map<String, Object> map : list) {
            if (map.get("smallsum") != null)
                sum = sum + (Double)map.get("smallsum");
        }

        model.addAttribute("total", sum);
        model.addAttribute("cartlist", list);
        return "before/cart";
    }

    @Override
    //购物车界面 删除一个商品
    public String deleteAgoods(Integer id, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uid", MyUtil.getUserId(session));
        map.put("gid", id);
        shopCartDao.deleteAgoods(map);

        return "forward:/cart/selectCart";
    }

    @Override
    public String deleteAllGoods(HttpSession session) {
        shopCartDao.deleteAllgoods(MyUtil.getUserId(session));
        return "forward:/cart/selectCart";
    }
}
