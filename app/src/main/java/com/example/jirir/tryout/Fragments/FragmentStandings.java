package com.example.jirir.tryout.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.jirir.tryout.Standing;
import com.example.jirir.tryout.StandingsListAdapter;
import com.example.jirir.tryout.R;

import java.util.ArrayList;

public class FragmentStandings extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //items in list zetten
        View view = inflater.inflate(R.layout.fragment_standings, container, false);

        Standing one = new Standing("BBC Lyra Nila Nijlen", 1, 12,2);
        Standing two = new Standing("Koninklijke Herentalse BBC", 2, 12,2);
        Standing three = new Standing("Basket Willebroek", 3, 10,4);
        Standing four = new Standing("Phantoms Basket Boom", 4, 10,4);
        Standing five = new Standing("Fellows Ekeren BBC", 5, 8,6);
        Standing six = new Standing("BBC Flourcouture Zoersel", 6, 8,6);
        Standing seven = new Standing("Gembo Borgerhout", 7, 7,7);
        Standing eight = new Standing("St. Amandse BBC", 8, 7,7);
        Standing nine = new Standing("Aartselaar BBC", 9, 6,7);
        Standing ten = new Standing("Willebies Antwerpen", 10, 6,7);
        Standing eleven = new Standing("BBC Musketiers Vremde VZW", 11, 4,10);
        Standing twelve = new Standing("Olicsa Antwerpen", 12, 3,11);
        Standing thrdteen = new Standing("K. Vabco Mol BBC", 13, 12,2);
        Standing fourteen = new Standing("BBC Putte", 14, 12,2);


        ArrayList<Standing> standingsList = new ArrayList<>();
        standingsList.add(one);
        standingsList.add(two);
        standingsList.add(three);
        standingsList.add(four);
        standingsList.add(five);
        standingsList.add(six);
        standingsList.add(seven);
        standingsList.add(eight);
        standingsList.add(nine);
        standingsList.add(ten);
        standingsList.add(eleven);
        standingsList.add(twelve);
        standingsList.add(thrdteen);
        standingsList.add(fourteen);

        ListView listView = view.findViewById(R.id.listv_standings);

        StandingsListAdapter adapter = new StandingsListAdapter(getContext(), R.layout.adapter_standings, standingsList);
        listView.setAdapter(adapter);

        return view;
    }
}
