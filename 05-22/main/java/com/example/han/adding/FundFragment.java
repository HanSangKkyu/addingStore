package com.example.han.adding;


import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.lambdainvoker.LambdaFunctionException;
import com.amazonaws.mobileconnectors.lambdainvoker.LambdaInvokerFactory;
import com.amazonaws.regions.Regions;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Collections;


/**
 * A simple {@link Fragment} subclass.
 */
public class FundFragment extends Fragment {


    LinearLayout searchBox;
    //  int layoutWidth = 1000;
    //   int layoutHeight = 140;
    final String[] favoItemArray = {"건강/운동", "게임", "교육", "금융", "날씨", "뉴스/잡지", "쇼핑", "도구", "스포츠", "음악,동영상", "소셜", "사진", "지도/내비게이션"};
    private Spinner favorite;
    private ArrayList<String> favoItem;
    private AdapterSpinner1 favoAdapter;
    private ImageButton sButton;
    private EditText keyword;


    ArrayList<PreviewClass> serchResult;
    private ListView listView;
    private FundListAdapter fundListAdapter;

    public FundFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_fund, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //load();
        searchBox = (LinearLayout) getActivity().findViewById(R.id.searchBox);
        //  searchBox.setLayoutParams(new LinearLayout.LayoutParams(layoutWidth, 0));
        searchBox.setVisibility(View.GONE);

        favorite = (Spinner) getActivity().findViewById(R.id.favorite);
        favoItem = new ArrayList<>();
        Collections.addAll(favoItem, favoItemArray);
        favoAdapter = new AdapterSpinner1(getActivity(), favoItem);
        favorite.setAdapter(favoAdapter);

        // 검색 버튼 누를시
        sButton = (ImageButton) getActivity().findViewById(R.id.searchButton);
        sButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyword = (EditText) getActivity().findViewById(R.id.keyword);
                keyword.getText();


                //검색 결과 보여주기
                serchResult = new ArrayList<>();
                listView = (ListView) getActivity().findViewById(R.id.listView);
                fundListAdapter = new FundListAdapter(getActivity(), R.layout.support_simple_spinner_dropdown_item, serchResult);
                listView.setAdapter(fundListAdapter);
            }
        });
    }

    private void load() {

        CognitoCachingCredentialsProvider cognitoProvider = new CognitoCachingCredentialsProvider(
                getActivity().getApplicationContext(),
                "ap-northeast-2:a03da40d-6e0a-40f9-9510-6a5fb5c4a37a", // 자격 증명 풀 ID
                Regions.AP_NORTHEAST_2 // 리전
        );
        LambdaInvokerFactory factory = new LambdaInvokerFactory(getActivity().getApplicationContext(),
                Regions.AP_NORTHEAST_2, cognitoProvider);
        Log.i("asdfgh", factory+"");

        final ShowingCastListInterface showingCastListInterface = factory.build(ShowingCastListInterface.class, new LambdaDataListBinder(new TypeToken<ArrayList<PreviewClass>>(){}.getType()));

        final CastRequestClass request = new CastRequestClass(0, 20);
        new AsyncTask<CastRequestClass, Void, ArrayList<PreviewClass>>() {
            @Override
            protected ArrayList<PreviewClass> doInBackground(CastRequestClass... params) {
                // invoke "echo" method. In case it fails, it will throw a
                // LambdaFunctionException.
                try {
                    return showingCastListInterface.addingShowCast(params[0]);
                } catch (LambdaFunctionException lfe) {
                    Log.v("asdf", "d");
                    Log.e("Tag", "Failed to invoke echo", lfe);
                    return null;
                }
            }

            @Override
            protected void onPostExecute(ArrayList<PreviewClass> result) {
                if (result == null) {

                    return;
                }

                FundListAdapter castAdapter = new FundListAdapter(getActivity(), R.layout.fund_list_row, result);
                listView = (ListView)getActivity().findViewById(R.id.listView);
                listView.setAdapter(castAdapter);

            }
        }.execute(request);
    }

    public void showSearch() {
        //  searchBox.setLayoutParams(new LinearLayout.LayoutParams(layoutWidth, layoutHeight));
        searchBox.setVisibility(View.VISIBLE);
     //   Log.v("asdf", layoutWidth + " " + layoutHeight);
    }
}