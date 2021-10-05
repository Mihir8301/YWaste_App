package com.example.ywasteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class new_donation_page extends  AppCompatActivity {
    private TextView displaytime;
    int hour,minute;
    EditText dateformat;
    int year,month,day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_donation_page);

        displaytime=findViewById(R.id.editTextDate);

        dateformat=findViewById(R.id.editTextDate);
        Calendar calender= Calendar.getInstance();



        displaytime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hour=calender.get(Calendar.HOUR_OF_DAY);
                minute=calender.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog=new TimePickerDialog(new_donation_page .this, R.style.Theme_AppCompat_Dialog, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        Calendar c=Calendar.getInstance();
                        c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        c.set(Calendar.MINUTE,minute);
                        c.setTimeZone(TimeZone.getDefault());
                        SimpleDateFormat format=new SimpleDateFormat("k:mm a");
                        String time=format.format(c.getTime());
                        displaytime.setText(time);
                    }
                },hour,minute,false);
                timePickerDialog.show();
            }
        });

        dateformat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year=calender.get(Calendar.YEAR);
                month=calender.get(Calendar.MONTH);
                day=calender.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog=new DatePickerDialog(new_donation_page .this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dateformat.setText(SimpleDateFormat.getDateInstance().format(calender.getTime()));
                    }
                },year,month,day);
                datePickerDialog.show();

            }
        });


    }
}