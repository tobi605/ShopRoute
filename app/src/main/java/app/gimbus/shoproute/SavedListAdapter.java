package app.gimbus.shoproute;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tobi6 on 12.03.2018.
 */

class SavedListAdapter extends ArrayAdapter  {


    SavedListAdapter(Context context, ArrayList<ArrayList<String>> lists){
        super(context, 0, lists);
    }

    public View getView(int position, View convertView,@NonNull final ViewGroup parent){
        final List<String> list = (ArrayList<String>) getItem(position);
        String date = list.get(2)+" "+list.get(1);
        final ArrayList<String> shop = new ArrayList<>();
        for (int i = 3; i < list.size(); i++)
            shop.add(list.get(i));
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.saved_list_element, parent, false);
        }
        TextView dateView = convertView.findViewById(R.id.list_element_date);
        TextView shopView = convertView.findViewById(R.id.list_element_shop);
        Button delete = convertView.findViewById(R.id.delete_saved);

        dateView.setText(date);
        shopView.setText(shop.get(0));

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                SavedListsActivity.setShopAndProducts(shop);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getContext().deleteFile(list.get(0)+"");
                remove(list);
                notifyDataSetChanged();
            }
        });
        return convertView;
    }
}
