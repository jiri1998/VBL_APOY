package com.example.jirir.tryout;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.tlb_toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navv_navview);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_closed);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.scrlv_fragment_container,
                    new FragmentHome()).commit();
        }

        navigationView.setCheckedItem(R.id.item_home);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.item_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.scrlv_fragment_container,
                        new FragmentHome()).commit();
                break;

            case R.id.item_games:
                getSupportFragmentManager().beginTransaction().replace(R.id.scrlv_fragment_container,
                        new FragmentGames()).commit();
                break;

            case R.id.item_players:
                getSupportFragmentManager().beginTransaction().replace(R.id.scrlv_fragment_container,
                        new FragmentPlayers()).commit();
                break;

            case R.id.item_standings:
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

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
