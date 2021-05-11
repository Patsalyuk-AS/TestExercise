package com.github.patsalyukas.test.sort;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Golfer implements Comparable<Golfer> {

    private String first;
    private String last;
    private int score;

    @Override
    public int compareTo(Golfer golfer) {
        return score - golfer.score;
    }
}
