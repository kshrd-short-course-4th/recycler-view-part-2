package com.example.rathana.recyclerviewdemostrate.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rathana.recyclerviewdemostrate.R;
import com.example.rathana.recyclerviewdemostrate.entity.Video;

import java.util.List;

/**
 * Created by RATHANA on 1/20/2018.
 */

public class RvLinearAdapter extends RecyclerView.Adapter<RvLinearAdapter.ViewHolder>{
    private Context context;
    private List<Video> videos;
    private CallBackListener listener;
    public RvLinearAdapter(Context context,List<Video> videos){
        this.context=context;this.videos=videos;
        this.listener= (CallBackListener) context;
    }
    public void setVideos(List<Video> videos){
        this.videos=videos;
        notifyDataSetChanged();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(
               R.layout.rv_item_linear_layout, parent,false
       );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if(this.videos!=null || !this.videos.isEmpty()){
            Video video=this.videos.get(position);
            if(!TextUtils.isEmpty(video.getTitle()))
                holder.title.setText(video.getTitle());
            if(!TextUtils.isEmpty(video.getChannelName()))
                holder.channelName.setText(video.getChannelName());
            if(!TextUtils.isEmpty(video.getViewer()))
                holder.viewer.setText(video.getViewer());
            if(video.getThumb()!=0)
                holder.thumb.setImageResource(video.getThumb());
        }

       /* holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onShowPopupMenu(v,position);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return this.videos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView thumb;
        private TextView title;
        private TextView viewer;
        private TextView channelName;
        private ImageView btnRemove;
        public ViewHolder(View itemView) {
            super(itemView);
            thumb=itemView.findViewById(R.id.thumb);
            title=itemView.findViewById(R.id.title);
            viewer=itemView.findViewById(R.id.viewer);
            channelName=itemView.findViewById(R.id.channelName);
            btnRemove=itemView.findViewById(R.id.btnRemove);

            btnRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onShowPopupMenu(v,getAdapterPosition());
                }
            });
        }
    }

    public interface  CallBackListener {
        void onShowPopupMenu(View view,int position);
    }
}
