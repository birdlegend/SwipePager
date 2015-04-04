package com.zsb.swipepager;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by zsb on 2015/4/1.
 */
public class Fragment1 extends Fragment {
    private View mMainView;
    private TextView tv;
    private Button btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = getActivity().getLayoutInflater();
        mMainView = inflater.inflate(R.layout.fragment1,
                (ViewGroup) getActivity().findViewById(R.id.viewPager), false);

        tv = (TextView) mMainView.findViewById(R.id.tv1);
        btn = (Button) mMainView.findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("Hello viewpager");
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) mMainView.getParent();
        if (viewGroup != null) {
            viewGroup.removeAllViewsInLayout();
            Log.v("Tag", "fragment1-->移除已经存在的view");
        }
        return mMainView;
    }
}
