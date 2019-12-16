package com.example.senderapp;
import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;



public class Add_Parcel extends AppCompatActivity implements LocationListener {
//implements View.OnClickListener

    private LocationManager locationManager;


    Button btnDatePicker, sendbtnDatePicker,confirm;
    EditText txtDate, sendtxtDate,name,phone,email,address;
    CheckBox fragil;
    Spinner type,weight;
    private int mYear, mMonth, mDay, smYear, smMonth, smDay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__parcel);


        btnDatePicker = (Button) findViewById(R.id.btn_date);
        txtDate = (EditText) findViewById(R.id.in_date);

        sendbtnDatePicker = (Button) findViewById(R.id.btn_send_date);
        sendtxtDate = (EditText) findViewById(R.id.send_date);

        name=(EditText) findViewById(R.id.Name);
        phone=(EditText) findViewById(R.id.Phone);
        email=(EditText)  findViewById(R.id.Email);
        address=(EditText)findViewById(R.id.addressText);
        confirm=(Button) findViewById(R.id.Confirm);
        fragil=(CheckBox) findViewById(R.id.Fragil);
        weight=(Spinner) findViewById(R.id.spinner2);
        type=(Spinner) findViewById(R.id.spinner);





        //LOCATION CONFIGURATIONS
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(Add_Parcel.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(Add_Parcel.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Add_Parcel.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            return;
        } else {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                    3000,   // 3 sec
                    0, this);

        }


    }

    @Override
    public void onLocationChanged(Location location) {

        //String str = "Latitude: "+location.getLatitude()+"\nLongitude: "+location.getLongitude();

        //Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();


        //////////////////////////////////

        Geocoder geocoder;
        List<Address> addresses = null;
        geocoder = new Geocoder(this, Locale.getDefault());

        try {
            addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
        } catch (IOException e) {
            e.printStackTrace();
        }

        String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
        String city = addresses.get(0).getLocality();
        String state = addresses.get(0).getAdminArea();
        String country = addresses.get(0).getCountryName();
        String postalCode = addresses.get(0).getPostalCode();
        String knownName = addresses.get(0).getFeatureName(); // Only if available else return NULL

        TextView textViewToChange = (TextView) findViewById(R.id.location);
        textViewToChange.setText(
                city + " ," + state + " ," + country + " ," + postalCode);
        //////////////////////////////
    }

    @Override
    public void onProviderDisabled(String provider) {

        /******** Called when User off Gps *********/

        Toast.makeText(getBaseContext(), "Gps turned off ", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProviderEnabled(String provider) {

        /******** Called when User on Gps  *********/


        Toast.makeText(getBaseContext(), "Gps turned on ", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub

    }


    //calendario em que o pacote sera enviado

    public void onClick(View v) {



        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();


    }

    //evento de clique no botao do segundo calendario(chegada prevista  do pacote)
    public void onClick2(View v) {



            // Get Current Date
            final Calendar d = Calendar.getInstance();
            smYear = d.get(Calendar.YEAR);
            smMonth = d.get(Calendar.MONTH);
            smDay = d.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            sendtxtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, smYear, smMonth, smDay);
            datePickerDialog.show();

    }

    public void confirmClick(View v){
        name.setTextColor(Color.BLACK);
        phone.setTextColor(Color.BLACK);
        email.setTextColor(Color.BLACK);
        address.setTextColor(Color.BLACK);
        Boolean flag=false;
     if(phone.length() < 9) {
         flag=true;
         phone.setTextColor(Color.RED);

     }
    if(!email.getText().toString().contains("@") || !email.getText().toString().contains("co") || !email.getText().toString().contains(".")) {
        email.setTextColor(Color.RED);

        flag=true;
    }
    if(address.getText().toString().isEmpty()) {
        address.setTextColor(Color.RED);
        flag=true;
    }
    if(name.getText().toString().isEmpty()) {
        name.setTextColor(Color.RED);
        flag=true;
    }
    if(flag)
        Toast.makeText(Add_Parcel.this,"INCORRECT INPUT",Toast.LENGTH_SHORT).show();
    else{

        Toast.makeText(Add_Parcel.this,"the form has been submitted!",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(Add_Parcel.this, MainActivity.class));
    }
    }
}