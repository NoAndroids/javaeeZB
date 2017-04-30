package com.qianfeng.mysql.jdbc.demo;//                            _ooOoo_
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


import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by jackiechan on 2017/4/30/下午8:15.
 */
public class Demo1 {
    @Test
    public void test1() throws Exception {
        //我们第一步指定驱动,不能随便写, jdbc 肯定规定好了怎么写
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());//注册完成之后, jdbc 接口就知道要用哪个实现类了
        //和数据库建立连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zddemo", "root", "qishimeiyoumima");//jdbc:mysql://localhost:3306/zddemo   http://www.baidu.com
        //发送 sql 语句, sql 语句有专门的对象发送
       //创建执行 sql 语句的对象
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(" SELECT  * FROM  users");//原先 sql 语句怎么写,这里就怎么写,返回值代码查询的结果
        //resultSet 是一个可迭代的对象
        while (resultSet.next()){//如果还有下一条, next 是进行移动,移动到下一条,如果移动成功,返回 true, 就说明有下一条 并且指向了下一条
            String username = resultSet.getString("username");
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");
            String birthday = resultSet.getString("birthday");
            String id = resultSet.getString("id");
            System.out.println(username);
            System.out.println(email);
            System.out.println(password);
            System.out.println(birthday);
            System.out.println(id);
        }
        //关闭释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
