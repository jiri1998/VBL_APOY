package com.example.jirir.tryout;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.jirir.tryout.Fragments.FragmentGames;
import com.example.jirir.tryout.Fragments.FragmentHome;
import com.example.jirir.tryout.Fragments.FragmentPlayers;
import com.example.jirir.tryout.Fragments.FragmentSettings;
import com.example.jirir.tryout.Fragments.FragmentStandings;
import com.example.jirir.tryout.Fragments.FragmentStats;
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
import java.util.List;

import javax.annotation.Nullable;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // zet toolbar als actionbar

        Toolbar toolbar = findViewById(R.id.tlb_toolbar);
        setSupportActionBar(toolbar);

        // instanties

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navv_navview);
        navigationView.setNavigationItemSelectedListener(this);

        // code voor juiste functionering burger icon en menu

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_closed);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // zet home als Main Fragment wanneer app wordt geopend

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.scrlv_fragment_container,
                    new FragmentHome()).commit();
        }

        navigationView.setCheckedItem(R.id.item_home);

    }

    // Menu code

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {

        FragmentManager manager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();

        final FragmentHome fragmentHome = new FragmentHome();
        final FragmentGames fragmentGames = new FragmentGames();
        final FragmentPlayers fragmentPlayers = new FragmentPlayers();
        final FragmentStandings fragmentStandings = new FragmentStandings();

        switch (menuItem.getItemId()) {
            case R.id.item_home:
                Bundle bundlefh = new Bundle();
                //b.putString("tmname", "Hopelijk Werkt dit");
                fragmentHome.setArguments(bundlefh);
                transaction.replace(R.id.scrlv_fragment_container, fragmentHome).commit();
                break;

            case R.id.item_games:
                Bundle bundlefg = new Bundle();
                //bundlefg.putStringArrayList("tmname", gamesList);
                fragmentGames.setArguments(bundlefg);
                transaction.replace(R.id.scrlv_fragment_container,fragmentGames).commit();
                break;

            case R.id.item_players:
                Bundle bundlefp = new Bundle();
                //bundlefg.putString("tmname", "Hopelijk Werkt dit");
                fragmentGames.setArguments(bundlefp);
                getSupportFragmentManager().beginTransaction().replace(R.id.scrlv_fragment_container,
                        new FragmentPlayers()).commit();
                break;

            case R.id.item_standings:
                Bundle bundlefs = new Bundle();
                //bundlefg.putString("tmname", "Hopelijk Werkt dit");
                fragmentGames.setArguments(bundlefs);
                getSupportFragmentManager().beginTransaction().replace(R.id.scrlv_fragment_container,
                        new FragmentStandings()).commit();
                break;

            case R.id.item_stats:
                getSupportFragmentManager().beginTransaction().replace(R.id.scrlv_fragment_container,
                        new FragmentStats()).commit();
                break;

            case R.id.item_settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.scrlv_fragment_container,
                        new FragmentSettings()).commit();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
