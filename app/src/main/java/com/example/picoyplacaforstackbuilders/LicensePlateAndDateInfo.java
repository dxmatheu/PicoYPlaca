package com.example.picoyplacaforstackbuilders;

import java.util.Calendar;

public class LicensePlateAndDateInfo {
    private int Digit1 = 0;
    private int Digit2 = 0;
    private int Digit3 = 0;
    private int Digit4 = 0;
    private int DayOfWeek = -1;
    private int Hour = -1;
    private int Minute = 0;

    private static final LicensePlateAndDateInfo instance = new LicensePlateAndDateInfo();

    public static LicensePlateAndDateInfo getInstance() {
        return instance;
    }

    public void setDigit1(int digit1) {
        Digit1 = digit1;
    }

    public int getDigit1() {
        return Digit1;
    }

    public void setDigit2(int digit2) {
        Digit2 = digit2;
    }

    public int getDigit2() {
        return Digit2;
    }

    public void setDigit3(int digit3) {
        Digit3 = digit3;
    }

    public int getDigit3() {
        return Digit3;
    }

    public void setDigit4(int digit4) {
        Digit4 = digit4;
    }

    public int getDigit4() {
        return Digit4;
    }

    public void setDayOfWeek(int dayOfWeek) {
        DayOfWeek = dayOfWeek;
    }

    public int getDayOfWeek() {
        return DayOfWeek;
    }

    public void setHour(int hour) {
        Hour = hour;
    }

    public int getHour() {
        return Hour;
    }

    public void setMinute(int minute) {
        Minute = minute;
    }

    public int getMinute() {
        return Minute;
    }
}
