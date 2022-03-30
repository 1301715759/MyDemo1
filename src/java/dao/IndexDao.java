package dao;

import entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("indexDao")
@Mapper
public interface IndexDao {
    public Goods selectGoodsById(Integer id);
    public List<Goods> search(String key);
    public List<Map<String, Object>> getLastedGoods(Goods goods);
}
