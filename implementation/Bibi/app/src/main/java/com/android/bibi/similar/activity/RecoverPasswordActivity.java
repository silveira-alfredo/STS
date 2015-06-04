package com.android.bibi.similar.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.android.bibi.R;
import com.android.bibi.similar.model.Recover;

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

      if(validateRecoverToServer()){
             showDialog(true);
        }else{
            showDialog(false);
        }
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

    public boolean validateRecoverToServer(){
        boolean isValid = false;

        String companyCode = String.valueOf(mCompanyCode.getText());
        String email = String.valueOf(mEmail.getText());

        //TODO validacoes
        if(!email.isEmpty() && !companyCode.isEmpty()){

            Recover recover = new Recover(companyCode, email, mContext);
            if( recover.serverRecover()){

                isValid = true;
            }
        }

        return isValid;
    }
    private void showDialog(boolean sucess) {

        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);

// 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage(R.string.signin_dialog_message)
                .setTitle(R.string.signin_dialog_title);

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });

// 3. Get the AlertDialog from create()
        AlertDialog dialog = builder.create();
    }
}

