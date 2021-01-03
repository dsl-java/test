package jsu.com.dao;

import jsu.com.Util.DBUtils;
import jsu.com.bean.GoodsBasicInfo;

import java.util.List;

public class GoodsBasicInfoDAO {

    //查询商品基本信息，返回集合
    public List<GoodsBasicInfo> getGoodsBasicInfoLsit(String sql){

        List<GoodsBasicInfo> goodsBasicInfos=DBUtils.getList(GoodsBasicInfo.class,sql);

        return  goodsBasicInfos;
    }

    //查询商品基本信息，返回集合
    public List<GoodsBasicInfo> getGoodsBasicInfoLsit(Integer id){
        String sql="select goods_id goodsId,goods_name goodsName,goods_type goodsType,goods_stock goodsStock," +
                "goods_price goodsPrice,provider_id provider_id FROM tb_goods_basicinfo  where goods_id=?";
        List<GoodsBasicInfo> goodsBasicInfos=DBUtils.getList(GoodsBasicInfo.class,sql,id);

        return  goodsBasicInfos;
    }

    //保存插入的商品对象
    public boolean saveGoodsBasicInfo(GoodsBasicInfo goodsBasicInfo) {
        String sql="insert into tb_goods_basicinfo(goods_name,goods_type,goods_stock,goods_price,provider_id)" +
                " values(?,?,?,?,?)";
        return DBUtils.save(sql,goodsBasicInfo.getGoodsName(),goodsBasicInfo.getGoodsType(),goodsBasicInfo.getGoodsStock(),
                goodsBasicInfo.getGoodsPrice(),goodsBasicInfo.getProvider_id());
    }

    //根据商品ID查找
    public GoodsBasicInfo getGoodsBasicInfoById(Integer goodsID) {
        String sql="select goods_id goodsId,goods_name goodsName,goods_type goodsType,goods_stock goodsStock," +
                "goods_price goodsPrice,provider_id provider_id FROM tb_goods_basicinfo where goods_id=?";
        GoodsBasicInfo goodsBasicInfo = DBUtils.getSingleObj(GoodsBasicInfo.class,sql,goodsID);
        return goodsBasicInfo;
    }

     //删除对象
    public boolean deleteGoodsBasicInfo(GoodsBasicInfo goodsBasicInfo){
        String sql="delete from tb_goods_basicinfo where goods_id=?";

        boolean flag=DBUtils.delete(sql,goodsBasicInfo.getGoodsId());

        return flag;
    }

     //修改对象(根据ID修改)
    public boolean updateGoodsBasicInfo(GoodsBasicInfo goodsBasicInfo){
        String sql="update tb_goods_basicinfo set goods_name=?,goods_type=?,goods_stock=?,goods_price=?,provider_id=? where goods_id=?";
        boolean flag=DBUtils.update(sql,goodsBasicInfo.getGoodsName(),goodsBasicInfo.getGoodsType(),goodsBasicInfo.getGoodsStock(),
                goodsBasicInfo.getGoodsPrice(),goodsBasicInfo.getProvider_id(),goodsBasicInfo.getGoodsId());
        return flag;
    }

}
