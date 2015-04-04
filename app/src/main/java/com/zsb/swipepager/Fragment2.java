package com.zsb.swipepager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zsb on 2015/4/1.
 */
public class Fragment2 extends Fragment {
    private View mMainView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = getActivity().getLayoutInflater();
        mMainView = inflater.inflate(R.layout.fragment2,
                (ViewGroup) getActivity().findViewById(R.id.viewPager), false);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) mMainView.getParent();
        if (viewGroup != null) {
            viewGroup.removeAllViewsInLayout();
            Log.v("Tag", "fragment2-->移除已经存在的view");
        }
        return mMainView;
    }
}
