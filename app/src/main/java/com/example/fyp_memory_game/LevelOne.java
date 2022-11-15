package com.example.fyp_memory_game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

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

public class LevelOne extends AppCompatActivity {

    ImageView iv_11, iv_12 , iv_13 ,
            iv_21, iv_22 , iv_23 ;

    //array for images
    Integer[] cardArray = {101,102,103,
            201,202,203};

    //actual images
    int image101,image102,image103,
            image201,image202,image203;

    int firstcard,secondcard;
    int clickfirst, clicksecond;
    int cardNumber = 1;

    int turn = 1;
    int playerPoints = 0,cpuPoints = 0;

    //TIMER
    private Chronometer chronometer;
    private long pauseOffset;
    private boolean running;
    private long elapsedMillis;
    String formatType;
    long base;
    //TextView tv_second;
    int seconds;

    Button playbtn, hintbtn, resetbtn;

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
        setContentView(R.layout.activity_level_one);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        mExplosionField = ExplosionField.attach2Window(this);

        myDb = new DatabaseHelper(this);

        iv_11 = (ImageView) findViewById(R.id.iv_11);
        iv_12 = (ImageView) findViewById(R.id.iv_12);
        iv_13 = (ImageView) findViewById(R.id.iv_13);

        iv_21 = (ImageView) findViewById(R.id.iv_21);
        iv_22 = (ImageView) findViewById(R.id.iv_22);
        iv_23 = (ImageView) findViewById(R.id.iv_23);

        playbtn = (Button) findViewById(R.id.btnplay);
        hintbtn = (Button) findViewById(R.id.btnhint);
        resetbtn = (Button) findViewById(R.id.btnreset);

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

        iv_21.setTag("3");
        iv_22.setTag("4");
        iv_23.setTag("5");

        //DISABLE ALL IMAGE
        iv_11.setEnabled(false);
        iv_12.setEnabled(false);
        iv_13.setEnabled(false);

        iv_21.setEnabled(false);
        iv_22.setEnabled(false);
        iv_23.setEnabled(false);

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
                    //hintclick = false;
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
                    //hintclick = false;
                    doStuff(iv_12,theCard);

                    if(soundclick.equals("on")){
                        mp_ivclick.start();
                    }
                }

                 if(hintbtn.isPressed()){
                    doStuffhint(iv_12,theCard);
                }

                //mp.start();
            }
        });

        iv_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());

                if(iv_13.isPressed()){
                    //hintclick = false;
                    doStuff(iv_13,theCard);

                    if(soundclick.equals("on")){
                        mp_ivclick.start();
                    }
                }

                if(hintbtn.isPressed()){
                    doStuffhint(iv_13,theCard);
                    //hintclick = false;
                }

                //mp.start();
            }
        });

        //ROW 2
        iv_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());

                if(iv_21.isPressed()){
                    //hintclick = false;
                    doStuff(iv_21,theCard);

                    if(soundclick.equals("on")){
                        mp_ivclick.start();
                    }
                }

                if(hintbtn.isPressed()){
                    doStuffhint(iv_21,theCard);
                    //hintclick = false;
                }

                //mp.start();
            }
        });

        iv_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());

                if(iv_22.isPressed()){
                   // hintclick = false;
                    doStuff(iv_22,theCard);

                    if(soundclick.equals("on")){
                        mp_ivclick.start();
                    }
                }

                if(hintbtn.isPressed()){
                    doStuffhint(iv_22,theCard);
                   // hintclick = false;
                }

                //mp.start();
            }
        });

        iv_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());

                if(iv_23.isPressed()){
                   // hintclick = false;
                    doStuff(iv_23,theCard);

                    if(soundclick.equals("on")){
                        mp_ivclick.start();
                    }
                }

                if(hintbtn.isPressed()){
                    doStuffhint(iv_23,theCard);
                    //hintclick = false;
                }

                //mp.start();
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
            }
        });

        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(soundclick.equals("on")){
                    mp_btnclick.start();
                }

                startActivity(new Intent(LevelOne.this,LevelOne.class));
                finish();
            }
        });

        //TIMER
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                //elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
                /*if ((SystemClock.elapsedRealtime() - chronometer.getBase()) >= 10000) {

                    chronometer.setBase(SystemClock.elapsedRealtime());
                    Toast.makeText(MainActivity.this, "Bing!", Toast.LENGTH_SHORT).show();
                }*/
            }

        });
    }


    // display images to card
    private void doStuff(ImageView iv, int card){
        if(cardArray[card]==101){
            iv.setImageResource(image101);
        }else if(cardArray[card]==102){
            iv.setImageResource(image102);
        }else if(cardArray[card]==103){
            iv.setImageResource(image103);
        }else if(cardArray[card]==201){
            iv.setImageResource(image201);
        }else if(cardArray[card]==202){
            iv.setImageResource(image202);
        }else if(cardArray[card]==203){
            iv.setImageResource(image203);
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

            iv_21.setEnabled(false);
            iv_22.setEnabled(false);
            iv_23.setEnabled(false);

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
                iv_21.setVisibility(View.INVISIBLE);
                mExplosionField.explode(iv_21);
                if(soundclick.equals("on")){
                    mp_explode_effect.start();
                }
            } else if (clickfirst == 4) {
                iv_22.setVisibility(View.INVISIBLE);
                mExplosionField.explode(iv_22);
                if(soundclick.equals("on")){
                    mp_explode_effect.start();
                }
            } else if (clickfirst == 5) {
                iv_23.setVisibility(View.INVISIBLE);
                mExplosionField.explode(iv_23);
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
                iv_21.setVisibility(View.INVISIBLE);
                mExplosionField.explode(iv_21);
                if(soundclick.equals("on")){
                    mp_explode_effect.start();
                }
            } else if (clicksecond == 4) {
                iv_22.setVisibility(View.INVISIBLE);
                mExplosionField.explode(iv_22);
                if(soundclick.equals("on")){
                    mp_explode_effect.start();
                }
            } else if (clicksecond == 5) {
                iv_23.setVisibility(View.INVISIBLE);
                mExplosionField.explode(iv_23);
                if(soundclick.equals("on")){
                    mp_explode_effect.start();
                }
            }


        }else {
            iv_11.setImageResource(R.drawable.cardcover);
            iv_12.setImageResource(R.drawable.cardcover);
            iv_13.setImageResource(R.drawable.cardcover);

            iv_21.setImageResource(R.drawable.cardcover);
            iv_22.setImageResource(R.drawable.cardcover);
            iv_23.setImageResource(R.drawable.cardcover);
        }

        iv_11.setEnabled(true);
        iv_12.setEnabled(true);
        iv_13.setEnabled(true);

        iv_21.setEnabled(true);
        iv_22.setEnabled(true);
        iv_23.setEnabled(true);

        //check if the game is over
        checkEnd();
    }

    private void checkEnd(){
        if(iv_11.getVisibility()==View.INVISIBLE &&
                iv_12.getVisibility()==View.INVISIBLE &&
                iv_13.getVisibility()==View.INVISIBLE &&
                iv_21.getVisibility()==View.INVISIBLE &&
                iv_22.getVisibility()==View.INVISIBLE &&
                iv_23.getVisibility()==View.INVISIBLE ){

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

            //gamefinish.start();

            //START KONFETTI
            /*viewKonfetti_cardsix.build()
                    .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA,Color.RED)
                    .setDirection(0.0,359.0)
                    .setSpeed(1f, 5f)
                    .setFadeOutEnabled(true)
                    .setTimeToLive(2000L)
                    .addShapes(Shape.RECT, Shape.CIRCLE)
                    .addSizes(new Size(12, 5f))
                    .setPosition(100f, viewKonfetti_cardsix.getWidth() + 50f, -50f, -50f)
                    .stream(500, 5000L);*/



            AlertDialog.Builder mBuilder = new AlertDialog.Builder(LevelOne.this);
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
                    startActivity(new Intent(LevelOne.this,LevelTwo.class));
                    finish();
                }
            });

            btn_no_nextlvl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(soundclick.equals("on")){
                        mp_btnclick.start();
                    }
                    startActivity(new Intent(LevelOne.this,MainActivity.class));
                    finish();
                }
            });


            mBuilder.setView(mView);
            AlertDialog dialog = mBuilder.create();
            dialog.show();

            SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

            String s1 = sh.getString("name", "");

            //add here
            boolean isInserted = myDb.insertData(
                    s1,
                    String.valueOf(seconds));

            if(isInserted == true){
                Toast.makeText(LevelOne.this,"Data Inserted",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(LevelOne.this,"Data not Inserted",Toast.LENGTH_LONG).show();
            }

            //tv_score = (TextView) mView.findViewById(R.id.et_score);
            //tv_score.setText(""+seconds);
            //btn_ok = (Button) mView.findViewById(R.id.btn_ok);

            /*btn_ok.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    //ENABLE BUTTON

                    if(!et_name.getText().toString().isEmpty() && !tv_score.getText().toString().isEmpty()){
                        // startActivity(new Intent(Cards_Six_activity.this,MainActivity.class));
                        //MEDIAPLAYER//
                        play_btn.start();
                        // btn_8.setActivated(true);

                        boolean isInserted = myDb.insertData(
                                et_name.getText().toString(),
                                tv_score.getText().toString());
                        if(isInserted == true){
                            //Toast.makeText(Cards_Six_activity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                            Toasty.info(Cards_Six_activity.this, "Data Inserted.", Toast.LENGTH_SHORT, true).show();
                            Intent intent = new Intent(Cards_Six_activity.this,MainActivity.class);
                            intent.putExtra("state", "success");
                            //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                            finish();
                        }
                        else
                            //startActivity(new Intent(Cards_Six_activity.this,MainActivity.class));
                            Toast.makeText(Cards_Six_activity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }


            });*/

            //mBuilder.setView(mView);
            //AlertDialog dialog = mBuilder.create();
            //dialog.show();

            //Toast.makeText(LevelOne.this,""+seconds+" "+s1,Toast.LENGTH_LONG).show();

        }
    }

    private void frontOfCardsResources() {
        image101 = R.drawable.dmas;
        image102 = R.drawable.muzium;
        image103 = R.drawable.library;

        image201 = R.drawable.dmas;
        image202 = R.drawable.muzium;
        image203 = R.drawable.library;
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

            iv_21.setEnabled(true);
            iv_22.setEnabled(true);
            iv_23.setEnabled(true);

            //ENABLE RESET & HINT BUTTON
            resetbtn.setEnabled(true);
            hintbtn.setEnabled(true);

            //hintclick = false;
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(LevelOne.this,MainActivity.class));
        finish();
    }

    // display images to card
    private void doStuffhint(ImageView iv, int card){
        if(cardArray[card]==101){
            iv.setImageResource(image101);
        }else if(cardArray[card]==102){
            iv.setImageResource(image102);
        }else if(cardArray[card]==103){
            iv.setImageResource(image103);
        }else if(cardArray[card]==201){
            iv.setImageResource(image201);
        }else if(cardArray[card]==202){
            iv.setImageResource(image202);
        }else if(cardArray[card]==203){
            iv.setImageResource(image203);
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

            iv_21.setEnabled(true);
            iv_22.setEnabled(true);
            iv_23.setEnabled(true);

            //hintclick =0;

            /*Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //check weather selected image are same
                    calculate();
                }
            },1000);*/
        }
    }


}