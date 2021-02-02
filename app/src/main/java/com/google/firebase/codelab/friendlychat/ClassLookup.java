package com.google.firebase.codelab.friendlychat;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ClassLookup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_lookup);
    }

    public void launchBusiness(View view) {
        String url = "https://www.wpi.edu/academics/calendar-courses/course-descriptions/18011/foisie-business-school";
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void launchCS(View view) {
        String url = "https://www.wpi.edu/academics/calendar-courses/course-descriptions/17851/computer-science";
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void launchEngineering(View view) {
        Intent intent = new Intent(this, Engineering.class);
        startActivity(intent);
    }

    public void launchHumanities(View view) {
        String url = "https://www.wpi.edu/academics/calendar-courses/course-descriptions/17866/humanities-arts";
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void launchIMGD(View view) {
        String url = "https://www.wpi.edu/academics/calendar-courses/course-descriptions/17941/interactive-media-game-development";
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void launchMath(View view) {
        String url = "https://www.wpi.edu/academics/calendar-courses/course-descriptions/17881/mathematical-sciences";
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void launchScience(View view) {
        Intent intent = new Intent(this, Science.class);
        startActivity(intent);
    }

    public void launchSocialScience(View view) {
        String url = "https://www.wpi.edu/academics/calendar-courses/course-descriptions/17896/social-science-policy-studies";
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }

    }
}
