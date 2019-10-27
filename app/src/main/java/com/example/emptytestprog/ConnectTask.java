package com.example.emptytestprog;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.view.TextureView;
import android.widget.TextView;

import org.w3c.dom.Text;

class ConnectTask extends AsyncTask<Void, Void, Void> {

    TextView result;
    Room room;
    String url;
    Context context;


    public ConnectTask(TextView result, String url, Context context){
        this.result = result;
        this.url = url;
        this.context = context;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        room = Utils.connect(url);
        Utils.SaveId(room.id, context);
        return null;
    }

    @Override
    protected void onPostExecute(Void param) {
        super.onPostExecute(param);
        result.setText(room.toString());
    }
}
