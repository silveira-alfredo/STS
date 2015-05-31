package com.android.bibi.similar.model;

import android.content.Context;
import android.content.Intent;

import com.android.bibi.driver.activity.MainDriver;
import com.android.bibi.passenger.activity.MainPassenger;

/**
 * Created by jsalgado on 30/05/15.
 */
public class Recover {

    public String companyCode;
    public String email;
    public Context context;

    public Recover(String companyCode, String email, Context context) {
        this.companyCode = companyCode;
        this.email = email;
        this.context = context;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public void serverRecover(){

        // Recover task e ao finalizar task popup informando e finish


    }
}
