package com.example.senderapp;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AddParcelActivity extends AppCompatActivity {

    Button btnDatePicker ,btnDatePicker2;
    EditText txtDate,txtDate2;
    private int mYear, mMonth, mDay;



    //calendario
    @Override
    protected void onCreate(Bundle savedInstanceState) { //configurando os botoes e caixas de texto
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_parcel);

        btnDatePicker=(Button)findViewById(R.id.btn_date);
        btnDatePicker2=(Button)findViewById(R.id.btn2_date);

        txtDate=(EditText)findViewById(R.id.mishdate);
        txtDate2=(EditText)findViewById(R.id.kabala_date);


        btnDatePicker.setOnClickListener((View.OnClickListener) this);
        btnDatePicker2.setOnClickListener((View.OnClickListener) this);
        //checar conversão


    }


        public void onClick(View v) {

            if (v == btnDatePicker) {

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

        }


    }

    //claendario kabala

