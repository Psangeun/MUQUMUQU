package com.example.musicquiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Locale;

public class QuizIntroActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_SPEECH_INPUT = 1000;
    private static final int TOTAL = 4 * 1000;
    private static final int COUNT_DOWN_INTERVAL = 1000;

    CountDownTimer countDownTimer;
    MediaPlayer player;
    TextView mTextTv,btnPass2,tvQ;
    ImageButton mVoiceBtn;
    ImageView iv;
    boolean check = false;
    public static int corCount = 0;
    public static int questionCount = 10;
    int curNum = 0; // 0,1,2,3,4
    public static int count = Fragment3.year;
    public static int[] songNums = new int[questionCount]; // 랜덤으로 5곡 저장
    int[][] music = {
            {R.raw.song2000_01, R.raw.song2000_02, R.raw.song2000_03, R.raw.song2000_04, R.raw.song2000_05, R.raw.song2000_06, R.raw.song2000_07, R.raw.song2000_08, R.raw.song2000_09, R.raw.song2000_10, R.raw.song2000_11, R.raw.song2000_12, R.raw.song2000_13, R.raw.song2000_14, R.raw.song2000_15, R.raw.song2000_16, R.raw.song2000_17, R.raw.song2000_18, R.raw.song2000_19, R.raw.song2000_20, R.raw.song2000_21, R.raw.song2000_22, R.raw.song2000_23, R.raw.song2000_24, R.raw.song2000_25, R.raw.song2000_26, R.raw.song2000_27, R.raw.song2000_28, R.raw.song2000_29, R.raw.song2000_30, R.raw.song2000_31, R.raw.song2000_32, R.raw.song2000_33, R.raw.song2000_34, R.raw.song2000_35, R.raw.song2000_36, R.raw.song2000_37, R.raw.song2000_38, R.raw.song2000_39, R.raw.song2000_40, R.raw.song2000_41, R.raw.song2000_42, R.raw.song2000_43, R.raw.song2000_44, R.raw.song2000_45, R.raw.song2000_46, R.raw.song2000_47, R.raw.song2000_48, R.raw.song2000_49, R.raw.song2000_50},
            {R.raw.song2010_01, R.raw.song2010_02, R.raw.song2010_03, R.raw.song2010_04, R.raw.song2010_05, R.raw.song2010_06, R.raw.song2010_07, R.raw.song2010_08, R.raw.song2010_09, R.raw.song2010_10, R.raw.song2010_11, R.raw.song2010_13, R.raw.song2010_14, R.raw.song2010_15, R.raw.song2010_16, R.raw.song2010_17, R.raw.song2010_18, R.raw.song2010_19, R.raw.song2010_20, R.raw.song2010_21, R.raw.song2010_22, R.raw.song2010_23, R.raw.song2010_24, R.raw.song2010_25, R.raw.song2010_26, R.raw.song2010_27, R.raw.song2010_28, R.raw.song2010_29, R.raw.song2010_30, R.raw.song2010_31, R.raw.song2010_32, R.raw.song2010_33, R.raw.song2010_34, R.raw.song2010_35, R.raw.song2010_36, R.raw.song2010_37, R.raw.song2010_38, R.raw.song2010_39, R.raw.song2010_40, R.raw.song2010_41, R.raw.song2010_42, R.raw.song2010_43, R.raw.song2010_44, R.raw.song2010_45, R.raw.song2010_46, R.raw.song2010_47, R.raw.song2010_48, R.raw.song2010_49, R.raw.song2010_50, R.raw.song2010_51},
            {R.raw.song2020_01, R.raw.song2020_02, R.raw.song2020_03, R.raw.song2020_04, R.raw.song2020_06, R.raw.song2021_01, R.raw.song2021_02, R.raw.song2021_03, R.raw.song2021_04, R.raw.song2021_05, R.raw.song2022_02, R.raw.song2022_03, R.raw.song2022_04, R.raw.song2022_05, R.raw.song2022_07}
    };

    public static String[][][] answer = {
            {
                    {"Gee","지","쥐","g"},{"점점"},{"사랑했나봐"},{"마지막 인사"},{"사랑의 시"},{"벌써 일년","벌써일년"},{"No.1","넘버원"},{"하루 하루","하루하루"},{"I love you","알러뷰"},{"So Hot","쏘핫"},{"거짓말"},{"Tell me","텔미"},{"아시나요"},{"우린 제법 잘 어울려요"},{"거짓말"},{"Never Ending Story","네버 엔딩 스토리"},{"With Me","윗미","with me","With me","위드 미"},{"미안해요"},{"제자리 걸음","제자리걸음"},{"열정"},{"사랑해도 헤어질 수 있다면"},{"사랑앓이"},{"사랑..그게 뭔데","사랑 그게 뭔데", "사랑그게뭔데"},{"정말 사랑했을까"},{"Break Away","브레이크어웨이","break away"},{"총 맞은 것처럼"},{"죄와벌","죄와 벌"},{"I Don't Care","아돈케어","I don't care","아이돈케어"},{"미인"},{"내사람","내 사람"},{"친구여"},{"Nobody","노바디"},{"이럴거면"},{"사랑은...향기를 남기고","사랑은 향기를 남기고"},{"또 한번 사랑은 가고"},{"비몽"},{"아틀란티스 소녀"},{"세글자"},{"LOVE ALL","러브올","love all"},{"하기 힘든 말"},{"Lollipop","롤리팝"},{"소원을 말해봐","지니","소원을 말해 봐"},{"Fly","플라이"},{"다시 사랑한다 말할까"},{"사랑은 가슴이 시킨다"},{"Love","러브","럽"},{"초련"},{"좋은 사람"},{"먼곳에서"},{"가시나무"}
            },
            {
                    {"벚꽃 엔딩"},{"밤편지"},{"야생화"},{"봄날"},{"금요일에 만나요"},{"첫눈처럼 너에게 가겠다"},{"봄 사랑 벚꽃 말고"},{"모든 날, 모든 순간","모든날 모든순간","모든 날 모든 순간"},{"어디에도"},{"바람기억"},{"선물"},{"너의 의미"},{"좋니"},{"비도 오고 그래서"},{"CHEER UP","치얼업"},{"우주를 줄게"},{"미리 메리 크리스마스"},{"또 다시 사랑"},{"널 사랑하지 않아"},{"썸"},{"사랑을 했다"},{"좋은 날"},{"한 여름밤의 꿀","한여름밤의 꿀"},{"Way Back Home","웨이 백 홈","way back home"},{"이 소설의 끝을 다시 써보려 해"},{"끝사랑"},{"DNA"},{"빨간 맛"},{"내가 저지른 사랑"},{"자니"},{"팔레트"},{"좋다고 말해"},{"걱정말아요 그대","걱정 말아요 그대"},{"여수 밤바다","여수밤바다"},{"너랑 나"},{"Beautiful","뷰티풀","beautiful"},{"뚜두뚜두"},{"TT","티티"},{"너를 만나"},{"지나오다"},{"그날처럼"},{"나만 안되는 연애"},{"한숨"},{"D","d","하프문"},{"Really Really","릴리 릴리","Really Really","윌리 윌리","릴리릴리","윌리윌리"},{"너였다면"},{"여행"},{"그리워하다"},{"마지막처럼"},{"뱅뱅뱅"}
            },
            {
                    //{"아무 노래"},{"메테오"},{"아로하"},{"흔들리는 꽃들 속에서네 샴푸 향이 느껴진 거야"},{"블루밍"},{"셀러브리티"},{"롤린"},{"다이너마이트"},{"넥스트 레벨","NEXT LEVEL"},{"라일락"},{"애프터 라이크","애프터 like","after like"},{"하이 보이"},{"셧다운","셧 다운"},{"어텐션","attention"},{"핑크 베놈"}
            }
    };

    @Override
    public void onBackPressed(){
        player.release();
        player = null;
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_intro);

        mTextTv = findViewById(R.id.textIntro);
        mVoiceBtn = findViewById(R.id.voiceBtnIntro);
        btnPass2 = findViewById(R.id.btnPassIntro);
        tvQ = findViewById(R.id.tvQI);
        iv = (ImageView)findViewById(R.id.ivIntro);

        init();
        makeSongNumbers();

        countDownTimer();
        countDownTimer.start();
        delayMusicPlay();

        mVoiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.pause();
                speak();
            }
        });
        btnPass2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextTv.setText(answer[count][songNums[curNum]][0]);

                if(curNum == questionCount -1){
                    player.stop();
                    player = null;

                    Intent intent = new Intent (QuizIntroActivity.this, ResultIntroActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Glide.with(QuizIntroActivity.this).load(R.drawable.countdownblue).into(iv);
                    player.stop();
                    curNum++;
                    countDownTimer();
                    countDownTimer.start();
                    delayMusicPlay();
                }

            }
        });
    }

    private void init() {
        for(int i = 0; i < songNums.length; i++) {
            songNums[i] = 0;
        }
    }

    private void makeSongNumbers() {
        for(int i=0; i<questionCount; i++) {
            songNums[i] = (int)(Math.random() * 50);

            // 중복 번호 제거
            for(int j=0; j<i; j++) {
                if(songNums[i] == songNums[j]) {
                    i--;
                    break;
                }
            }
        }
    }

    public void countDown(){
        player.release();
        player = null;

        player = MediaPlayer.create(QuizIntroActivity.this, music[count][songNums[curNum]]);
        player.start();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
                player.stop();
                Glide.with(QuizIntroActivity.this).load(R.drawable.qblue).into(iv);
            }
        },5000);
    }
    public void countDownTimer(){
        Glide.with(QuizIntroActivity.this).load(R.drawable.waveblue).into(iv);
        countDownTimer = new CountDownTimer(TOTAL, COUNT_DOWN_INTERVAL) {
            @Override
            public void onTick(long millisUntilFinished) {
                Glide.with(QuizIntroActivity.this).load(R.drawable.countdownblue).into(iv);
                mVoiceBtn.setClickable(false);
                btnPass2.setClickable(false);
            }
            @Override
            public void onFinish() {
                mVoiceBtn.setClickable(true);
                btnPass2.setClickable(true);
            }
        };
    }

    private void speak() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "정답을 말해주세요!");

        try{
            startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);
        }
        catch (Exception e){
            //Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case REQUEST_CODE_SPEECH_INPUT:{
                if (resultCode == RESULT_OK && data!=null){
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    mTextTv.setText(result.get(0));
                    answerCheck();
                }
                else{
                    Glide.with(QuizIntroActivity.this).load(R.drawable.waveblue).into(iv);
                    countDown();
                    player.setLooping(true);
                }
                break;
            }
        }
    }

    public void delayMusicPlay() {
        tvQ.setText(curNum+1 + "/" + questionCount);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
                Glide.with(QuizIntroActivity.this).load(R.drawable.waveblue).into(iv);
                player = MediaPlayer.create(QuizIntroActivity.this, music[count][songNums[curNum]]);
                mTextTv.setText("");
                countDown();
                player.setLooping(true);
            }
        },4000); //1초 후 인트로 실행
    }

    public void answerCheck(){
        for(int i = 0; i<answer[count][songNums[curNum]].length; i++) {
            if (mTextTv.getText().equals(answer[count][songNums[curNum]][i])) {
                check = true;
                break;
            }
        }
        if(curNum == questionCount-1){
            if (check) {
                mTextTv.setText("정답!!!");
                player.stop();
                corCount++;
                Intent intent = new Intent (QuizIntroActivity.this, ResultIntroActivity.class);
                startActivity(intent); //인트로 실행 후 바로 MainActivity로 넘어감.
                finish();
            }
            else {
                mTextTv.setText("다시 들어보세요");

                Glide.with(QuizIntroActivity.this).load(R.drawable.waveblue).into(iv);
                countDown();
                player.setLooping(true);
            }
        }
        else if(check){
            mTextTv.setText("정답!!!");
            player.stop();
            curNum++;
            corCount++;

            countDownTimer();
            countDownTimer.start();

            delayMusicPlay();
            check = false;

        }
        else {
            mTextTv.setText("다시 들어보세요");

            Glide.with(QuizIntroActivity.this).load(R.drawable.waveblue).into(iv);
            countDown();
            player.setLooping(true);
        }
    }
}