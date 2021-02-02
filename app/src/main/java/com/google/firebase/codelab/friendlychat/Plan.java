package com.google.firebase.codelab.friendlychat;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Plan extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
    }

    public void launchNotes(View view) {
        Log.d(LOG_TAG, "Button 2 clicked!");
        Intent intent = new Intent(this, Notes.class);
        startActivity(intent);
    }

    public void openBannerWeb(View view) {
        String url = "https://bannerweb.wpi.edu/pls/prod/twbkwbis.P_WWWLogin";
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }
}
