package ru.yandex.sprint_3;

public class CourierGenerator {

    public static Courier getDefault() {
        return new Courier("hf56e7dаdyfh", "8f6fe7dhhduf", "8f7fd66ed8f");
    }

    public static Courier getWithoutOneValidField() {
        return new Courier("8f67dhehuf", "8f66ed78f");
    }

    public static Courier getWithoutTwoValidFields() {
        return new Courier("h56аtydfh");

    }
}
