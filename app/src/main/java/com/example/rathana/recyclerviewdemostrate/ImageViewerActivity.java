package com.example.rathana.recyclerviewdemostrate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.rathana.recyclerviewdemostrate.entity.Menu;

public class ImageViewerActivity extends AppCompatActivity {
    private  Menu menu;
    private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);
        image=findViewById(R.id.image);
        Intent intent=getIntent();
        if(intent!=null){
           menu=new Menu(intent.getIntExtra("IMAGE",0),
                   intent.getStringExtra("TITLE"));
        }
        if(menu!=null){
            image.setImageResource(menu.getThumb());
        }

    }
}
