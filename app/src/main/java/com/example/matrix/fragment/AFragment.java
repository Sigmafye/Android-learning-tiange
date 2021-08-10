package com.example.matrix.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.matrix.R;

import java.nio.BufferUnderflowException;

public class AFragment extends Fragment {
    private TextView mTvTitle;
    private Activity mActivity;

    public static AFragment newInstance(String title) {
        AFragment aFragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        //可保证Fragment在重建的时候保持参数的一致性，不用再次传参
        aFragment.setArguments(bundle);
        return aFragment;
    }

    @Nullable
    @Override
    //相当于Activity中的setContentView()
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflateView = inflater.inflate(R.layout.fragment_a, container, false);
        return inflateView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //
        mTvTitle = view.findViewById(R.id.tv_title);
        if (getArguments() != null) {
            mTvTitle.setText(getArguments().getString("title"));
        }


//        if (getActivity() != null) {
//            // todo ...
//        } else {
//
//        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        mActivity = (Activity) context; //不推荐
    }

    @Override
    //该方法会导致getActivity为null
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //取消进行中的异步任务
    }
}
