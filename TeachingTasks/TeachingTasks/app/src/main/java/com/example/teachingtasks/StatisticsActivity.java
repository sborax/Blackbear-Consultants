package com.example.teachingtasks;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.Arrays;
import java.util.List;

public class StatisticsActivity extends AppCompatActivity {

    PieChart chart;
    //PieEntry[] pieEntries;
    PieDataSet pieDataSet;
    PieData pieData;
    Legend legend;
    Description description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        chart = (PieChart) findViewById(R.id.chart);

        //This will need to match the styling of whether we use Arrays, Lists, ArrayLists, etc.
        List<PieEntry> pieEntries = Arrays.asList(
                new PieEntry(6, "Correct"),
                new PieEntry(3, "Incorrect")
        );

        pieDataSet = new PieDataSet(pieEntries, "SquareData");
        pieDataSet.setColors(new int[] { R.color.colorPieGreen, R.color.colorPieRed }, StatisticsActivity.this);

        pieData = new PieData(pieDataSet);

        chart.setData(pieData);
        chart.setCenterText("Square Identification");
        chart.setHoleRadius(50f);
        legend = chart.getLegend();
        legend.setEnabled(false);
        description = chart.getDescription();
        description.setEnabled(false);
    }
}
