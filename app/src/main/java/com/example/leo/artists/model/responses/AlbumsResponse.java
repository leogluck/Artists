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

        private String mbid;

        public String getMbid() { return this.mbid; }

        public void setMbid(String mbid) { this.mbid = mbid; }

        private String url;

        public String getUrl() { return this.url; }

        public void setUrl(String url) { this.url = url; }
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

        private String mbid;

        public String getMbid() { return this.mbid; }

        public void setMbid(String mbid) { this.mbid = mbid; }

        private String url;

        public String getUrl() { return this.url; }

        public void setUrl(String url) { this.url = url; }

        private Artist artist;

        public Artist getArtist() { return this.artist; }

        public void setArtist(Artist artist) { this.artist = artist; }

        private List<Image> image;

        public List<Image> getImages() { return this.image; }

        public void setImage(List<Image> image) { this.image = image; }
    }

    public class Attr {
        private String artist;

        public String getArtist() { return this.artist; }

        public void setArtist(String artist) { this.artist = artist; }

        private String page;

        public String getPage() { return this.page; }

        public void setPage(String page) { this.page = page; }

        private String perPage;

        public String getPerPage() { return this.perPage; }

        public void setPerPage(String perPage) { this.perPage = perPage; }

        private String totalPages;

        public String getTotalPages() { return this.totalPages; }

        public void setTotalPages(String totalPages) { this.totalPages = totalPages; }

        private String total;

        public String getTotal() { return this.total; }

        public void setTotal(String total) { this.total = total; }
    }

    public class Topalbums {
        private List<Album> album;

        public List<Album> getAlbum() { return this.album; }

        public void setAlbum(List<Album> album) { this.album = album; }

        @SerializedName("@attr")
        private Attr attr;

        public Attr getAttr() { return this.attr; }

        public void setAttr(Attr attr) { this.attr = attr; }
    }

}
