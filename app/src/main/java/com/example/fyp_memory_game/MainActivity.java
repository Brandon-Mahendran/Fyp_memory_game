package com.example.fyp_memory_game;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fyp_memory_game.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    EditText et_name_dialogbox;
    Button btn_ok_dialogbox;
    TextView welc_textview, tf_username;

    NumberPicker picker1;
    private String[] pickerVals;
    int valuePicker1;

    SharedPreferences sharedPreferencesSound;
    SharedPreferences.Editor myEditsound;
    String s1_sound;

    MediaPlayer mp_btnlevels;

    AppCompatButton btnlvlOne, btnlvlTwo, btnlvlThree, btnlvlFour, btnlvlFive, btnlvlSix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle("Home");

        mp_btnlevels = MediaPlayer.create(this,R.raw.click_effect);

        picker1 = (NumberPicker) findViewById(R.id.numberpick);

        welc_textview = (TextView) findViewById(R.id.welc_textview);

        btnlvlOne = (AppCompatButton)findViewById(R.id.btnlvl_one);
        btnlvlTwo = (AppCompatButton)findViewById(R.id.btnlvl_two);
        btnlvlThree = (AppCompatButton)findViewById(R.id.btnlvl_three);
        btnlvlFour = (AppCompatButton)findViewById(R.id.btnlvl_four);
        btnlvlFive = (AppCompatButton)findViewById(R.id.btnlvl_five);
        btnlvlSix = (AppCompatButton)findViewById(R.id.btnlvl_six);


        sharedPreferencesSound = getSharedPreferences("MySharedPrefSound", MODE_PRIVATE);
        myEditsound = sharedPreferencesSound.edit();

        setSupportActionBar(binding.appBarMain.toolbar);
        /*binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "This is a Mobile Game for Mental Health Intervention developed for students.", Snackbar.LENGTH_LONG)
                       // .setAction("Action", null).show();
            }
        });*/

        picker1.setMaxValue(1);
        picker1.setMinValue(0);
        picker1.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        pickerVals = new String[] {"Levels", "Achievements"};
        picker1.setDisplayedValues(pickerVals);

        picker1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                valuePicker1 = picker1.getValue();
                Log.d("picker value", pickerVals[valuePicker1]);
            }
        });

        //level one btn
        btnlvlOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(valuePicker1 == 1){
                    startActivity(new Intent(MainActivity.this,LevelOneScore.class));
                    finish();
                }else{
                    //Toast.makeText(view.getContext(), "test", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,LevelOne.class));
                    finish();
                }

                //play sound
                String soundclick = sharedPreferencesSound.getString("sound", "");
                if(soundclick.equals("on")){
                    mp_btnlevels.start();
                }


            }
        });

        //level two btn
        btnlvlTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(valuePicker1 == 1){
                    startActivity(new Intent(MainActivity.this,LevelTwoScore.class));
                    finish();
                }else{
                    startActivity(new Intent(MainActivity.this,LevelTwo.class));
                    finish();
                }

                //play sound
                String soundclick = sharedPreferencesSound.getString("sound", "");
                if(soundclick.equals("on")){
                    mp_btnlevels.start();
                }

            }
        });

        //level three btn
        btnlvlThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(valuePicker1 == 1){
                    startActivity(new Intent(MainActivity.this,LevelThreeScore.class));
                    finish();
                }else{
                    startActivity(new Intent(MainActivity.this,LevelThree.class));
                    finish();
                }

                //play sound
                String soundclick = sharedPreferencesSound.getString("sound", "");
                if(soundclick.equals("on")){
                    mp_btnlevels.start();
                }

            }
        });

        //level four btn
        btnlvlFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(valuePicker1 == 1){
                    startActivity(new Intent(MainActivity.this,LevelFourScore.class));
                    finish();
                }else{
                    startActivity(new Intent(MainActivity.this,LevelFour.class));
                    finish();
                }

                //play sound
                String soundclick = sharedPreferencesSound.getString("sound", "");
                if(soundclick.equals("on")){
                    mp_btnlevels.start();
                }

            }
        });

        //level five btn
        btnlvlFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(valuePicker1 == 1){
                    startActivity(new Intent(MainActivity.this,LevelFiveScore.class));
                    finish();
                }else{
                    startActivity(new Intent(MainActivity.this,LevelFive.class));
                    finish();
                }

                //play sound
                String soundclick = sharedPreferencesSound.getString("sound", "");
                if(soundclick.equals("on")){
                    mp_btnlevels.start();
                }

            }
        });

        //level six btn
        btnlvlSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(valuePicker1 == 1){
                    startActivity(new Intent(MainActivity.this,LevelSixScore.class));
                    finish();
                }else{
                    startActivity(new Intent(MainActivity.this,LevelSix.class));
                    finish();
                }

                //play sound
                String soundclick = sharedPreferencesSound.getString("sound", "");
                if(soundclick.equals("on")){
                    mp_btnlevels.start();
                }

            }
        });

        DrawerLayout drawer = binding.drawerLayout;
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        //NavigationView navigationView = binding.navView;
        /*NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        //dont use this line else onNavigationItemSelected will not work
        //NavigationUI.setupWithNavController(navigationView, navController);*/


        final SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(this);

        if(!prefs.contains("FirstTime")) {

            //Alertdialog box
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
            mBuilder.setCancelable(false);
            View mView = getLayoutInflater().inflate(R.layout.dialog_box, null);
            et_name_dialogbox = (EditText) mView.findViewById(R.id.et_name_dialogbox);
            btn_ok_dialogbox = (Button) mView.findViewById(R.id.btn_ok_dialogbox);

            mBuilder.setView(mView);
            AlertDialog dialog = mBuilder.create();
            dialog.show();

            btn_ok_dialogbox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                    SharedPreferences.Editor myEdit = sharedPreferences.edit();
                    myEdit.putString("name", et_name_dialogbox.getText().toString());
                    myEdit.apply();

                    //here
                    myEditsound.putString("sound", "off");
                    myEditsound.apply();
                    //Toast.makeText(MainActivity.this, "Sound Off", Toast.LENGTH_SHORT).show();

                    //Toast.makeText(MainActivity.this, "dialogbox", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();


                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("FirstTime", true);
                    editor.apply();
                }
            });

        }

        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        String s1 = sh.getString("name", "");
        //et_name_dialogbox.setText(s1);
        welc_textview.setText("Welcome " + s1 +"!");

        // display name at nav header
        //View headerView = navigationView.getHeaderView(0);
        //tf_username= (TextView) headerView.findViewById(R.id.tf_username);
        //tf_username.setText(""+s1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem checkable = menu.findItem(R.id.action_settings);

        s1_sound = sharedPreferencesSound.getString("sound", "");
        if(s1_sound.equals("off")){
            checkable.setChecked(false);
        }else if(s1_sound.equals("on")){
            checkable.setChecked(true);
        }else{
            checkable.setChecked(false);
        }

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

            if(s1_sound.equals("off")){
                myEditsound.putString("sound", "on");
                myEditsound.apply();
                mp_btnlevels.start();
                Toast.makeText(MainActivity.this, "Sound On", Toast.LENGTH_SHORT).show();

            } else if (s1_sound.equals("on")){
                myEditsound.putString("sound", "off");
                myEditsound.apply();
                Toast.makeText(MainActivity.this, "Sound Off", Toast.LENGTH_SHORT).show();
            }else{
                myEditsound.putString("sound", "on");
                myEditsound.apply();
                mp_btnlevels.start();
                Toast.makeText(MainActivity.this, "Sound On else", Toast.LENGTH_SHORT).show();

            }

            //Toast.makeText(MainActivity.this, "action setings", Toast.LENGTH_SHORT).show();
            return true;
        }

        if (id == R.id.action_edit) {

            //play sound
            String soundclick = sharedPreferencesSound.getString("sound", "");
            if(soundclick.equals("on")){
                mp_btnlevels.start();
            }
            startActivity(new Intent(MainActivity.this,EditUserProfile.class));
            finish();
            return true;
        }

        //addhere
        if (id == R.id.action_info) {

            //play sound
            String soundclick = sharedPreferencesSound.getString("sound", "");
            if(soundclick.equals("on")){
                mp_btnlevels.start();
            }
            Toast.makeText(MainActivity.this, "This is a Mobile Game for Mental Health Intervention developed for students.", Toast.LENGTH_LONG).show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.nav_home){
            //Toast.makeText(MainActivity.this, "testmenu", Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.nav_edit){
            Toast.makeText(MainActivity.this, "testmenuedit", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this,EditUserProfile.class));
            finish();

        }
        if(id == R.id.level_one){
            startActivity(new Intent(MainActivity.this,LevelOneScore.class));
            finish();
        }

        if(id == R.id.level_two){
            startActivity(new Intent(MainActivity.this,LevelTwoScore.class));
            finish();
        }

        if(id == R.id.level_three){
            startActivity(new Intent(MainActivity.this,LevelThreeScore.class));
            finish();
        }
        return true;
    }

    //Added by me
    /*@Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.level_one) {
            // Handle the camera action
            Toast.makeText(MainActivity.this, "test", Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.nav_edit){
            Toast.makeText(MainActivity.this, "edit", Toast.LENGTH_SHORT).show();
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/

    /*@Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        String s1 = sh.getString("name", "");
        //et_name_dialogbox.setText(s1);
        welc_textview.setText("Welcome "+s1+", "+"let's play a memory game!!");

    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("name", et_name_dialogbox.getText().toString());
        myEdit.apply();
    }*/
}