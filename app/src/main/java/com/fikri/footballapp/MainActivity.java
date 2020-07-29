package com.fikri.footballapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.fikri.footballapp.adapter.CardViewFootballAdapter;
import com.fikri.footballapp.adapter.GridFootballAdapter;
import com.fikri.footballapp.adapter.ListFootballAdapter;
import com.fikri.footballapp.model.Football;
import com.fikri.footballapp.model.FootballData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvFootballs;
    private ArrayList<Football> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean isDarkModeOn = Preferences.getMode(getBaseContext());
        if (isDarkModeOn) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        rvFootballs = findViewById(R.id.rv_footballs);
        rvFootballs.setHasFixedSize(true);
        rvFootballs.addItemDecoration(new DividerItemDecoration(rvFootballs.getContext(),DividerItemDecoration.VERTICAL));

        list.addAll(FootballData.getListData());
        if(Preferences.getView(getBaseContext()).equals("Grid")){
            setSubTitle("Grid");
            showRecyclerGrid();
        }else if(Preferences.getView(getBaseContext()).equals("CardView")){
            setSubTitle("CardView");
            showRecyclerCardView();
        }else{
            setSubTitle("List");
            showRecyclerList();
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem item = menu.findItem(R.id.app_bar_switch);
        Switch switchToggle = item.getActionView().findViewById(R.id.switch_toggle);
        boolean isDarkModeOn = Preferences.getMode(getBaseContext());
        if (isDarkModeOn) {
            switchToggle.setChecked(true);
        } else {
            switchToggle.setChecked(false);
        }

        switchToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    Preferences.setMode(getBaseContext(),true);
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    Preferences.setMode(getBaseContext(),false);
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setSubTitle(String subtitle){
        if(getSupportActionBar() != null){
            String sub = "Mode "+subtitle;
            getSupportActionBar().setSubtitle(sub);
        }
    }

    public void setMode(int selectMode){
        switch (selectMode){
            case R.id.action_user:
                Intent about = new Intent(MainActivity.this,AboutActivity.class);
                startActivity(about);
                break;
            case R.id.action_list:
                setSubTitle("List");
                showRecyclerList();
                Preferences.setView(getBaseContext(),"List");
                break;
            case R.id.action_grid:
                setSubTitle("Grid");
                showRecyclerGrid();
                Preferences.setView(getBaseContext(),"Grid");
                break;
            case R.id.action_cardview:
                setSubTitle("CardView");
                showRecyclerCardView();
                Preferences.setView(getBaseContext(),"CardView");
                break;
        }
    }

    private void showRecyclerList(){
        rvFootballs.setLayoutManager(new LinearLayoutManager(this));
        ListFootballAdapter listFootballAdapter = new ListFootballAdapter(list);
        rvFootballs.setAdapter(listFootballAdapter);

        listFootballAdapter.setOnItemClickCallback(new ListFootballAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Football data) {
                showSelectedFootbal(data);
            }
        });
    }

    private void showRecyclerGrid(){
        rvFootballs.setLayoutManager(new GridLayoutManager(this,2));
        GridFootballAdapter gridFootballAdapter = new GridFootballAdapter(list);
        rvFootballs.setAdapter(gridFootballAdapter);

        gridFootballAdapter.setOnItemClickCallback(new GridFootballAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Football data) {
                showSelectedFootbal(data);
            }
        });
    }

    private void showRecyclerCardView(){
        rvFootballs.setLayoutManager(new LinearLayoutManager(this));
        CardViewFootballAdapter cardViewFootballAdapter = new CardViewFootballAdapter(list);
        rvFootballs.setAdapter(cardViewFootballAdapter);

        cardViewFootballAdapter.setOnItemClickCallback(new CardViewFootballAdapter.OnItemClickCallback(){
            @Override
            public void onItemClicked(Football data) {
                showSelectedFootbal(data);
            }
        });

        cardViewFootballAdapter.setOnBtnClickCallback(new CardViewFootballAdapter.OnBtnClickCallback(){
            @Override
            public void onBtnClicked(Football data) {
                String name = data.getName();
                String about = data.getAbout();
                String coach = data.getCoach();
                Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Nama Klub: "+name+"\nTentang Klub: "+about+"\nPelatih Klub: "+coach);
                startActivity(Intent.createChooser(shareIntent, "Share via"));
            }
        });
    }

    private void showSelectedFootbal(Football football){
        Intent detail = new Intent(MainActivity.this,DetailActivity.class);
        detail.putExtra(DetailActivity.TITLE,football.getName());
        detail.putExtra(DetailActivity.NAME,football.getName());
        detail.putExtra(DetailActivity.ABOUT,football.getAbout());
        detail.putExtra(DetailActivity.COACH,football.getCoach());
        detail.putExtra(DetailActivity.IMAGE,football.getPhoto());
        startActivity(detail);
    }
}
