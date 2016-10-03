package com.example.administrator.listviewtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    static final int EDIT_TEXT_REQUEST = 1;  // The request code

    ListView listView;
    ArrayList<VehicleModel> myListData;
    ArrayAdapter<VehicleModel> myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_activity);

        createDataList();

        listView = (ListView) findViewById(R.id.warp_list);

        // Insert data into CustomAdapter
        myAdapter = new MyCustomAdapter(this, 0, myListData);

        // Set adapter to ListView
        // It will create ListView with ArrayList automatically
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // If click each item on ListView
                Intent intent = new Intent(ListViewActivity.this, InformationActivity.class);

                // The i variable is a position (of ArrayList and ListView)
                // Now put any data into intent
                intent.putExtra("SelectedVehicle", myListData.get(i));
                intent.putExtra("Position", i + "");

                // Send intent then start InformationActivity and wait for result
                startActivityForResult(intent, EDIT_TEXT_REQUEST);

            }
        });

        // OK, let's see InformationActivity now!!
        // ─=≡Σ((( つ•̀ω•́)つLET’S GO!

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to #ก็อบเขามา
        if (requestCode == EDIT_TEXT_REQUEST) {
            // Make sure the request was successful #ก็อบเขามา
            if (resultCode == RESULT_OK) {

                // Do something here #ก็อบเขามา

                listView = (ListView) findViewById(R.id.warp_list);

                // Get a position of user selected item on ListView
                int position = Integer.parseInt(data.getStringExtra("Position"));

                // Set view point at the last time once user click on ListView item
                listView.setSelection(position);

                // Get Edited data from InformationActivity
                VehicleModel vehicleModel = (VehicleModel) data.getSerializableExtra("EditedVehicle");
                String editedHeader = vehicleModel.getHeader();
                String editedContent = vehicleModel.getContent();

                // Set Edited data into each ArrayList element
                myListData.get(position).setHeader(editedHeader);
                myListData.get(position).setContent(editedContent);

                // Ok and then notify our adapter to make sure that ArrayList<VehicleModel> is updated!!
                myAdapter.notifyDataSetChanged();
                //┬┴┬┴┤(･_├┬┴┬┴ // |||||ω・)|||||

                // finish Yeah!! \\(ಸ‿ಸ)//

            }
        }
    }

    private void createDataList(){

        myListData = new ArrayList<>();

        // Create data for ListView
        myListData.add(new VehicleModel("airplane", "nothing", R.drawable.airplane));
        myListData.add(new VehicleModel("ambulance", "nothing", R.drawable.ambulance));
        myListData.add(new VehicleModel("articulated lorry", "nothing", R.drawable.articulated_lorry));
        myListData.add(new VehicleModel("automobile", "nothing", R.drawable.automobile));
        myListData.add(new VehicleModel("bicycle", "nothing", R.drawable.bicycle));
        myListData.add(new VehicleModel("bus", "nothing", R.drawable.bus));
        myListData.add(new VehicleModel("canoe", "nothing", R.drawable.canoe));
        myListData.add(new VehicleModel("fire engine", "nothing", R.drawable.fire_engine));
        myListData.add(new VehicleModel("helicopter", "nothing", R.drawable.helicopter));
        myListData.add(new VehicleModel("minibus", "nothing", R.drawable.minibus));
        myListData.add(new VehicleModel("motor scooter", "nothing", R.drawable.motor_scooter));
        myListData.add(new VehicleModel("police car", "nothing", R.drawable.police_car));
        myListData.add(new VehicleModel("recreational_vehicle", "nothing", R.drawable.recreational_vehicle));
        myListData.add(new VehicleModel("rocket", "nothing", R.drawable.rocket));
        myListData.add(new VehicleModel("scooter", "nothing", R.drawable.scooter));
        myListData.add(new VehicleModel("taxi", "nothing", R.drawable.taxi));
        myListData.add(new VehicleModel("tractor", "nothing", R.drawable.tractor));
        myListData.add(new VehicleModel("trolleybus", "nothing", R.drawable.trolleybus));
        // W T F

//        for (int i = 1; i < 26; i++) {
//            myListData.add(new VehicleModel("Header " + i, getResources().getString(R.string.lorem) + " " + i));
//        }

    }



}
