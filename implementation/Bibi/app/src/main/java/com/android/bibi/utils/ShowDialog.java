package com.android.bibi.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.android.bibi.R;

/**
 * Created by jsalgado on 04/06/15.
 */
public class ShowDialog {

    private Context mContext;
    private String mMessage;
    private String mTitle;
    private DialogMessageType mTypeMessage;

    public ShowDialog(Context mContext, String mMessage,  String mTitle, DialogMessageType typeMessage) {
        this.mContext = mContext;
        this.mMessage = mMessage;
        this.mTypeMessage = typeMessage;
        this.mTitle = mTitle;

        decideMessageType();
    }

    public ShowDialog(Context mContext, String mMessage, DialogMessageType typeMessage) {
        this.mContext = mContext;
        this.mMessage = mMessage;
        this.mTypeMessage = typeMessage;

        decideMessageType();
    }

    private void decideMessageType(){


        switch (mTypeMessage){
            case ALERT:
                showAlertDialog();
                break;

            case ERROR:
                showErrorDialog();
                break;

            case INFORMATIVE:
                showInformativeDialog();
                break;

            case OTHER:
                showCustomDialog();
                break;

            default:
                break;
        }
    }

    private void showErrorDialog(){

    }

    private void showAlertDialog(){

        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);

        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage(mMessage)
                .setTitle(mTitle);

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

    private void showCustomDialog(){

    }

    private void showInformativeDialog(){

    }
}
