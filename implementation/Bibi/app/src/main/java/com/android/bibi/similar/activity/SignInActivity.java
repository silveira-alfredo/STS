package com.android.bibi.similar.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.android.bibi.R;
import com.android.bibi.similar.controller.SignInController;
import com.android.bibi.similar.model.SignIn;

/**
 * Created by jsalgado on 28/05/15.
 * Sign Controller
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

        SignInController controller = new SignInController(companyCode, mContext, password, email);

        if(!controller.validateLoginToServer()){
            //dados invalidos
            showDialog();
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

    private void showDialog() {

        // 1. Instantiate an AlertDialog.Builder with its constructor
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

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
        dialog.show();
    }
}
