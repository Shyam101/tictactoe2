package com.example.tictactoe;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.Toast;

public class for_two_play extends DialogFragment {

    PlayerInfo info;
    public interface PlayerInfo
    {
        public void send(String p1,String p2);
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        EditText f1,f2;

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        final LayoutInflater inflater=getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dialog_second,null));



        builder.setPositiveButton("Let's Rock", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Dialog f = (Dialog) dialog;

                EditText inputTemp = (EditText) f.findViewById(R.id.first);
                String d= inputTemp.getText().toString();

                EditText dk=(EditText)f.findViewById(R.id.second);
                String j=dk.getText().toString();

                //Toast.makeText(getActivity(),d+"\n"+j,Toast.LENGTH_SHORT).show();


                info.send(d,j);

                //MainActivity.fragmentManager.beginTransaction().replace(R.id.container,new Board(),null).addToBackStack(null).commit();

            }
        });



        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity=(Activity)context;

        try {
            info=(PlayerInfo) activity;
        }catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString());
        }
    }
}
