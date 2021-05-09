/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.model;

import java.sql.Timestamp;

/**
 *
 * @author ad
 */
public class BankUserDTO {
    private int seq;
    private String id;
    private String pwd;
    private Timestamp joindate;

    public BankUserDTO(int seq, String id, String pwd, Timestamp joindate) {
        this.seq = seq;
        this.id = id;
        this.pwd = pwd;
        this.joindate = joindate;
    }

    public BankUserDTO() {
    }

    public int getSeq() {
        return seq;
    }

    public String getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }

    public Timestamp getJoindate() {
        return joindate;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setJoindate(Timestamp joindate) {
        this.joindate = joindate;
    }

    @Override
    public String toString() {
        return "BankUserDTO{" + "seq=" + seq + ", id=" + id + ", pwd=" + pwd + ", joindate=" + joindate + '}';
    }
    
    
}
