package com.codegym.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Music {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name_song", columnDefinition = "nvarchar(100)")
    private String nameSong;
    @Column(name = "name_singer", columnDefinition = "nvarchar(100)")

    private String singer;

    @Column(name = "path_song", columnDefinition = "nvarchar(100)")

    private String pathSong;
    @Column(name = "kind_song", columnDefinition = "nvarchar(100)")

    private String kindSong;

    public Music(){}

    public Music(int id, String nameSong, String singer, String pathSong, String kindSong) {
        this.id = id;
        this.nameSong = nameSong;
        this.singer = singer;
        this.pathSong = pathSong;
        this.kindSong = kindSong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getPathSong() {
        return pathSong;
    }

    public void setPathSong(String pathSong) {
        this.pathSong = pathSong;
    }

    public String getKindSong() {
        return kindSong;
    }

    public void setKindSong(String kindSong) {
        this.kindSong = kindSong;
    }
}
