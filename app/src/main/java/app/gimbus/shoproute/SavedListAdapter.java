package app.gimbus.shoproute;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.text.format.DateFormat;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by tobi6 on 12.03.2018.
 */

class SavedListAdapter extends ArrayAdapter  {


    SavedListAdapter(Context context, List<Pair<String, Set<String>>> lists){
        super(context, 0, lists);
    }

    public View getView(int position, View convertView,@NonNull final ViewGroup parent){
        final Pair<String, Set<String>> pair = (Pair<String, Set<String>>) getItem(position);
        Date unparsed = new Date(pair.first);
        String date = DateFormat.getTimeFormat(getContext()).format(unparsed)+" "+DateFormat.getDateFormat(getContext()).format(unparsed);
        final ArrayList<String> shop = new ArrayList<>();
        shop.addAll(pair.second);
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
                SharedPreferences.Editor edit = getContext().getSharedPreferences(String.valueOf(R.string.preferences), Context.MODE_PRIVATE).edit();
                edit.remove(pair.first);
                edit.apply();
                remove(pair);
                notifyDataSetChanged();
            }
        });
        return convertView;
    }
}
