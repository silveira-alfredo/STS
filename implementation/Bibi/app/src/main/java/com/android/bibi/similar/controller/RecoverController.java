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

    public RecoverController(String mCompanyCode, String mEmail, Context mContext) {
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

    public boolean validateRecoverToServer(){
        boolean isValid = false;

        //TODO validacoes
        if(!mEmail.isEmpty() && !mCompanyCode.isEmpty()){

            Recover recover = new Recover(mCompanyCode, mEmail, mContext);
            recover.serverRecover();
        }else{
            isValid = false;
        }


        return isValid;
    }
}
