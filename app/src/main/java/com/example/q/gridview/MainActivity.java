package com.example.q.gridview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    Button galleryBtn;
    Button cameraBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_layout);
        galleryBtn = (Button) findViewById(R.id.gallerybtn);
        cameraBtn = (Button)findViewById(R.id.camerabtn);
        gridView = (GridView) findViewById(R.id.grid_view);
        gridView.setAdapter(new ImageAdapter(this));
        /**
         * *On Click event for single gridview item
         */
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //sending image id to FullScreenActiviey
                Intent i = new Intent(getApplicationContext(),FullImageActivity.class);
                //passing array index
                i.putExtra("id",position);
                startActivity(i);
            }
        });
        galleryBtn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){

            }
        });
    }
}
