package com.example.jirir.tryout.Fragments;

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
import android.widget.Toast;

import com.example.jirir.tryout.Game;
import com.example.jirir.tryout.GamesListAdapter;
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

    private static final String Key_date = "date";
    private static final String Key_name_home = "name_home";
    private static final String Key_name_away = "name_away";
    private static final String Key_score_home = "score_home";
    private static final String Key_score_away = "score_away";

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DocumentReference dbRef = db.document("Games/Game1");

    String[] dates;
    String[] names_home;
    String[] names_away;
    Integer[] scores_home;
    Integer[] scores_away;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //items uit database halen
        dbRef.get().
                addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()){
                            dates[0] = documentSnapshot.getString(Key_date);
                            names_home[0] = documentSnapshot.getString(Key_name_home);
                            names_away[0] = documentSnapshot.getString(Key_name_away);
                            scores_home[0] = documentSnapshot.getDouble(Key_score_home).intValue();
                            scores_away[0] = documentSnapshot.getDouble(Key_score_away).intValue();
                        }
                        else{
                            Toast.makeText(FragmentGames.this.getContext(), "failed to load games from database", Toast.LENGTH_LONG).show();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });

        //items in list zetten
        View view = inflater.inflate(R.layout.fragment_games, container, false);

        Game one = new Game(dates[0],names_home[0], names_away[0],scores_home[0], scores_away[0]);
        Game two = new Game("05/01/2019", "Antwerp Giants", "BBC Floorcouture® Zoersel", 64, 45);
        Game three = new Game("06/01/2019", "Antwerp Giants", "BBC Floorcouture® Zoersel", 99, 76);
        Game four = new Game("08/01/2019", "Antwerp Giants", "BBC Floorcouture® Zoersel", 100, 102);
        Game five = new Game("12/01/2019", "Antwerp Giants", "BBC Floorcouture® Zoersel", 101, 88);

        ArrayList<Game> gamesList = new ArrayList<>();
        gamesList.add(one);
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
