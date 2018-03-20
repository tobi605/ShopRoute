package app.gimbus.shoproute;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.route_show);
        if (!ShoppingListHolder.getInstance().isSorted())
            ShoppingListHolder.getInstance().sortItems(ShopHolder.getInstance().getShop());
        shoppingList = ShoppingListHolder.getInstance().getList();

        final TextView currentItemName = findViewById(R.id.current_item_name);
        final ListView otherItems = findViewById(R.id.other_items);
        Button postponeButton = findViewById(R.id.postpone_item);
        Button gotItButton = findViewById(R.id.got_item);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();
        if (preferences.getInt(String.valueOf(R.string.saved_list_index), -1) == -1) {
            editor.putInt(String.valueOf(R.string.saved_list_index), 0);
            editor.apply();
        }

        builder.setTitle(R.string.dialog_title);
        if (!ShoppingListHolder.getInstance().getComesFromSave()) {
            builder.setMultiChoiceItems(new String[]{getApplicationContext().getResources().getString(R.string.save_list_question)},
                    null, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                            if (b) ShoppingListHolder.getInstance().setToBeSaved();
                        }
                    });
        }

        builder.setPositiveButton(R.string.dialog_positive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (ShoppingListHolder.getInstance().getToBeSaved()) {
                    ShoppingListHolder.getInstance().saveListToFile(preferences.getInt(String.valueOf(R.string.saved_list_index), -1), getApplicationContext());
                    editor.putInt(String.valueOf(R.string.saved_list_index), preferences.getInt(String.valueOf(R.string.saved_list_index), -1) + 1);
                }
                ShoppingListHolder.getInstance().clearList();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        final AlertDialog dialog = builder.create();

        current = shoppingList.remove(0);
        currentItemName.setText(current.toString());
        final ArrayAdapter<Product> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.shop_browse_item, shoppingList);
        otherItems.setAdapter(arrayAdapter);

        gotItButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shoppingList.size() == 0) {
                    currentItemName.setText(R.string.no_item);
                    current = null;
                    dialog.show();
                } else if (shoppingList.size() == 1) {
                    current = shoppingList.remove(0);
                    arrayAdapter.notifyDataSetChanged();
                    currentItemName.setText(current.toString());
                } else {
                    current = shoppingList.remove(0);
                    arrayAdapter.notifyDataSetChanged();
                    currentItemName.setText(current.toString());
                }
            }
        });
        postponeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!shoppingList.isEmpty()) {
                    shoppingList.add(current);
                    current = shoppingList.remove(0);
                    arrayAdapter.notifyDataSetChanged();
                    currentItemName.setText(current.toString());
                }
            }
        });
    }
}
