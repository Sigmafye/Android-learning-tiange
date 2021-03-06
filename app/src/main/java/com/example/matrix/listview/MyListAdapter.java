package com.example.matrix.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.matrix.R;

public class MyListAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public MyListAdapter(Context context) {
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    static class ViewHolder {
        public ImageView imageView;
        public TextView tvtitle, tvtime, tvcontent;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.layout_list_item, null);
            holder = new ViewHolder();
            holder.imageView = view.findViewById(R.id.iv);
            holder.tvtitle = view.findViewById(R.id.tv_title);
            holder.tvcontent = view.findViewById(R.id.tv_content);
            holder.tvtime = view.findViewById(R.id.tv_time);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.tvtitle.setText("这是标题");
        holder.tvcontent.setText("这是内容");
        holder.tvtime.setText("2020-01-12");

        Glide.with(mContext).load("https://img0.baidu.com/it/u=205441424,1768829584&fm=26&fmt=auto&gp=0.jpg").into(holder.imageView);
        return view;
    }
}