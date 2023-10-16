package com.example.musicquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultIntroActivity extends AppCompatActivity {
    int correct = QuizIntroActivity.corCount;
    int total = QuizIntroActivity.questionCount;

    TextView tvHR,tvRH;
    TextView an1, an2, an3, an4, an5, an6, an7, an8, an9, an10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_intro);

        tvRH = findViewById(R.id.tvResultIntro);
        tvRH.setText(correct + "/" + total);

        an1 = findViewById(R.id.ai1);
        an2 = findViewById(R.id.ai2);
        an3 = findViewById(R.id.ai3);
        an4 = findViewById(R.id.ai4);
        an5 = findViewById(R.id.ai5);
        an6 = findViewById(R.id.ai6);
        an7 = findViewById(R.id.ai7);
        an8 = findViewById(R.id.ai8);
        an9 = findViewById(R.id.ai9);
        an10 = findViewById(R.id.ai10);

        an1.setText(QuizIntroActivity.answer[QuizIntroActivity.count][QuizIntroActivity.songNums[0]][0]);
        an2.setText(QuizIntroActivity.answer[QuizIntroActivity.count][QuizIntroActivity.songNums[1]][0]);
        an3.setText(QuizIntroActivity.answer[QuizIntroActivity.count][QuizIntroActivity.songNums[2]][0]);
        an4.setText(QuizIntroActivity.answer[QuizIntroActivity.count][QuizIntroActivity.songNums[3]][0]);
        an5.setText(QuizIntroActivity.answer[QuizIntroActivity.count][QuizIntroActivity.songNums[4]][0]);
        an6.setText(QuizIntroActivity.answer[QuizIntroActivity.count][QuizIntroActivity.songNums[5]][0]);
        an7.setText(QuizIntroActivity.answer[QuizIntroActivity.count][QuizIntroActivity.songNums[6]][0]);
        an8.setText(QuizIntroActivity.answer[QuizIntroActivity.count][QuizIntroActivity.songNums[7]][0]);
        an9.setText(QuizIntroActivity.answer[QuizIntroActivity.count][QuizIntroActivity.songNums[8]][0]);
        an10.setText(QuizIntroActivity.answer[QuizIntroActivity.count][QuizIntroActivity.songNums[9]][0]);

        tvHR = findViewById(R.id.tvMainIntro);
        tvHR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuizIntroActivity.corCount = 0;
                Intent intent = new Intent(ResultIntroActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}