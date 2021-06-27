package com.github.patsalyukas.test.warburton;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Album {

    private String name;
    private List<Track> tracks;
    private List<Artist> artists;

}
