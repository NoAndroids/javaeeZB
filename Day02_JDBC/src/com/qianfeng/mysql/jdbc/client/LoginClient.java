package com.qianfeng.mysql.jdbc.client;

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
import com.qianfeng.mysql.jdbc.service.UserService;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by jackiechan on 2017/4/30/下午9:28.
 */
public class LoginClient {
    @Test
    public void testLogin() throws SQLException {
        //
        Scanner input=new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = input.nextLine();
        System.out.println("请输入密码");
        String password = input.nextLine();
        UserService userService=new UserService();
        User user = userService.loginByUserNameAndPassword(username, password);
        if (user != null) {
            System.out.println("登录成功欢迎:  "+user.getUsername());

        }else{
            System.out.println("用户名或者密码错误");
        }
    }

    public static void main(String[] args) throws SQLException {
        //
        Scanner input=new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = input.nextLine();
        System.out.println("请输入密码");
        String password = input.nextLine();
        UserService userService=new UserService();
        User user = userService.loginByUserNameAndPassword(username, password);
        if (user != null) {
            System.out.println("登录成功欢迎:  "+user.getUsername());

        }else{
            System.out.println("用户名或者密码错误");
        }
    }
}
