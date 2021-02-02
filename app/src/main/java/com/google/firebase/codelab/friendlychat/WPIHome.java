package com.google.firebase.codelab.friendlychat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class WPIHome extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private Button button19;
    private int mColor;

    private Button toPlan;
    private Button toCourseLookup;
    private Button toMap;
    private Button toChat;
    private Button toEmail;
    private Button switchColor;
    public Switch switch2;

    private boolean switchOnOff;
    private int col;

    private SharedPreferences mPreferences;
    private String sharedPrefFile = "colorchange";
    public static final String COLOR_KEY  = "keycolor";
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String SWITCH2 = "switch2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wpihome);

        // assign buttons
        toPlan = (Button) findViewById(R.id.button9);
        toCourseLookup = (Button) findViewById(R.id.button8);
        toMap = (Button) findViewById(R.id.button16);
        toChat = (Button) findViewById(R.id.button18);
        toEmail = (Button) findViewById(R.id.button19);
        switchColor = (Button) findViewById(R.id.button20);
        switch2 = (Switch) findViewById(R.id.switch2);

        mColor = ContextCompat.getColor(this, R.color.colorPrimary);
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        mColor = mPreferences.getInt(COLOR_KEY, mColor);
        toPlan.setBackgroundColor(mColor);
        toCourseLookup.setBackgroundColor(mColor);
        toMap.setBackgroundColor(mColor);
        toChat.setBackgroundColor(mColor);
        toEmail.setBackgroundColor(mColor);

        //loadData();
        //updateViews();


        //mColor = mPreferences.getInt(COLOR_KEY, mColor);
        switchColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color;

                if(switch2.isChecked()) { // on
                    color = getResources().getColor(R.color.colorPrimaryDark);
                    switchOnOff = true;
                } else {
                    color = getResources().getColor(R.color.colorPrimary);
                    switchOnOff = false;
                }

                mColor = color;
                toPlan.setBackgroundColor(mColor);
                toCourseLookup.setBackgroundColor(mColor);
                toMap.setBackgroundColor(mColor);
                toChat.setBackgroundColor(mColor);
                toEmail.setBackgroundColor(mColor);

                Toast.makeText(getBaseContext(), "Color changed!", Toast.LENGTH_SHORT).show();


            }

        });

        //Toast.makeText(this, "Color changed!", Toast.LENGTH_SHORT).show();
        switchOnOff = mPreferences.getBoolean(SWITCH2, false);
        switch2.setChecked(switchOnOff);


    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putBoolean(SWITCH2, switchOnOff);
        preferencesEditor.putInt(COLOR_KEY, mColor);
        preferencesEditor.apply();

        switch2.setChecked(switchOnOff);

    }

    public void launchPlan(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, Plan.class);
        startActivity(intent);
    }

    public void launchCourseLookup(View view) {
        Log.d(LOG_TAG, "Button 2 clicked!");
        Intent intent = new Intent(this, ClassLookup.class);
        startActivity(intent);
    }

    public void launchMap(View view) {
        Uri address = Uri.parse("geo:0,0?q=WPI");
        Intent intent = new Intent(Intent.ACTION_VIEW, address);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void launchDept(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void launchOutlook(View view) {
        String url = "https://login.microsoftonline.com/common/oauth2/authorize?client_id=00000002-0000-0ff1-ce00-000000000000&redirect_uri=https%3a%2f%2foutlook.office365.com%2fowa%2f&resource=00000002-0000-0ff1-ce00-000000000000&response_mode=form_post&response_type=code+id_token&scope=openid&msafed=0&client-request-id=60e96031-ec71-4910-913e-53c56a30d7fb&protectedtoken=true&domain_hint=wpi.edu&nonce=637161339365394033.b5b0e7c0-8f3c-47e7-b7cf-5bb986ead7ca&state=Dcs7EoAgDABR0NarhM8EEjgOgTBjpY3D9aV42601xpzbsdmwY5iQI0XEipSxpoDoJEtQ7gHKxA6JlUG4T8gitZC2wb3Z_V7-Wc2v93Y6vh8&sso_reload=true";
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }
}
