package app.gimbus.shoproute;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        //Buttons
        Button createListButton = findViewById(R.id.create_list_button);
        Button browseShopsButton = findViewById(R.id.browse_shops_button);
        Button savedLists = findViewById(R.id.saved_lists);
        createListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChooseShopActivity.class);
                startActivity(intent);
            }
        });
        browseShopsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BrowseShopsActivity.class);
                startActivity(intent);
            }
        });
        savedLists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SavedListsActivity.class));
            }
        });
    }
}
