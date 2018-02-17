package app.gimbus.shoproute;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by tobi6 on 17.02.2018.
 */

public class ProductAdapter extends ArrayAdapter<Product> {

    ProductAdapter(@NonNull Context context, Product[] products) {
        super(context, 0, products);
    }

    @Override
    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent){
        Product product = getItem(position);
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list_element, parent, false);
        }
        TextView name = convertView.findViewById(R.id.itemName);
        Button addButton = convertView.findViewById(R.id.list_item_add);
        name.setText(product.toString());
        addButton.setTag(product);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShoppingListHolder.getInstance().addItem((Product) view.getTag());
            }
        });
        return convertView;
    }
}
