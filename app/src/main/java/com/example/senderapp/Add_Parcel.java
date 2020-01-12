package com.example.senderapp;

import android.app.DatePickerDialog;
import android.content.Intent;
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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;



public class Add_Parcel extends AppCompatActivity implements LocationListener {
//implements View.OnClickListener

    private LocationManager locationManager;


    Button btnDatePicker, sendbtnDatePicker,confirm;
    EditText sendDate,name,phone,email,address,expectedDate;
    CheckBox fragil;
    Spinner type,weight;
    TextView phoneText;
    TextView location,emailtext,nametext,addresstext,sendText,expecText,typeText,weightText,status;
    public int mYear, mMonth, mDay, smYear, smMonth, smDay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__parcel);






        btnDatePicker = (Button) findViewById(R.id.btn_date);
        sendDate = (EditText) findViewById(R.id.in_date);

        sendbtnDatePicker = (Button) findViewById(R.id.btn_send_date);
        expectedDate = (EditText) findViewById(R.id.send_date);

        name=(EditText) findViewById(R.id.Name);
        phone=(EditText) findViewById(R.id.Phone);
        email=(EditText)  findViewById(R.id.Email);
        address=(EditText)findViewById(R.id.addressText);
        confirm=(Button) findViewById(R.id.Confirm);
        fragil=(CheckBox) findViewById(R.id.Fragil);
        weight=(Spinner) findViewById(R.id.spinner2);
        type=(Spinner) findViewById(R.id.spinner);
        phoneText=(TextView)  findViewById(R.id.phonetext);
        location = (TextView) findViewById(R.id.location);
        emailtext=(TextView ) findViewById(R.id.emailtext);
        addresstext=(TextView ) findViewById(R.id.addresstext);
        nametext=(TextView ) findViewById(R.id.nameText);
        sendText=(TextView ) findViewById(R.id.sendtext);
        expecText=(TextView ) findViewById(R.id.expectText);
        typeText=(TextView ) findViewById(R.id.spintext1);
        weightText=(TextView ) findViewById(R.id.spintext2);
        status=(TextView ) findViewById(R.id.statusText);
       /* new_parcel.setName(name.getText().toString());
        new_parcel.setPhoneNumber(phone.getText().toString());
        new_parcel.setEmail(email.getText().toString());
        new_parcel.setAddress(address.getText().toString());
        new_parcel.setWeight(weight.getSelectedItem().toString());
        new_parcel.setType(type.getSelectedItem().toString());

        new_parcel.setFragile(fragil.isChecked());
        new_parcel.setSendDate(sendDate.getText().toString());
        new_parcel.setExpectedDate(expectedDate.getText().toString());
        */
       status.setTextSize(20);



        //LOCATION CONFIGURATIONS
        /*
        Location mobileLocation;
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(Add_Parcel.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(Add_Parcel.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Add_Parcel.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            return;
        } else {
            mobileLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            Geocoder geocoder;
            List<Address> addresses = null;
            geocoder = new Geocoder(this, Locale.getDefault());

            try {
                addresses = geocoder.getFromLocation(mobileLocation.getLatitude(), mobileLocation.getLongitude(), 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
            } catch (IOException e) {
                e.printStackTrace();
            }

            String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
            String city = addresses.get(0).getLocality();
            String state = addresses.get(0).getAdminArea();
            String country = addresses.get(0).getCountryName();
            String postalCode = addresses.get(0).getPostalCode();
            String knownName = addresses.get(0).getFeatureName(); // Only if available else return NULL


            location.setText(
                    city + "  ," + state + "  ," + country + "  ," + postalCode);

        }

        if (ActivityCompat.checkSelfPermission(Add_Parcel.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(Add_Parcel.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Add_Parcel.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            return;
        } else {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                    3000,   // 3 sec
                    0, this);

        }

    /*

*/







    }

    @Override
    public void onLocationChanged(Location location) {




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
                city + "  ," + state + "  ," + country + "  ," + postalCode);
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

                        sendDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

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

                            expectedDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, smYear, smMonth, smDay);
            datePickerDialog.show();

    }



    public void confirmClick(View v){
        Calendar now = Calendar.getInstance();
        sendText.setText("");
        expecText.setText("");
        phoneText.setText("");
        emailtext.setText("");
        addresstext.setText("");
        nametext.setText("");
        expecText.setText("");
        weightText.setText("");

        Boolean flag=false;
        Date today=new Date();
        if(mYear > now.get(Calendar.YEAR)||mMonth > now.get(Calendar.MONTH) ||(mDay > now.get(Calendar.DAY_OF_MONTH)) || sendDate.getText().toString().isEmpty())
        {
            sendText.setTextColor(Color.RED);
            sendText.setText("invalid date");
            flag =true;
        }
        if(smYear > now.get(Calendar.YEAR) ||smMonth > now.get(Calendar.MONTH) ||(smDay > now.get(Calendar.DAY_OF_MONTH))||expectedDate.getText().toString().isEmpty())
        {
            expecText.setTextColor(Color.RED);
            expecText.setText("invalid date");
            flag=true;
        }
     if(phone.length() < 9) {
         flag=true;
         phoneText.setText("you must to insert a valid number");
         phoneText.setTextColor(Color.RED);

     }
    if(!email.getText().toString().contains("@") || !email.getText().toString().contains("co") || !email.getText().toString().contains(".")) {
        emailtext.setTextColor(Color.RED);
        emailtext.setText("you must insert a valid email");
        flag=true;
    }
    if(address.getText().toString().isEmpty() || !address.getText().toString().contains(" ") ) {
        addresstext.setText("you must insert an valid address");
        addresstext.setTextColor(Color.RED);
        flag=true;
    }
    if(name.getText().toString().isEmpty()) {
        nametext.setTextColor(Color.RED);
        nametext.setText("invalid name");
        flag=true;
    }



   /* if(type.getSelectedItem().toString()||type.get )
    {
      expecText.setTextColor(Color.RED);
      expecText.setText("choose an option");
    }*/
    if(weight.getSelectedItem().toString()== "select your option" )
    {
        weightText.setTextColor(Color.RED);
        weightText.setText("choose an option");
    }
    if(flag)
        Toast.makeText(Add_Parcel.this,"CHECK YOUR ANSWERS",Toast.LENGTH_SHORT).show();
    else{
        Parcel new_parcel = new Parcel(location.getText().toString(),type.getSelectedItem().toString(),weight.getSelectedItem().toString(),fragil.isChecked(),name.getText().toString(),
                address.getText().toString(),sendDate.getText().toString(),expectedDate.getText().toString(),phone.getText().toString(),email.getText().toString()
        );

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://senderapp-85057.firebaseio.com");



        //DatabaseReference myRef = database.getReference("Parcel" + String.valueOf(new Date().getTime()) );
        DatabaseReference myRef = database.getReference("Parcels" );
        DatabaseReference myRef1 = myRef.child("Parcel" + String.valueOf(new Date().getTime()));


        HashMap<String,String> hashMap =new HashMap<>();
        hashMap.put("Location",new_parcel.getLocation());
        hashMap.put("Name",new_parcel.getName());
        hashMap.put("Phone Number",new_parcel.getPhoneNumber());
        hashMap.put("Email",new_parcel.getEmail());
        hashMap.put("Address",new_parcel.getAddress());
        hashMap.put("Weight",new_parcel.getWeight());
        hashMap.put("Parcel Type",new_parcel.getType());
        hashMap.put("Fragile",String.valueOf(new_parcel.isFragile()));
        hashMap.put("Send Date",new_parcel.getSendDate());
        hashMap.put("Expected Date",new_parcel.getExpectedDate());

        myRef1.setValue(hashMap);



        Toast.makeText(Add_Parcel.this,"the form has been submitted!",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(Add_Parcel.this, MainActivity.class));
    }
    }
}