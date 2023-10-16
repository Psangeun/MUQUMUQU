package com.example.musicquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultNormalActivity extends AppCompatActivity {
    int correct = QuizNormalActivity.corCount;
    int total = QuizNormalActivity.questionCount;

    TextView tvER,tvRE;
    TextView an1, an2, an3, an4, an5, an6, an7, an8, an9, an10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_normal);
        tvRE = findViewById(R.id.tvResultNormal);
        tvRE.setText(correct + "/" + total);

        an1 = findViewById(R.id.an1);
        an2 = findViewById(R.id.an2);
        an3 = findViewById(R.id.an3);
        an4 = findViewById(R.id.an4);
        an5 = findViewById(R.id.an5);
        an6 = findViewById(R.id.an6);
        an7 = findViewById(R.id.an7);
        an8 = findViewById(R.id.an8);
        an9 = findViewById(R.id.an9);
        an10 = findViewById(R.id.an10);

        an1.setText(QuizNormalActivity.answer[QuizNormalActivity.count][QuizNormalActivity.songNums[0]][0]);
        an2.setText(QuizNormalActivity.answer[QuizNormalActivity.count][QuizNormalActivity.songNums[1]][0]);
        an3.setText(QuizNormalActivity.answer[QuizNormalActivity.count][QuizNormalActivity.songNums[2]][0]);
        an4.setText(QuizNormalActivity.answer[QuizNormalActivity.count][QuizNormalActivity.songNums[3]][0]);
        an5.setText(QuizNormalActivity.answer[QuizNormalActivity.count][QuizNormalActivity.songNums[4]][0]);
        an6.setText(QuizNormalActivity.answer[QuizNormalActivity.count][QuizNormalActivity.songNums[5]][0]);
        an7.setText(QuizNormalActivity.answer[QuizNormalActivity.count][QuizNormalActivity.songNums[6]][0]);
        an8.setText(QuizNormalActivity.answer[QuizNormalActivity.count][QuizNormalActivity.songNums[7]][0]);
        an9.setText(QuizNormalActivity.answer[QuizNormalActivity.count][QuizNormalActivity.songNums[8]][0]);
        an10.setText(QuizNormalActivity.answer[QuizNormalActivity.count][QuizNormalActivity.songNums[9]][0]);
        tvER = findViewById(R.id.tvMainNormal);
        tvER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuizNormalActivity.corCount = 0;
                Intent intent = new Intent(ResultNormalActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}