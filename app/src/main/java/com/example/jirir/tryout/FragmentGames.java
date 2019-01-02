package com.example.jirir.tryout;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class FragmentGames extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_games, container, false);

        Game one = new Game("01/02/2019","Antwerp Giants", "BBC Floorcouture® Zoersel");
        Game two = new Game("01/02/2019", "Antwerp Giants", "BBC Floorcouture® Zoersel");

        ArrayList<Game> gamesList = new ArrayList<>();
        gamesList.add(one);
        gamesList.add(two);

        ListView listView = view.findViewById(R.id.listv_games);

        GamesListAdapter adapter = new GamesListAdapter(getContext(), R.layout.adapter_games, gamesList);
        listView.setAdapter(adapter);

        return view;
    }
}
