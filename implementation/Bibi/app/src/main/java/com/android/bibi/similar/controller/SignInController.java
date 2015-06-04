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
    private String mErrorMessage;
    private String mTreatedMessage;

    public SignInController(String mCompanyCode, Context mContext, String mPassword, String mEmail) {
        this.mCompanyCode = mCompanyCode;
        this.mContext = mContext;
        this.mPassword = mPassword;
        this.mEmail = mEmail;
    }

    public String getmTreatedMessage() {
        return mTreatedMessage;
    }

    public void setmTreatedMessage(String mTreatedMessage) {
        this.mTreatedMessage = mTreatedMessage;
    }

    public String getmCompanyCode() {
        return mCompanyCode;
    }

    public String getmErrorMessage() {
        return mErrorMessage;
    }

    public void setmErrorMessage(String mErrorMessage) {
        this.mErrorMessage = mErrorMessage;
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


    // VAI MUDAR ESSA ARQUITETURA

    // tratamentos para os possiveis erros no servidor
    public void treatSignInError(String errorMessage){

        this.mErrorMessage = errorMessage;

        //tratar a mensagem de erro

        this.mTreatedMessage = "";

    }

    // obter tratamento de erro
    public String getTreatedMessage(){

        return this.mTreatedMessage;

    }

    public boolean validateLoginToServer(){
        boolean isValid = true;

        //TODO validacoes
        if(!mEmail.isEmpty() && !mCompanyCode.isEmpty() && !mPassword.isEmpty()){

            SignIn signIn = new SignIn(mCompanyCode, mEmail,  mPassword , mContext);
            isValid =  signIn.serverSignIn();


        }else isValid = false;

        return isValid;
    }
}
