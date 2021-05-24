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
public class BankUserService {
    private static String userid;
    private static int userno; //사용자번호
    private static String userpwd; //비밀번호
    private static Timestamp userjoindate; //가입날짜
    private static String username; //이름
    private static long userjumin; //주민번호
    private static String usertel; //전화번호
    private static String useremail; //이메일

    public static String getUserid() {
        return userid;
    }

    public static void setUserid(String userid) {
        BankUserService.userid = userid;
    }

    public static int getUserno() {
        return userno;
    }

    public static void setUserno(int userno) {
        BankUserService.userno = userno;
    }

    public static String getUserpwd() {
        return userpwd;
    }

    public static void setUserpwd(String userpwd) {
        BankUserService.userpwd = userpwd;
    }

    public static Timestamp getUserjoindate() {
        return userjoindate;
    }

    public static void setUserjoindate(Timestamp userjoindate) {
        BankUserService.userjoindate = userjoindate;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        BankUserService.username = username;
    }

    public static long getUserjumin() {
        return userjumin;
    }

    public static void setUserjumin(long userjumin) {
        BankUserService.userjumin = userjumin;
    }

    public static String getUsertel() {
        return usertel;
    }

    public static void setUsertel(String usertel) {
        BankUserService.usertel = usertel;
    }

    public static String getUseremail() {
        return useremail;
    }

    public static void setUseremail(String useremail) {
        BankUserService.useremail = useremail;
    }
    
}
