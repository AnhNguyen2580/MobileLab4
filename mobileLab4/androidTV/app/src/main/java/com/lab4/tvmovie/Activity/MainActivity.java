package com.lab4.tvmovie.Activity;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.lab4.tvmovie.Fragment.MainFragment;
import com.lab4.tvmovie.R;


public class MainActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_browse_fragment, new MainFragment())
                    .commitNow();
        }
    }
}