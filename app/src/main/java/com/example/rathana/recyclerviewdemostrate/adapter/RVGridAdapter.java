package com.example.rathana.recyclerviewdemostrate.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rathana.recyclerviewdemostrate.R;
import com.example.rathana.recyclerviewdemostrate.entity.Menu;

import java.util.List;

/**
 * Created by RATHANA on 1/20/2018.
 */

public class RVGridAdapter extends RecyclerView.Adapter<RVGridAdapter.ViewHolder> {

    private Context context;
    private List<Menu> menus;
    private CallBackListener listener;

    public interface CallBackListener{
        void onItemClickListener(int position);
    }

    public RVGridAdapter(Context context,List<Menu> menus){
        this.context=context;this.menus=menus;
        this.listener= (CallBackListener) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(
                R.layout.grid_item_recycler_view_layout,parent,false
        );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Menu menu=this.menus.get(position);
        holder.title.setText(menu.getTitle());
        holder.thumb.setImageResource(menu.getThumb());

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+ holder.title.getText()+" "+ position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.menus.size();
    }

    public void setMenus(List<Menu> menus) {
        this.menus=menus;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView thumb;
        private TextView title;
        public ViewHolder(View itemView) {
            super(itemView);
            thumb=itemView.findViewById(R.id.thumb);
            title=itemView.findViewById(R.id.title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "click on Item->" + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                    listener.onItemClickListener(getAdapterPosition());
                }
            });
        }
    }
}
