package app.gimbus.shoproute;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by tobi6 on 19.02.2018.
 */

public class ShowRouteActivity extends AppCompatActivity {
    private ArrayList<Product> shoppingList;
    private Product current;

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.route_show);
        if(!ShoppingListHolder.getInstance().isSorted()) ShoppingListHolder.getInstance().sortItems(ShopHolder.getInstance().getShop());
        shoppingList = ShoppingListHolder.getInstance().getList();

        final TextView currentItemName = findViewById(R.id.current_item_name);
        final ListView otherItems = findViewById(R.id.other_items);
        Button postponeButton = findViewById(R.id.postpone_item);
        Button gotItButton = findViewById(R.id.got_item);

        current = shoppingList.remove(0);
        currentItemName.setText(current.toString());
        final ArrayAdapter<Product> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.shop_browse_item, shoppingList);
        otherItems.setAdapter(arrayAdapter);

        gotItButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(shoppingList.size()==0){
                    currentItemName.setText(R.string.no_item);
                }
                else if(shoppingList.size()==1){
                    current = shoppingList.remove(0);
                    arrayAdapter.notifyDataSetChanged();
                    currentItemName.setText(current.toString());
                }
                else {
                    current = shoppingList.remove(0);
                    arrayAdapter.notifyDataSetChanged();
                    currentItemName.setText(current.toString());
                }
            }
        });
        postponeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shoppingList.add(current);
                current = shoppingList.remove(0);
                arrayAdapter.notifyDataSetChanged();
                currentItemName.setText(current.toString());
            }
        });
    }
}
