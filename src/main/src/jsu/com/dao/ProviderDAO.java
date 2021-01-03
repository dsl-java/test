package jsu.com.dao;

import jsu.com.Util.DBUtils;
import jsu.com.bean.Provider;

import java.util.List;

public class ProviderDAO {

    //查询供应商基本信息，返回集合
    public List<Provider> getProviderLsit(String sql){

        List<Provider> providers= DBUtils.getList(Provider.class,sql);
        return  providers;
    }

    //查询供应商基本信息，返回集合，根据ID查询
    public List<Provider> getProviderLsit(Integer id){
        String sql="select provider_id providerId,provider_name providerName,provider_address providerAddress," +
                "provider_tel providerTel FROM tb_goods_provider  where provider_id=?";
        List<Provider> providers=DBUtils.getList(Provider.class,sql,id);

        return  providers;
    }

    //保存插入的供应商对象
    public boolean saveProvider(Provider provider) {
        String sql="insert into tb_goods_provider(provider_name,provider_address,provider_tel)" +
                " values(?,?,?)";
        return DBUtils.save(sql,provider.getProviderName(),provider.getProviderAddress(),provider.getProviderTel());
    }

    //根据供应商ID查找
    public Provider getProviderById(Integer providerID) {
        String sql="select provider_id providerId,provider_name providerName,provider_address providerAddress," +
                "provider_tel providerTel  FROM tb_goods_provider where provider_id=?";
        Provider provider = DBUtils.getSingleObj(Provider.class,sql,providerID);
        return provider;
    }

    //删除对象
    public boolean deleteProvider(Provider provider){
        String sql="delete from tb_goods_provider where provider_id=?";

        boolean flag=DBUtils.delete(sql,provider.getProviderId());

        return flag;
    }

    //修改对象(根据ID修改)
    public boolean updateProvider(Provider provider){
        String sql="update tb_goods_provider set provider_name=?,provider_address=?,provider_tel=? where provider_id=?";
        boolean flag=DBUtils.update(sql,provider.getProviderName(),provider.getProviderAddress(),
                provider.getProviderTel(),provider.getProviderId());
        return flag;
    }

}
