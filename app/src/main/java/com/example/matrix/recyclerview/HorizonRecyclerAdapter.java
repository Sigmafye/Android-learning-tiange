package com.example.matrix.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.matrix.R;

public class HorizonRecyclerAdapter extends RecyclerView.Adapter<HorizonRecyclerAdapter.LinearRecyclerViewHolder> {

    private Context contextM;
    private MyItemClickListener myItemClickListener;

    public HorizonRecyclerAdapter(Context context, MyItemClickListener myItemClickListener) {
        this.contextM = context;
        this.myItemClickListener = myItemClickListener;
    }

    @NonNull
    @Override
    public LinearRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new LinearRecyclerViewHolder(LayoutInflater.from(contextM).inflate(R.layout.layout_horizon_recycler_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final LinearRecyclerViewHolder viewHolder, int i) {
        viewHolder.textView.setText("love you");
        viewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(contextM, "click..." + viewHolder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
                //可用自己的接口，并在外部实现上一行的方法--回调函数
                myItemClickListener.goClick(viewHolder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        // 实际开发中用列表的长度
        return 30;
    }
    //握着列表元素的静态类
    static class LinearRecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        LinearRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
        }
    }

    public interface MyItemClickListener{
        void goClick(int pos);
    }

}
