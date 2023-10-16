package com.example.musicquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultTAActivity extends AppCompatActivity {
    int correct = QuizTAActivity.corCount;
    int total = QuizTAActivity.questionCount;

    TextView tv,tv2;
    TextView ai1,ai2,ai3,ai4,ai5,ai6,ai7,ai8,ai9,ai10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_ta);
        tv2 = findViewById(R.id.tvResultTA);
        tv2.setText(correct + "/" + total);

        ai1 = findViewById(R.id.at1);
        ai2 = findViewById(R.id.at2);
        ai3 = findViewById(R.id.at3);
        ai4 = findViewById(R.id.at4);
        ai5 = findViewById(R.id.at5);
        ai6 = findViewById(R.id.at6);
        ai7 = findViewById(R.id.at7);
        ai8 = findViewById(R.id.at8);
        ai9 = findViewById(R.id.at9);
        ai10 = findViewById(R.id.at10);

        ai1.setText(QuizTAActivity.answer[QuizTAActivity.count][QuizTAActivity.songNums[0]][0]);
        ai2.setText(QuizTAActivity.answer[QuizTAActivity.count][QuizTAActivity.songNums[1]][0]);
        ai3.setText(QuizTAActivity.answer[QuizTAActivity.count][QuizTAActivity.songNums[2]][0]);
        ai4.setText(QuizTAActivity.answer[QuizTAActivity.count][QuizTAActivity.songNums[3]][0]);
        ai5.setText(QuizTAActivity.answer[QuizTAActivity.count][QuizTAActivity.songNums[4]][0]);
        ai6.setText(QuizTAActivity.answer[QuizTAActivity.count][QuizTAActivity.songNums[5]][0]);
        ai7.setText(QuizTAActivity.answer[QuizTAActivity.count][QuizTAActivity.songNums[6]][0]);
        ai8.setText(QuizTAActivity.answer[QuizTAActivity.count][QuizTAActivity.songNums[7]][0]);
        ai9.setText(QuizTAActivity.answer[QuizTAActivity.count][QuizTAActivity.songNums[8]][0]);
        ai10.setText(QuizTAActivity.answer[QuizTAActivity.count][QuizTAActivity.songNums[9]][0]);

        tv = findViewById(R.id.tvMainTA);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuizTAActivity.corCount = 0;
                Intent intent = new Intent(ResultTAActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}