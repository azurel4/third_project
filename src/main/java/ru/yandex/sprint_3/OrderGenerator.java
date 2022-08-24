package ru.yandex.sprint_3;

public class OrderGenerator {
    public static Order getDefault() {
        return new Order("gl15eg", "hgevin", "+7 800 355 35 35", "60",
                "2022-10-10", "fgggg", new String[]{"BLACK", "GREY"}, "gghjj", "fjfjf");
    }

    public static Order getOnlyBlack() {
        return new Order("gleg", "hgevin", "+7 800 355 35 35", "60",
                "2022-10-10", "fgggg", new String[]{"BLACK"}, "gghjj", "fjfjf");
    }

    public static Order getOnlyGrey() {
        return new Order("gleg", "hgevin", "+7 800 355 35 35", "60",
                "2022-10-10", "fgggg", new String[]{"GREY"}, "gghjj", "fjfjf");
    }

    public static Order getWithoutColor() {
        return new Order("gleg", "hgevin", "+7 800 355 35 35", "60",
                "2022-10-10", "fgggg", new String[]{""}, "gghjj", "fjfjf");
    }
}
