package garyapps.fyte.Models.Cells;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
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
    private TextView chartDesc;
    private ImageButton changeSizeButton;
    private BarChart weeklySessionTracker;
    private RelativeLayout layout;

    private FyteTrackerRowModel model;
    private boolean isMinimized;
    private FyteTableRowAdapter adapter;

    public TrackerUpdateCell(FyteTableRowAdapter adapter, FyteRowModel model, boolean isMinimized){
        this.isMinimized = isMinimized;
        this.adapter = adapter;

        bindViews(adapter.getLayoutInflater().inflate(R.layout.tracker_discipline_cell, null), ((FyteTrackerRowModel) model));
        loadChart();
        if(this.isMinimized){
            minimizeView();
        }else{
            maximizeView();
        }
    }

    public TrackerUpdateCell(FyteTableRowAdapter adapter, FyteRowModel model){
        this(adapter, model, true);
    }

    private void bindViews(View v){
        this.view = v;
        this.layout = v.findViewById(R.id.tracker_cell_layout);
        this.disciplineTitle = v.findViewById(R.id.tracker_cell_discipline_title);
        this.startDate = v.findViewById(R.id.tracker_cell_start_date);
        this.weeklySessionTracker = v.findViewById(R.id.tracker_cell_discipline_week_session_tracker);
        this.changeSizeButton = v.findViewById(R.id.tracker_cell_size_button);
        this.chartDesc = v.findViewById(R.id.tracker_cell_tracker_desc);
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

        this.chartDesc.setText("Weekly Session Counter");

        this.changeSizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setIsMinimized(!isMinimized);
            }
        });

        this.layout.getLayoutTransition().addTransitionListener(new LayoutTransition.TransitionListener() {
            @Override
            public void startTransition(LayoutTransition transition, ViewGroup container, View view, int transitionType) {

            }

            @Override
            public void endTransition(LayoutTransition transition, ViewGroup container, View view, int transitionType) {
                //adapter.refreshLayout();
                refreshLayout();
            }
        });

    }

    public void maximizeView(){
        this.weeklySessionTracker.setVisibility(View.VISIBLE);
        this.chartDesc.setVisibility(View.VISIBLE);
        //refreshLayout();
    }

    public void minimizeView(){
        this.weeklySessionTracker.setVisibility(View.GONE);
        this.chartDesc.setVisibility(View.GONE);
        //refreshLayout();
    }

    private void refreshLayout(){
        this.view.forceLayout();
        this.view.requestLayout();

        this.adapter.refreshLayout();
    }

    public void setIsMinimized(boolean bool){
        this.isMinimized = bool;
        if(bool){
            minimizeView();
        }else{
            maximizeView();
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
        this.weeklySessionTracker.setTouchEnabled(false);
        this.weeklySessionTracker.invalidate();
    }

    @Override
    public void onClick(final FyteTableRowAdapter adapter, final AdapterView<?> parent, final View view, final int position, final long id) {

        //TODO send user to view of this discipline and other useful info
    }

    @Override
    public FyteRowModel getModel(){ return model; }
}
