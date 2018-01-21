package com.example.rathana.recyclerviewdemostrate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.rathana.recyclerviewdemostrate.adapter.RVGridAdapter;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onShowRVAsListView(View view) {
        startActivity(new Intent(this,RVLinearLayoutManagerActivity.class));
    }

    public void onShowRVAsGridView(View view) {
        startActivity(new Intent(this,GridLayoutManagerActivity.class));
    }

    public void onShowRVAsStaggerGrid(View view) {
        startActivity(new Intent(this,StaggeredGridActivity.class));
    }

}
