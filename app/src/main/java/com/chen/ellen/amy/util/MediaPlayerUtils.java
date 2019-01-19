package com.chen.ellen.amy.util;

import android.app.Activity;
import android.media.MediaPlayer;

import com.chen.ellen.amy.activity.main.MainActivity;
import com.chen.ellen.amy.bean.Music;

import java.io.IOException;
import java.util.List;

public class MediaPlayerUtils {

    private MediaPlayer mediaPlayer;
    private List<Music> playList;
    private int position;
    private Activity activity;
    private static MediaPlayerUtils mediaPlayerUtils;

    private MediaPlayerUtils(){
        mediaPlayer = new MediaPlayer();
    }

    public static MediaPlayerUtils getInstance(Activity activity){
        if(mediaPlayerUtils == null){
            synchronized (MediaPlayerUtils.class){
                if(mediaPlayerUtils == null){
                    mediaPlayerUtils = new MediaPlayerUtils();
                    mediaPlayerUtils.activity = activity;
                }
            }
        }
        return mediaPlayerUtils;
    }

    public void playByList(int position,List<Music> musicList){
        this.position = position;
        setPlayList(musicList);
        play(playList.get(position));
    }

    private void play(Music music){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
        mediaPlayer.reset();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                next();
            }
        });
        try {
            mediaPlayer.setDataSource(music.getPath());
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.start();
    }

    public void next(){
        if(playList == null || playList.size() == 0){
            return;
        }
        this.position++;
        if(this.position == playList.size()){
            this.position = 0;
        }
        playByList(position,playList);
        MainActivity mainActivity = (MainActivity) activity;
        mainActivity.updatePlay(playList.get(position));
    }

    public boolean startAndPause(){
        boolean falg = false;
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            falg = false;
        }else {
            mediaPlayer.start();
            falg = true;
        }
        return falg;
    }

    public boolean isPlaying(){
        return mediaPlayer.isPlaying();
    }

    public void setPlayList(List<Music> musicList){
        playList = musicList;
    }

}
