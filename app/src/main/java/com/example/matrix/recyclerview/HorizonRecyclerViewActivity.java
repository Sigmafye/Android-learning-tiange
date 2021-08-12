package com.example.matrix.recyclerview;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.matrix.R;

public class HorizonRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRvHorizon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizon_recycler_view);

        mRvHorizon = findViewById(R.id.rv_horizon);

        Log.d("my Recycler Object:", mRvHorizon == null ? "yes" : "no");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HorizonRecyclerViewActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRvHorizon.setLayoutManager(linearLayoutManager);
        mRvHorizon.addItemDecoration(new MyDecoration());
        mRvHorizon.setAdapter(new HorizonRecyclerAdapter(HorizonRecyclerViewActivity.this, new HorizonRecyclerAdapter.MyItemClickListener() {
            @Override
            public void goClick(int pos) {
                Toast.makeText(HorizonRecyclerViewActivity.this, "pos:" + pos, Toast.LENGTH_SHORT).show();
            }
        }));

    }

    class MyDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0, 0, getResources().getDimensionPixelOffset(R.dimen.dividerHeight), 0);
        }
    }
}
