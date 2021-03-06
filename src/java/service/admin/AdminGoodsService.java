package service.admin;

import entity.Goods;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

public interface AdminGoodsService {
    public String selectAGoods(Model model, Integer id, String act);
    public String deleteGoods(Integer ids[], Model model);
    public String deleteAGoods(Integer id, Model model);
    public String addOrUpdateGoods(Goods goods, HttpServletRequest request, String updateAct);
    public String selectGoods(Model model, Integer pageCur, String act);
}
