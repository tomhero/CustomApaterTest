package com.example.administrator.listviewtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class InformationActivity extends AppCompatActivity {

    VehicleModel selectedVehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_information);

        Intent myIntent = getIntent(); // gets the previously created intent (゜∀゜)!!!
        selectedVehicle = (VehicleModel) myIntent.getSerializableExtra("SelectedVehicle");
        int imageResourceId = selectedVehicle.getImageId(); // getter from VehicleModel class
        String selectedHeader = selectedVehicle.getHeader(); // getter from VehicleModel class
        String selectedContent = selectedVehicle.getContent(); // getter from VehicleModel class
        final String selectedPosition = myIntent.getStringExtra("Position");

        ImageView vehicleImage = (ImageView) findViewById(R.id.vehicle_image);
        vehicleImage.setImageResource(imageResourceId);

        // set text to show header that user has selected
        final TextView header = (TextView) findViewById(R.id.sub_header);
        header.setText(selectedHeader);
        //header.setEnabled(false);

        // set text to show content that user has selected
        final TextView content = (TextView) findViewById(R.id.sub_content);
        content.setText(selectedContent);
        //content.setEnabled(false);


        Button saveButton = (Button) findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // when click on the save button
                Intent intent = new Intent();

                // prepare intent to send back of it
                selectedVehicle.setHeader(header.getText().toString()); // setter from VehicleModel class
                selectedVehicle.setContent(content.getText().toString()); // setter from VehicleModel class
                intent.putExtra("EditedVehicle", selectedVehicle);
                intent.putExtra("Position", selectedPosition);

                // You must call setResult method to send back the result here !important
                setResult(RESULT_OK ,intent); //USE RESULT_OK because that Result is OK? (ಠ_ಠ)
                finish(); //And then finishing activity

                // Ok, return to ListViewActivity now!! | ε=┌(;･_･)┘ |
                // and then see onActivityResult!!
            }
        });

//        Button editHeaderButton = (Button) findViewById(R.id.edit_header_button);
//        editHeaderButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                content.setEnabled(false);
//                header.setEnabled(true);
//                header.requestFocus();
//            }
//        });
//
//        Button editContentButton = (Button) findViewById(R.id.edit_content_button);
//        editContentButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                header.setEnabled(false);
//                content.setEnabled(true);
//                content.requestFocus();
//            }
//        });

    }





}
