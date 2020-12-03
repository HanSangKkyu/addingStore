package com.example.han.adding;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class FundListAdapter extends ArrayAdapter<PreviewClass> {

    List<PreviewClass> mData;
    Context context;

    public FundListAdapter(@NonNull Context context, int resource, @NonNull List<PreviewClass> objects) {
        super(context, resource, objects);

        mData=objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if(v == null){
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.fund_list_row, null);
            TextView tv = (TextView)v.findViewById(R.id.title);
            tv.setText(mData.get(position).getTitle());
        }
        // 이미지, 텍스트 붙이기

        return v;
    }
}
