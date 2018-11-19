package com.example.rjgoo.recentrify;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.example.rjgoo.recentrify.MainActivity.showFragment;


public class Home_Fragment extends Fragment {

    Unbinder unbinder;

    public Home_Fragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home_, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.b_stats, R.id.b_profile, R.id.b_pt, R.id.b_share})
    public void onClick(View view) {

        Class fragment = null;

        switch (view.getId()) {
            case R.id.b_stats:
                fragment = Stats_Fragment.class;
                showFragment(fragment);
                break;
            case R.id.b_profile:
                fragment = Stats_Fragment.class;
                showFragment(fragment);
                break;
            case R.id.b_pt:
                fragment = Stats_Fragment.class;
                showFragment(fragment);
                break;
            case R.id.b_share:
                fragment = Stats_Fragment.class;
                showFragment(fragment);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
