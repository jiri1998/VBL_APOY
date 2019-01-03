package com.example.jirir.tryout.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.jirir.tryout.Player;
import com.example.jirir.tryout.PlayersListAdapter;
import com.example.jirir.tryout.R;

import java.util.ArrayList;

public class FragmentPlayers extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_players, container, false);

        Player one = new Player("Jiri", "Ruysink","8", "PF", "ZOERSEL", 24.5, 5.7, 10.3);
        Player two = new Player("Kieran", "Ruysink","13", "SF", "ANTWERP", 19.2, 4.1, 3.0);
        Player three = new Player("Louis", "Cueppens","14", "C", "ZOERSEL", 22.4, 2.3, 15.5);
        Player four = new Player("Jeffrey", "Tjoens","1", "SG/SF", "ZOERSEL", 15.6, 6.0, 5.2);

        ArrayList<Player> playerList = new ArrayList<>();
        playerList.add(one);
        playerList.add(two);
        playerList.add(three);
        playerList.add(four);

        ListView listView = view.findViewById(R.id.listv_players);

        PlayersListAdapter adapter = new PlayersListAdapter(getContext(), R.layout.adapter_players, playerList);
        listView.setAdapter(adapter);

        return view;
    }
}
