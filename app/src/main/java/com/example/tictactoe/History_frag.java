package com.example.tictactoe;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
public class History_frag extends Fragment {


    public History_frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_history_frag, container, false);
        TextView textView=view.findViewById(R.id.display);

        List<History_table> history=MainActivity.myDatabase.myDao().readHistory();

        String show="";
        for (History_table d:history)
        {
            show=show+"\n"+d.getP1()+"   "+d.getP2()+"   "+d.getWinner();
        }

        textView.setText(show);

        return view;
    }

}
