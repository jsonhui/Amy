package com.chen.ellen.amy.util;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.chen.ellen.amy.bean.Music;

import java.util.ArrayList;
import java.util.List;

public class ContentProviderUtils {

    private static  ContentProviderUtils contentProviderUtils;
    private Context context;
    private ContentResolver contentProvider;

    private ContentProviderUtils(){}

    public static ContentProviderUtils getInstance(Context context){
        if (contentProviderUtils == null){
            synchronized (ContentProviderUtils.class){
                if (contentProviderUtils == null){
                    contentProviderUtils = new ContentProviderUtils();
                    contentProviderUtils.context = context;
                    contentProviderUtils.contentProvider = context.getContentResolver();
                }
            }
        }
        return contentProviderUtils;
    }

    /**
     * 获取本机音乐列表
     * @return
     */
    public List<Music> getMusics() {
        ArrayList<Music> musics = new ArrayList<>();
        Cursor c = null;
        try {
            c = contentProvider.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null,
                    MediaStore.Audio.Media.DEFAULT_SORT_ORDER);

            while (c.moveToNext()) {
                String path = c.getString(c.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));// 路径
                String name = c.getString(c.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME)); // 歌曲名
                String album = c.getString(c.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM)); // 专辑
                String artist = c.getString(c.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST)); // 作者
                long size = c.getLong(c.getColumnIndexOrThrow(MediaStore.Audio.Media.SIZE));// 大小
                int duration = c.getInt(c.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION));// 时长
                int time = c.getInt(c.getColumnIndexOrThrow(MediaStore.Audio.Media._ID));// 歌曲的id
                int albumId = c.getInt(c.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM_ID));
                if(duration != 0) {
                    Music music = new Music(name, artist,path);
                    musics.add(music);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (c != null) {
                c.close();
            }
        }
        return musics;
    }
}
