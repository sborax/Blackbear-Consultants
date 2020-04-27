package com.example.teachingtasks;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.Arrays;
import java.util.List;

public class StatisticsActivity extends AppCompatActivity {


    GameTaskDBHelper db;

    PieChart chartTotal;
    PieDataSet pieDataSetTotal;
    PieData pieDataTotal;

    PieChart chartNumber;
    PieDataSet pieDataSetNumber;
    PieData pieDataNumber;

    Button taskNavButton, statisticsNavButton, settingsNavButton;
    TextView username;

    Legend totalLegend;
    Legend numLegend;
    Description totalDescription;
    Description numDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        username = (TextView) findViewById(R.id.username);
        username.setText(getIntent().getStringExtra("EXTRA_USER"));

        db = new GameTaskDBHelper(this);

        //total (make generic!)
        int totalCorrect = db.getTaskMastery(username.getText().toString(), "numbertask");
        int totalIncorrect = db.getTaskIncorrect(username.getText().toString(), "numbertask");
        float percent = (float)totalCorrect/(totalCorrect+totalIncorrect);


        chartTotal = (PieChart) findViewById(R.id.chartTotal);

        //This will need to match the styling of whether we use Arrays, Lists, ArrayLists, etc.
        List<PieEntry> pieEntriesTotal = Arrays.asList(
                new PieEntry(totalCorrect, "Correct"),
                new PieEntry(totalIncorrect, "Incorrect")
        );

        pieDataSetTotal = new PieDataSet(pieEntriesTotal, "");
        pieDataSetTotal.setColors(new int[] { R.color.colorPieGreen, R.color.colorPieRed }, StatisticsActivity.this);

        pieDataTotal = new PieData(pieDataSetTotal);
        pieDataTotal.setValueTextColor(Color.BLACK);
        pieDataTotal.setValueTextSize(15);
        pieDataTotal.setValueFormatter(new MyValueFormatter());

        chartTotal.setData(pieDataTotal);
        chartTotal.setCenterText(Float.toString(percent*100)+"%");
        setChartStyle(chartTotal);
        totalLegend = chartTotal.getLegend();
        totalLegend.setTextColor(Color.WHITE);
        totalLegend.setTypeface(Typeface.SANS_SERIF);
        totalDescription = chartTotal.getDescription();
        totalDescription.setEnabled(false);

        //number (also need to make generic)
        int numCorrect = db.getTaskMastery(username.getText().toString(), "numbertask");
        int numIncorrect = db.getTaskIncorrect(username.getText().toString(), "numbertask");


        chartNumber = (PieChart) findViewById(R.id.chartNumber);

        //This will need to match the styling of whether we use Arrays, Lists, ArrayLists, etc.
        List<PieEntry> pieEntriesNumber = Arrays.asList(
                new PieEntry(numCorrect, "Correct"),
                new PieEntry(numIncorrect, "Incorrect")
        );

        pieDataSetNumber = new PieDataSet(pieEntriesNumber, "");
        pieDataSetNumber.setColors(new int[] { R.color.colorPieGreen, R.color.colorPieRed }, StatisticsActivity.this);

        pieDataNumber = new PieData(pieDataSetNumber);
        pieDataNumber.setValueTextColor(Color.BLACK);
        pieDataNumber.setValueTypeface(Typeface.SANS_SERIF);
        pieDataNumber.setValueTextSize(15);
        pieDataNumber.setValueFormatter(new MyValueFormatter());

        chartNumber.setData(pieDataNumber);
        chartNumber.setCenterText("Number Accuracy");
        setChartStyle(chartNumber);
        numLegend = chartNumber.getLegend();
        numLegend.setEnabled(false);
        numDescription = chartNumber.getDescription();
        numDescription.setEnabled(false);

        taskNavButton = (Button) findViewById(R.id.taskNavButton);
        statisticsNavButton = (Button) findViewById(R.id.statisticsNavButton);
        settingsNavButton = (Button) findViewById(R.id.settingsNavButton);

        taskNavButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                new NavButtonEventHandler().onClick(StatisticsActivity.this, v, username.getText().toString());
                return false;
            }
        });

        statisticsNavButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                new NavButtonEventHandler().onClick(StatisticsActivity.this, v, username.getText().toString());
                return false;
            }
        });

        settingsNavButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                new NavButtonEventHandler().onClick(StatisticsActivity.this, v, username.getText().toString());
                return false;
            }
        });
    }

    private void setChartStyle(PieChart chart) {
        chart.setHoleRadius(45f);
        chart.setRotationEnabled(false);
        chart.setDrawEntryLabels(false);
        chart.setRotationAngle(180f);
    }

}

class MyValueFormatter extends ValueFormatter {

    @Override
    public String getFormattedValue(float value) {
        return String.valueOf((int) value);
    }
}
