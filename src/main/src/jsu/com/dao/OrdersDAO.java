package jsu.com.dao;

import jsu.com.Util.DBUtils;
import jsu.com.bean.Orders;
import jsu.com.bean.Provider;

import java.util.List;

public class OrdersDAO {
    //查询供应商基本信息，返回集合
    public List<Orders> getOrdersLsit(String sql){

        List<Orders> ordersList= DBUtils.getList(Orders.class,sql);

        return  ordersList;
    }

    //查询供应商基本信息，返回集合根据ID查询
    public List<Orders> getOrdersLsit(Integer id){

        String sql="SELECT order_id orderId, order_type orderType, trader trade, " +
                "order_goods_id orderGoodsId, order_count orderCount FROM tb_goods_order where order_id=? ";

        List<Orders> ordersList=DBUtils.getList(Orders.class,sql,id);
        return  ordersList;
    }

    //保存插入的订单对象
    public boolean saveOrders(Orders orders) {
        String sql="insert into tb_goods_order(order_type,trader,order_goods_id,order_count)" +
                " values(?,?,?,?)";
        return DBUtils.save(sql,orders.getOrderType(),orders.getTrade(),orders.getOrderGoodsId(),orders.getOrderCount());
    }
}
