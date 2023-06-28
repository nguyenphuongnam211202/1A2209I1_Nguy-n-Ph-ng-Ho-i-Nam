package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table
public class Song {
    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Name khong duoc de trong")
    @Size(min = 1, max = 800, message = "Name khong duoc vuot qua 800 ki tu" )
    @Pattern(regexp = "^[^@;,.=+\\-]*$",message = "Name khong chua cac ki tu dac biet nhu @ ; , . = - + , ….")
    @Column(columnDefinition = "nvarchar(45)")
    private String name;


    @NotBlank(message = "Singer khong duoc de trong")
    @Size(min = 1, max =300, message = "Singer khong duoc vuot qua 800 ki tu" )
    @Pattern(regexp = "^[^@;,.=+\\-]*$",message = "Singer khong chua cac ki tu dac biet nhu @ ; , . = - + , ….")
    @Column(columnDefinition = "nvarchar(45)")
    private String singer;

    @NotBlank(message = "Type khong duoc de trong")
    @Size(min = 1, max = 1000, message = "Type khong duoc vuot qua 800 ki tu" )
    @Pattern(regexp = "^[^,]*$",message = "Type khong chua cac ki tu dac biet nhu @ ; , . = - + , ….")
    @Column(columnDefinition = "nvarchar(45)")
    private String type;


    public Song(){
    }
    public Song(int id, String name, String singer, String type) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
