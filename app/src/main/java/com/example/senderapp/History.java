package com.example.senderapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class History extends AppCompatActivity {
    TextView text;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        text=(TextView) findViewById(R.id.textView);
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://senderapp-85057.firebaseio.com/");


        DatabaseReference myRef = database.getReference("Parcels");


        ValueEventListener postListener = new ValueEventListener() {
            @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
               // HashMap temp= dataSnapshot.getValue(HashMap.class);
                text.setText(String.valueOf(dataSnapshot.getValue()));
                // ...
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                text.setText("nao");
            }
        };

        myRef.addValueEventListener(postListener);

    }
}
