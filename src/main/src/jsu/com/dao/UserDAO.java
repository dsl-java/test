package jsu.com.dao;

import jsu.com.Util.DBUtils;
import jsu.com.bean.User;

public class UserDAO {
    //保存注册对象
    public boolean saveUser(User user) {
        String sql="insert into tb_user(username,password)" +
                " values(?,?)";
        return DBUtils.save(sql,user.getUsername(),user.getPassword());
    }

    //查询是否有该用户
    public Integer selectUserCount(String Username) {
        String sql = "SELECT COUNT(*) FROM tb_user a WHERE a.username =?";
        Integer count = DBUtils.getCount(sql,Username);
        return count;
    }

    //根据用户名和密码查询用户
    public User getUserByUsernameAndPass(String username, String password) {

        String sql = "SELECT id, username, password FROM tb_user \n" +
                "WHERE username = ? AND password = ?";

        return DBUtils.getSingleObj(User.class,sql,username,password);
    }

    //根据用户ID查询该用户
    public User getUserInfoById(Integer userID) {
        String sql = "SELECT id, username, password FROM tb_user \n" +
                "WHERE id= ?";
        User user = DBUtils.getSingleObj(User.class,sql,userID);
        return user;
    }

    //根据ID修改密码
    public boolean updatePassword(User user){
        String sql="update tb_user set password=? where id=?";
        boolean flag=DBUtils.update(sql,user.getPassword(),user.getId());
        return flag;
    }
}
