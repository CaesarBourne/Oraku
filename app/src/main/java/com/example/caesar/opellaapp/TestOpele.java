package com.example.caesar.opellaapp;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class TestOpele extends AppCompatActivity {
    public static final String EXTRA_CARD_ONE = "one";
    public static final String EXTRA_CARD_TWO = "two";
    public static final String EXTRA_CARD_THREE = "three";
    public static final String EXTRA_CARD_FOUR = "four";
    public static final String EXTRA_CARD_FIVE = "five";
    public static final String EXTRA_CARD_SIX = "six";


    CardView lifecard,wealthcard, mothercard, parentscard, childrencard, illnesscard, marraigecard, deathcard, travelcard, leadercard,
                mindcard, enemycard, demandcard, ownercard, homecard, abroadcard;
    LinearLayout lifelayout, wealthlayout, motherlayout;
    CardView cardArray[];
    LinearLayout mylinearLayout;
    AnimationDrawable myanimationDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_opele);


        mylinearLayout = findViewById(R.id.sixtenlinear);
        myanimationDrawable = (AnimationDrawable) mylinearLayout.getBackground();
        myanimationDrawable.setEnterFadeDuration(4500);
        myanimationDrawable.setExitFadeDuration(4500);
        myanimationDrawable.start();
//        if (getIntent().getExtras() != null){
          final   int first = getIntent().getExtras().getInt(EXTRA_CARD_ONE);
           final int second = getIntent().getExtras().getInt(EXTRA_CARD_TWO);
        final int third = getIntent().getExtras().getInt(EXTRA_CARD_THREE);
        final int fourth = getIntent().getExtras().getInt(EXTRA_CARD_FOUR);
        final int fifth = getIntent().getExtras().getInt(EXTRA_CARD_FIVE);
        final int sixth = getIntent().getExtras().getInt(EXTRA_CARD_SIX);



        lifecard = findViewById(R.id.lifecard);
        wealthcard = findViewById(R.id.wealthcard);
        mothercard = findViewById(R.id.mothercard);
        parentscard = findViewById(R.id.parentscard);
        childrencard = findViewById(R.id.childrencard);
        illnesscard = findViewById(R.id.illnesscard);
        marraigecard = findViewById(R.id.marraigecard);
        deathcard = findViewById(R.id.deathcard);
        travelcard = findViewById(R.id.travelcard);
        leadercard = findViewById(R.id.leadercard);
        mindcard = findViewById(R.id.mindcard);
        enemycard = findViewById(R.id.enemycard);
        demandcard = findViewById(R.id.demandcard);
        ownercard = findViewById(R.id.ownercard);
        homecard = findViewById(R.id.homecard);
        abroadcard = findViewById(R.id.abroadcard);

        final CardView[] CardLayouts= {lifecard, wealthcard,mothercard, parentscard, childrencard, illnesscard, marraigecard, deathcard,
                                    travelcard, leadercard, mindcard, enemycard, demandcard, ownercard, homecard, abroadcard};


        Animation animtelife = new AnimationUtils().loadAnimation(getApplicationContext(), R.anim.growbig);
        final Animation animtelife2 = new AnimationUtils().loadAnimation(getApplicationContext(), R.anim.growbig2);
        final Animation animtelife3 = new AnimationUtils().loadAnimation(getApplicationContext(), R.anim.growbig3);
        final Animation animtelife4 = new AnimationUtils().loadAnimation(getApplicationContext(), R.anim.growbig4);
        final Animation animtelife5 = new AnimationUtils().loadAnimation(getApplicationContext(), R.anim.growbig5);
        final Animation animtelife6 = new AnimationUtils().loadAnimation(getApplicationContext(), R.anim.growbig6);

        CardLayouts[first].startAnimation(animtelife); ;


        CardLayouts[fourth].setAnimation(animtelife);
        CardLayouts[fifth].setAnimation(animtelife);
        CardLayouts[sixth].setAnimation(animtelife);

        animtelife.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                CardLayouts[second].startAnimation(animtelife2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });



        animtelife2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                CardLayouts[third].setAnimation(animtelife3);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        animtelife3.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                CardLayouts[third].startAnimation(animtelife4);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        animtelife4.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                CardLayouts[third].setAnimation(animtelife5);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                CardLayouts[third].startAnimation(animtelife5);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        animtelife5.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                CardLayouts[third].startAnimation(animtelife6);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        animtelife6.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });




    }


//    public void startLayout(View view){
//        final Handler handle = new Handler() ;
//        final LinearLayout linearArray[] = {lifelayout, wealthlayout, motherlayout };
//
//        Runnable run = new Runnable() {
//            @Override
//            public void run() {
//
//                for (int i = 0; i < cardArray.length; i++ ){
//                    linearArray[1].setBackgroundColor(getResources().getColor(R.color.deep_orange_A700));
//                    handle.postDelayed(this,1000);
//                }
//
//
//            }
//        };
//        handle.post(run);
//    }

    public void startTime(View view){
        final Handler handle = new Handler() ;
        final CardView cardArray[] = {lifecard, wealthcard, mothercard };
        Handler handler, handler2, handler3;
        handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                cardArray[0].setBackgroundColor(getResources().getColor(R.color.deep_orange_A700));
            }
        }, 3000);

        handler2= new Handler();
        handler2.postDelayed(new Runnable(){
            @Override
            public void run(){
                cardArray[1].setBackgroundColor(getResources().getColor(R.color.deep_orange_A700));
            }
        }, 3000);

        handler3 =  new Handler();
        handler3
                .postDelayed(new Runnable(){
            @Override
            public void run(){
                cardArray[2].setBackgroundColor(getResources().getColor(R.color.deep_orange_A700));
            }
        }, 3000);
    }

    }


