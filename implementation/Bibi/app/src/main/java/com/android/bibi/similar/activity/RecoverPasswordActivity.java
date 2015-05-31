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
import com.android.bibi.similar.controller.RecoverController;

/**
 * Created by jsalgado on 30/05/15.
 */
public class RecoverPasswordActivity extends ActionBarActivity {

    private EditText mCompanyCode;
    private EditText mEmail;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_recover);

        mCompanyCode = (EditText) findViewById(R.id.recover_cod_empresa);
        mEmail = (EditText) findViewById(R.id.recover_email);
        mContext = getApplicationContext();
    }

    public void recoverFinishedClick(View v){


        String companyCode = String.valueOf(mCompanyCode.getText());
        String email = String.valueOf(mEmail.getText());


        RecoverController recover = new RecoverController(companyCode, mContext,email);
        recover.validateRecoverToServer();
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

