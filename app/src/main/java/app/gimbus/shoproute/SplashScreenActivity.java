package app.gimbus.shoproute;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;


public class SplashScreenActivity extends AppCompatActivity {
    public void onCreate(Bundle savedinstance){
        super.onCreate(savedinstance);
        setContentView(R.layout.splash_screen);
        int delay = 1500;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                finish();
            }
        }, delay);
    }
}
