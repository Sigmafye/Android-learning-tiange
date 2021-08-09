package com.example.matrix.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.matrix.R;

public class GridRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRvGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);

        mRvGrid = findViewById(R.id.rv_grid);

        mRvGrid.setLayoutManager(new GridLayoutManager(GridRecyclerViewActivity.this, 3));
        mRvGrid.setAdapter(new GridRecyclerAdapter(GridRecyclerViewActivity.this, new GridRecyclerAdapter.MyItemClickListener() {
            @Override
            public void goClick(int pos) {
                Toast.makeText(GridRecyclerViewActivity.this, "pos:" + pos, Toast.LENGTH_SHORT).show();
            }
        }));

    }
}
