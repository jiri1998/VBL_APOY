package com.example.jirir.tryout;

import android.content.Context;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jirir.tryout.Fragments.FragmentGames;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.Inflater;

public class GamesListAdapter extends RecyclerView.Adapter<GamesListAdapter.Viewholder> {

    public List<Game> gamesList;
    private static final String TAG = "GamesListAdapter";
    private Context mContext;
    int mRecource;

    public GamesListAdapter(List<Game> gamesList) {
        this.gamesList = gamesList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_games, viewGroup, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int position) {
        viewholder.txtvdate.setText(gamesList.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return gamesList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        View mView;
        public TextView txtvdate;
        public TextView txtvhname;
        public TextView txtvaname;
        public TextView txtvhscore;
        public TextView txtvascore;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;

            txtvdate = (TextView) mView.findViewById(R.id.txtv_date_games);
            txtvhname = (TextView) mView.findViewById(R.id.txtv_games_hname);
            txtvaname = (TextView) mView.findViewById(R.id.txtv_games_aname);
            txtvhscore = (TextView) mView.findViewById(R.id.txtv_games_hscr);
            txtvascore = (TextView) mView.findViewById(R.id.txtv_games_ascr);
        }
    }

    /*private static final String TAG = "GamesListAdapter";
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
    }*/
}
