package com.example.rathana.recyclerviewdemostrate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rathana.recyclerviewdemostrate.adapter.RvLinearAdapter;
import com.example.rathana.recyclerviewdemostrate.entity.Video;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInBottomAnimationAdapter;

public class RVLinearLayoutManagerActivity extends AppCompatActivity
        implements RvLinearAdapter.CallBackListener{

    private RecyclerView recyclerView;
    private RvLinearAdapter adapter;
    private List<Video> videos=new ArrayList<>();
    private EditText edSearch;
    private static List<Video> listVideos=new ArrayList();
    private static final int REQUEST_CODE=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvlinear_layout_manager);
        setupRecyclerView();
        edSearch=findViewById(R.id.search);
        edSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String text= edSearch.getText().toString();
                Log.e("Search", "onEditorAction: "+text );
                search(text);
                return false;
            }
        });
    }
    private  void search(String text){
        List<Video> list=new ArrayList<>();
        //if search box is empty get all data and refresh recycler view again
        if(text.equalsIgnoreCase("")){
            Log.e("empty string", "search: " );
            this.videos.addAll(listVideos);
            this.adapter.notifyDataSetChanged();
            return;
        }

        //searching
        for(Video video: videos){
            if(video.getTitle().matches("(?i)("+text+").*")){
                list.add(video);
                Log.e("search result", "search: "+video.getTitle());
            }
        }
        this.videos.clear();
        this.videos.addAll(list);
        this.adapter.notifyDataSetChanged();
    }
    private void setupRecyclerView() {
        recyclerView=findViewById(R.id.rv_linear_layoutmanager);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        //layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new RvLinearAdapter(this,videos);

        //setup animator
        /*SlideInBottomAnimationAdapter animator= new SlideInBottomAnimationAdapter(adapter);
        animator.setDuration(1000);
        recyclerView.setAdapter(animator);*/

        //add Alpha animator
        AlphaInAnimationAdapter alpha=new AlphaInAnimationAdapter(adapter);
        alpha.setDuration(1000);
        recyclerView.setAdapter(alpha);
        setVideos();
    }

    //get data from memory or network

    private void setVideos() {
        String channelName="";
        for(int i =0;i<50;i++){
            if(i%2==0) channelName="Makara";
            else channelName="Bunma";
            videos.add(new Video(R.drawable.thumb,"Khat Jame Rock Old Song, Nop Stop Collection "+i,
                    channelName,"100,000 K"));
        }
        listVideos.addAll(videos);
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_new_item:{
                addNewItem();
                return true;
            }
        }
        return false;
    }
    private void addNewItem() {
        Intent intent=new Intent(this,AddNewSongActivity.class);
        startActivityForResult(intent,REQUEST_CODE);
    }

    //for receive data for the second screen
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE && resultCode==RESULT_OK){
            if(data!=null){
                String title=data.getStringExtra("TITLE");
                String channel=data.getStringExtra("CHANNEL");
                String viewer=data.getStringExtra("VIEWER");
                //add to arrayList
                this.videos.add(0,new Video(R.drawable.kangaroo,title,channel,viewer));
                this.adapter.notifyItemInserted(0);
                this.recyclerView.scrollToPosition(0);
            }
        }
    }
}
