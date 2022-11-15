package com.example.fyp_memory_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class LevelFiveScore extends AppCompatActivity {

    private ListView mlistView;

    DatabaseHelper myDb = new DatabaseHelper(this);
    SQLiteDatabase db;

    private ArrayList<String> Id = new ArrayList<String>();
    private ArrayList<String> Name = new ArrayList<String>();
    private ArrayList<String> Score = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_five_score);
        setTitle("Level Five Achievements");

        mlistView = (ListView)findViewById(R.id.listview);
        mlistView.setDivider(new ColorDrawable(0x99F10529));   //0xAARRGGBB
        mlistView.setDividerHeight(1);

        myDb = new DatabaseHelper(this);
    }

    @Override
    protected void onResume() {
        displayData();
        super.onResume();
    }

    //DISPLAY DATA FOR LEVEL FIVE
    private void displayData() {
        db = myDb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM  levelfive_table ORDER BY SCORE ",null);
        Id.clear();
        Name.clear();
        Score.clear();
        if (cursor.moveToFirst()) {
            do {
                Id.add(cursor.getString(cursor.getColumnIndex("ID")));
                Name.add(cursor.getString(cursor.getColumnIndex("NAME")));
                Score.add(cursor.getString(cursor.getColumnIndex("SCORE")));
            } while (cursor.moveToNext());
        }
        CustomAdapterLevelFive ca = new CustomAdapterLevelFive(LevelFiveScore.this,Id, Name,Score);
        mlistView.setAdapter(ca);
        //code to set adapter to populate list
        cursor.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.levelfive_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_delete) {
            deleteAll();
            Toast.makeText(LevelFiveScore.this, "Deleted", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LevelFiveScore.this,MainActivity.class));
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void deleteAll() {
        db = myDb.getReadableDatabase();
        db.delete("levelfive_table",null,null);
        db.execSQL("delete from "+ "levelfive_table");
        db.close();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(LevelFiveScore.this,MainActivity.class));
        finish();
    }
}