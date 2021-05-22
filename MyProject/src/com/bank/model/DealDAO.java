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
}
