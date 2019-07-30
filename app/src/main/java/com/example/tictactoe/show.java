package com.example.tictactoe;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class show extends AppCompatActivity {

    private ViewPager viewPager;
    pager_addapter pager_addapter;
    private TabLayout tabLayout;
    private Toolbar toolbar;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        Intent intent=getIntent();
        position = (int) intent.getIntExtra("No",0);
        //MainActivity.fragmentManager.beginTransaction().replace(R.id.container,new Home(),null).commit();

        toolbar=findViewById(R.id.include);
        setSupportActionBar(toolbar);


        viewPager=findViewById(R.id.pager);
        tabLayout=findViewById(R.id.tabs);
        pager_addapter=new pager_addapter(getSupportFragmentManager());
        viewPager.setAdapter(pager_addapter);

        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(position);
    }
}
