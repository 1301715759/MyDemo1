package service.admin;

import dao.AdminTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
@Service("adminTypeService")
@Transactional
public class AdminTypeServicempl implements AdminTypeService{
    @Autowired
    private AdminTypeDao adminTypeDao;

    @Override
    public String addType(String typename, Model model, HttpSession session) {
        adminTypeDao.addType(typename);
        session.setAttribute("goodsType", adminTypeDao.selectGoodsType());
        return "forward:/adminType/toAddType";
    }

    @Override
    public String toAddType(Model model) {
        model.addAttribute("allTypes", adminTypeDao.selectGoodsType());
        return "admin/addType";
    }

    @Override
    public String deleteType(Integer id, Model model) {
        if(adminTypeDao.selectGoodsByType(id).size() > 0) {
            model.addAttribute("msg", "该类型已有物品，不允许删除");
            return "forward:/adminType/toDeleteType";
        }
        if(adminTypeDao.deleteType(id) > 0)
            model.addAttribute("msg", "删除成功！");
        return "forward:/adminType/toDeleteType";
    }

    @Override
    public String toDeleteType(Model model) {
        model.addAttribute("allTypes", adminTypeDao.selectGoodsType());
        return "admin/deleteType";
    }
}
