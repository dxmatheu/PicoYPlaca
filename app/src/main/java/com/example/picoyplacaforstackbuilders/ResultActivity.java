package com.example.picoyplacaforstackbuilders;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private final LicensePlateAndDateInfo LPAndDateInfo = LicensePlateAndDateInfo.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView LicensePlate = findViewById(R.id.LisencePlateTV);
        TextView DateAndTime = findViewById(R.id.DateAndTimeTV);
        TextView Result = findViewById(R.id.ResultTV);

        LicensePlate.setText("XXX-" + LPAndDateInfo.getDigit1() + LPAndDateInfo.getDigit2() + LPAndDateInfo.getDigit3() + LPAndDateInfo.getDigit4());

        if(LPAndDateInfo.getDayOfWeek() == 1){
            if(LPAndDateInfo.getMinute() <= 9){
                DateAndTime.setText("On: Sunday" + " at " + LPAndDateInfo.getHour() + "H0" + LPAndDateInfo.getMinute());
            }
            else
                DateAndTime.setText("On: Sunday" + " at " + LPAndDateInfo.getHour() + "H" + LPAndDateInfo.getMinute());
        }
        else if(LPAndDateInfo.getDayOfWeek() == 2){
            if(LPAndDateInfo.getMinute() <= 9){
                DateAndTime.setText("On: Monday" + " at " + LPAndDateInfo.getHour() + "H0" + LPAndDateInfo.getMinute());
            }
            else
                DateAndTime.setText("On: Monday" + " at " + LPAndDateInfo.getHour() + "H" + LPAndDateInfo.getMinute());
        }
        else if(LPAndDateInfo.getDayOfWeek() == 3){
            if(LPAndDateInfo.getMinute() <= 9){
                DateAndTime.setText("On: Tuesday" + " at " + LPAndDateInfo.getHour() + "H0" + LPAndDateInfo.getMinute());
            }
            else
                DateAndTime.setText("On: Tuesday" + " at " + LPAndDateInfo.getHour() + "H" + LPAndDateInfo.getMinute());
        }
        else if(LPAndDateInfo.getDayOfWeek() == 4){
            if(LPAndDateInfo.getMinute() <= 9){
                DateAndTime.setText("On: Wednesday" + " at " + LPAndDateInfo.getHour() + "H0" + LPAndDateInfo.getMinute());
            }
            else
                DateAndTime.setText("On: Wednesday" + " at " + LPAndDateInfo.getHour() + "H" + LPAndDateInfo.getMinute());
        }
        else if(LPAndDateInfo.getDayOfWeek() == 5){
            if(LPAndDateInfo.getMinute() <= 9){
                DateAndTime.setText("On: Thursday" + " at " + LPAndDateInfo.getHour() + "H0" + LPAndDateInfo.getMinute());
            }
            else
                DateAndTime.setText("On: Thursday" + " at " + LPAndDateInfo.getHour() + "H" + LPAndDateInfo.getMinute());
        }
        else if(LPAndDateInfo.getDayOfWeek() == 6){
            if(LPAndDateInfo.getMinute() <= 9){
                DateAndTime.setText("On: Friday" + " at " + LPAndDateInfo.getHour() + "H0" + LPAndDateInfo.getMinute());
            }
            else
                DateAndTime.setText("On: Friday" + " at " + LPAndDateInfo.getHour() + "H" + LPAndDateInfo.getMinute());
        }
        else if(LPAndDateInfo.getDayOfWeek() == 7){
            if(LPAndDateInfo.getMinute() <= 9){
                DateAndTime.setText("On: Saturday" + " at " + LPAndDateInfo.getHour() + "H0" + LPAndDateInfo.getMinute());
            }
            else
                DateAndTime.setText("On: Saturday" + " at " + LPAndDateInfo.getHour() + "H" + LPAndDateInfo.getMinute());
        }

        if(LPAndDateInfo.getHour() >= 7 && LPAndDateInfo.getHour() <= 9 && LPAndDateInfo.getMinute() <= 30
                || LPAndDateInfo.getHour() >= 16 && LPAndDateInfo.getHour() <= 19 && LPAndDateInfo.getMinute() <=30){
            if((LPAndDateInfo.getDigit4() == 1 || LPAndDateInfo.getDigit4() == 2) && LPAndDateInfo.getDayOfWeek() == 2){
                Result.setText("CAN'T GO OUT");
                Result.setTextColor(Color.RED);
            }
            else if((LPAndDateInfo.getDigit4() == 3 || LPAndDateInfo.getDigit4() == 4) && LPAndDateInfo.getDayOfWeek() == 3){
                Result.setText("CAN'T GO OUT");
                Result.setTextColor(Color.RED);
            }
            else if((LPAndDateInfo.getDigit4() == 5 || LPAndDateInfo.getDigit4() == 6) && LPAndDateInfo.getDayOfWeek() == 4){
                Result.setText("CAN'T GO OUT");
                Result.setTextColor(Color.RED);
            }
            else if((LPAndDateInfo.getDigit4() == 7 || LPAndDateInfo.getDigit4() == 8) && LPAndDateInfo.getDayOfWeek() == 5){
                Result.setText("CAN'T GO OUT");
                Result.setTextColor(Color.RED);
            }
            else if((LPAndDateInfo.getDigit4() == 9 || LPAndDateInfo.getDigit4() == 0) && LPAndDateInfo.getDayOfWeek() == 6){
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