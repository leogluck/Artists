package com.example.leo.artists.model.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Leo on 09.11.2017
 */

public class AlbumsResponse {

    private Topalbums topalbums;

    public Topalbums getTopalbums() { return this.topalbums; }

    public void setTopalbums(Topalbums topalbums) { this.topalbums = topalbums; }

    public class Artist {
        private String name;

        public String getName() { return this.name; }

        public void setName(String name) { this.name = name; }
    }

    public class Image {
        @SerializedName("#text")
        private String text;

        public String getText() { return this.text; }

        public void setText(String text) { this.text = text; }

        private String size;

        public String getSize() { return this.size; }

        public void setSize(String size) { this.size = size; }
    }

    public class Album {
        private String name;

        public String getName() { return this.name; }

        public void setName(String name) { this.name = name; }

        private int playcount;

        public int getPlaycount() { return this.playcount; }

        public void setPlaycount(int playcount) { this.playcount = playcount; }

        private List<Image> image;

        public List<Image> getImages() { return this.image; }

        public void setImage(List<Image> image) { this.image = image; }
    }

    public class Topalbums {

        private List<Album> album;

        public List<Album> getAlbum() { return this.album; }

        public void setAlbum(List<Album> album) { this.album = album; }
    }

}
