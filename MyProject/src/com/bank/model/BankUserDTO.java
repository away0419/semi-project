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
    private int seq; //사용자번호
    private String id; //아이디
    private String pwd; //비밀번호
    private Timestamp joindate; //가입날짜
    private String name; //이름
    private long jumin; //주민번호
    private String tel; //전화번호
    private String email; //이메일

    public BankUserDTO(int seq, String id, String pwd, Timestamp joindate, String name, long jumin, String tel, String email) {
        this.seq = seq;
        this.id = id;
        this.pwd = pwd;
        this.joindate = joindate;
        this.name = name;
        this.jumin = jumin;
        this.tel = tel;
        this.email = email;
    }

    public BankUserDTO() {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setJumin(long jumin) {
        this.jumin = jumin;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getName() {
        return name;
    }

    public long getJumin() {
        return jumin;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "BankUserDTO{" + "seq=" + seq + ", id=" + id + ", pwd=" + pwd + ", joindate=" + joindate + ", name=" + name + ", jumin=" + jumin + ", tel=" + tel + ", email=" + email + '}';
    }

    
}
