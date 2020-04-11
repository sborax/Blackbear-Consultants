package com.example.teachingtasks;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class StatisticsActivity extends AppCompatActivity {

    PieChart chartTotal;
    PieDataSet pieDataSetTotal;
    PieData pieDataTotal;
    PieChart chartSquare;
    PieDataSet pieDataSetSquare;
    PieData pieDataSquare;
    PieChart chartCircle;
    PieDataSet pieDataSetCircle;
    PieData pieDataCircle;
    Legend legend;
    Description description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        chartSquare = (PieChart) findViewById(R.id.chartSquare);

        //This will need to match the styling of whether we use Arrays, Lists, ArrayLists, etc.
        List<PieEntry> pieEntriesSquare = Arrays.asList(
                new PieEntry(6, "Correct"),
                new PieEntry(3, "Incorrect")
        );

        pieDataSetSquare = new PieDataSet(pieEntriesSquare, "SquareData");
        pieDataSetSquare.setColors(new int[] { R.color.colorPieGreen, R.color.colorPieRed }, StatisticsActivity.this);

        pieDataSquare = new PieData(pieDataSetSquare);

        pieDataSquare.setValueTextColors(Arrays.asList(R.color.black, R.color.white));
        pieDataSquare.setValueTextSize(13);
        pieDataSquare.setValueFormatter(new MyValueFormatter());

        chartSquare.setData(pieDataSquare);
        chartSquare.setCenterText("Square Identification");
        setChartStyle(chartSquare);



        chartCircle = (PieChart) findViewById(R.id.chartCircle);

        //This will need to match the styling of whether we use Arrays, Lists, ArrayLists, etc.
        List<PieEntry> pieEntriesCircle = Arrays.asList(
                new PieEntry(6, "Correct"),
                new PieEntry(7, "Incorrect")
        );

        pieDataSetCircle = new PieDataSet(pieEntriesSquare, "CircleData");
        pieDataSetCircle.setColors(new int[] { R.color.colorPieGreen, R.color.colorPieRed }, StatisticsActivity.this);

        pieDataCircle = new PieData(pieDataSetCircle);
        pieDataCircle.setValueTextColor(R.color.black);
        pieDataCircle.setValueTextSize(13);
        pieDataCircle.setValueFormatter(new MyValueFormatter());

        chartCircle.setData(pieDataCircle);
        chartCircle.setCenterText("Square Identification");
        setChartStyle(chartCircle);


        chartTotal = (PieChart) findViewById(R.id.chartTotal);

        //This will need to match the styling of whether we use Arrays, Lists, ArrayLists, etc.
        List<PieEntry> pieEntriesTotal = Arrays.asList(
                new PieEntry(12, "Correct"),
                new PieEntry(10, "Incorrect")
        );

        pieDataSetTotal = new PieDataSet(pieEntriesTotal, "");
        pieDataSetTotal.setColors(new int[] { R.color.colorPieGreen, R.color.colorPieRed }, StatisticsActivity.this);

        pieDataTotal = new PieData(pieDataSetTotal);
        pieDataTotal.setValueTextColor(R.color.black);
        pieDataTotal.setValueTextSize(15);
        pieDataTotal.setValueFormatter(new MyValueFormatter());

        chartTotal.setData(pieDataTotal);
        chartTotal.setCenterText("Total Accuracy");
        setChartStyle(chartTotal, true);
        legend = chartTotal.getLegend();
    }

    private void setChartStyle(PieChart chart, boolean total) {
        chart.setHoleRadius(45f);
        chart.setRotationEnabled(false);
        chart.setDrawEntryLabels(false);
        chart.setRotationAngle(180f);
        description = chart.getDescription();
        description.setEnabled(false);
        if (!total) {
            chart.setMaxAngle(180f);
            legend = chart.getLegend();
            legend.setEnabled(false);
        }
    }

    private void setChartStyle(PieChart chart) {
        setChartStyle(chart, false);
    }
}

class MyValueFormatter extends ValueFormatter {

    private DecimalFormat mFormat;

    @Override
    public String getFormattedValue(float value) {
        return String.valueOf((int) value);
    }
}
