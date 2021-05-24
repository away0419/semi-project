/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.thread;

import java.awt.*;
 
import javax.swing.*;
import javax.swing.table.*;
 
public class MyRenderer extends DefaultTableCellRenderer 
{
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean
            isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected,
                hasFocus, row, column);
        
        if (!isSelected) {
            if((long)table.getValueAt(row, 2)>0)
                cell.setForeground(Color.red);
            else
                cell.setForeground(Color.blue);
                
            
//            if (row % 2 == 0) {
//                cell.setForeground(Color.BLUE);
//            } else {
//                cell.setForeground(Color.red);
//            }
//
////            if (column == 2) {
////                if (Long.parseLong((String) value) >= 0) {
////                    cell.setForeground(Color.blue);
////                } else{
////                    cell.setForeground(Color.red);
////                }
////
////            }

        }
        
        return cell;
    }
}