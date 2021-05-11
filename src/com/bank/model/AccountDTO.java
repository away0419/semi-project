/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.model;

import java.sql.Timestamp;

/**
 *
 * @author knit
 */
public class AccountDTO {
    private long accountno;
    private String acpwd;
    private int typeno;
    private int userno;
    private Timestamp makedate;

    public AccountDTO() {
    }

    public AccountDTO(long accountno, String acpwd, int typeno, int userno, Timestamp makedate) {
        this.accountno = accountno;
        this.acpwd = acpwd;
        this.typeno = typeno;
        this.userno = userno;
        this.makedate = makedate;
    }

    public long getAccountno() {
        return accountno;
    }

    public String getAcpwd() {
        return acpwd;
    }

    public int getTypeno() {
        return typeno;
    }

    public int getUserno() {
        return userno;
    }

    public Timestamp getMakedate() {
        return makedate;
    }

    public void setAccountno(long accountno) {
        this.accountno = accountno;
    }

    public void setAcpwd(String acpwd) {
        this.acpwd = acpwd;
    }

    public void setTypeno(int typeno) {
        this.typeno = typeno;
    }

    public void setUserno(int userno) {
        this.userno = userno;
    }

    public void setMakedate(Timestamp makedate) {
        this.makedate = makedate;
    }
    
    
}
