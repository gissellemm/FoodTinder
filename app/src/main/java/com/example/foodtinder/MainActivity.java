package com.example.foodtinder;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;


import java.io.*;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView
                = findViewById(R.id.bottomNavigationView);

        bottomNavigationView
                .setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.discover);
    }
    DiscoverPage discoverPage = new DiscoverPage();
    CommonPage commonPage = new CommonPage();
    FriendsPage friendsPage = new FriendsPage();
    LikesPage likesPage = new LikesPage();

    @Override
    public boolean
    onNavigationItemSelected(@NonNull MenuItem item)
    {

        switch (item.getItemId()) {
            case R.id.discover:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, discoverPage)
                        .commit();
                return true;
            case R.id.common:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, commonPage)
                        .commit();
                return true;
            case R.id.friends:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, friendsPage)
                        .commit();
                return true;
            case R.id.likes:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, likesPage)
                        .commit();
                return true;
        }
        return false;
    }

}
