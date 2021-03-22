package com.example.picoyplacaforstackbuilders;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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

        CheckBtn.setOnClickListener(this::ButtonClicked);

    }

    private void ButtonClicked(View view) {

        if(LPAndDateInfo.DayOfWeek != -1 && LPAndDateInfo.Hour != -1){
            startActivity(new Intent(this, ResultActivity.class));
        }
        else{
            Toast.makeText(getApplicationContext(),"Please fill in a date first",Toast.LENGTH_SHORT).show();
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
