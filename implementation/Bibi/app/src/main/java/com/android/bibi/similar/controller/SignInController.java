package com.android.bibi.similar.controller;

import android.content.Context;

import com.android.bibi.similar.model.SignIn;

/**
 * Created by jsalgado on 30/05/15.
 */
public class SignInController {


    private String mCompanyCode;
    private String mEmail;
    private String mPassword;
    private Context mContext;

    public SignInController(String mCompanyCode, Context mContext, String mPassword, String mEmail) {
        this.mCompanyCode = mCompanyCode;
        this.mContext = mContext;
        this.mPassword = mPassword;
        this.mEmail = mEmail;
    }

    public String getmCompanyCode() {
        return mCompanyCode;
    }

    public void setmCompanyCode(String mCompanyCode) {
        this.mCompanyCode = mCompanyCode;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public void validateLoginToServer(){
        boolean isValid = false;

        //TODO validacoes
        if(!mEmail.isEmpty() && !mCompanyCode.isEmpty() && !mPassword.isEmpty()){

            SignIn signIn = new SignIn(mCompanyCode, mEmail,  mPassword , mContext);
            signIn.serverSignIn();
        }

        //return isValid;
    }
}
