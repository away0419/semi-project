/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.model;

import com.bank.db.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ad
 */
public class BankUserDAO {
    
    public int insertUser(BankUserDTO dto) throws SQLException{
        Connection conn =null;
        PreparedStatement ps=null;
        
        try {
            conn = DBUtil.getConnection();
            
            String sql = "insert into bankuser values(bankuser_seq.nextval,?,?,?,?,?,?,default)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getId());
            ps.setString(2, dto.getPwd());
            ps.setString(3, dto.getName());
            ps.setLong(4, dto.getJumin());
            ps.setString(5, dto.getTel());
            ps.setString(6, dto.getEmail());
            
            int j = ps.executeUpdate();
            
            return j;
        }finally{
            DBUtil.dbClose(ps, conn);
        }

    }//insertUser();
    
    public boolean userLogin(BankUserDTO dto) throws SQLException{
        Connection conn =null;
        PreparedStatement ps=null;
        ResultSet rs =null;
        
        try {
            boolean bool=false;
            conn = DBUtil.getConnection();
       
            String sql = "select * from bankuser where userid=? and userpwd=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getId());
            ps.setString(2, dto.getPwd());
            
            rs = ps.executeQuery();
            if(rs.next()){
                String dbPwd = rs.getString(3);
                if(dbPwd.equals(dto.getPwd())){
                    bool=true; 
                }
            }
            return bool;
        }finally{
            DBUtil.dbClose(rs, ps, conn);
        }
    }//userLogin();
    
    public boolean idCheck(String id) throws SQLException{
        Connection conn =null;
        PreparedStatement ps=null;
        ResultSet rs =null;
        
        try {
            boolean bool=false;
            conn = DBUtil.getConnection();
       
            String sql = "select * from bankuser where userid=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);

            rs = ps.executeQuery();
            if(rs.next()){
                bool=true; 
            }
            return bool;
        }finally{
            DBUtil.dbClose(rs, ps, conn);
        }
    }//idCheck();
    
    public boolean juminCheck(String jumin) throws SQLException{
        Connection conn =null;
        PreparedStatement ps=null;
        ResultSet rs =null;
        long ju= Long.parseLong(jumin);
        
        try {
            boolean bool=false;
            conn = DBUtil.getConnection();
       
            String sql = "select * from bankuser where jumin=?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, ju);
            
            rs = ps.executeQuery();
            if(rs.next()){
                bool=true; 
            }
            return bool;
        }finally{
            DBUtil.dbClose(rs, ps, conn);
        }
    }//idCheck();
    
    public boolean namejuminCheck(String name, String jumin) throws SQLException{
        Connection conn =null;
        PreparedStatement ps=null;
        ResultSet rs =null;
        long ju= Long.parseLong(jumin);
        
        try {
            boolean bool=false;
            conn = DBUtil.getConnection();
       
            String sql = "select * from bankuser where username=? and jumin=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setLong(2, ju);
            
            rs = ps.executeQuery();
            if(rs.next()){
                bool=true; 
            }
            return bool;
        }finally{
            DBUtil.dbClose(rs, ps, conn);
        }
    }
    
    public BankUserDTO searchIdPwd(String name, String jumin) throws SQLException{
        Connection conn =null;
        PreparedStatement ps=null;
        ResultSet rs =null;
        long ju= Long.parseLong(jumin);
        
        try {
            conn = DBUtil.getConnection();
       
            String sql = "select userid,userpwd from bankuser where username=? and jumin=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setLong(2, ju);
            
            rs = ps.executeQuery();
            BankUserDTO dto = new BankUserDTO();
            if(rs.next()){
                 dto.setId(rs.getString(1));
                 dto.setPwd(rs.getString(2));                
            }
            return dto;
        }finally{
            DBUtil.dbClose(rs, ps, conn);
        }
    }
}
