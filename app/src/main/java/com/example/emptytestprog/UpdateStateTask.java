package com.example.emptytestprog;

import android.os.AsyncTask;
import android.widget.TextView;

class UpdateStateTask extends AsyncTask<Void, Void, Void> {

    TextView result;
    String song;

    public UpdateStateTask(TextView result, String song_id){
        this.result = result;
        this.song = song_id;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        Utils.changeState(song, 1);
        return null;
    }

    @Override
    protected void onPostExecute(Void param) {
        super.onPostExecute(param);
        result.setText(result.getText() + " " + 1);
    }
}
