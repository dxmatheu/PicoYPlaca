package com.example.picoyplacaforstackbuilders;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText TimeET;
    EditText DateET;
    Button CheckBtn;
    private final LicensePlateAndDateInfo LPAndDateInfo = LicensePlateAndDateInfo.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CheckBtn = findViewById(R.id.CheckBtn);

        NumberPicker LicenseDigit1 = findViewById(R.id.LicenseDigit1);
        NumberPicker LicenseDigit2 = findViewById(R.id.LicenseDigit2);
        NumberPicker LicenseDigit3 = findViewById(R.id.LicenseDigit3);
        NumberPicker LicenseDigit4 = findViewById(R.id.LicenseDigit4);

        LicenseDigit1.setMaxValue(9);
        LicenseDigit1.setMinValue(0);
        LicenseDigit2.setMinValue(0);
        LicenseDigit3.setMaxValue(9);
        LicenseDigit2.setMaxValue(9);
        LicenseDigit3.setMinValue(0);
        LicenseDigit4.setMinValue(0);
        LicenseDigit4.setMaxValue(9);

        LicenseDigit1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener(){
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                LPAndDateInfo.setDigit1(newVal);
            }
        });

        LicenseDigit2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                LPAndDateInfo.setDigit2(newVal);
            }
        });

        LicenseDigit3.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                LPAndDateInfo.setDigit3(newVal);
            }
        });

        LicenseDigit4.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                LPAndDateInfo.setDigit4(newVal);
            }
        });

        TimeET = findViewById(R.id.TimeET);
        TimeET.setInputType(InputType.TYPE_NULL);

        TimeET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowTimeDialog(TimeET);
            }
        });

        DateET = findViewById(R.id.DateET);
        CheckBtn.setOnClickListener(this::ButtonClicked);

    }

    private void ButtonClicked(View view) {

        Calendar calendar = Calendar.getInstance();
        LPAndDateInfo.setDayOfWeek(Calendar.getInstance().get(Calendar.DAY_OF_WEEK));
        if(!DateET.getText().toString().matches("")){
            try {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                calendar.setTime(dateFormat.parse(DateET.getText().toString()));
            }
            catch (ParseException e){
                Toast.makeText(getApplicationContext(),"Using today's date",Toast.LENGTH_SHORT).show();
            }
        }
        if(DateET.getText().toString().matches("")){
            Toast.makeText(getApplicationContext(),"Please fill in a date first",Toast.LENGTH_SHORT).show();
        }

        else if(LPAndDateInfo.getHour() == -1){
            Toast.makeText(getApplicationContext(),"Please pick an hour",Toast.LENGTH_SHORT).show();
        }
        else{
            LPAndDateInfo.setDayOfWeek(calendar.get(Calendar.DAY_OF_WEEK));
            startActivity(new Intent(this, ResultActivity.class));

        }

    }

    private void ShowTimeDialog(EditText TimeET) {
        final Calendar calendar = Calendar.getInstance();

        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                LPAndDateInfo.setHour(calendar.get(Calendar.HOUR_OF_DAY));
                calendar.set(Calendar.MINUTE,minute);
                LPAndDateInfo.setMinute(calendar.get(Calendar.MINUTE));

                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
                TimeET.setText(dateFormat.format(calendar.getTime()));

            }
        };

        new TimePickerDialog(MainActivity.this, timeSetListener,
                calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE),
                        false).show();
    }
}
