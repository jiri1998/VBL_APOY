package com.example.jirir.tryout.Fragments;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FragmentGames extends Fragment {

    private static final String TAG = "FragmentGames";
    private FirebaseFirestore db;
    private RecyclerView gamesListView;
    private GamesListAdapter gamesListAdapter;
    private List<Game> gamesList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        gamesList = new ArrayList<>();
        gamesListAdapter = new GamesListAdapter(gamesList);
        View view = inflater.inflate(R.layout.fragment_games, container, false);

        // database
        gamesListView = (RecyclerView) view.findViewById(R.id.listv_games);
        gamesListView.setHasFixedSize(true);
        gamesListView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        gamesListView.setAdapter(gamesListAdapter);

        db = FirebaseFirestore.getInstance();

        db.collection("Games").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@javax.annotation.Nullable QuerySnapshot queryDocumentSnapshots, @javax.annotation.Nullable FirebaseFirestoreException e) {
                if (e != null){
                    Log.d(TAG, "error: " + e.getMessage());
                }

                for (DocumentChange doc: queryDocumentSnapshots.getDocumentChanges()){
                    if (doc.getType() == DocumentChange.Type.ADDED){

                        String date = doc.getDocument().getString("date");
                        Log.d(TAG, date);
                        Game game = doc.getDocument().toObject(Game.class);
                        gamesList.add(game);
                    }
                }
            }
        });

        //items in list zetten
        return view;
    }
}
