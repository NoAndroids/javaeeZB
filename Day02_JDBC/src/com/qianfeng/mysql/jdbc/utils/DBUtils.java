package com.qianfeng.mysql.jdbc.utils;

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


import java.sql.*;
import java.util.ResourceBundle;

/**
 * Created by jackiechan on 2017/4/30/下午8:56.
 */
public class DBUtils {
    private static String userName;
    private static String password;
    private static String url;
    static {
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("db");
            Class.forName(bundle.getString("jdbc.className"));
            userName=bundle.getString("jdbc.username");
            password=bundle.getString("jdbc.password");
            url = bundle.getString("jdbc.url");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url,userName,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public static  void closeAll(Connection connection, Statement statement, ResultSet set){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                connection=null;
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                statement = null;
            }
        }
        if (set != null) {
            try {
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
                set=null;
            }
        }

    }
}
