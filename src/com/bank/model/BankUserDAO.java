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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ad
 */
public class BankUserDAO {
    
    public int insertUser(BankUserDTO dto) throws SQLException{
        try {
            Connection conn = DBUtil.getConnection();
            
            String sql = "insert into bankuser values(bankuser_seq.nextval,?,?,default)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getId());
            ps.setString(2, dto.getPwd());
            
            int j = ps.executeUpdate();
            
            return j;
        }finally{
        }

    }
    
    public boolean userLogin(BankUserDTO dto) throws SQLException{
        try {
            Connection conn = DBUtil.getConnection();
            
            String sql = "select 1 from bankuser where id=? and pwd=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getId());
            ps.setString(2, dto.getPwd());
            
            boolean bool = ps.execute();
            
            return bool;
        }finally{
        }
    }
    
}
