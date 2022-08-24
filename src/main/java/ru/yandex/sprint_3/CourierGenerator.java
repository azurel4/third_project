package ru.yandex.sprint_3;

public class CourierGenerator {

    public static Courier getDefault() {
        return new Courier("h56yfh", "8f6huf", "8f6s8f");
    }

    public static Courier getWithoutOneValidField() {
        return new Courier("89s768y", "8f6us");
    }

    public static Courier getWithoutTwoValidFields() {
        return new Courier("89su6f8");

    }
}
