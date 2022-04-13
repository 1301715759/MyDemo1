package dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("/ShopCartDao")
@Mapper
public interface ShopCartDao {
    public int focus(Map<String, Object> map);
    public List<Map<String, Object>> isFocus(Map<String, Object> map);

    public int addCart (Map<String, Object> map);
    public List<Map<String, Object>> isPutCart(Map<String, Object> map);
    public int updateCart (Map<String, Object> map);
    public List<Map<String, Object>> selectCart(Integer id);

    public int deleteAgoods (Map<String, Object> map);
    public int deleteAllgoods(Integer id);
    public List<Map<String, Object>> goodsCount(Map<String, Object> map);
}
