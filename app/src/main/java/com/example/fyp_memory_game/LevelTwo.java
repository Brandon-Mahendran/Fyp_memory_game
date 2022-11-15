package com.example.fyp_memory_game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;

import tyrantgit.explosionfield.ExplosionField;

public class LevelTwo extends AppCompatActivity {

    ImageView iv_11, iv_12 , iv_13 , iv_14,
            iv_21, iv_22 , iv_23 , iv_24;

    //array for images
    Integer[] cardArray = {101,102,103,104,
            201,202,203,204};

    //actual images
    int image101,image102,image103,image104,
            image201,image202,image203,image204;

    int firstcard,secondcard;
    int clickfirst, clicksecond;
    int cardNumber = 1;

    int turn = 1;
    int playerPoints = 0,cpuPoints = 0;

    //TIMER
    private Chronometer chronometer;
    private long pauseOffset;
    private boolean running;
    String formatType;
    long base;
    //TextView tv_second;
    int seconds;

    Button playbtn, resetbtn, hintbtn;

    //TextView
    TextView textView_diplaytime;
    Button btn_yes_nextlvl, btn_no_nextlvl;

    //DB
    DatabaseHelper myDb ;

    //EXPLOSIONFIELD
    private ExplosionField mExplosionField;

    //private boolean hintclick;
    MediaPlayer mp_btnclick, mp_ivclick, mp_explode_effect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_two);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        mExplosionField = ExplosionField.attach2Window(this);

        myDb = new DatabaseHelper(this);

        iv_11 = (ImageView)findViewById(R.id.iv_11);
        iv_12 = (ImageView)findViewById(R.id.iv_12);
        iv_13 = (ImageView)findViewById(R.id.iv_13);
        iv_14 = (ImageView)findViewById(R.id.iv_14);

        iv_21 = (ImageView)findViewById(R.id.iv_21);
        iv_22 = (ImageView)findViewById(R.id.iv_22);
        iv_23 = (ImageView)findViewById(R.id.iv_23);
        iv_24 = (ImageView)findViewById(R.id.iv_24);

        playbtn = (Button) findViewById(R.id.btnplay);
        resetbtn = (Button) findViewById(R.id.btnreset);
        hintbtn = (Button) findViewById(R.id.btnhint);

        //MEDIAPLAYER
        mp_btnclick = MediaPlayer.create(this,R.raw.click_effect);
        mp_ivclick = MediaPlayer.create(this,R.raw.tab_effect);
        mp_explode_effect = MediaPlayer.create(this,R.raw.breaking_effect);

        //TIMER
        //tv_second = (TextView)findViewById(R.id.tv_seconds);
        chronometer = findViewById(R.id.chronometer2);
        chronometer.setFormat(" %s");
        chronometer.setBase(SystemClock.elapsedRealtime());
        base=chronometer.getBase();
        formatType=chronometer.getFormat();

        iv_11.setTag("0");
        iv_12.setTag("1");
        iv_13.setTag("2");
        iv_14.setTag("3");

        iv_21.setTag("4");
        iv_22.setTag("5");
        iv_23.setTag("6");
        iv_24.setTag("7");

        //DISABLE ALL IMAGE
        iv_11.setEnabled(false);
        iv_12.setEnabled(false);
        iv_13.setEnabled(false);
        iv_14.setEnabled(false);

        iv_21.setEnabled(false);
        iv_22.setEnabled(false);
        iv_23.setEnabled(false);
        iv_24.setEnabled(false);

        //DISABLE RESET & HINT BUTTON
        resetbtn.setEnabled(false);
        hintbtn.setEnabled(false);

        //load the cards images
        frontOfCardsResources();

        //shuffle the images
        Collections.shuffle(Arrays.asList(cardArray));

        //Sound
        SharedPreferences sharedPreferencesSound = getSharedPreferences("MySharedPrefSound", MODE_PRIVATE);
        String soundclick = sharedPreferencesSound.getString("sound", "");

        //ROW1
        iv_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());

                if(iv_11.isPressed()){
                    doStuff(iv_11,theCard);

                    if(soundclick.equals("on")){
                        mp_ivclick.start();
                    }
                }

                if(hintbtn.isPressed()){
                    doStuffhint(iv_11,theCard);
                }

            }
        });

        iv_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());

                if(iv_12.isPressed()){
                    doStuff(iv_12,theCard);

                    if(soundclick.equals("on")){
                        mp_ivclick.start();
                    }
                }

                if(hintbtn.isPressed()){
                    doStuffhint(iv_12,theCard);
                }
            }
        });

        iv_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());

                if(iv_13.isPressed()){
                    doStuff(iv_13,theCard);

                    if(soundclick.equals("on")){
                        mp_ivclick.start();
                    }
                }

                if(hintbtn.isPressed()){
                    doStuffhint(iv_13,theCard);
                }
            }
        });

        iv_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());

                if(iv_14.isPressed()){
                    doStuff(iv_14,theCard);

                    if(soundclick.equals("on")){
                        mp_ivclick.start();
                    }
                }

                if(hintbtn.isPressed()){
                    doStuffhint(iv_14,theCard);
                }
            }
        });

        //ROW 2
        iv_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());

                if(iv_21.isPressed()){
                    doStuff(iv_21,theCard);

                    if(soundclick.equals("on")){
                        mp_ivclick.start();
                    }
                }

                if(hintbtn.isPressed()){
                    doStuffhint(iv_21,theCard);
                }
            }
        });

        iv_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());

                if(iv_22.isPressed()){
                    doStuff(iv_22,theCard);

                    if(soundclick.equals("on")){
                        mp_ivclick.start();
                    }
                }

                if(hintbtn.isPressed()){
                    doStuffhint(iv_22,theCard);
                }
            }
        });

        iv_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());

                if(iv_23.isPressed()){
                    doStuff(iv_23,theCard);

                    if(soundclick.equals("on")){
                        mp_ivclick.start();
                    }
                }

                if(hintbtn.isPressed()){
                    doStuffhint(iv_23,theCard);
                }
            }
        });

        iv_24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());

                if(iv_24.isPressed()){
                    doStuff(iv_24,theCard);

                    if(soundclick.equals("on")){
                        mp_ivclick.start();
                    }
                }

                if(hintbtn.isPressed()){
                    doStuffhint(iv_24,theCard);
                }
            }
        });

        hintbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(soundclick.equals("on")){
                    mp_btnclick.start();
                }

                if(iv_11.getVisibility()==View.VISIBLE){
                    iv_11.performClick();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //check weather selected image are same
                            iv_11.setImageResource(R.drawable.cardcover);
                        }
                    },1000);
                }

                if(iv_12.getVisibility()==View.VISIBLE){
                    iv_12.performClick();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //check weather selected image are same
                            iv_12.setImageResource(R.drawable.cardcover);
                        }
                    },1000);
                }

                if(iv_13.getVisibility()==View.VISIBLE){
                    iv_13.performClick();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //check weather selected image are same
                            iv_13.setImageResource(R.drawable.cardcover);
                        }
                    },1000);
                }

                if(iv_14.getVisibility()==View.VISIBLE){
                    iv_14.performClick();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //check weather selected image are same
                            iv_14.setImageResource(R.drawable.cardcover);
                        }
                    },1000);
                }

                if(iv_21.getVisibility()==View.VISIBLE){
                    iv_21.performClick();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //check weather selected image are same
                            iv_21.setImageResource(R.drawable.cardcover);
                        }
                    },1000);
                }

                if(iv_22.getVisibility()==View.VISIBLE){
                    iv_22.performClick();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //check weather selected image are same
                            iv_22.setImageResource(R.drawable.cardcover);
                        }
                    },1000);
                }

                if(iv_23.getVisibility()==View.VISIBLE){
                    iv_23.performClick();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //check weather selected image are same
                            iv_23.setImageResource(R.drawable.cardcover);
                        }
                    },1000);
                }

                if(iv_24.getVisibility()==View.VISIBLE){
                    iv_24.performClick();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //check weather selected image are same
                            iv_24.setImageResource(R.drawable.cardcover);
                        }
                    },1000);
                }

            }
        });

        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(soundclick.equals("on")){
                    mp_btnclick.start();
                }
                startActivity(new Intent(LevelTwo.this,LevelTwo.class));
                finish();
            }
        });

        //TIMER
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {

            }

        });
    }

    private void doStuffhint(ImageView iv,int card){
        if(cardArray[card]==101){
            iv.setImageResource(image101);
        }else if(cardArray[card]==102){
            iv.setImageResource(image102);
        }else if(cardArray[card]==103){
            iv.setImageResource(image103);
        }else if(cardArray[card]==104){
            iv.setImageResource(image104);
        }else if(cardArray[card]==201){
            iv.setImageResource(image201);
        }else if(cardArray[card]==202){
            iv.setImageResource(image202);
        }else if(cardArray[card]==203){
            iv.setImageResource(image203);
        }else if(cardArray[card]==204){
            iv.setImageResource(image204);
        }

        //check which image is selected and save it to temp variable
        if(cardNumber == 1){
            firstcard = cardArray[card];
            if(firstcard>200){
                firstcard = firstcard-100;
            }
            cardNumber = 2;
            clickfirst = card;

            iv.setEnabled(false);
        }else if(cardNumber == 2){
            secondcard = cardArray[card];

            if(secondcard>200){
                secondcard = secondcard-100;
            }
            cardNumber = 1;
            clicksecond = card;

            iv_11.setEnabled(true);
            iv_12.setEnabled(true);
            iv_13.setEnabled(true);
            iv_14.setEnabled(true);

            iv_21.setEnabled(true);
            iv_22.setEnabled(true);
            iv_23.setEnabled(true);
            iv_24.setEnabled(true);

        }

    }

    private void doStuff(ImageView iv,int card){
        if(cardArray[card]==101){
            iv.setImageResource(image101);
        }else if(cardArray[card]==102){
            iv.setImageResource(image102);
        }else if(cardArray[card]==103){
            iv.setImageResource(image103);
        }else if(cardArray[card]==104){
            iv.setImageResource(image104);
        }else if(cardArray[card]==201){
            iv.setImageResource(image201);
        }else if(cardArray[card]==202){
            iv.setImageResource(image202);
        }else if(cardArray[card]==203){
            iv.setImageResource(image203);
        }else if(cardArray[card]==204){
            iv.setImageResource(image204);
        }

        //check which image is selected and save it to temp variable
        if(cardNumber == 1){
            firstcard = cardArray[card];
            if(firstcard>200){
                firstcard = firstcard-100;
            }
            cardNumber = 2;
            clickfirst = card;

            iv.setEnabled(false);
        }else if(cardNumber == 2){
            secondcard = cardArray[card];

            if(secondcard>200){
                secondcard = secondcard-100;
            }
            cardNumber = 1;
            clicksecond = card;

            iv_11.setEnabled(false);
            iv_12.setEnabled(false);
            iv_13.setEnabled(false);
            iv_14.setEnabled(false);

            iv_21.setEnabled(false);
            iv_22.setEnabled(false);
            iv_23.setEnabled(false);
            iv_24.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //check weather selected image are same
                    calculate();
                }
            },1000);
        }

    }

    private void calculate(){
        if(firstcard == secondcard) {

            SharedPreferences sharedPreferencesSound = getSharedPreferences("MySharedPrefSound", MODE_PRIVATE);
            String soundclick = sharedPreferencesSound.getString("sound", "");

            if (clickfirst == 0) {
                iv_11.setVisibility(View.INVISIBLE);
                mExplosionField.explode(iv_11);
                if(soundclick.equals("on")){
                    mp_explode_effect.start();
                }
            } else if (clickfirst == 1) {
                iv_12.setVisibility(View.INVISIBLE);
                mExplosionField.explode(iv_12);
                if(soundclick.equals("on")){
                    mp_explode_effect.start();
                }
            } else if (clickfirst == 2) {
                iv_13.setVisibility(View.INVISIBLE);
                mExplosionField.explode(iv_13);
                if(soundclick.equals("on")){
                    mp_explode_effect.start();
                }
            } else if (clickfirst == 3) {
                iv_14.setVisibility(View.INVISIBLE);
                mExplosionField.explode(iv_14);
                if(soundclick.equals("on")){
                    mp_explode_effect.start();
                }
            } else if (clickfirst == 4) {
                iv_21.setVisibility(View.INVISIBLE);
                mExplosionField.explode(iv_21);
                if(soundclick.equals("on")){
                    mp_explode_effect.start();
                }
            } else if (clickfirst == 5) {
                iv_22.setVisibility(View.INVISIBLE);
                mExplosionField.explode(iv_22);
                if(soundclick.equals("on")){
                    mp_explode_effect.start();
                }
            } else if (clickfirst == 6) {
                iv_23.setVisibility(View.INVISIBLE);
                mExplosionField.explode(iv_23);
                if(soundclick.equals("on")){
                    mp_explode_effect.start();
                }
            } else if (clickfirst == 7) {
                iv_24.setVisibility(View.INVISIBLE);
                mExplosionField.explode(iv_24);
                if(soundclick.equals("on")){
                    mp_explode_effect.start();
                }
            }

            if (clicksecond == 0) {
                iv_11.setVisibility(View.INVISIBLE);
                mExplosionField.explode(iv_11);
                if(soundclick.equals("on")){
                    mp_explode_effect.start();
                }
            } else if (clicksecond == 1) {
                iv_12.setVisibility(View.INVISIBLE);
                mExplosionField.explode(iv_12);
                if(soundclick.equals("on")){
                    mp_explode_effect.start();
                }
            } else if (clicksecond == 2) {
                iv_13.setVisibility(View.INVISIBLE);
                mExplosionField.explode(iv_13);
                if(soundclick.equals("on")){
                    mp_explode_effect.start();
                }
            } else if (clicksecond == 3) {
                iv_14.setVisibility(View.INVISIBLE);
                mExplosionField.explode(iv_14);
                if(soundclick.equals("on")){
                    mp_explode_effect.start();
                }
            } else if (clicksecond == 4) {
                iv_21.setVisibility(View.INVISIBLE);
                mExplosionField.explode(iv_21);
                if(soundclick.equals("on")){
                    mp_explode_effect.start();
                }
            } else if (clicksecond == 5) {
                iv_22.setVisibility(View.INVISIBLE);
                mExplosionField.explode(iv_22);
                if(soundclick.equals("on")){
                    mp_explode_effect.start();
                }
            } else if (clicksecond == 6) {
                iv_23.setVisibility(View.INVISIBLE);
                mExplosionField.explode(iv_23);
                if(soundclick.equals("on")){
                    mp_explode_effect.start();
                }
            } else if (clicksecond == 7) {
                iv_24.setVisibility(View.INVISIBLE);
                mExplosionField.explode(iv_24);
                if(soundclick.equals("on")){
                    mp_explode_effect.start();
                }
            }

        }else {
            iv_11.setImageResource(R.drawable.cardcover);
            iv_12.setImageResource(R.drawable.cardcover);
            iv_13.setImageResource(R.drawable.cardcover);
            iv_14.setImageResource(R.drawable.cardcover);

            iv_21.setImageResource(R.drawable.cardcover);
            iv_22.setImageResource(R.drawable.cardcover);
            iv_23.setImageResource(R.drawable.cardcover);
            iv_24.setImageResource(R.drawable.cardcover);

        }

        iv_11.setEnabled(true);
        iv_12.setEnabled(true);
        iv_13.setEnabled(true);
        iv_14.setEnabled(true);

        iv_21.setEnabled(true);
        iv_22.setEnabled(true);
        iv_23.setEnabled(true);
        iv_24.setEnabled(true);

        //check if the game is over
        checkEnd();
    }

    private void checkEnd(){
        if(iv_11.getVisibility()==View.INVISIBLE &&
                iv_12.getVisibility()==View.INVISIBLE &&
                iv_13.getVisibility()==View.INVISIBLE &&
                iv_14.getVisibility()==View.INVISIBLE &&

                iv_21.getVisibility()==View.INVISIBLE &&
                iv_22.getVisibility()==View.INVISIBLE &&
                iv_23.getVisibility()==View.INVISIBLE &&
                iv_24.getVisibility()==View.INVISIBLE ){

            //STOP THE TIMER
            if (running) {
                chronometer.stop();
                pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();

                seconds = (int) pauseOffset / 1000;
                seconds = Math.abs(seconds);
                //tv_second.setText( Math.abs(seconds) + " seconds");
                running = false;
            }

            //Disable play button
            playbtn.setEnabled(false);

            AlertDialog.Builder mBuilder = new AlertDialog.Builder(LevelTwo.this);
            mBuilder.setCancelable(false);
            View mView = getLayoutInflater().inflate(R.layout.dialog_box_achievement, null);
            textView_diplaytime = (TextView) mView.findViewById(R.id.textView_diplaytime);
            textView_diplaytime.setText("Well Done!.."+seconds+" seconds");
            btn_yes_nextlvl = (Button) mView.findViewById(R.id.btn_yes_dialogbox_achievement);
            btn_no_nextlvl = (Button) mView.findViewById(R.id.btn_no_dialogbox_achieve);

            //Sound
            SharedPreferences sharedPreferencesSound = getSharedPreferences("MySharedPrefSound", MODE_PRIVATE);
            String soundclick = sharedPreferencesSound.getString("sound", "");

            btn_yes_nextlvl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(soundclick.equals("on")){
                        mp_btnclick.start();
                    }
                    startActivity(new Intent(LevelTwo.this,LevelThree.class));
                    finish();
                }
            });

            btn_no_nextlvl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(soundclick.equals("on")){
                        mp_btnclick.start();
                    }
                    startActivity(new Intent(LevelTwo.this,MainActivity.class));
                    finish();
                }
            });

            mBuilder.setView(mView);
            AlertDialog dialog = mBuilder.create();
            dialog.show();

            SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

            String s1 = sh.getString("name", "");

            //add here
            boolean isInserted = myDb.insertData_leveltwo(
                    s1,
                    String.valueOf(seconds));

            if(isInserted == true){
                Toast.makeText(LevelTwo.this,"Data Inserted",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(LevelTwo.this,"Data not Inserted",Toast.LENGTH_LONG).show();
            }

        }
    }

    private void frontOfCardsResources() {
        image101 = R.drawable.dmas;
        image102 = R.drawable.muzium;
        image103 = R.drawable.library;
        image104 = R.drawable.dataranperdana;

        image201 = R.drawable.dmas;
        image202 = R.drawable.muzium;
        image203 = R.drawable.library;
        image204 = R.drawable.dataranperdana;
    }

    //TIMER
    public void startChronometer(View v) {
        if (!running) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            chronometer.start();
            running = true;

            SharedPreferences sharedPreferencesSound = getSharedPreferences("MySharedPrefSound", MODE_PRIVATE);
            String soundclick = sharedPreferencesSound.getString("sound", "");
            if(soundclick.equals("on")){
                mp_btnclick.start();
            }

            //ENABLE ALL IMAGE
            iv_11.setEnabled(true);
            iv_12.setEnabled(true);
            iv_13.setEnabled(true);
            iv_14.setEnabled(true);

            iv_21.setEnabled(true);
            iv_22.setEnabled(true);
            iv_23.setEnabled(true);
            iv_24.setEnabled(true);

            //ENABLE RESET & HINT BUTTON
            resetbtn.setEnabled(true);
            hintbtn.setEnabled(true);

        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(LevelTwo.this,MainActivity.class));
        finish();
    }
}