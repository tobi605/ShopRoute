package app.gimbus.shoproute;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.Vector;

/**
 * Created by tobi6 on 21.01.2018.
 */

public class CreateListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedinstance){
        super.onCreate(savedinstance);
        setContentView(R.layout.list_creator);

        ListView productList = findViewById(R.id.list_creator_list);
        LinkedList<Product> products = ShopHolder.getInstance().getShop().getProducts();
        ProductAdapter adapter = new ProductAdapter(getApplicationContext(),products);
        productList.setAdapter(adapter);
        Button previewList = findViewById(R.id.previewListButton);
        Button showRoute = findViewById(R.id.showRouteButton);

        previewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateListActivity.this, PreviewListActivity.class);
                startActivity(intent);
            }
        });

        showRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateListActivity.this, ShowRouteActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
