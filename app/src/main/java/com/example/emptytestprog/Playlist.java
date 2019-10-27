package com.example.emptytestprog;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.deezer.sdk.model.Album;
import com.deezer.sdk.model.Permissions;
import com.deezer.sdk.model.Track;
import com.deezer.sdk.network.connect.DeezerConnect;
import com.deezer.sdk.network.connect.event.DialogListener;
import com.deezer.sdk.network.request.DeezerRequest;
import com.deezer.sdk.network.request.DeezerRequestFactory;
import com.deezer.sdk.network.request.event.JsonRequestListener;
import com.deezer.sdk.network.request.event.RequestListener;

import java.util.List;

public class Playlist extends AppCompatActivity {

    String applicationID = "376644";
    DeezerConnect deezerConnect;
    TextView textView3,textView5,textView6,textView7;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        activity = this;

        String[] permissions = new String[] {
                Permissions.BASIC_ACCESS,
                Permissions.MANAGE_LIBRARY,
                Permissions.LISTENING_HISTORY };

// The listener for authentication events
        DialogListener listener = new DialogListener() {

            public void onComplete(Bundle values) {

                RequestListener listener = new JsonRequestListener() {

                    public void onResult(Object result, Object requestId) {
                        List<Track> tracks = (List<Track>) result;
                        textView3 =(TextView)findViewById(R.id.textView3);
                        textView5 =(TextView)findViewById(R.id.textView5);
                        textView6 =(TextView)findViewById(R.id.textView6);
                        textView7 =(TextView)findViewById(R.id.textView7);




                        textView3.setText(tracks.get(0).getTitle()+" - "+ tracks.get(0).getArtist().getName());
                        textView5.setText(tracks.get(1).getTitle()+" - "+ tracks.get(1).getArtist().getName());
                        textView6.setText(tracks.get(2).getTitle()+" - "+ tracks.get(2).getArtist().getName());
                        textView7.setText(tracks.get(3).getTitle() +" - "+ tracks.get(3).getArtist().getName());

                        ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
                        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
                        ImageView imageView3 = (ImageView) findViewById(R.id.imageView3);
                        ImageView imageView4 = (ImageView) findViewById(R.id.imageView4);

                        imageView1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String room_id = Utils.DownId(activity);
                                new AddSongTask(null, room_id, "1").execute();
                            }
                        });

                        imageView2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String room_id = Utils.DownId(activity);
                                new AddSongTask(null, room_id, "2").execute();
                            }
                        });

                        imageView3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String room_id = Utils.DownId(activity);
                                new AddSongTask(null, room_id, "3").execute();
                            }
                        });

                        imageView4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String room_id = Utils.DownId(activity);
                                new AddSongTask(null, room_id, "4").execute();
                            }
                        });

                        // do something with the albums
                    }

                    public void onUnparsedResult(String requestResponse, Object requestId) {}

                    public void onException(Exception e, Object requestId) {}
                };


                DeezerRequest request = DeezerRequestFactory.requestPlaylistTracks(908622995);
                request.setId("myRequest");
                deezerConnect.requestAsync(request, listener);

            }

            public void onCancel() {}

            public void onException(Exception e) {}


        };


         deezerConnect = new DeezerConnect(this, applicationID);
        // Launches the authentication process
        deezerConnect.authorize(this, permissions, listener);


// create the request


// set a requestId, that will be passed on the listener's callback methods


// launch the request asynchronously


    }



}
