package com.example.caesar.opellaapp;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.caesar.opellaapp.Utilities.CONSTANTS;
import com.example.caesar.opellaapp.Utilities.SharedPrefUtil;
import com.example.caesar.opellaapp.WalletPay.TestWalletLayout;
import com.example.caesar.opellaapp.WalletPay.WalletActivity;
import com.robertlevonyan.views.customfloatingactionbutton.FloatingActionLayout;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class Test3DRotateActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    /** Called when the activity is first created. */
    private final String TAG="Test3DRotateActivity";
    private ImageView image, image2, image3, image4, image5, image6, image7, image8;
    private Button start ,stop;
    private Rotate3dAnimation rotation;
    private StartNextRotate startNext;
    MediaPlayer mPlayer;
    boolean checkClicked = false;
    CoordinatorLayout mylinearLayout;
    AnimationDrawable myanimationDrawable;
    com.robertlevonyan.views.customfloatingactionbutton.FloatingActionButton customFAB;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        animateButton();
        mylinearLayout = findViewById(R.id.coordinateopeletray);
        myanimationDrawable = (AnimationDrawable) mylinearLayout.getBackground();
        myanimationDrawable.setEnterFadeDuration(4500);
        myanimationDrawable.setExitFadeDuration(4500);
        myanimationDrawable.start();

//        GifImageView giffa = (GifImageView) findViewById(R.id.gifview);
//        giffa.setImageResource(R.drawable.carrywe);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        toggle.setDrawerIndicatorEnabled(false);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        image =  (ImageView) findViewById(R.id.image);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);
        image4 = (ImageView) findViewById(R.id.image4);
        image5 = (ImageView) findViewById(R.id.image5);
        image6 = (ImageView) findViewById(R.id.image6);
        image7 = (ImageView) findViewById(R.id.image7);
        image8 = (ImageView) findViewById(R.id.image8);

        image.setImageResource(R.drawable.opelefront);
        image2.setImageResource(R.drawable.opelefront);
        image3.setImageResource(R.drawable.opeleback);
        image4.setImageResource(R.drawable.opeleback);
        image5.setImageResource(R.drawable.opelefront);
        image6.setImageResource(R.drawable.opeleback);
        image7.setImageResource(R.drawable.opelefront);
        image8.setImageResource(R.drawable.opeleback);
        customFAB =(com.robertlevonyan.views.customfloatingactionbutton.FloatingActionButton) findViewById(R.id.custom_fab);

        start=(Button) findViewById(R.id.play_button);
//check if its fals which its always apart from when its default value is true
        boolean test =new SharedPrefUtil( getApplicationContext()).getBoolean(CONSTANTS.SAVED_START_parameters, true);
        if ( new SharedPrefUtil( getApplicationContext()).getInt(CONSTANTS.SAVED_SEED_NUMBER) == 0 &&
                new SharedPrefUtil( getApplicationContext()).getBoolean(CONSTANTS.SAVED_START_parameters) ){

            final int a = 10;
            new SharedPrefUtil(getApplicationContext()).saveInt(CONSTANTS.SAVED_SEED_NUMBER, a);
        }


        final int ds =new SharedPrefUtil( getApplicationContext()).getInt(CONSTANTS.SAVED_SEED_NUMBER);
        String textvalue = String.valueOf(String.valueOf(ds));
        customFAB.setFabText(textvalue);
//        stop = (Button) findViewById(R.id.stop);
        start.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                // TODO Auto-generated method stub
                //For 360 degree rotation
                checkClicked = true;
                if (checkClicked && ds != 0 ){
                    int reduced = ds - 1;
                    String textreducedvalue = String.valueOf(String.valueOf(reduced));
                    customFAB.setFabText(textreducedvalue);
                    new SharedPrefUtil(getApplicationContext()).saveBoolean(CONSTANTS.SAVED_START_parameters, false);
                    new SharedPrefUtil(getApplicationContext()).saveInt(CONSTANTS.SAVED_SEED_NUMBER, reduced);
                    startRotation(0,1440);
                }
                else {
          Toast.makeText(Test3DRotateActivity.this, "Buy opele seeds to consult Oraku!!", Toast.LENGTH_LONG).show();
          customFAB.setFabIconColor(R.color.primary_light);
                }

            }
        });

//        stop.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                image.clearAnimation();
//                image2.clearAnimation();
//                image3.clearAnimation();
//                image4.clearAnimation();
//                image5.clearAnimation();
//                image6.clearAnimation();
//                image7.clearAnimation();
//                image8.clearAnimation();
//
//                int imageArray[] = {R.drawable.opelefront, R.drawable.opeleback};
//
//                Random number = new Random();
//                int a =  number.nextInt(2);
//                int b =  number.nextInt(2);
//                int c =  number.nextInt(2);
//                int d =  number.nextInt(2);
//                int e =  number.nextInt(2);
//                int f =  number.nextInt(2);
//                int g =  number.nextInt(2);
//                int h =  number.nextInt(2);
//
//                image.setImageResource(imageArray[a]);
//                image2.setImageResource(imageArray[b]);
//                image3.setImageResource(imageArray[c]);
//                image4.setImageResource(imageArray[d]);
//                image5.setImageResource(imageArray[e]);
//                image6.setImageResource(imageArray[f]);
//                image7.setImageResource(imageArray[g]);
//                image8.setImageResource(imageArray[h]);
//
//            }
//        });


    }

    private void startRotation(float start, float end) {
        // Calculating center point
        final float centerX = image.getWidth() / 2.0f;
        final float centerY = image.getHeight() / 2.0f;
        Log.d(TAG, "centerX="+centerX+", centerY="+centerY);
        // Create a new 3D rotation with the supplied parameter
        // The animation listener is used to trigger the next animation
        //final Rotate3dAnimation rotation =new Rotate3dAnimation(start, end, centerX, centerY, 310.0f, true);
        //Z axis is scaled to 0
        rotation =new Rotate3dAnimation(start, end, centerX, centerY, 0f, true);
        rotation.setDuration(5000);
        rotation.setFillAfter(true);
        //rotation.setInterpolator(new AccelerateInterpolator());
        //Uniform rotation
        rotation.setInterpolator(new LinearInterpolator());
        //Monitor settings
        startNext = new StartNextRotate();
        rotation.setAnimationListener(startNext);
        image.startAnimation(rotation);
        image2.startAnimation(rotation);
        image3.startAnimation(rotation);
        image4.startAnimation(rotation);
        image5.startAnimation(rotation);
        image6.startAnimation(rotation);
        image7.startAnimation(rotation);
        image8.startAnimation(rotation);


    }
    public void startWallet (View view){
        Intent intent = new Intent(Test3DRotateActivity.this, WalletActivity.class);
        startActivity(intent);
    }
    public void startTestWallet (View view){
        Intent intent = new Intent(Test3DRotateActivity.this, TestWalletLayout.class);
        startActivity(intent);
    }

    private class StartNextRotate implements Animation.AnimationListener {

        public void onAnimationEnd(Animation animation) {
            // TODO Auto-generated method stub
            Log.d(TAG, "onAnimationEnd......");
//            image.startAnimation(rotation);
//            image3.startAnimation(rotation);
//            image5.startAnimation(rotation);
//            image7.startAnimation(rotation);
            int imageArray[] = {R.drawable.opelefront, R.drawable.opeleback};

            Random number = new Random();
            int a =  number.nextInt(2);
            int b =  number.nextInt(2);
            int c =  number.nextInt(2);
            int d =  number.nextInt(2);
            int e =  number.nextInt(2);
            int f =  number.nextInt(2);
            int g =  number.nextInt(2);
            int h =  number.nextInt(2);


            image.setImageResource(imageArray[a]);
            image2.setImageResource(imageArray[b]);
            image3.setImageResource(imageArray[c]);
            image4.setImageResource(imageArray[d]);
            image5.setImageResource(imageArray[e]);
            image6.setImageResource(imageArray[f]);
            image7.setImageResource(imageArray[g]);
            image8.setImageResource(imageArray[h]);

            Random starter = new Random();
            int j =  starter.nextInt(16);
            int k =  starter.nextInt(16);
            int l =  starter.nextInt(16);
            int m =  number.nextInt(16);
            int n =  number.nextInt(16);
            int o =  number.nextInt(16);


            Intent intent = new Intent(Test3DRotateActivity.this, TestOpele.class);
            intent.putExtra(TestOpele.EXTRA_CARD_ONE, j);
            intent.putExtra(TestOpele.EXTRA_CARD_TWO, k);
            intent.putExtra(TestOpele.EXTRA_CARD_THREE, l);
            intent.putExtra(TestOpele.EXTRA_CARD_FOUR, m);
            intent.putExtra(TestOpele.EXTRA_CARD_FIVE, n);
            intent.putExtra(TestOpele.EXTRA_CARD_SIX, o);
            startActivity(intent);
        }

        public void onAnimationRepeat(Animation animation) {
            // TODO Auto-generated method stub

        }

        public void onAnimationStart(Animation animation) {
            // TODO Auto-generated method stub

        }

    }
    @Override
    protected void onDestroy() {
        // Stop the sound
        if (mPlayer != null) {
            mPlayer.stop();
            mPlayer = null;
        }
        super.onDestroy();
    }







    void animateButton() {
        // Load the animation
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        final double animationDuration = 3.0 * 1000;
        myAnim.setDuration((long)animationDuration);

        // Use custom animation interpolator to achieve the bounce effect
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.20, 20.00);

        myAnim.setInterpolator(interpolator);

        // Animate the button
        Button button = (Button)findViewById(R.id.play_button);
        button.startAnimation(myAnim);
        playSound();

        // Run button animation again after it finished
        myAnim.setAnimationListener(new Animation.AnimationListener(){
            @Override
            public void onAnimationStart(Animation arg0) {}

            @Override
            public void onAnimationRepeat(Animation arg0) {}

            @Override
            public void onAnimationEnd(Animation arg0) {
                if (checkClicked){

                }else {
                    animateButton();
                }

            }
        });
    }

    void playSound() {
        if (mPlayer != null) {
            mPlayer.stop();
            mPlayer.reset();
        }

        mPlayer = MediaPlayer.create(Test3DRotateActivity.this, R.raw.bubble);
        mPlayer.start();
    }
    public void immagesBounce(){
        image.clearAnimation();
        image2.clearAnimation();
        TranslateAnimation transAnim = new TranslateAnimation(1, 2, 0,
                getDisplayHeight());
        transAnim.setStartOffset(500);
        transAnim.setDuration(3000);
        transAnim.setFillAfter(true);
        transAnim.setInterpolator(new BounceInterpolator());
        transAnim.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                Log.i(TAG, "Starting button dropdown animation");

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.i(TAG,
                        "Ending button dropdown animation. Clearing animation and setting layout");
                image.clearAnimation();
                final int left = image.getLeft();
                final int top = image.getTop();
                final int right = image.getRight();
                final int bottom = image.getBottom();
                image.layout(left, top, right, bottom);

            }
        });

        image.startAnimation(transAnim);
        image2.startAnimation(transAnim);
        image3.startAnimation(transAnim);
        image4.startAnimation(transAnim);
        image5.startAnimation(transAnim);
        image6.startAnimation(transAnim);
        image7.startAnimation(transAnim);
        image8.startAnimation(transAnim);
    }
    private int getDisplayHeight() {
        return this.getResources().getDisplayMetrics().heightPixels;
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
         if (id == R.id.navigation_home) {
            Intent intent = new Intent(Test3DRotateActivity.this, MainActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.navigation_wallet) {
            Intent intent = new Intent(Test3DRotateActivity.this, WalletActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.navigation_info) {
            Intent intent = new Intent(Test3DRotateActivity.this, TestOpele.class);
            startActivity(intent);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}