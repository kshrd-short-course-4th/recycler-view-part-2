package com.example.rathana.recyclerviewdemostrate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.rathana.recyclerviewdemostrate.adapter.RvLinearAdapter;
import com.example.rathana.recyclerviewdemostrate.entity.Video;

import java.util.ArrayList;
import java.util.List;

public class RVLinearLayoutManagerActivity extends AppCompatActivity
        implements RvLinearAdapter.CallBackListener{

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
        //layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
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

    @Override
    public void onShowPopupMenu(View view, int position) {
        Toast.makeText(this, ""+position, Toast.LENGTH_SHORT).show();
        createPopupMenu(view,position);
    }

    private void  createPopupMenu(View view ,final int p){
        PopupMenu menu=new PopupMenu(this,view);
        menu.inflate(R.menu.popup_menu);
        menu.show();
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId()==R.id.remove){
                    removeVideoItem(p);
                    return true;
                }
                return false;
            }
        });
    }

    private void removeVideoItem(int p) {
        Video video=this.videos.get(p);
        this.videos.remove(video);
        adapter.notifyItemRemoved(p);
    }

}
