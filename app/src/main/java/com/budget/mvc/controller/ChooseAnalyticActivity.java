package com.budget.personalfinancetracking.mvc.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChooseAnalyticActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_analytic);
    }

    public void goToTodayAnaylytics(View view) {
        Intent i=new Intent(ChooseAnalyticActivity.this,DailyAnaylyticsActivity.class);
        startActivity(i);
    }

    public void goTOWeekAnalytics(View view) {
        Intent i=new Intent(ChooseAnalyticActivity.this,WeeklyAnalyticsActivity.class);
        startActivity(i);
    }

    public void goToMOnthlyAnalytics(View view) {
        Intent i=new Intent(ChooseAnalyticActivity.this,MonthlyAnalyticsActivity.class);
        startActivity(i);
    }
}