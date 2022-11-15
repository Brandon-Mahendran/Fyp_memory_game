package com.example.fyp_memory_game;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapterLevelSix extends BaseAdapter {

    private Context mContext;
    DatabaseHelper myDb ;
    SQLiteDatabase db;
    private ArrayList<String> Id = new ArrayList<String>();
    private ArrayList<String> Name = new ArrayList<String>();
    private ArrayList<String> Score = new ArrayList<String>();

    public CustomAdapterLevelSix(Context context,ArrayList<String> Id,ArrayList<String> Name,ArrayList<String> Score){
        this.mContext = context;
        this.Id = Id;
        this.Name = Name;
        this.Score = Score;
    }

    public int getCount() {

        if(Id.size() > 6){
            return Math.min(Id.size(),6);
        }else{
            return Id.size();
        }

    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        final CustomAdapterLevelSix.viewHolder holder;
        myDb =new DatabaseHelper(mContext);
        LayoutInflater layoutInflater;
        if (convertView == null) {
            layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_achievement_layout, null);
            holder = new CustomAdapterLevelSix.viewHolder();
            // holder.id = (TextView) convertView.findViewById(R.id.et_id);
            holder.name = (TextView) convertView.findViewById(R.id.tv_name_six);
            holder.score = (TextView) convertView.findViewById(R.id.tv_score_six);
            convertView.setTag(holder);
        } else {
            holder = (CustomAdapterLevelSix.viewHolder) convertView.getTag();
        }
        // holder.id.setText(Id.get(position));
        holder.name.setText(Name.get(position));
        holder.score.setText(Score.get(position)+"\tsec");

        return convertView;
    }

    public class viewHolder {
        // TextView id;
        TextView name;
        TextView score;
    }
}
