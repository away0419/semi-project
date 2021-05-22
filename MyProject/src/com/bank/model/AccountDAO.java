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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author knit
 */
public class AccountDAO {
    
    public int insertAccount(AccountDTO dto) throws SQLException{
        Connection conn =null;
        PreparedStatement ps=null;
        
        try {
            conn = DBUtil.getConnection();
            
            String sql = "insert into account values(account_seq.nextval,?,default,?,?,default)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, dto.getAcpwd());
            ps.setInt(2, dto.getTypeno());
            ps.setInt(3, dto.getUserno());
            
            
            int j = ps.executeUpdate();
            System.out.println("성공");
            return j;
        }finally{
            DBUtil.dbClose(ps, conn);
        }

    }//insertUser();
    
    public List<AccountDTO> userAcList(int userno) throws SQLException{
        Connection conn =null;
        PreparedStatement ps=null;
        ResultSet rs =null;
        List<AccountDTO> listacdto= new ArrayList<>();
        
        try {
          
            conn = DBUtil.getConnection();
       
            String sql = "select * from account where userno=? order by accountno";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userno);

            rs = ps.executeQuery();
            
            while(rs.next()){
                AccountDTO acdto = new AccountDTO();
                acdto.setAccountno(rs.getLong(1));
                acdto.setAcpwd(rs.getInt(2));
                acdto.setPrice(rs.getLong(3));
                acdto.setTypeno(rs.getInt(4));
                acdto.setUserno(rs.getInt(5));
                acdto.setMakedate(rs.getTimestamp(6));
                
                listacdto.add(acdto);
            }
            return listacdto;
        }finally{
            DBUtil.dbClose(rs, ps, conn);
            
        }
    }
    
    public int userAcCnt(int userno) throws SQLException{
        Connection conn =null;
        PreparedStatement ps=null;
        ResultSet rs =null;
        int cnt=0;
        try {
          
            conn = DBUtil.getConnection();
       
            String sql = "select count(*) from account where userno=? order by accountno";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userno);

            rs = ps.executeQuery();
            
            while(rs.next()){
                 cnt=rs.getInt(1);
                
               
            }
            return cnt;
        }finally{
            DBUtil.dbClose(rs, ps, conn);
            
        }
    }
    
    public AccountDTO acInfo(String ac) throws SQLException{
        Connection conn =null;
        PreparedStatement ps=null;
        ResultSet rs =null;
        AccountDTO dto= null;
        
        try {
          
            conn = DBUtil.getConnection();
       
            String sql = "select * from account where accountno=?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, Long.parseLong(ac));

            rs = ps.executeQuery();
            
            while(rs.next()){
                dto=new AccountDTO();
                dto.setAccountno(rs.getLong(1));
                dto.setAcpwd(rs.getInt(2));
                dto.setPrice(rs.getLong(3));
                dto.setTypeno(rs.getInt(4));
                dto.setUserno(rs.getInt(5));
                dto.setMakedate(rs.getTimestamp(6));
            }
            return dto;
        }finally{
            DBUtil.dbClose(rs, ps, conn);
            
        }
    }
    
    public int sendPrice(long ac, long price) throws SQLException{
        Connection conn =null;
        PreparedStatement ps=null;
        
        try {
            conn = DBUtil.getConnection();
            
            String sql = "update account set price=price - ? where accountno = ?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, price);
            ps.setLong(2, ac);
            
            
            int j = ps.executeUpdate();
            System.out.println("성공");
            return j;
        }finally{
            DBUtil.dbClose(ps, conn);
        }

    }//sendPrice
    
    public int takePrice(long ac, long price) throws SQLException{
        Connection conn =null;
        PreparedStatement ps=null;
        
        try {
            conn = DBUtil.getConnection();
            
            String sql = "update account set price=price + ? where accountno = ?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, price);
            ps.setLong(2, ac);
            
            
            int j = ps.executeUpdate();
            System.out.println("성공");
            return j;
        }finally{
            DBUtil.dbClose(ps, conn);
        }

    }//takePrice
}
