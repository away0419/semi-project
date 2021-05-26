/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.model;

import com.bank.db.DBUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ad
 */
public class DealDAO {
    
    public int insertDeal(DealDTO dto) throws SQLException{
        Connection conn =null;
        PreparedStatement ps=null;
        
        try {
            conn = DBUtil.getConnection();
            
            String sql = "insert into deal values(deal_seq.nextval,?,?,?,?,?,?,default)";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, dto.getSendac());
            ps.setLong(2, dto.getTakeac());
            ps.setLong(3, dto.getSendprice());
            ps.setLong(4, dto.getTakeprice());
            ps.setString(5, dto.getSenduser());
            ps.setString(6, dto.getTakeuser());
           
            
            int j = ps.executeUpdate();
            
            return j;
        }finally{
            DBUtil.dbClose(ps, conn);
        }

    }//insertUser();
    
    public List<DealDTO> selectDealByAc(String ac) throws SQLException{
        Connection conn =null;
        PreparedStatement ps=null;
        ResultSet rs =null;
        long  lac = Long.parseLong(ac);
        List<DealDTO> list = new ArrayList<>();
        
        try {
            
            conn = DBUtil.getConnection();
       
            String sql = "select * from deal where sendaccount=? or takeaccount=? order by dealdate desc" ;
            ps = conn.prepareStatement(sql);
            ps.setLong(1, lac);
            ps.setLong(2, lac);

            rs = ps.executeQuery();
            
            
           while(rs.next()){
                DealDTO dto= new DealDTO();
                dto.setDealno(rs.getInt(1));
                dto.setSendac(rs.getLong(2));
                dto.setTakeac(rs.getLong(3));
                dto.setSendprice(rs.getLong(4));
                dto.setTakeprice(rs.getLong(5));
                dto.setSenduser(rs.getString(6));
                dto.setTakeuser(rs.getString(7));
                dto.setDealdate(rs.getTimestamp(8));
                
                list.add(dto);
                
            }
            return list;
        }finally{
            DBUtil.dbClose(rs, ps, conn);
            
        }
    }
    public List<DealDTO> selectDealByAcDate(String ac,String date1, String date2) throws SQLException{
        Connection conn =null;
        PreparedStatement ps=null;
        ResultSet rs =null;
        long  lac = Long.parseLong(ac);
        List<DealDTO> list = new ArrayList<>();
        
        try {
            
            conn = DBUtil.getConnection();
       
            String sql = "select * from deal where (sendaccount=? or takeaccount=?) and trunc(dealdate) between ? and ? order by dealdate desc" ;
            ps = conn.prepareStatement(sql);
            ps.setLong(1, lac);
            ps.setLong(2, lac);
            ps.setString(3,date1);
            ps.setString(4,date2);

            rs = ps.executeQuery();
            
            
           while(rs.next()){
                DealDTO dto= new DealDTO();
                dto.setDealno(rs.getInt(1));
                dto.setSendac(rs.getLong(2));
                dto.setTakeac(rs.getLong(3));
                dto.setSendprice(rs.getLong(4));
                dto.setTakeprice(rs.getLong(5));
                dto.setSenduser(rs.getString(6));
                dto.setTakeuser(rs.getString(7));
                dto.setDealdate(rs.getTimestamp(8));
                
                list.add(dto);
                
            }
            return list;
        }finally{
            DBUtil.dbClose(rs, ps, conn);
            
        }
    }
    
    public List<DealDTO> selectDealByNameDate(String name,Timestamp tm1, Timestamp tm2) throws SQLException{
        Connection conn =null;
        PreparedStatement ps=null;
        ResultSet rs =null;
        List<DealDTO> list = new ArrayList<>();
        
        try {
            
            conn = DBUtil.getConnection();
       
            String sql = "select * from deal where (senduser=? or takeuser=?) and trunc(dealdate) between ? and ? order by dealdate desc" ;
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, name);
            ps.setTimestamp(3,tm1);
            ps.setTimestamp(4,tm2);


            rs = ps.executeQuery();
            
            
           while(rs.next()){
                DealDTO dto= new DealDTO();
                dto.setDealno(rs.getInt(1));
                dto.setSendac(rs.getLong(2));
                dto.setTakeac(rs.getLong(3));
                dto.setSendprice(rs.getLong(4));
                dto.setTakeprice(rs.getLong(5));
                dto.setSenduser(rs.getString(6));
                dto.setTakeuser(rs.getString(7));
                dto.setDealdate(rs.getTimestamp(8));
                
                list.add(dto);
                
            }
            return list;
        }finally{
            DBUtil.dbClose(rs, ps, conn);
            
        }
    }

    public int sendCntByDate(String name, Date d) throws SQLException{
        Connection conn =null;
        PreparedStatement ps=null;
        ResultSet rs =null;
        int cnt=0;
        try {
          
            conn = DBUtil.getConnection();
       
            String sql = "select count(*) from deal where senduser=? and trunc(dealdate)=? order by dealdate desc";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setDate(2, d);

            rs = ps.executeQuery();
            
            while(rs.next()){
                 cnt=rs.getInt(1);
                
               
            }
            return cnt;
        }finally{
            DBUtil.dbClose(rs, ps, conn);
            
        }
    }
    public int takeCntByDate(String name, Date d) throws SQLException{
        Connection conn =null;
        PreparedStatement ps=null;
        ResultSet rs =null;
        int cnt=0;
        try {
          
            conn = DBUtil.getConnection();
       
            String sql = "select count(*) from deal where takeuser=? and trunc(dealdate)=? order by dealdate desc";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setDate(2, d);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                 cnt=rs.getInt(1);
                
               
            }
            return cnt;
        }finally{
            DBUtil.dbClose(rs, ps, conn);
            
        }
    }
}

