package com.example.rathana.recyclerviewdemostrate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.rathana.recyclerviewdemostrate.adapter.RVGridAdapter;
import com.example.rathana.recyclerviewdemostrate.entity.Menu;

import java.util.ArrayList;
import java.util.List;

public class StaggeredGridActivity extends AppCompatActivity implements RVGridAdapter.CallBackListener{
    RecyclerView recyclerView;
    RVGridAdapter adapter;
    List<Menu> menus =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stagered_grid);

        recyclerView=findViewById(R.id.rv_staggered_grid);
        StaggeredGridLayoutManager manager=new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        adapter=new RVGridAdapter(this,this.menus ,Menu.STAGGERED);
        recyclerView.setAdapter(adapter);
        setMenus();
    }

    private void setMenus() {
        for(int i=0;i<=50;i++){
            String title="";
            if(i%2==0) title="Title "+i;
            else title="Government shutdown continues as Congress tangles on immigration, short-term funding";
            this.menus.add(new Menu(R.drawable.thumb,title));
        }
        adapter.setMenus(this.menus);
    }

    @Override
    public void onItemClickListener(int position) {

    }
}
