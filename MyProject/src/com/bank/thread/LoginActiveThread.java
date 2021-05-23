/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.thread;

import com.bank.view.BankMain;
import javax.swing.JLabel;
import com.bank.view.Login;
/**
 *
 * @author ad
 */
public class LoginActiveThread extends Thread{
    private JLabel la;
    private static int time;
    private BankMain bm;
    private Login login;
    
    public LoginActiveThread(JLabel la,BankMain bm){
        super();
        time=180;
        login=new Login();
        this.la=la;
        this.bm=bm;
    }
    
    public void run() {
		for(; time>0; time--) {
			try {
                                int min=time/60;
                                int sec=time%60;
                                
                                
                                if(sec<10){
                                    la.setText("0"+min+":0"+sec);
                                }else
                                    la.setText("0"+min+":"+sec);
                                Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
                bm.dispose();
                login.setVisible(true);
	}

    public static void setTime(int time) {
        LoginActiveThread.time = time;
    }
    
}
