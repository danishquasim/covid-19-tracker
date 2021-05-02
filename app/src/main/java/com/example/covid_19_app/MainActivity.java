package com.example.covid_19_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.charts.Pie;
import com.anychart.core.cartesian.series.Line;
import com.anychart.data.Mapping;
import com.anychart.enums.Anchor;
import com.anychart.enums.MarkerType;
import com.anychart.enums.TooltipPositionMode;
import com.anychart.graphics.vector.Stroke;
import com.anychart.data.Mapping;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private TextView totalconfirmedcases, totaldeath,  totalrecovered,todayconfirmed,todayrecovered,todaydeaths,date;
    private ProgressBar progressbar;
    private Button refr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalconfirmedcases = findViewById(R.id.totalConfirm);
        totaldeath = findViewById(R.id.totalDeath);
        totalrecovered = findViewById(R.id.totalRecovered);
        todayconfirmed = findViewById(R.id.dailyConfirm);
        todayrecovered = findViewById(R.id.dailyRecovered);
        todaydeaths = findViewById(R.id.dailyDeath);
        date = findViewById(R.id.dateHeader);
        refr = findViewById(R.id.refresh);
//        String dat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
//        date.setText(dat);
        refr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });



        getdata();

    }

    private void getdata() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://api.covid19india.org/data.json";
        StringRequest stringrequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
//                            JSONObject jsonobject = new JSONObject(response.toString());
//                            totalconfirmedcases.setText(jsonobject.getString("cases"));
//                            totaldeath.setText(jsonobject.getString("deaths"));
//                            totalrecovered.setText(jsonobject.getString("recovered"));
//                            todayconfirmed.setText(jsonobject.getString("todayCases"));
//                            todaydeaths.setText(jsonobject.getString("todayDeaths"));
//                            todayrecovered.setText(jsonobject.getString("todayRecovered"));
                            JSONObject jsonobject = new JSONObject(response.toString());
                            JSONArray currentdata = jsonobject.getJSONArray("cases_time_series");
                            JSONObject dailydata = currentdata.getJSONObject(currentdata.length()-1);
                            totalconfirmedcases.setText(dailydata.getString("totalconfirmed"));
                            totaldeath.setText(dailydata.getString("totaldeceased"));
                            totalrecovered.setText(dailydata.getString("totalrecovered"));
                            todayconfirmed.setText(dailydata.getString("dailyconfirmed"));
                            todaydeaths.setText(dailydata.getString("dailydeceased"));
                            todayrecovered.setText(dailydata.getString("dailyrecovered"));
                            date.setText(dailydata.getString("date"));
//                            for(int i =0;i<currentdata.length();i++)
//                            {
//                                JSONObject dailydata = currentdata.getJSONObject(i);
//                                String dateym = dailydata.getString("dateymd");
//                                boolean check;
//                                if (date.equals(dateym)){
//
//                                    totalconfirmedcases.setText(dailydata.getString("dailyconfirmed"));
//                                    totaldeath.setText(dailydata.getString("deaths"));
//                                    totalrecovered.setText(dailydata.getString("recovered"));
//                                    todayconfirmed.setText(dailydata.getString("dailyconfirmed"));
//                                    todaydeaths.setText(dailydata.getString("dailyrecovered"));
//                                    todayrecovered.setText(dailydata.getString("todayRecovered"));
//                                }
//                            }



                            Pie pie = AnyChart.pie();
                            List<DataEntry> data = new ArrayList<>();
                            data.add(new ValueDataEntry("TOTAL DEATH", Integer.parseInt(dailydata.getString("totaldeceased"))));
                            data.add(new ValueDataEntry("TOTAL RECOVERED", Integer.parseInt(dailydata.getString("totalrecovered"))));
                            data.add(new ValueDataEntry("TOTAL CASES", Integer.parseInt(dailydata.getString("totalconfirmed"))));

                            pie.data(data);

                            AnyChartView anyChartView = (AnyChartView) findViewById(R.id.any_chart_view);
                            anyChartView.setChart(pie);



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error Response",error.toString());

            }
    });

        queue.add(stringrequest);


    }


    private class CustomDataEntry extends ValueDataEntry {

        CustomDataEntry(String x, Number value, Number value2, Number value3) {
            super(x, value);
            setValue("value2", value2);
            setValue("value3", value3);
        }

    }

}