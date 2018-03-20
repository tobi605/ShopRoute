package app.gimbus.shoproute;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;

import java.util.LinkedList;

/**
 * Created by tobi6 on 21.01.2018.
 */

public class CreateListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedinstance){
        super.onCreate(savedinstance);
        setContentView(R.layout.list_creator);

        ListView productList = findViewById(R.id.list_creator_list);
        Button previewList = findViewById(R.id.previewListButton); // list preview
        Button showRoute = findViewById(R.id.showRouteButton); // accept list
        final AutoCompleteTextView autoCompleteTextView = findViewById(R.id.text_input);

        final LinkedList<Product> products = ShopHolder.getInstance().getShop().getProducts();
        final ProductAdapter adapter = new ProductAdapter(getApplicationContext(),products);
        final ArrayAdapter<Product> productArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, products);

        autoCompleteTextView.setAdapter(productArrayAdapter);
        productList.setAdapter(adapter);

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

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ShoppingListHolder.getInstance().addItem((Product) adapterView.getItemAtPosition(i));
                products.remove(adapterView.getItemAtPosition(i));
                productArrayAdapter.notifyDataSetChanged();
                adapter.notifyDataSetChanged();
                autoCompleteTextView.setText("");
            }
        });
    }
}
