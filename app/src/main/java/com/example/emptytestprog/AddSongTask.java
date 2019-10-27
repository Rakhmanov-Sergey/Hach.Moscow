package com.example.emptytestprog;


import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.view.TextureView;
import android.widget.TextView;

import org.w3c.dom.Text;

class AddSongTask extends AsyncTask<Void, Void, Void> {

    TextView result;
    boolean responce;
    String room_id, service_id;

    public AddSongTask(TextView result, String room_id, String service_id){
        this.result = result;
        this.room_id=room_id;
        this.service_id = service_id;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        responce = Utils.suggest(room_id, service_id);
        return null;
    }

    @Override
    protected void onPostExecute(Void param) {
        super.onPostExecute(param);
        if (result != null) {
            result.setText(String.valueOf(responce));
        }
    }
}
