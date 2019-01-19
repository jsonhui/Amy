package com.chen.ellen.amy.adapter;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chen.ellen.amy.R;
import com.chen.ellen.amy.activity.main.MainActivity;
import com.chen.ellen.amy.bean.Music;
import com.chen.ellen.amy.util.MediaPlayerUtils;

import java.io.IOException;
import java.util.List;

public class LocalMusicAdapter extends RecyclerView.Adapter<LocalMusicAdapter.LocalMusicViewHolder> {


    private Context context;
    private List<Music> musicList;
    private Activity activity;

    public LocalMusicAdapter(Context context,Activity activity, List<Music> musicList){
        this.musicList = musicList;
        this.context = context;
        this.activity = activity;
    }

    @NonNull
    @Override
    public LocalMusicViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_music,viewGroup,false);
        return new LocalMusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LocalMusicViewHolder localMusicViewHolder, final int i) {
        localMusicViewHolder.tvName.setText(musicList.get(i).getName());
        localMusicViewHolder.tvSingerName.setText(musicList.get(i).getSingerName());
        localMusicViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayerUtils.getInstance(activity).playByList(i,musicList);
                MainActivity mainActivity = (MainActivity) activity;
                mainActivity.updatePlay(musicList.get(i));
            }
        });
    }

    @Override
    public int getItemCount() {
        return musicList == null?0:musicList.size();
    }

    class LocalMusicViewHolder extends RecyclerView.ViewHolder{

        TextView tvName,tvSingerName;

        public LocalMusicViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvSingerName =itemView.findViewById(R.id.tv_singer_name);
        }
    }

}
