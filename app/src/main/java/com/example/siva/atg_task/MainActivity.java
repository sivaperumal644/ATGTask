package com.example.siva.atg_task;

import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawer;
    TextView textView;
    ImageView imageView;
    MaterialSearchView searchView;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_main);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        scrollView = findViewById(R.id.scroll_view);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        LinearLayout image = findViewById(R.id.images);
        LayoutInflater inflater = LayoutInflater.from(this);

        ImageView nav = findViewById(R.id.nav);
        nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(Gravity.LEFT);
            }
        });

        for(int i = 0; i<5; i++){
            View view = inflater.inflate(R.layout.item, image,false);
            imageView = view.findViewById(R.id.imageView);
            textView = view.findViewById(R.id.text);

            if(i==0){

                imageView.setImageResource(R.drawable.first_avenger);
                textView.setText("Captain America The First Avenger");
            }
            else if(i == 1){
                imageView.setImageResource(R.drawable.wintersoldier);
                textView.setText("Captain America The Winter Soldier");

            }
            else if( i == 2){
                imageView.setImageResource(R.drawable.civil_war);
                textView.setText("Captain America Civil War");

            }
            else if(i == 3){
                imageView.setImageResource(R.drawable.infinitywar);
                textView.setText("Avengers Infinity War");
            }
            else if(i == 4){
                imageView.setImageResource(R.drawable.ic_add_black_24dp);
                textView.setText("    More Movies");
            }

            image.addView(view);
        }

        OverScrollDisabler.disableOverScroll(scrollView);



    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search,menu);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);
        return true;
    }
}
