package com.example.tictactoe;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Board extends Fragment {

    ImageButton[] bns=new ImageButton[9];

    public Board() {
        // Required empty public constructor
    }

    String p1="";
    String p2="";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_board, container, false);

        Bundle bundle=getArguments();
        p1= (String) bundle.get("p1");
        p2= (String) bundle.get("p2");
        Toast.makeText(getActivity(),p1+"\n"+p2,Toast.LENGTH_SHORT).show();

        bns[0]=view.findViewById(R.id.bn0);
        bns[1]=view.findViewById(R.id.bn1);
        bns[2]=view.findViewById(R.id.bn2);
        bns[3]=view.findViewById(R.id.bn3);
        bns[4]=view.findViewById(R.id.bn4);
        bns[5]=view.findViewById(R.id.bn5);
        bns[6]=view.findViewById(R.id.bn6);
        bns[7]=view.findViewById(R.id.bn7);
        bns[8]=view.findViewById(R.id.bn8);

        bns[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(),"everything added",Toast.LENGTH_SHORT).show();

                add_data(p1,p2,p1);
                Intent intent=new Intent(getActivity(),show.class);
                startActivity(intent);
            }
        });

        bns[1].setBackgroundResource(R.drawable.test);
        bns[2].setImageResource(R.drawable.test2);
        bns[3].setImageResource(R.drawable.test);
        bns[8].setImageResource(R.drawable.test);
        //button1.setImageDrawable(getContext().getDrawable(R.drawable.test));
        return view;
    }

    private void add_data(String p1,String p2,String wonBy)
    {


      Score_Table score_table1=new Score_Table();
      score_table1.setName(p1);
      score_table1.setWon(1);
      score_table1.setLost(0);

      Score_Table score_table=new Score_Table();
      score_table.setName(p2);
      score_table.setWon(50);
      score_table.setLost(100);

      History_table history_table=new History_table();
      history_table.setP1(p1);
      history_table.setP2(p2);
      history_table.setWinner("draw");

      MainActivity.myDatabase.myDao().addHistory(history_table);
      MainActivity.myDatabase.myDao().addScore(score_table1);
      MainActivity.myDatabase.myDao().addScore(score_table);
    }

}
