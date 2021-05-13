/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.model;

import com.bank.db.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
