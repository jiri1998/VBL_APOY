package com.example.jirir.tryout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayersListAdapter extends ArrayAdapter<Player> {

    private static final String TAG = "GamesListAdapter";
    private Context mContext;
    int mRecource;

    public PlayersListAdapter(Context context, int resource, ArrayList<Player> objects) {
        super(context, resource, objects);
        mContext = context;
        mRecource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get info
        String name = getItem(position).getName();
        String sirname = getItem(position).getSirname();
        String number = getItem(position).getNumber();
        String pos = getItem(position).getPos();
        String team_name = getItem(position).getTeam_name();
        Double points = getItem(position).getPoints();
        Double assists = getItem(position).getAssists();
        Double rebounds = getItem(position).getRebounds();

        Player player = new Player(name, sirname, number ,pos, team_name, points, assists, rebounds);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mRecource, parent,false);

        TextView txtvname = (TextView) convertView.findViewById(R.id.txtv_players_nm);
        TextView txtvsirname = (TextView) convertView.findViewById(R.id.txtv_players_sirname);
        TextView txtvnumber = (TextView) convertView.findViewById(R.id.txtv_players_number);
        TextView txtvpos = (TextView) convertView.findViewById(R.id.txtv_players_pos);
        TextView txtvteamnm = (TextView) convertView.findViewById(R.id.txtv_players_tmname);
        TextView txtvpoints = (TextView) convertView.findViewById(R.id.txtv_players_pnt);
        TextView txtvassists = (TextView) convertView.findViewById(R.id.txtv_players_ast);
        TextView txtvrebounds = (TextView) convertView.findViewById(R.id.txtv_players_reb);

        txtvname.setText(name);
        txtvsirname.setText(sirname);
        txtvnumber.setText(number);
        txtvpos.setText(pos);
        txtvteamnm.setText(team_name);
        txtvpoints.setText(points.toString());
        txtvassists.setText(assists.toString());
        txtvrebounds.setText(rebounds.toString());

        return convertView;
    }
}
