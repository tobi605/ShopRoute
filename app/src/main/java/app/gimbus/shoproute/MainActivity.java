package app.gimbus.shoproute;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        try {
            wait(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setContentView(R.layout.main_menu);
    }
}
