package com.example.tictactoe;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {
    Button bn1,bn2,bn3;

    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        bn1=view.findViewById(R.id.bn11);
        bn2=view.findViewById(R.id.bn22);
        bn3=view.findViewById(R.id.bn33);


        bn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.frag_num=2;
                new for_two_play().show(getFragmentManager(),"double");
                //MainActivity.fragmentManager.beginTransaction().replace(R.id.container,new Board(),null).addToBackStack(null).commit();

            }
        });
        bn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.frag_num=2;
                new for_single_play().show(getFragmentManager(),"double");
                //MainActivity.fragmentManager.beginTransaction().replace(R.id.container,new Board(),null).addToBackStack(null).commit();
            }
        });

        bn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),skins_activity.class));
            }
        });

        return view;
    }



}
