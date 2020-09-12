package com.example.gadsleaderboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

public class LandingActivity extends AppCompatActivity {

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        ImageView image = (ImageView) findViewById(R.id.landing_image);
        image.setImageDrawable(this.getDrawable(R.drawable.gads_image));

        getStarted();
    }

    private void getStarted() {
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(LandingActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },5000);
    }
}
