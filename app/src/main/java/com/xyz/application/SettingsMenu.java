package com.xyz.application;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

        final Button personalbut = (Button) findViewById(R.id.personalbuttonset);
        final Button familybut = (Button) findViewById(R.id.familybuttonset);
        final Button workbut = (Button) findViewById(R.id.workbuttonset);
        final Button schoolbut = (Button) findViewById(R.id.schoolbuttonset);
        final Button birthdaybut = (Button) findViewById(R.id.birthdaysbuttonset);
        final Button otherbut = (Button) findViewById(R.id.otherbuttonset);



        //this sector always need to exist
        //its to redoo the color of the buttons... hopefully
        if(!metadata.personal.equals("iii")){
            personalbut.setBackgroundColor(Color.parseColor(metadata.personal));
        }
        if (!metadata.family.equals("iii")){
            familybut.setBackgroundColor(Color.parseColor(metadata.family));
        }
        if (!metadata.work.equals("iii")){
            workbut.setBackgroundColor(Color.parseColor(metadata.work));
        }
        if (!metadata.school.equals("iii")){
            schoolbut.setBackgroundColor(Color.parseColor(metadata.school));
        }
        if (!metadata.birthdays.equals("iii")){
            birthdaybut.setBackgroundColor(Color.parseColor(metadata.birthdays));
        }
        if (!metadata.other.equals("iii")){
            otherbut.setBackgroundColor(Color.parseColor(metadata.other));
        }


        workbut.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                ColorChooser(workbut.getId());
            }
        });
        familybut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ColorChooser(familybut.getId());
            }
        });

        schoolbut.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                ColorChooser(schoolbut.getId());
            }
        });

        birthdaybut.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                ColorChooser(birthdaybut.getId());
            }
        });

        otherbut.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                ColorChooser(otherbut.getId());
            }
        });
        //this is just test
        personalbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //////////////////////////
                //test for sanity!
                /*TextView hi = (TextView) findViewById(R.id.textView2);
                if(hi.getText() == "fuck"){
                    hi.setText("penis");
                }else{
                    hi.setText("fuck");
                }*/
                /////////////////////////

                ColorChooser(personalbut.getId());


                /////////////////////////////////
                //old method of working that 'worked'
                /*setContentView(R.layout.colorchoice_settingsview);
                TextView title = (TextView) findViewById(R.id.colorchoicelabel);
                String notificationname = (String) but.getText();

                title.setText("Choose a color for " + notificationname.toLowerCase() + " notifications");
                final Button checkcolor = (Button) findViewById(R.id.testbutton);

                checkcolor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        RadioGroup getcolorgroup = (RadioGroup) findViewById(R.id.colorchoicegroup);
                        RadioButton colorchoosen = (RadioButton) findViewById(getcolorgroup.getCheckedRadioButtonId());

                        metadata.personal = (String) colorchoosen.getText();
                        changeLayout();
                    }
                });*/
                /////////////////////////////////////
            }
        });

    }

    private void ColorChooser(int id){
        Button but = (Button) findViewById(id);
        setContentView(R.layout.colorchoice_settingsview);
        TextView title = (TextView) findViewById(R.id.colorchoicelabel);
        final String notificationname = (String) but.getText();

        title.setText("Choose a color for " + notificationname.toLowerCase() + " notifications");
        final Button checkcolor = (Button) findViewById(R.id.testbutton);

        checkcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup getcolorgroup = (RadioGroup) findViewById(R.id.colorchoicegroup);
                RadioButton colorchoosen = (RadioButton) findViewById(getcolorgroup.getCheckedRadioButtonId());
                if (notificationname.toLowerCase().equals("personal")) {
                    metadata.personal = (String) colorchoosen.getText();
                }
                if (notificationname.toLowerCase().equals("family")) {
                    metadata.family = (String) colorchoosen.getText();
                }
                if (notificationname.toLowerCase().equals("work")) {
                    metadata.work = (String) colorchoosen.getText();
                }
                if (notificationname.toLowerCase().equals("school")) {
                    metadata.school = (String) colorchoosen.getText();
                }
                if (notificationname.toLowerCase().equals("birthdays")) {
                    metadata.birthdays = (String) colorchoosen.getText();
                }
                if (notificationname.toLowerCase().equals("other")) {
                    metadata.other = (String) colorchoosen.getText();
                }

                changeLayout();
            }
        });
    }

    private void changeLayout(){
        //got to find a better fix for this shit
        //joules have a look at this and let me know
        Intent restart = new Intent(SettingsMenu.this, SettingsMenu.class);
        startActivity(restart);
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
