package com.example.jirir.tryout;

import android.content.Context;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.Inflater;

public class GamesListAdapter extends ArrayAdapter<Game> {

    private static final String TAG = "GamesListAdapter";
    private Context mContext;
    int mRecource;

    public GamesListAdapter(Context context, int resource, ArrayList<Game> objects) {
        super(context, resource, objects);
        mContext = context;
        mRecource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get info
        String date = getItem(position).getDate();
        String homeName = getItem(position).getHome_team_name();
        String awayName = getItem(position).getAway_team_name();
        Integer homeScore = getItem(position).getHome_team_score();
        Integer awayScore = getItem(position).getAway_team_score();

        Game game = new Game(date, homeName, awayName ,homeScore, awayScore);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mRecource, parent,false);

        TextView txtvdate = (TextView) convertView.findViewById(R.id.txtv_date_games);
        TextView txtvhname = (TextView) convertView.findViewById(R.id.txtv_games_hname);
        TextView txtvaname = (TextView) convertView.findViewById(R.id.txtv_games_aname);
        TextView txtvhscore = (TextView) convertView.findViewById(R.id.txtv_games_hscr);
        TextView txtvascore = (TextView) convertView.findViewById(R.id.txtv_games_ascr);

        txtvdate.setText(date);
        txtvhname.setText(homeName);
        txtvaname.setText(awayName);
        txtvhscore.setText(homeScore.toString());
        txtvascore.setText(awayScore.toString());

        return convertView;
    }
}
