package com.chidren.hometown.util;

import com.chidren.hometown.dataobject.HumanDO;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.*;
import java.util.logging.Logger;

public class C3p0Utils {
    static Logger logger =Logger.getLogger(C3p0Utils.class.getName());
    
    //通过标识名来创建相应连接池
    static ComboPooledDataSource dataSource =new ComboPooledDataSource("mysql");
    //从连接池中取用一个连接
    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        return null;
    }
    public static void query(){
        String sql="select * from human  ORDER BY gmt_create desc limit 1000";
        Connection conn=getConnection();
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
        Connection conn=getConnection();
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
    //释放连接回连接池
     public static void close(Connection conn, PreparedStatement pst, ResultSet rs){
            if(rs!=null){  
                try {  
                    rs.close();  
                } catch (SQLException e) {
                    logger.info(e.getMessage());

                }  
            }  
            if(pst!=null){  
                try {  
                    pst.close();  
                } catch (SQLException e) {
                    logger.info(e.getMessage());

                }  
            }  
      
            if(conn!=null){  
                try {  
                    conn.close();  
                } catch (SQLException e) {
                    logger.info(e.getMessage());

                }  
            }  
        }  
}