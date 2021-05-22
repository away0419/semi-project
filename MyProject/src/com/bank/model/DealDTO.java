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
public class DealDTO {
    private int dealno;
    private long sendac;
    private long takeac;
    private long sendprice;
    private long takeprice;
    private String senduser;
    private String takeuser;
    private Timestamp dealdate;

    public DealDTO() {
    }

    public int getDealno() {
        return dealno;
    }

    public void setDealno(int dealno) {
        this.dealno = dealno;
    }

    public long getSendac() {
        return sendac;
    }

    public void setSendac(long sendac) {
        this.sendac = sendac;
    }

    public long getTakeac() {
        return takeac;
    }

    public void setTakeac(long takeac) {
        this.takeac = takeac;
    }

    public long getSendprice() {
        return sendprice;
    }

    public void setSendprice(long sendprice) {
        this.sendprice = sendprice;
    }

    public long getTakeprice() {
        return takeprice;
    }

    public void setTakeprice(long takeprice) {
        this.takeprice = takeprice;
    }

    public String getSenduser() {
        return senduser;
    }

    public void setSenduser(String senduser) {
        this.senduser = senduser;
    }

    public String getTakeuser() {
        return takeuser;
    }

    public void setTakeuser(String takeuser) {
        this.takeuser = takeuser;
    }

    public Timestamp getDealdate() {
        return dealdate;
    }

    public void setDealdate(Timestamp dealdate) {
        this.dealdate = dealdate;
    }

    @Override
    public String toString() {
        return "DealDTO{" + "dealno=" + dealno + ", sendac=" + sendac + ", takeac=" + takeac + ", sendprice=" + sendprice + ", takeprice=" + takeprice + ", senduser=" + senduser + ", takeuser=" + takeuser + ", dealdate=" + dealdate + '}';
    }
    
    
}
