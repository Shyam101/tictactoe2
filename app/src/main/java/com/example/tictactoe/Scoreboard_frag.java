package com.example.tictactoe;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Scoreboard_frag extends Fragment {

    private TextView textView;

    public Scoreboard_frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_scoreboard_frag, container, false);
        textView=view.findViewById(R.id.score);

       String info="";

        List<Score_Table> list=MainActivity.myDatabase.myDao().readScore();

        for(Score_Table u:list)
        {
            info+="\n"+u.getName()+" "+u.getWon()+"  "+u.getLost();
        }
        textView.setText(info);

        return view;
    }

}
