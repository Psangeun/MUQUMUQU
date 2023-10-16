package com.example.musicquiz;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragment1).commitAllowingStateLoss();

        findViewById(R.id.btnNormal).setOnClickListener(mClick);
        findViewById(R.id.btnTA).setOnClickListener(mClick);
        findViewById(R.id.btnIntro).setOnClickListener(mClick);

    }

    final View.OnClickListener mClick = new View.OnClickListener() {
        public void onClick(View v) {
            transaction = fragmentManager.beginTransaction();

            switch (v.getId()) {
                case R.id.btnNormal:
                    transaction.replace(R.id.frameLayout, fragment1).commitAllowingStateLoss();
                    break;
                case R.id.btnTA:
                    transaction.replace(R.id.frameLayout, fragment2).commitAllowingStateLoss();
                    break;
                case R.id.btnIntro:
                    transaction.replace(R.id.frameLayout, fragment3).commitAllowingStateLoss();
                    break;
            }

        }
    };


}