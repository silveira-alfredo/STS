package com.android.bibi.similar.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.android.bibi.R;
import com.android.bibi.passenger.activity.MainPassenger;
import com.android.bibi.similar.controller.SignInController;

/**
 * Created by jsalgado on 28/05/15.
 */
public class SignInActivity extends ActionBarActivity {

    private EditText mCompanyCode;
    private EditText mEmail;
    private EditText mPassword;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        mCompanyCode = (EditText) findViewById(R.id.codigo_empresa);
        mEmail = (EditText) findViewById(R.id.signin_email);
        mPassword = (EditText) findViewById(R.id.signin_senha);
        mContext = getApplicationContext();
    }

    public void recoverPasswordClick(View v){
        Intent intent = new Intent(this, RecoverPasswordActivity.class);
        startActivity(intent);
    }

    public void signInClicked(View v){
        String companyCode = String.valueOf(mCompanyCode.getText());

        String email = String.valueOf(mEmail.getText());

        String password = String.valueOf(mPassword.getText());

        SignInController controller = new SignInController(companyCode, mContext,password, email);
        controller.validateLoginToServer();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
