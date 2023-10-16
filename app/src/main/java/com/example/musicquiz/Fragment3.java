package com.example.musicquiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment3 extends Fragment {
    private View view;
    private Button btn1,btn2,btn3;
    public static int year;
    private static Toast sToast;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_3,container,false);

        btn1 = (Button) view.findViewById(R.id.Intro2020); //fragment에서 findViewByid는 view.을 이용해서 사용
        btn2 = (Button) view.findViewById(R.id.Intro2010);
        btn3 = (Button) view.findViewById(R.id.Intro2000);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast(getActivity(),"2030년에 업데이트 예정입니다");
//                year=2;
//                Intent intent = new Intent(getActivity(), QuizIntroActivity.class); //fragment라서 activity intent와는 다른 방식
//                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                year=1;
                Intent intent = new Intent(getActivity(), QuizIntroActivity.class); //fragment라서 activity intent와는 다른 방식
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                year=0;
                Intent intent = new Intent(getActivity(), QuizIntroActivity.class); //fragment라서 activity intent와는 다른 방식
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        return view;
    }
    public static void showToast(Context context, String message) {
        if (sToast == null) {
            sToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        } else {
            sToast.setText(message);
        }
        sToast.show();
    }
}

