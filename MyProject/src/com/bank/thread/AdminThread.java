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
public class AdminThread extends Thread implements ActionListener{
    JTextArea ta;
    JTextField tf;
    JButton bt;
    Socket socket;
    DataOutputStream dos;
    DataInputStream dis;
    String username;
    ServerSocket sc;
    
    
    public AdminThread(JTextArea ta, JTextField tf, JButton bt) {
        this.ta = ta;
        this.tf = tf;
        this.bt = bt;
        tf.addActionListener(this);
	bt.addActionListener(this);
        username=BankUserService.getUsername();
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
    
     public void startserver(){
        try {
            sc= new ServerSocket(8888);
            ta.append("사용자 기다리는중....\n");
            this.start();
        } catch (IOException ex) {
            Logger.getLogger(AdminThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void run() {
        try {
            socket = sc.accept();
            ta.append("연결되었습니다.\n");
            dos= new DataOutputStream(socket.getOutputStream());
            dis=new DataInputStream(socket.getInputStream());
            while(dis!=null){
                String data =dis.readUTF();
                ta.append(data);
            }
        } catch (IOException e) {//e.printStackTrace(); }
        }//run()
    }//내부 class
    
    
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
