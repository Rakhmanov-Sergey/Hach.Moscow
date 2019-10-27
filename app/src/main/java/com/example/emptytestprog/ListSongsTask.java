package com.example.emptytestprog;


import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

class ListSongsTask extends AsyncTask<Void, Void, Void> {

    TextView result1, result2, result3, result4, result;
    ImageView image1, image2, image3, image4;
    ArrayList<Song> list;
    String room_id;
    boolean with_image = false;


    public ListSongsTask(TextView result, String room_id){
        this.result = result;
        this.room_id=room_id;
        with_image = false;
    }

    public ListSongsTask(TextView result1, TextView result2, TextView result3, TextView result4,
                         ImageView image1, ImageView image2, ImageView image3, ImageView image4, String room_id){
        this.result1 = result1;
        this.result2 = result2;
        this.result3 = result3;
        this.result4 = result4;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;

        this.room_id=room_id;
        with_image = true;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        list = Utils.requestSongsList(room_id);
        return null;
    }

    @Override
    protected void onPostExecute(Void param) {
        super.onPostExecute(param);
        if (!with_image) {
            result.setText(list.toString());
        } else{
            if (list != null){
                for (int i = 0; i < list.size(); i++) {
                    Song song = list.get(i);
                    if (song.service_id.equals("1")){
                        result1.setVisibility(View.VISIBLE);
                        image1.setVisibility(View.VISIBLE);
                        ListActivity.song1_id = song.id;
                        result1.setText(result1.getText()+ " " + song.state);
                    } else if (song.service_id.equals("2")){
                        result2.setVisibility(View.VISIBLE);
                        image2.setVisibility(View.VISIBLE);
                        result2.setText(result2.getText()+ " " + song.state);
                        ListActivity.song2_id = song.id;
                    } else if (song.service_id.equals("3")){
                        result3.setVisibility(View.VISIBLE);
                        image3.setVisibility(View.VISIBLE);
                        ListActivity.song3_id = song.id;
                        result3.setText(result3.getText()+ " " + song.state);
                    } else if (song.service_id.equals("4")){
                        result4.setVisibility(View.VISIBLE);
                        image4.setVisibility(View.VISIBLE);
                        ListActivity.song4_id = song.id;
                        result4.setText(result4.getText()+ " " + song.state);
                    }
                }
            }
        }

    }
}
