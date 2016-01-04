package com.xyz.application;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class SettingsMenu extends AppCompatActivity {


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settingsview);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        //don't touch this
        //


    }
  /*  public void testmethod(Button button){
        button.setBackgroundColor(Color.parseColor("white"));
        button.setText("I like pizza!");

    }*/
    @Override
    public void onStart() {
        super.onStart();
        setContentView(R.layout.settingsview);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "SettingsMenu Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.xyz.application/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);


        final Button but = (Button) findViewById(R.id.button1);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //test for sanity!
                /*TextView hi = (TextView) findViewById(R.id.textView2);
                if(hi.getText() == "fuck"){
                    hi.setText("penis");
                }else{
                    hi.setText("fuck");
                }*/
                setContentView(R.layout.colorchoice_settingsview);
                TextView title = (TextView) findViewById(R.id.colorchoicelabel);
                String notificationname = (String) but.getText();
                title.setText("Choose a color for " + notificationname.toLowerCase() + " notifications");
                final Button checkcolor = (Button) findViewById(R.id.testbutton);
                checkcolor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        changeLayout();
                    }
                });
            }
        });

    }
    private void changeLayout(){
        setContentView(R.layout.settingsview);
    }


    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "SettingsMenu Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.xyz.application/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
