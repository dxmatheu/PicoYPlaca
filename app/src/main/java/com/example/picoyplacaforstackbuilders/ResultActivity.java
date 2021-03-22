package com.example.picoyplacaforstackbuilders;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private LicensePlateAndDateInfo LPAndDateInfo = LicensePlateAndDateInfo.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView LicensePlate = findViewById(R.id.LisencePlateTV);
        TextView DateAndTime = findViewById(R.id.DateAndTimeTV);
        TextView Result = findViewById(R.id.ResultTV);

        LicensePlate.setText("XXX-" + LPAndDateInfo.Digit1 + LPAndDateInfo.Digit2 + LPAndDateInfo.Digit3 + LPAndDateInfo.Digit4);

        if(LPAndDateInfo.DayOfWeek == 1){
            if(LPAndDateInfo.Minute <= 9){
                DateAndTime.setText("On: Sunday" + " at: " + LPAndDateInfo.Hour + "H0" + LPAndDateInfo.Minute);
            }
            else
                DateAndTime.setText("On: Sunday" + " at: " + LPAndDateInfo.Hour + "H" + LPAndDateInfo.Minute);
        }
        else if(LPAndDateInfo.DayOfWeek == 2){
            if(LPAndDateInfo.Minute <= 9){
                DateAndTime.setText("On: Monday" + " at: " + LPAndDateInfo.Hour + "H0" + LPAndDateInfo.Minute);
            }
            else
                DateAndTime.setText("On: Monday" + " at: " + LPAndDateInfo.Hour + "H" + LPAndDateInfo.Minute);
        }
        else if(LPAndDateInfo.DayOfWeek == 3){
            if(LPAndDateInfo.Minute <= 9){
                DateAndTime.setText("On: Tuesday" + " at: " + LPAndDateInfo.Hour + "H0" + LPAndDateInfo.Minute);
            }
            else
                DateAndTime.setText("On: Tuesday" + " at: " + LPAndDateInfo.Hour + "H" + LPAndDateInfo.Minute);
        }
        else if(LPAndDateInfo.DayOfWeek == 4){
            if(LPAndDateInfo.Minute <= 9){
                DateAndTime.setText("On: Wednesday" + " at: " + LPAndDateInfo.Hour + "H0" + LPAndDateInfo.Minute);
            }
            else
                DateAndTime.setText("On: Wednesday" + " at: " + LPAndDateInfo.Hour + "H" + LPAndDateInfo.Minute);
        }
        else if(LPAndDateInfo.DayOfWeek == 5){
            if(LPAndDateInfo.Minute <= 9){
                DateAndTime.setText("On: Thursday" + " at: " + LPAndDateInfo.Hour + "H0" + LPAndDateInfo.Minute);
            }
            else
                DateAndTime.setText("On: Thursday" + " at: " + LPAndDateInfo.Hour + "H" + LPAndDateInfo.Minute);
        }
        else if(LPAndDateInfo.DayOfWeek == 6){
            if(LPAndDateInfo.Minute <= 9){
                DateAndTime.setText("On: Friday" + " at: " + LPAndDateInfo.Hour + "H0" + LPAndDateInfo.Minute);
            }
            else
                DateAndTime.setText("On: Friday" + " at: " + LPAndDateInfo.Hour + "H" + LPAndDateInfo.Minute);
        }
        else if(LPAndDateInfo.DayOfWeek == 7){
            if(LPAndDateInfo.Minute <= 9){
                DateAndTime.setText("On: Saturday" + " at: " + LPAndDateInfo.Hour + "H0" + LPAndDateInfo.Minute);
            }
            else
                DateAndTime.setText("On: Saturday" + " at: " + LPAndDateInfo.Hour + "H" + LPAndDateInfo.Minute);
        }

        if(LPAndDateInfo.Hour >= 7 && LPAndDateInfo.Hour <= 9 && LPAndDateInfo.Minute <= 30
                || LPAndDateInfo.Hour >= 16 && LPAndDateInfo.Hour <= 19 && LPAndDateInfo.Minute <=30){
            if((LPAndDateInfo.Digit4 == 1 || LPAndDateInfo.Digit4 == 2) && LPAndDateInfo.DayOfWeek == 2){
                Result.setText("CAN'T GO OUT");
                Result.setTextColor(Color.RED);
            }
            else if((LPAndDateInfo.Digit4 == 3 || LPAndDateInfo.Digit4 == 4) && LPAndDateInfo.DayOfWeek == 3){
                Result.setText("CAN'T GO OUT");
                Result.setTextColor(Color.RED);
            }
            else if((LPAndDateInfo.Digit4 == 5 || LPAndDateInfo.Digit4 == 6) && LPAndDateInfo.DayOfWeek == 4){
                Result.setText("CAN'T GO OUT");
                Result.setTextColor(Color.RED);
            }
            else if((LPAndDateInfo.Digit4 == 7 || LPAndDateInfo.Digit4 == 8) && LPAndDateInfo.DayOfWeek == 5){
                Result.setText("CAN'T GO OUT");
                Result.setTextColor(Color.RED);
            }
            else if((LPAndDateInfo.Digit4 == 9 || LPAndDateInfo.Digit4 == 0) && LPAndDateInfo.DayOfWeek == 6){
                Result.setText("CAN'T GO OUT");
                Result.setTextColor(Color.RED);
            }
            else{
                Result.setText("can go out");
                Result.setTextColor(Color.GREEN);
            }
        }
        else{
            Result.setText("can go out");
            Result.setTextColor(Color.GREEN);
        }

    }
}