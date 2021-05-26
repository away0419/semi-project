/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.thread;

import com.bank.model.BankUserService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author ad
 */
public class UserThread extends Thread implements  ActionListener{
    JTextArea ta;
    JTextField tf;
    JButton bt;
    Socket socket;
    DataOutputStream dos;
    DataInputStream dis;
    String username;
    
    public UserThread(JTextArea ta, JTextField tf, JButton bt) {
        this.ta = ta;
        this.tf = tf;
        this.bt = bt;
        tf.addActionListener(this);
	bt.addActionListener(this);
        
        username=BankUserService.getUsername();
    }
    
    public void startserver(){
        try {
            //socket=new Socket("192.168.11.33", 8888);
            socket=new Socket("127.0.0.1", 8888);
            ta.append("상담사와 연결되었습니다.\n");
            dis=new DataInputStream(socket.getInputStream());
            dos= new DataOutputStream(socket.getOutputStream());
            
            this.start();
        } catch (IOException ex) {
            Logger.getLogger(AdminThread.class.getName()).log(Level.SEVERE, null, ex);
            ta.append("상담사가 부재중입니다.\n");
        }
    }
    
    public void end(){
        try {
            dos.close();
            dis.close();
            socket.close();
            this.stop();
        } catch (IOException ex) {
            Logger.getLogger(AdminThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    public void run() {
        try {
            while(dis!=null){
                String data =dis.readUTF();
                ta.append(data);
            }
            
        } catch (IOException e) { //e.printStackTrace(); }
        }//run()
    }//내부클래스
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bt || e.getSource()==tf){
            try {
                if(dos!=null){
                    dos.writeUTF("["+username+"]"+ tf.getText() +"\n");
                    ta.append("["+username+"]"+ tf.getText() +"\n");
                    tf.setText("");
                    tf.requestFocus();
                }
            } catch (IOException e1) {
                e1.printStackTrace(); }
        }
    }
    
}
