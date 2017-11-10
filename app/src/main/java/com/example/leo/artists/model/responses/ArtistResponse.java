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

    public class Artist {
        private String name;

        public String getName() { return this.name; }

        public void setName(String name) { this.name = name; }

        private String listeners;

        public String getListeners() { return this.listeners; }

        public void setListeners(String listeners) { this.listeners = listeners; }

        private List<Image> image;

        public List<Image> getImages() { return this.image; }

        public void setImage(List<Image> image) { this.image = image; }
    }

    public class Topartists
    {
        private List<Artist> artist;

        public List<Artist> getArtist() { return this.artist; }

        public void setArtist(List<Artist> artist) { this.artist = artist; }
    }
}
