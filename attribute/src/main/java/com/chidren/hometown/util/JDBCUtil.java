/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.chidren.hometown.util;

import com.chidren.hometown.dataobject.HumanDO;

import java.sql.*;

/**
 *
 * @author wb-lcj442691
 * @version $Id: JDBCUtil.java, v 0.1 2018年11月22日 17:48 wb-lcj442691 Exp $
 */
public class JDBCUtil {
    static          Connection conn = null;

    static {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/hometown?useUnicode=true&characterEncoding=utf8";
        String username = "root";
        String password = "root";
        try {
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  static int insertOne() {

        int i = 0;

        Statement statement;
        try {
            conn.setAutoCommit(false);
            String sql = "INSERT INTO `human`( `fullname`, `english_name`, `register_reside`, "
                    + "`identification`, `nation`, `sex`, `birthday`, `head_image`, `political_outlook`, `blood_type`, `height`, `summary`, "
                    + "`email`, `mobile`, `marryed`, `joinwork_time`, `education`, `human_status`) VALUES ( '李虎胡', 'lihuhu', '山东临沂', '371329199898554555', '苗族', 1, '2018-11-13', 'http://12321"
                    + ".com', '党员', '大O', 133, '品格良好', '25821436522@qq.com', '18987455125', 1, '2018-11-12', 1, 1);\n";
            statement = conn.createStatement();
            i=statement.executeUpdate(sql);
            statement.close();
            conn.commit();
            System.out.println(conn.isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return i;
    }
    public static void query(){
        String sql="select * from human  ORDER BY gmt_create desc limit 1000";

        Statement statement;
        try {
            long start=System.currentTimeMillis();

              statement = conn.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            resultSet.close();
            statement.close();
            System.out.println(System.currentTimeMillis()-start);
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
    public  static int insert(HumanDO human) {
        int i = 0;
        String sql ="INSERT INTO `human`( `fullname`, `english_name`, `register_reside`, "
                + "`identification`, `nation`, `sex`, `birthday`, `head_image`, `political_outlook`, `blood_type`, `height`, `summary`, "
                + "`email`, `mobile`, `marryed`, `joinwork_time`, `education`, `human_status`)"+
                "VALUES ("
                + " ?, "
                + "?, "
                + "?, "
                + "?, "
                + "?,"
                + " ?, "
                + "?,"
                + " ?,"
                + " ?,"
                + " ?,"
                + " ?,"
                + " ?,"
                + " ?, "
                + "?, "
                + "?, "
                + "?,"
                + "?,"
                + " ?);";
        PreparedStatement pstmt;
        try {
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, human.getFullname());
            pstmt.setString(2, human.getEnglishName());
            pstmt.setString(3,human.getRegisterReside());
            pstmt.setString(4,human.getIdentification());
            pstmt.setString(5,human.getNation());
            pstmt.setInt(6,human.getSex());
            pstmt.setDate(7,new Date(human.getBirthday().getTime()));
            pstmt.setString(8,human.getHeadImage());
            pstmt.setString(9,human.getPoliticalOutlook());
            pstmt.setString(10,human.getBloodType());
            pstmt.setInt(11,human.getHeight());
            pstmt.setString(12,human.getSummary());
            pstmt.setString(13,human.getEmail());
            pstmt.setString(14,human.getMobile());
            pstmt.setInt(15,human.getMarryed());
            pstmt.setDate(16,new Date(human.getJoinworkTime().getTime()));
            pstmt.setInt(17,human.getEducation());
            pstmt.setInt(18,human.getHumanStatus());
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return i;
    }
    @Override
    protected   void finalize(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}