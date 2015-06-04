package com.android.bibi.similar.model;

import android.content.Context;
import android.content.Intent;

import com.android.bibi.driver.activity.MainDriver;
import com.android.bibi.passenger.activity.MainPassenger;
import com.android.bibi.similar.task.SignInTask;

import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Created by jsalgado on 30/05/15.
 */
public class SignIn {

    public String companyCode;
    public String email;
    public String password;
    public Context context;
    public int userType;

    public SignIn(String companyCode, String email, String password , Context context) {
        this.companyCode = companyCode;
        this.email = email;
        this.password = password;
        this.context = context;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean serverSignIn(){

        boolean isValid = true;
       // SignInTask task = new SignInTask();

        //chamar a task retornando aqui o tipo de usuario
        //em caso de erro na propria task o erro será tratado e exibido na tela retornando aqui false.

        //tipo de usuario
        userType = 1;
        if (userType == 0){
            Intent intent = new Intent(context, MainDriver.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }else{
            Intent intent = new Intent(context, MainPassenger.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }

        return  isValid;
    }
}
