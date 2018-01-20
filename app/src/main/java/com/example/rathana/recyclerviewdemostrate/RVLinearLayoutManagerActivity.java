package com.example.rathana.recyclerviewdemostrate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rathana.recyclerviewdemostrate.adapter.RvLinearAdapter;
import com.example.rathana.recyclerviewdemostrate.entity.Video;

import java.util.ArrayList;
import java.util.List;

public class RVLinearLayoutManagerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RvLinearAdapter adapter;
    private List<Video> videos=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvlinear_layout_manager);
        setupRecyclerView();
    }
    private void setupRecyclerView() {
        recyclerView=findViewById(R.id.rv_linear_layoutmanager);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new RvLinearAdapter(this,videos);
        recyclerView.setAdapter(adapter);
        setVideos();
    }

    //get data from memory or network

    private void setVideos() {
        String channelName="";
        for(int i =0;i<50;i++){
            if(i%2==0) channelName="Makara";
            else channelName="Bunma";
            this.videos.add(new Video(R.drawable.thumb,"Khat Jame Rock Old Song, Nop Stop Collection "+i,
                    channelName,"100,000 K"));
        }
        adapter.setVideos(this.videos);
    }
}
