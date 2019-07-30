package com.example.tictactoe;


import android.arch.persistence.room.Room;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends option_menu implements for_two_play.PlayerInfo{

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    public static FragmentManager fragmentManager;
    public static int frag_num=1;
    public static MyDatabase myDatabase;
    public NavigationView navigationView;
    static Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        myDatabase= Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "userData").allowMainThreadQueries().build();

        drawerLayout=findViewById(R.id.rootmain);
        navigationView=findViewById(R.id.navigationdrawer);
        fragmentManager=getSupportFragmentManager();
        intent=new Intent(this,show.class);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.history:
                        intent.putExtra("No",0);
                        startActivity(intent);
                        return true;
                    case R.id.scorebord:
                    intent.putExtra("No",1);
                        startActivity(intent);
                        return true;
                        default:
                            return false;

                }
            }
        });

        if(findViewById(R.id.container)!=null)
        {

            fragmentManager.beginTransaction().add(R.id.container,new Home(),null).commit();
        }


    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawers();
        else if(frag_num==1) {
            new AlertDialog.Builder(this).setIcon(R.drawable.ic_exit_to_app_black_24dp).setTitle("Exit the Game").setMessage("Are you Sure?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    }).setNegativeButton("No",null).show();
        }
        else if(frag_num==3)
        {
            frag_num=1;
            fragmentManager.beginTransaction().replace(R.id.container,new Home(),null).commit();
        }
        else
        super.onBackPressed();
    }


    @Override
    public void send(String p1, String p2) {
        Board board=new Board();
        Bundle bundle=new Bundle();
        bundle.putString("p1",p1);
        bundle.putString("p2",p2);
        //Toast.makeText(this,p1+"\n"+p2,Toast.LENGTH_SHORT).show();
        board.setArguments(bundle);

        fragmentManager.beginTransaction().replace(R.id.container,board,null).addToBackStack(null).commit();
    }
}
