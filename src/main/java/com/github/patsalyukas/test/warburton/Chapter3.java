package com.github.patsalyukas.test.warburton;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter3 {

    //1.1
    public int addUp(Stream<Integer> numbers) {
        return numbers.mapToInt(e -> e).sum();
    }

    //1.2
    List<String> getNamesAndPlaces(Stream<Artist> artists) {
        return (artists.map(artist -> artist.getName() + "-" + artist.getOrigin()).collect(Collectors.toList()));
    }

    //1.3
    public List<Album> albumWithThreeAndMoreTracks(Stream<Album> albums) {
        return albums.filter(e -> e.getTracks().size() > 2).collect(Collectors.toList());
    }

}
