package com.example.matrix.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.matrix.R;

class MyGridViewAdapter extends BaseAdapter {

    private Context mcontext;
    private LayoutInflater mlayoutInflater;


    MyGridViewAdapter(Context context) {
        this.mcontext = context;
        mlayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 30;
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
        public ImageView imagview;
        public TextView textview;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {

            convertView = mlayoutInflater.inflate(R.layout.layout_grid_item, null);
            holder = new ViewHolder();
            holder.imagview = convertView.findViewById(R.id.iv_grid);
            holder.textview = convertView.findViewById(R.id.iv_title);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textview.setText("Love U n+" + position + " times");
        Glide.with(mcontext).load("https://img0.baidu.com/it/u=2660430160,4119651390&fm=26&fmt=auto&gp=0.jpg").into(holder.imagview);

        return convertView;
    }
}
