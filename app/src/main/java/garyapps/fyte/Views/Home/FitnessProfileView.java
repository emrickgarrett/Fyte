package garyapps.fyte.Views.Home;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;

import garyapps.fyte.Models.CalendarData.Day;
import garyapps.fyte.Models.CalendarData.FyteCalendarData;
import garyapps.fyte.R;
import garyapps.fyte.Utilities.DateHelper;
import garyapps.fyte.Utilities.Shared;

/**
 * Created by garrettemrick on 12/25/17.
 */

public class FitnessProfileView extends RelativeLayout {

    private TextView fullName;
    private TextView chartDesc;
    private TextView weightChange;
    private LineChart weightChart;

    public FitnessProfileView(Activity context){
        super(context);

        View v = context.getLayoutInflater().inflate(R.layout.fitness_progress_cell, null);

        //v.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 200));

        this.bindViews(v);
        this.bindValues();
        this.addView(v);
    }

    private void bindViews(View v){
        this.fullName = v.findViewById(R.id.fitness_full_name);
        this.chartDesc = v.findViewById(R.id.fitness_chart_desc);
        this.weightChart = v.findViewById(R.id.fitness_weight_chart);
        this.weightChange = v.findViewById(R.id.fitness_weight_change);
    }

    private void bindValues(){
        //TODO
        this.fullName.setText(Shared.appUser.getFullName());
        this.chartDesc.setText("Your Weight");

        //generate chart
        loadChart();
    }

    private void loadChart(){
        ArrayList<Entry> entries = new ArrayList<Entry>();
        FyteCalendarData calendarData  = new FyteCalendarData();
        calendarData.fetchWeightData();
        ArrayList<Day> days  = calendarData.getCurrentWeek();

        float totalWeightChange = 0.0f;
        float minWeightChange = 0.0f;
        float maxWeightChange = 0.0f;
        for(Day day : days){
            entries.add(new Entry(day.getIntValue(), totalWeightChange + day.getCount()));
            totalWeightChange += day.getCount();
            if(totalWeightChange < minWeightChange){
                minWeightChange = totalWeightChange;
            }
            if(totalWeightChange > maxWeightChange){
                maxWeightChange = totalWeightChange;
            }
        }
        this.weightChange.setText("" + totalWeightChange);
        if(totalWeightChange > 0){
            this.weightChange.setTextColor(Color.GREEN);
        }else{
            this.weightChange.setTextColor(Color.RED);
        }

        LineDataSet dataSet = new LineDataSet(entries, "Weekly Results");
        dataSet.setDrawValues(false);
        LineData lineData = new LineData(dataSet);

        IAxisValueFormatter formatter = new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return DateHelper.parseShortDayName((int)value);
            }
        };

        IAxisValueFormatter formatter2 = new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return (Shared.appUser.getWeight() + value) + " " + Shared.appUser.getWeightUnit();
            }
        };

        XAxis xAxis = this.weightChart.getXAxis();
        xAxis.setGranularity(1f); // minimum axis-step (interval) is 1
        xAxis.setValueFormatter(formatter);
        xAxis.setDrawAxisLine(false);
        xAxis.setDrawGridLines(false);

        YAxis yAxis = this.weightChart.getAxisLeft();
        yAxis.setValueFormatter(formatter2);
        yAxis.setGranularity(.3f);
        yAxis.setAxisMaximum(Math.max(.5f, maxWeightChange));
        yAxis.setAxisMinimum(Math.min(-.5f, minWeightChange));

        this.weightChart.setData(lineData);
        this.weightChart.getAxisRight().setEnabled(false);
        this.weightChart.getDescription().setEnabled(false);
        this.weightChart.getLegend().setEnabled(false);
        this.weightChart.setTouchEnabled(false);
        this.weightChart.invalidate();
    }


}
