package com.example.picoyplacaforstackbuilders;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

public class ShowResult extends Activity {

    private LicensePlateAndDateInfo LPandDateInfo = LicensePlateAndDateInfo.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);

        TextView LicensePlate = findViewById(R.id.LisencePlateTV);
        TextView DateAndTime = findViewById(R.id.DateAndTimeTV);
        TextView Result = findViewById(R.id.ResultTV);

        LicensePlate.setText("XXX-" + LPandDateInfo.Digit1 + LPandDateInfo.Digit2 + LPandDateInfo.Digit3 + LPandDateInfo.Digit4);

        if(LPandDateInfo.DayOfWeek == 1){
            DateAndTime.setText("On: Sunday" + " at: " + LPandDateInfo.Hour + "H" + LPandDateInfo.Minute);
        }
        else if(LPandDateInfo.DayOfWeek == 2){
            DateAndTime.setText("On: Monday" + " at: " + LPandDateInfo.Hour + "H" + LPandDateInfo.Minute);
        }
        else if(LPandDateInfo.DayOfWeek == 3){
            DateAndTime.setText("On: Tuesday" + " at: " + LPandDateInfo.Hour + "H" + LPandDateInfo.Minute);
        }
        else if(LPandDateInfo.DayOfWeek == 4){
            DateAndTime.setText("On: Wednesday" + " at: " + LPandDateInfo.Hour + "H" + LPandDateInfo.Minute);
        }
        else if(LPandDateInfo.DayOfWeek == 5){
            DateAndTime.setText("On: Thursday" + " at: " + LPandDateInfo.Hour + "H" + LPandDateInfo.Minute);
        }
        else if(LPandDateInfo.DayOfWeek == 6){
            DateAndTime.setText("On: Friday" + "  at: " + LPandDateInfo.Hour + "H" + LPandDateInfo.Minute);
        }
        else if(LPandDateInfo.DayOfWeek == 7){
            DateAndTime.setText("On: Saturday" + " at: " + LPandDateInfo.Hour + "H" + LPandDateInfo.Minute);
        }

        if(LPandDateInfo.Hour >= 7 && LPandDateInfo.Hour <= 9 && LPandDateInfo.Minute <= 30
                || LPandDateInfo.Hour >= 16 && LPandDateInfo.Hour <= 19 && LPandDateInfo.Minute <=30){
            if((LPandDateInfo.Digit4 == 1 || LPandDateInfo.Digit4 == 2) && LPandDateInfo.DayOfWeek == 2){
                Result.setText("CAN'T GO OUT");
                Result.setTextColor(Color.RED);
            }
            else if((LPandDateInfo.Digit4 == 3 || LPandDateInfo.Digit4 == 4) && LPandDateInfo.DayOfWeek == 3){
                Result.setText("CAN'T GO OUT");
                Result.setTextColor(Color.RED);
            }
            else if((LPandDateInfo.Digit4 == 5 || LPandDateInfo.Digit4 == 6) && LPandDateInfo.DayOfWeek == 4){
                Result.setText("CAN'T GO OUT");
                Result.setTextColor(Color.RED);
            }
            else if((LPandDateInfo.Digit4 == 7 || LPandDateInfo.Digit4 == 8) && LPandDateInfo.DayOfWeek == 5){
                Result.setText("CAN'T GO OUT");
                Result.setTextColor(Color.RED);
            }
            else if((LPandDateInfo.Digit4 == 9 || LPandDateInfo.Digit4 == 0) && LPandDateInfo.DayOfWeek == 6){
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
