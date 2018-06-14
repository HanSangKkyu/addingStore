package com.example.han.adding;


import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collections;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnalyzeFragment extends Fragment {

    Spinner spinner;
    Spinner sub;
    AdapterSpinner mainSpinner;
    AdapterSpinner subSpinner;
    ArrayList<String> mainItem;
    final String[] mainArray = {"직업군, 취미, 성별, 나이대"};
    final String[] jobArray = {"예술, 사무직, 자영업, 서비스직, 생산직, 농축산, 학생, 기타"};
    final String[] ageArray = {"10대, 20대, 30대, 40대, 5/60대"};
    final String[] favArray = {"건강, 게임, 교육, 금융, 쇼핑, 스포츠, 소셜, 미디어"};
    final String[] genderArray = {"남, 여"};
    LinearLayout job;
    LinearLayout age;
    LinearLayout fav;
    LinearLayout gender;

    PieChart pieChart;
    PieChart secondChart;
    BarChart barChart;
    BarChart favChart;


    int check = 0;//현재 어떠한 정보가 위에서 선택되었는지 체크하는 변수

    public AnalyzeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        init();
        onDataSet();
        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayList<String> subItem;
                subItem = new ArrayList<>();
                String str = parent.getItemAtPosition(position).toString();
                switch (str) {
                    case "직업군":
                        check = 1;
                        job.setVisibility(View.VISIBLE);
                        fav.setVisibility(View.GONE);
                        age.setVisibility(View.GONE);
                        gender.setVisibility(View.GONE);

                        Collections.addAll(subItem, jobArray);
                        subSpinner = new AdapterSpinner(getActivity(), subItem);
                        sub.setAdapter(subSpinner);
                        break;
                    case "취미":
                        check = 2;
                        job.setVisibility(View.GONE);
                        fav.setVisibility(View.VISIBLE);
                        age.setVisibility(View.GONE);
                        gender.setVisibility(View.GONE);

                        Collections.addAll(subItem, favArray);
                        subSpinner = new AdapterSpinner(getActivity(), subItem);
                        sub.setAdapter(subSpinner);
                        break;
                    case "성별":
                        check = 3;
                        job.setVisibility(View.GONE);
                        fav.setVisibility(View.GONE);
                        age.setVisibility(View.GONE);
                        gender.setVisibility(View.VISIBLE);

                        Collections.addAll(subItem, genderArray);
                        subSpinner = new AdapterSpinner(getActivity(), subItem);
                        sub.setAdapter(subSpinner);
                        break;
                    case "나이대":
                        check = 4;
                        job.setVisibility(View.GONE);
                        fav.setVisibility(View.GONE);
                        age.setVisibility(View.VISIBLE);
                        gender.setVisibility(View.GONE);

                        Collections.addAll(subItem, ageArray);
                        subSpinner = new AdapterSpinner(getActivity(), subItem);
                        sub.setAdapter(subSpinner);
                        break;
                }
            }
        });
        if (sub != null) {
            sub.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String str = parent.getItemAtPosition(position).toString();
                    switch (check) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }

                }
            });
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_analyze, container, false);

    }

    private void onDataSet() {


        pieChart = (PieChart) findViewById(R.id.piechart);
        secondChart = (PieChart) findViewById(R.id.secondchart);
        barChart = (BarChart) findViewById(R.id.bar);
        favChart = (BarChart) findViewById(R.id.favorite);

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5, 10, 5, 5);

        pieChart.setDragDecelerationFrictionCoef(0.95f);

        pieChart.setDrawHoleEnabled(false);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f);

        ArrayList<PieEntry> yValues = new ArrayList<PieEntry>();

        yValues.add(new PieEntry(34f, "10대"));
        yValues.add(new PieEntry(23f, "20대"));
        yValues.add(new PieEntry(14f, "30대"));
        yValues.add(new PieEntry(35f, "40대"));
        yValues.add(new PieEntry(40f, "5/60대"));

        Description description = new Description();
        description.setText("연령 분포"); //라벨
        description.setTextSize(15);
        pieChart.setDescription(description);

        pieChart.animateY(1000, Easing.EasingOption.EaseInOutCubic); //애니메이션

        PieDataSet dataSet = new PieDataSet(yValues, "age");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData data = new PieData((dataSet));
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.YELLOW);

        pieChart.setData(data);


        secondChart.setUsePercentValues(true);
        secondChart.getDescription().setEnabled(false);
        secondChart.setExtraOffsets(5, 10, 5, 5);

        secondChart.setDragDecelerationFrictionCoef(0.95f);

        secondChart.setDrawHoleEnabled(false);
        secondChart.setHoleColor(Color.WHITE);
        secondChart.setTransparentCircleRadius(61f);

        ArrayList<PieEntry> gValues = new ArrayList<PieEntry>();

        gValues.add(new PieEntry(34f, "여성"));
        gValues.add(new PieEntry(23f, "남성"));

        Description gdescription = new Description();
        gdescription.setText("성별 분포"); //라벨
        gdescription.setTextSize(15);
        secondChart.setDescription(gdescription);

        secondChart.animateY(1000, Easing.EasingOption.EaseInOutCubic); //애니메이션

        PieDataSet gdataSet = new PieDataSet(gValues, "gender");
        gdataSet.setSliceSpace(3f);
        gdataSet.setSelectionShift(5f);
        gdataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        PieData gdata = new PieData((gdataSet));
        gdata.setValueTextSize(10f);
        gdata.setValueTextColor(Color.YELLOW);

        secondChart.setData(gdata);


        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(4f, 0));
        entries.add(new BarEntry(8f, 1));
        entries.add(new BarEntry(6f, 2));
        entries.add(new BarEntry(2f, 3));
        entries.add(new BarEntry(18f, 4));
        entries.add(new BarEntry(9f, 5));
        entries.add(new BarEntry(16f, 6));
        entries.add(new BarEntry(5f, 7));
        entries.add(new BarEntry(3f, 8));
        entries.add(new BarEntry(8f, 9));
        entries.add(new BarEntry(9f, 10));
        entries.add(new BarEntry(3f, 11));
        entries.add(new BarEntry(5f, 12));


        ArrayList<String> labels = new ArrayList<String>();
        labels.add("건강");
        labels.add("게임");
        labels.add("교육");
        labels.add("금융");
        labels.add("쇼핑");
        labels.add("스포츠");
        labels.add("소셜");
        labels.add("미디어");

//        XAxis xAxis = barChart.getXAxis();
//        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
//        XAxis bottomAxis = barChart.getXAxis();
//        bottomAxis.setLabelCount(entries.size());
//        bottomAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//        bottomAxis.setDrawLabels(true);
//        bottomAxis.setDrawGridLines(false);
//        bottomAxis.setDrawAxisLine(true);


        BarDataSet dataset = new BarDataSet(entries, "favorite");


        BarData dt = new BarData(dataset);
        dataset.setColors(ColorTemplate.PASTEL_COLORS);


        barChart.setData(dt);
        barChart.animateY(5000);

        ArrayList fav_labels = new ArrayList();
        fav_labels.add("예술");
        fav_labels.add("사무직");
        fav_labels.add("자영업");
        fav_labels.add("서비스직");
        fav_labels.add("생산직");
        fav_labels.add("농축산");
        fav_labels.add("학생");
        fav_labels.add("기타");


        ArrayList fav_entries = new ArrayList();
        fav_entries.add(new BarEntry(1f, 3));
        fav_entries.add(new BarEntry(2f, 2));
        fav_entries.add(new BarEntry(3f, 7));
        fav_entries.add(new BarEntry(4f, 13));
        fav_entries.add(new BarEntry(5f, 7));
        fav_entries.add(new BarEntry(6f, 4));
        fav_entries.add(new BarEntry(7f, 6));
        fav_entries.add(new BarEntry(8f, 9));

        ArrayList fav_entries2 = new ArrayList();
        fav_entries2.add(new BarEntry(1f, 0));
        fav_entries2.add(new BarEntry(2f, 1));
        fav_entries2.add(new BarEntry(3f, 2));
        fav_entries2.add(new BarEntry(4f, 3));
        fav_entries2.add(new BarEntry(5f, 4));
        fav_entries2.add(new BarEntry(6f, 5));
        fav_entries2.add(new BarEntry(7f, 6));

        BarDataSet fav_dataset = new BarDataSet(fav_entries, "A");
        fav_dataset.setColors(ColorTemplate.PASTEL_COLORS);
        BarDataSet fav_dataset2 = new BarDataSet(fav_entries2, "B");
        fav_dataset2.setColors(ColorTemplate.COLORFUL_COLORS);

        BarData fv_dt = new BarData(fav_dataset, fav_dataset2);
        fv_dt.setValueFormatter(new LargeValueFormatter());

        float barWidth = 0.3f;
        float barSpace = 0f;
        float groupSpace = 0.4f;
        favChart.setData(fv_dt);
        favChart.getBarData().setBarWidth(barWidth);
        favChart.getXAxis().setAxisMinimum(0);
        favChart.getXAxis().setAxisMaximum(0 + favChart.getBarData().getGroupWidth(groupSpace, barSpace) * fav_entries.size());
        favChart.groupBars(0, groupSpace, barSpace);
        favChart.getData().setHighlightEnabled(false);
        favChart.invalidate();

        Legend l = favChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(true);
        l.setYOffset(20f);
        l.setXOffset(0f);
        l.setYEntrySpace(0f);
        l.setTextSize(8f);

        XAxis xAxis = favChart.getXAxis();
        xAxis.setGranularity(1f);
        xAxis.setGranularityEnabled(true);
        xAxis.setCenterAxisLabels(true);
        xAxis.setDrawGridLines(false);
        xAxis.setAxisMaximum(fav_labels.size());
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(fav_labels));
        favChart.getAxisRight().setEnabled(false);

        favChart.getAxisRight().setEnabled(false);
        YAxis leftAxis = favChart.getAxisLeft();
        leftAxis.setValueFormatter(new LargeValueFormatter());
        leftAxis.setDrawGridLines(true);
        leftAxis.setSpaceTop(35f);
        leftAxis.setAxisMinimum(0f);

//        favChart.setPinchZoom(false);
//        favChart.setScaleEnabled(false);
//        favChart.setDrawBarShadow(false);
//        favChart.setDrawGridBackground(false);
//
//        favChart.setData(fv_dt);
//        favChart.animateY(5000);


    }

    private void init() {
        mainItem = new ArrayList<>();
        spinner = (Spinner) getActivity().findViewById(R.id.main);
        sub = (Spinner) getActivity().findViewById(R.id.sub);
        Collections.addAll(mainItem, mainArray);
        mainSpinner = new AdapterSpinner(getActivity(), mainItem);
        spinner.setAdapter(mainSpinner);
        job = (LinearLayout) getActivity().findViewById(R.id.job);
        age = (LinearLayout) getActivity().findViewById(R.id.age);
        fav = (LinearLayout) getActivity().findViewById(R.id.fav);
        gender = (LinearLayout) getActivity().findViewById(R.id.gender);
    }

}
