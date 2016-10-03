package com.example.administrator.listviewtest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 30/9/2559.
 * This is a Custom Adapter class you can customize adapter to connect adaptee here!!
 * adaptee is a whatever List appearance that your create with own splendid ideal eiei
 */

class MyCustomAdapter extends ArrayAdapter<VehicleModel>{

     MyCustomAdapter(Context context, int resource, List<VehicleModel> myData) {
         // resource variable is The resource ID for a layout file
         // containing a TextView to use when instantiating views #ก็อบเขามา
         // in this case --> not in use
        super(context, 0, myData);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        // **convertView is a 1 item in ListView
        View currentView = convertView; //**

        // Check if an existing view is being reused, otherwise inflate the view
        if (currentView == null) {
            currentView = LayoutInflater.from(getContext()).inflate(R.layout.item_list, parent, false);
        }

        // getItem is a Superclass(ArrayAdapter) method to get List<> object conveniently
        VehicleModel myData = getItem(position);

        // set image on this View
        ImageView image = (ImageView) currentView.findViewById(R.id.image_item);
        image.setImageResource(myData.getImageId());

        // set header
        TextView header = (TextView) currentView.findViewById(R.id.header);
        header.setText(myData.getHeader());

        // set content
        TextView content = (TextView) currentView.findViewById(R.id.content);
        content.setText(myData.getContent());

        return currentView;

    }

    // ┬┴┬┴┤(･_├┬┴┬┴ ┬┴┬┴┤(･_├┬┴┬┴ ┬┴┬┴┤(･_├┬┴┬┴
    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
    //|||||ω・)||||| |||||ω・)||||| |||||ω・)|||||


}
