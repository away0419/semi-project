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
    private int acpwd;
    private int typeno;
    private int userno;
    private Timestamp makedate;

    public AccountDTO() {
    }

    public long getAccountno() {
        return accountno;
    }

    public int getAcpwd() {
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

    public void setAcpwd(int acpwd) {
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

    @Override
    public String toString() {
        return "AccountDTO{" + "accountno=" + accountno + ", acpwd=" + acpwd + ", typeno=" + typeno + ", userno=" + userno + ", makedate=" + makedate + '}';
    }

    
    
}
