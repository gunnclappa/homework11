package guru.qa.utils;

import java.util.Random;

public class RandomValues {

    private enum Month {
        January, February, March, April, May, June, July, August, September, October, November, December
    }

    private enum Hobby {
        Reading, Music, Sports
    }

    private enum Gender {
        Male, Female, Other
    }

    public String month() {
        return String.valueOf(Month.values()[new Random().nextInt(Month.values().length)]);
    }

    public String hobby() {
        return String.valueOf(Hobby.values()[new Random().nextInt(Hobby.values().length)]);
    }

    public String gender() {
        return String.valueOf(Gender.values()[new Random().nextInt(Gender.values().length)]);
    }
}