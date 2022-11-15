package com.example.fyp_memory_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditUserProfile extends AppCompatActivity {

    EditText et_name_editprofile;
    Button btnupdate;

    //private boolean hintclick;
    MediaPlayer mp_btnclick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_profile);
        setTitle("Edit User Name");

        et_name_editprofile = (EditText) findViewById(R.id.et_name_editprofile);
        btnupdate = (Button) findViewById(R.id.btnupdate);

        //MEDIAPLAYER
        mp_btnclick = MediaPlayer.create(this,R.raw.click_effect);

        //Sound
        SharedPreferences sharedPreferencesSound = getSharedPreferences("MySharedPrefSound", MODE_PRIVATE);
        String soundclick = sharedPreferencesSound.getString("sound", "");

        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        String s1 = sh.getString("name", "");
        et_name_editprofile.setText(s1);

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(soundclick.equals("on")){
                    mp_btnclick.start();
                }

                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                myEdit.putString("name", et_name_editprofile.getText().toString());
                myEdit.apply();

                Toast.makeText(EditUserProfile.this, "Updated", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(EditUserProfile.this,MainActivity.class));
                finish();

            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(EditUserProfile.this,MainActivity.class));
        finish();
    }
}