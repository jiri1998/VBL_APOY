package com.example.jirir.tryout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StandingsListAdapter extends ArrayAdapter<Standing> {

    private static final String TAG = "StandingsListAdapter";
    private Context mContext;
    int mRecource;

    public StandingsListAdapter(Context context, int resource, ArrayList<Standing> objects) {
        super(context, resource, objects);
        mContext = context;
        mRecource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get info
        String team_name = getItem(position).getTeam_name();
        Integer rank = getItem(position).getRank();
        Integer wins = getItem(position).getWins();
        Integer losses = getItem(position).getLosses();

        Standing standing = new Standing(team_name, rank, wins ,losses);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mRecource, parent,false);

        TextView txtvtmname = (TextView) convertView.findViewById(R.id.txtv_standings_tmname);
        TextView txtvrank = (TextView) convertView.findViewById(R.id.txtv_standings_rank);
        TextView txtvwins = (TextView) convertView.findViewById(R.id.txtv_standings_wins);
        TextView txtvlosses = (TextView) convertView.findViewById(R.id.txtv_standings_losses);

        txtvtmname.setText(team_name);
        txtvrank.setText(rank.toString());
        txtvwins.setText(wins.toString());
        txtvlosses.setText(losses.toString());

        return convertView;
    }
}
