package dao;

import entity.Goods;
import entity.GoodsType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("adminTypeDao")
@Mapper
public interface AdminTypeDao {
    public List<GoodsType> selectGoodsType();
    public int addType(String typename);
    public int deleteType(Integer id);
    public List<Goods> selectGoodsByType(Integer id);
}
