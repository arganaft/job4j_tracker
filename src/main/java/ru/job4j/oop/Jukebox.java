package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже пешеходы по лужам" + System.lineSeparator()
                    + "А вода по асфальту рекой" + System.lineSeparator()
                    + "И неясно прохожим в этот день непогожий" + System.lineSeparator()
                    + "Почему я веселый такой");
        } else if (position == 2) {
            System.out.println("Спят усталые игрушки, книжки спят." + System.lineSeparator()
                    + "Одеяла и подушки ждут ребят." + System.lineSeparator()
                    + "Даже сказка спать ложится," + System.lineSeparator()
                    + "Чтобы ночью нам присниться." + System.lineSeparator()
                    + "Ты ей пожелай:" + System.lineSeparator()
                    + "Баю-бай.");
        } else {
            System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox odyssey = new Jukebox();
        odyssey.music(1);
        odyssey.music(2);
        odyssey.music(3254);
    }
}
