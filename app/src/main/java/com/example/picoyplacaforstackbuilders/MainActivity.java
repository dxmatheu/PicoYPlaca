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

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText DateAndTime;
    Button CheckBtn;
    private LicensePlateAndDateInfo LPandDateInfo = LicensePlateAndDateInfo.getInstance();

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
                LPandDateInfo.setDigit1(newVal);
                Log.e("flag for number picker: ", String.valueOf(newVal));
            }
        });

        LicenseDigit2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                LPandDateInfo.setDigit2(newVal);
                Log.e("flag for number picker: ", String.valueOf(LPandDateInfo.Digit2));
            }
        });

        LicenseDigit3.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                LPandDateInfo.setDigit3(newVal);
            }
        });

        LicenseDigit4.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                LPandDateInfo.setDigit4(newVal);
            }
        });

        DateAndTime = findViewById(R.id.DateAndTimeET);
        DateAndTime.setInputType(InputType.TYPE_NULL);

        DateAndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDateTimeDialog(DateAndTime);
            }
        });

        CheckBtn.setOnClickListener(this::ButtonClicked);

    }

    private void ButtonClicked(View view) {

        if(LPandDateInfo.DayOfWeek != -1 && LPandDateInfo.Hour != -1){
            startActivity(new Intent(this, ShowResult.class));
        }
        else{
            Toast.makeText(getApplicationContext(),"Please fill in a date first",Toast.LENGTH_SHORT).show();
        }

    }

    private void ShowDateTimeDialog(EditText dateAndTime) {
        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                LPandDateInfo.setDayOfWeek(calendar.get(Calendar.DAY_OF_WEEK));
                Log.e("day of month ", String.valueOf(calendar.get(Calendar.DAY_OF_WEEK)));


                TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        LPandDateInfo.setHour(calendar.get(Calendar.HOUR_OF_DAY));
                        Log.e("hour of day ", String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)));
                        calendar.set(Calendar.MINUTE,minute);
                        LPandDateInfo.setMinute(calendar.get(Calendar.MINUTE));
                        Log.e("minute of hour ", String.valueOf(calendar.get(Calendar.MINUTE)));

                        SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm");

                        DateAndTime.setText(dateFormat.format(calendar.getTime()));

                    }
                };

                new TimePickerDialog(MainActivity.this, timeSetListener,
                        calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false).show();
            }
        };

        new DatePickerDialog(MainActivity.this, dateSetListener,
                calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();

    }

}