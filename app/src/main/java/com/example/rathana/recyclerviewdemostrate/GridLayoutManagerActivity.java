package com.example.rathana.recyclerviewdemostrate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rathana.recyclerviewdemostrate.adapter.RVGridAdapter;
import com.example.rathana.recyclerviewdemostrate.entity.Menu;

import java.util.ArrayList;
import java.util.List;

public class GridLayoutManagerActivity extends AppCompatActivity
implements RVGridAdapter.CallBackListener{
    private RecyclerView recyclerView;
    private RVGridAdapter adapter;
    private List<Menu> menus=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout_manager);

        recyclerView=findViewById(R.id.rv_grid);
        GridLayoutManager layoutManager=new GridLayoutManager(
                this,3,GridLayoutManager.VERTICAL,
                false
        );
        recyclerView.setLayoutManager(layoutManager);
        adapter=new RVGridAdapter(this,this.menus);
        recyclerView.setAdapter(adapter);

        setMenuItems();
    }

    private void setMenuItems() {
        for(int i=0;i<20;i++){
            this.menus.add(new Menu(R.drawable.thumb,"menu "+ i));
        }
        adapter.setMenus(this.menus);
    }

    @Override
    public void onItemClickListener(int position) {
        Intent i=new Intent(this,ImageViewerActivity.class);
        Menu menu=this.menus.get(position);
        i.putExtra("IMAGE",menu.getThumb());
        i.putExtra("TITLE",menu.getTitle());
        startActivity(i);
    }
}
