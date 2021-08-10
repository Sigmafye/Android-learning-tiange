package com.example.matrix.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.matrix.R;

public class AFragment extends Fragment {
    private BFragment bFragment;
    private TextView mTvTitle;
    private Activity mActivity;
    private Button mBtnChange, mBtnReset, mBtnMessage;
    private IOnMessageClick listener;

    public static AFragment newInstance(String title) {
        AFragment aFragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        //可保证Fragment在重建的时候保持参数的一致性，不用再次传参
        aFragment.setArguments(bundle);
        return aFragment;
    }

    public interface IOnMessageClick {
        void iOnClick(String text);
    }

    @Nullable
    @Override
    //相当于Activity中的setContentView()
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflateView = inflater.inflate(R.layout.fragment_a, container, false);
        //在用replace时会重新渲染，会打印
        Log.d("AFragment", "----onCreateView----");
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

        mBtnChange = view.findViewById(R.id.btn_change);
        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bFragment == null) {
                    bFragment = new BFragment();
                }

                //为了保证返回时不重新渲染界面
                Fragment fragment = getFragmentManager().findFragmentByTag("tagA");
                if (fragment != null) {
                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.fl_container, bFragment).addToBackStack(null).commitAllowingStateLoss();
                } else {
                    //添加到回退栈中
                    getFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).addToBackStack(null).commitAllowingStateLoss();

                }
            }
        });

        mBtnMessage = view.findViewById(R.id.btn_message);
        mBtnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //不推荐。推荐：在Activity中实现一个在Fragment中定义的接口，实现回调，参数由Fragment向Activity传递
//                ((ContainerActivity) getActivity()).setData("Fragment向Activity传递");
                listener.iOnClick("Fragment向Activity传递-你好！");
            }
        });

        mBtnReset = view.findViewById(R.id.btn_reset);
        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvTitle.setText("我是新文字");
            }
        });

//        if (getActivity() != null) {
//            // todo ...
//        } else {
//
//        }
    }

    @Override
//    Activity和Fragment发生关系时被调用
    public void onAttach(Context context) {
        super.onAttach(context);
//        mActivity = (Activity) context; //不推荐
        try {
            listener = (IOnMessageClick) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity必须实现IOnMessageClick接口");
        } catch (Exception e) {
            e.getStackTrace();
        }

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
