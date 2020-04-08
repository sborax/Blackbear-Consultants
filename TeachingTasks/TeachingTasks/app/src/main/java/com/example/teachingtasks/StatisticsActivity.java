package com.example.teachingtasks;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StatisticsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        PieChart chart = (PieChart) findViewById(R.id.chart);
        List<PieEntry> pieEntries = Arrays.asList(
                new PieEntry(6, "Correct"),
                new PieEntry(3, "Incorrect")
        );

        PieDataSet pieDataSet = new PieDataSet(pieEntries, "SquareData");
        pieDataSet.setColors(R.color.colorPieGreen, R.color.colorPieRed);
        PieData pieData = new PieData(pieDataSet);

        chart.setData(pieData);
        chart.setCenterText("Square Identification");
        chart.setHoleRadius(40f);
        Legend legend = chart.getLegend();
        legend.setEnabled(false);
        Description description = chart.getDescription();
        description.setEnabled(false);
    }
}
