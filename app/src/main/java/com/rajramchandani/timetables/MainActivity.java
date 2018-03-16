package com.rajramchandani.timetables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    public void table(int val)
    {
        ListView listview=(ListView)findViewById(R.id.listview);
        ArrayList<String> al=new ArrayList<String>();
        for(int i=1;i<=10;i++)
        {
            al.add(val+"*"+i+"="+Integer.toString(i*val));
        }
        ArrayAdapter<String> ad= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,al);
        listview.setAdapter(ad);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar=(SeekBar)findViewById(R.id.seekBar);
        seekBar.setMax(20);
        seekBar.setProgress(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min=1;
                int val;
                if(progress<1)
                {
                    seekBar.setProgress(min);
                    val=min;
                }
                else
                {
                    seekBar.setProgress(progress);
                    val=progress;
                }

                table(val);
            }



            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
         table(10);

    }
}
