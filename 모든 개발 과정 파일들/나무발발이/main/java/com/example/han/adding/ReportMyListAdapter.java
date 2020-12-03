package com.example.han.adding;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ReportMyListAdapter extends ArrayAdapter<String> {

    List<String> mData;
    Context context;

    public ReportMyListAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);

        mData = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.report_my_list_row, null);
        }
        // 이미지, 텍스트 붙이기
        ImageView imageView = (ImageView) v.findViewById(R.id.img);
        TextView title = (TextView) v.findViewById(R.id.title);
        TextView kind = (TextView) v.findViewById(R.id.kind);
        TextView deadline = (TextView) v.findViewById(R.id.deadline);
        TextView take = (TextView) v.findViewById(R.id.take);


        return v;
    }
}
