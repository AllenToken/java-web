package com.hxh.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @Author: H_xinghai
 * @Date: 2019/6/14 17:10
 * @Description:
 */

public class DBUtils {

    private static String url = "";
    private static String username = "";
    private static String driver = "";
    private static String password = "";


    static {
        try {
            //��ȡ������Ϣ
            Properties pr = new Properties();
            pr.load(DBUtils.class.getClassLoader().getResourceAsStream(("mysql.properties")));

            url = pr.getProperty("url");
            username = pr.getProperty("username");
            driver = pr.getProperty("driver");
            password = pr.getProperty("password");
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,username,password);
        }catch(Exception e){
            e.printStackTrace();
        }
        return connection;
    }

    //ÿ�����ݿ������֮�����ͳһ����Դ����رղ���

    public static void close(ResultSet rs, Statement st,Connection con){
        if (rs != null){
            try {
                rs.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if (st != null){
            try {
                st.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if (con != null){
            try {
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        if (getConnection() != null){
            System.out.println("database linked success!");
        }else{
            System.out.println("database linked false!");
        }
    }
}
