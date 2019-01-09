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
import android.support.v7.widget.Toolbar;
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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String Key_date = "date";
    private static final String Key_name_home = "name_home";
    private static final String Key_name_away = "name_away";
    private static final String Key_score_home = "score_home";
    private static final String Key_score_away = "score_away";

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DocumentReference dbRef = db.document("Games/Game1");

    private final String[] dates = {"06/01/2019"};
    String[] names_home = {"BBC Floorcouture® Zoersel"};
    String[] names_away = {"BBC Lira Nijlen"};
    Integer[] scores_home = {70};
    Integer[] scores_away = {65};

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

    //

    public void database(View view){

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
                            Toast.makeText(MainActivity.this, "failed to load games from database", Toast.LENGTH_LONG).show();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
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
                //bundlefg.putString("tmname", "Hopelijk Werkt dit");
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
