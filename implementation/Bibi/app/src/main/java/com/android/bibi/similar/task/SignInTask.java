package com.android.bibi.similar.task;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Created by jsalgado on 30/05/15.
 */
public class SignInTask extends AsyncTask<HttpUriRequest, Void, String> {


    public static final String HTTP_RESPONSE = "httpResponse";

    private Context mContext;
    private HttpClient mClient;
    private String mAction;

    public SignInTask(Context context, String action)
    {
        this.mContext = context;
        this.mAction = action;
        this.mClient = new DefaultHttpClient();
    }

    public SignInTask(Context context, String action, HttpClient client)
    {
        this.mContext = context;
        this.mAction = action;
        this.mClient = client;
    }

    @Override
    protected String doInBackground(HttpUriRequest... params) {
        try
        {
            HttpUriRequest request = params[0];
            HttpResponse serverResponse = mClient.execute(request);
            BasicResponseHandler handler = new BasicResponseHandler();
            String response = handler.handleResponse(serverResponse);
            return response;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result)
    {
        Intent intent = new Intent(mAction);
        intent.putExtra(HTTP_RESPONSE, result);
        mContext.sendBroadcast(intent);
    }

}
