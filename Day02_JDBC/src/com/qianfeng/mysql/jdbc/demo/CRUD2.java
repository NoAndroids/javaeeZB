package com.qianfeng.mysql.jdbc.demo;

//                            _ooOoo_  
//                           o8888888o  
//                           88" . "88  
//                           (| -_- |)  
//                            O\ = /O  
//                        ____/`---'\____  
//                      .   ' \\| |// `.  
//                       / \\||| : |||// \  
//                     / _||||| -:- |||||- \  
//                       | | \\\ - /// | |  
//                     | \_| ''\---/'' | |  
//                      \ .-\__ `-` ___/-. /  
//                   ___`. .' /--.--\ `. . __  
//                ."" '< `.___\_<|>_/___.' >'"".  
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |  
//                 \ \ `-. \_ __\ /__ _/ .-` / /  
//         ======`-.____`-.___\_____/___.-`____.-'======  
//                            `=---='  
//  
//         .............................................  
//                  佛祖镇楼                  BUG辟易  
//          佛曰:  
//                  写字楼里写字间，写字间里程序员；  
//                  程序人员写程序，又拿程序换酒钱。  
//                  酒醒只在网上坐，酒醉还来网下眠；  
//                  酒醉酒醒日复日，网上网下年复年。  
//                  但愿老死电脑间，不愿鞠躬老板前；  
//                  奔驰宝马贵者趣，公交自行程序员。  
//                  别人笑我忒疯癫，我笑自己命太贱；  
//  


import com.qianfeng.mysql.jdbc.pojo.User;
import com.qianfeng.mysql.jdbc.utils.DBUtils;
import org.junit.Test;

import java.sql.*;
import java.util.Date;

/**
 * Created by jackiechan on 2017/4/30/下午9:04.
 */
public class CRUD2 {
    @Test
    public void test1() throws Exception {
        User user=new User();
        user.setUsername("zhangsan1111");
        user.setPassword("mima111111");
        user.setEmail("fsdfsdfsd1111111");
        user.setBirthday(new Date());
        Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT  into users (username,password,email,birthday) VALUES (?,?,?,?)");
        preparedStatement.setString(1,user.getUsername());
        preparedStatement.setString(2,user.getPassword());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setDate(4,new java.sql.Date(user.getBirthday().getTime()));
        int i = preparedStatement.executeUpdate();
        if (i >0){
            System.out.println("chenggong");
        }
        DBUtils.closeAll(connection,preparedStatement,null);
    }

    @Test
    public void test2() throws Exception {
        Connection connection = DBUtils.getConnection();
        User user=new User();
        user.setUsername("zhangsan");
        user.setPassword("mima' or 1='1");//叫 sql 注入,preparedStatement的作用就是防止 sql 注入
        Statement statement = connection.createStatement();
        String sql="select * from users where username = '" + user.getUsername() + "' and password = '" + user.getPassword() +"'";
        System.out.println(sql);
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getString("email"));
        }
        DBUtils.closeAll(connection,statement,resultSet);
    }

    @Test
    public void test3() throws Exception {
        Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE  users set username=? where id =?");
        preparedStatement.setString(1,"xiugaimingzi");
        preparedStatement.setInt(2,4);
        int i = preparedStatement.executeUpdate();
        DBUtils.closeAll(connection,preparedStatement,null);
    }


    @Test
    public void test4() throws Exception {
        Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE from users  where id =?");
        preparedStatement.setInt(1,4);
        int i = preparedStatement.executeUpdate();
        DBUtils.closeAll(connection,preparedStatement,null);
    }
}
