package com.example.jirir.tryout.Fragments;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jirir.tryout.Game;
import com.example.jirir.tryout.GamesListAdapter;
import com.example.jirir.tryout.MainActivity;
import com.example.jirir.tryout.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Date;

public class FragmentGames extends Fragment {

    private static final String TAG = "FragmentGames";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //items in list zetten
        View view = inflater.inflate(R.layout.fragment_games, container, false);

        Bundle b = getArguments();
        String result = b.getString("tmname");
        Log.d(TAG, b.getString("tmname"));

        Game two = new Game("05/01/2019", result, "BBC Floorcouture® Zoersel", 64, 45);
        Game three = new Game("06/01/2019", "Antwerp Giants", "BBC Floorcouture® Zoersel", 99, 76);
        Game four = new Game("08/01/2019", "Antwerp Giants", "BBC Floorcouture® Zoersel", 100, 102);
        Game five = new Game("12/01/2019", "Antwerp Giants", "BBC Floorcouture® Zoersel", 101, 88);

        ArrayList<Game> gamesList = new ArrayList<>();
        gamesList.add(two);
        gamesList.add(three);
        gamesList.add(four);
        gamesList.add(five);

        ListView listView = view.findViewById(R.id.listv_games);

        GamesListAdapter adapter = new GamesListAdapter(getContext(), R.layout.adapter_games, gamesList);
        listView.setAdapter(adapter);

        return view;
    }
}
