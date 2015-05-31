package com.android.bibi.similar.controller;

import android.content.Context;

import com.android.bibi.similar.model.Recover;
import com.android.bibi.similar.model.SignIn;

/**
 * Created by jsalgado on 30/05/15.
 */
public class RecoverController {


    private String mCompanyCode;
    private String mEmail;
    private Context mContext;

    public RecoverController(String mCompanyCode, Context mContext, String mEmail) {
        this.mCompanyCode = mCompanyCode;
        this.mContext = mContext;
        this.mEmail = mEmail;
    }

    public String getmCompanyCode() {
        return mCompanyCode;
    }

    public void setmCompanyCode(String mCompanyCode) {
        this.mCompanyCode = mCompanyCode;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public void validateRecoverToServer(){
        boolean isValid = false;

        //TODO validacoes
        if(!mEmail.isEmpty() && !mCompanyCode.isEmpty()){

            Recover recover = new Recover(mCompanyCode, mEmail, mContext);
            recover.serverRecover();
        }

        //return isValid;
    }
}
