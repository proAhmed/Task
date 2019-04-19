package com.ahmed.testforapp.base;

import android.os.Bundle;

import com.ahmed.testforapp.R;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity {
    @LayoutRes
    protected abstract int layoutRes();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutRes());
        ButterKnife.bind(this);
    }

    public void fragmentMoveAddBackStack(Fragment fragment){
        getSupportFragmentManager().beginTransaction().add(R.id.container,fragment).addToBackStack("").commit();
    }
    public void fragmentMove(Fragment fragment){
        getSupportFragmentManager().beginTransaction().add(R.id.container,fragment).commit();
    }
}
