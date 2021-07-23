package com.github.patsalyukas.test.warburton;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter5 {

    List<String> getNamesAndPlacesInUpperCase(Stream<Artist> artists) {
        return (artists.map(artist -> artist.getName() + "-" + artist.getOrigin()).map(String::toUpperCase).collect(Collectors.toList()));
    }

    public int totalOfArtists(List<Artist> artists) {
        Optional<Integer> count = artists.stream().map(artist -> artist.getMember().size()).reduce((a, b) -> a + b);
        return count.orElse(0);
    }

}
