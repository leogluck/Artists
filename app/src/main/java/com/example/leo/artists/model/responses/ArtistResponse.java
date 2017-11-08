package com.example.leo.artists.model.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Leo on 08.11.2017
 */

public class ArtistResponse {

    @SerializedName("topartists")
    private Topartists topArtists;

    public Topartists getTopArtists() { return this.topArtists; }

    public void setTopArtists(Topartists topArtists) { this.topArtists = topArtists; }

    public class Image
    {
        @SerializedName("#text")
        private String text;

        public String getText() { return this.text; }

        public void setText(String text) { this.text = text; }

        private String size;

        public String getSize() { return this.size; }

        public void setSize(String size) { this.size = size; }
    }

    public class Artist
    {
        private String name;

        public String getName() { return this.name; }

        public void setName(String name) { this.name = name; }

        private String listeners;

        public String getListeners() { return this.listeners; }

        public void setListeners(String listeners) { this.listeners = listeners; }

        private String mbid;

        public String getMbid() { return this.mbid; }

        public void setMbid(String mbid) { this.mbid = mbid; }

        private String url;

        public String getUrl() { return this.url; }

        public void setUrl(String url) { this.url = url; }

        private String streamable;

        public String getStreamable() { return this.streamable; }

        public void setStreamable(String streamable) { this.streamable = streamable; }

        private List<Image> image;

        public List<Image> getImages() { return this.image; }

        public void setImage(List<Image> image) { this.image = image; }
    }

    public class Attr
    {
        private String country;

        public String getCountry() { return this.country; }

        public void setCountry(String country) { this.country = country; }

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

    public class Topartists
    {
        private List<Artist> artist;

        public List<Artist> getArtist() { return this.artist; }

        public void setArtist(List<Artist> artist) { this.artist = artist; }

        @SerializedName("@attr")
        private Attr attr;

        public Attr getAttr() { return this.attr; }

        public void setAttr(Attr attr) { this.attr = attr; }
    }
}
