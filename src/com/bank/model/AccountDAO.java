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
    
    
}
