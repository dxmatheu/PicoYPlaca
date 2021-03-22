package com.example.picoyplacaforstackbuilders;

import java.util.Calendar;

public class LicensePlateAndDateInfo {
    int Digit1 = 0;
    int Digit2 = 0;
    int Digit3 = 0;
    int Digit4 = 0;
    int DayOfWeek = -1;
    int Hour = -1;
    int Minute = 0;

    private static LicensePlateAndDateInfo instance = new LicensePlateAndDateInfo();

    public static LicensePlateAndDateInfo getInstance() {
        return instance;
    }

    public void setDigit1(int digit1) {
        Digit1 = digit1;
    }

    public void setDigit2(int digit2) {
        Digit2 = digit2;
    }

    public void setDigit3(int digit3) {
        Digit3 = digit3;
    }

    public void setDigit4(int digit4) {
        Digit4 = digit4;
    }

    public void setDayOfWeek(int dayOfWeek) {
        DayOfWeek = dayOfWeek;
    }

    public void setHour(int hour) {
        Hour = hour;
    }

    public void setMinute(int minute) {
        Minute = minute;
    }

}
