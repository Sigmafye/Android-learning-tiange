package com.example.matrix.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.matrix.R;

//当只有一种ViewHolder时，超类可以设置为自定义的LinearRecyclerAdapter.LinearRecyclerViewHolder。但为了两个ViewHolder的差异显示，所以还是用父类
public class LinearRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context contextM;
    private MyItemClickListener myItemClickListener;

    public LinearRecyclerAdapter(Context context, MyItemClickListener myItemClickListener) {
        this.contextM = context;
        this.myItemClickListener = myItemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return viewType == 0 ?
                //偶数ViewHolder 1
                new LinearRecyclerViewHolder(LayoutInflater.from(contextM).inflate(R.layout.layout_linear_recycler_item, viewGroup, false)) :
                //奇数ViewHolder 2
                new LinearRecyclerViewHolder2(LayoutInflater.from(contextM).inflate(R.layout.layout_linear_recycler_item_2, viewGroup, false));
    }

    @Override
    public int getItemViewType(int position) {
//        return super.getItemViewType(position);
        //根据奇偶性自定义返回值
        return position % 2 == 0 ? 0 : 1;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {
        if (getItemViewType(i) == 0){
            ((LinearRecyclerViewHolder)viewHolder).textView.setText("Love me!");
        }
        else {
            ((LinearRecyclerViewHolder2)viewHolder).textView.setText("Love you!");
        }

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
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

    //握着列表元素的静态类--视图的其一
    static class LinearRecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        LinearRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
        }
    }

    //握着列表元素的静态类--视图的其二
    static class LinearRecyclerViewHolder2 extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;

        LinearRecyclerViewHolder2(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
            imageView = itemView.findViewById(R.id.iv_image);
        }
    }

    public interface MyItemClickListener {
        void goClick(int pos);
    }

}
