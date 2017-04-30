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
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackiechan on 2017/4/30/下午8:34.
 */
public class CRUD {
    //
    @Test
    public void testInsert() throws Exception {

        //连接数据库
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql:///zddemo", "root", "qishimeiyoumima");
        Statement statement = connection.createStatement();
        statement.execute("insert into users (username,password,email,birthday) values('lisi111','dfadfsf234','dsfs@asd.com','2017-01-01')");
        statement.close();
        connection.close();
    }
    @Test
    public void testUpdate() throws Exception {

        //连接数据库
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql:///zddemo", "root", "qishimeiyoumima");
        Statement statement = connection.createStatement();
        statement.execute("UPDATE  users SET  username='fasdfsdafdf' ,password ='fsdfdgsdfgdfsgdfsg' where id =1");
        statement.close();
        connection.close();
    }

    @Test
    public void testSelect() throws Exception {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //连接数据库
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql:///zddemo", "root", "qishimeiyoumima");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users");
        List<User> users=new ArrayList<>();
        while (resultSet.next()) {
            User user=new User();
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setUsername(resultSet.getString("username"));
            user.setBirthday(sdf.parse(resultSet.getString("birthday")));
            user.setId(resultSet.getInt("id"));
            users.add(user);
        }
        resultSet.close();
        statement.close();
        connection.close();
        System.out.println(users);
    }

    @Test
    public void testDelete() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql:///zddemo", "root", "qishimeiyoumima");
        Statement statement = connection.createStatement();
        statement.execute("DELETE from users where id =1");
        statement.close();
        connection.close();
    }

}
