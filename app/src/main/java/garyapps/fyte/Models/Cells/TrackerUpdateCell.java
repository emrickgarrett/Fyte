package garyapps.fyte.Models.Cells;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;

import garyapps.fyte.Adapters.FyteTableRowAdapter;
import garyapps.fyte.Models.CalendarData.Day;
import garyapps.fyte.Models.CalendarData.FyteCalendarData;
import garyapps.fyte.Models.FyteRowModel;
import garyapps.fyte.Models.FyteTrackerRowModel;
import garyapps.fyte.R;
import garyapps.fyte.Utilities.DateHelper;
import garyapps.fyte.Utilities.Shared;

/**
 * Created by garrettemrick on 12/19/17.
 */

public class TrackerUpdateCell extends FyteCell{

    private TextView disciplineTitle;
    private TextView startDate;
    private BarChart weeklySessionTracker;

    private FyteTrackerRowModel model;

    public TrackerUpdateCell(Activity context, FyteRowModel model){
        bindViews(context.getLayoutInflater().inflate(R.layout.tracker_discipline_cell, null), ((FyteTrackerRowModel) model));
        loadChart();
    }

    private void bindViews(View v){
        this.view = v;
        this.disciplineTitle = v.findViewById(R.id.tracker_cell_discipline_title);
        this.startDate = v.findViewById(R.id.tracker_cell_start_date);
        this.weeklySessionTracker = v.findViewById(R.id.tracker_cell_discipline_week_session_tracker);
    }

    private void bindViews(View v, FyteTrackerRowModel model) {
        this.bindViews(v);
        this.model = model;

        if(model.discipline != ""){
            disciplineTitle.setText(model.discipline);
        }

        if(model.experienceLevel != ""){
            //do work
        }
    }

    private void loadChart(){
        ArrayList<BarEntry> entries = new ArrayList<BarEntry>();
        FyteCalendarData calendarData  = new FyteCalendarData();
        calendarData.fetchData(Shared.appUser.getId(), model.disciplineId);
        ArrayList<Day> days  = calendarData.getCurrentWeek();

        for(Day day : days){
            entries.add(new BarEntry(day.getIntValue(), day.getSessionCount()));
        }

        BarDataSet dataSet = new BarDataSet(entries, "Weekly Results");
        dataSet.setDrawValues(false);
        BarData barData = new BarData(dataSet);

        IAxisValueFormatter formatter = new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return DateHelper.parseShortDayName((int)value);
            }
        };

        IAxisValueFormatter formatter2 = new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return ((int) value) + "";
            }
        };

        XAxis xAxis = this.weeklySessionTracker.getXAxis();
        xAxis.setGranularity(1f); // minimum axis-step (interval) is 1
        xAxis.setValueFormatter(formatter);
        xAxis.setDrawAxisLine(false);
        xAxis.setDrawGridLines(false);

        YAxis yAxis = this.weeklySessionTracker.getAxisLeft();
        yAxis.setValueFormatter(formatter2);
        yAxis.setGranularity(1f);
        yAxis.setAxisMinimum(0f);

        this.weeklySessionTracker.setData(barData);
        this.weeklySessionTracker.setFitBars(true);
        this.weeklySessionTracker.getAxisRight().setEnabled(false);
        this.weeklySessionTracker.getDescription().setEnabled(false);
        this.weeklySessionTracker.getLegend().setEnabled(false);
        this.weeklySessionTracker.invalidate();
    }

    @Override
    public void onClick(final FyteTableRowAdapter adapter, final AdapterView<?> parent, final View view, final int position, final long id) {

        //TODO send user to view of this discipline and other useful info
    }

    @Override
    public FyteRowModel getModel(){ return model; }
}
