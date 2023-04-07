package ru.croc.java.homework4.secondTaskTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.croc.java.homework4.secondTask.LiteraryAgency;
import ru.croc.java.homework4.secondTask.Pair;

import java.util.Arrays;

public class SecondTaskTests {
    /**
     * Тест коректных, ненулевых начальных значений
     */
    @Test
    public void testCorrectData(){
        LiteraryAgency testAgency = new LiteraryAgency();
        testAgency.sendDataForRating(Arrays.asList("Мир без насилия;Петрова Елена;Насилие – это всегда плохо. Оно наносит вред как жертвам, так и насильникам. Как избежать насилия и создать мир без конфликтов?",
                "Технологии будущего;Сидоров Дмитрий;Какие технологии изменят мир в ближайшие годы? Будут ли люди жить в виртуальной реальности? Как улучшатся медицинские технологии?",
                "Секреты успеха;Николаева Мария;Какие качества помогают людям добиться успеха в карьере и личной жизни? Что нужно делать, чтобы стать лидером и достичь своих целей?"));
        Assertions.assertEquals(Arrays.asList(new Pair<>("Петрова Елена", 15.0),
                new Pair<>("Сидоров Дмитрий", 11.11),
                new Pair<>("Николаева Мария", 4.76)), testAgency.getRatingList());
    }

    /**
     * тест коректных начальных значений без встречающихся слов
     */
    @Test
    public void testZeroEntry(){
        LiteraryAgency testAgency = new LiteraryAgency();
        testAgency.sendDataForRating(Arrays.asList("История кино;Морозов Иван;Как киноизобразительное искусство развивалось на протяжении всей истории? Какие фильмы стали настоящими шедеврами и почему?",
                "Здоровый образ жизни;Иванов Андрей;Забота о своем здоровье – это залог долголетия. Чтобы поддерживать организм в хорошем состоянии, нужно правильно питаться и заниматься спортом.",
                "Искусство декорирования интерьеров;Козлова Ольга;Как создать уютный и стильный интерьер своей квартиры? Какие элементы декора будут выглядеть привлекательно?"));
        Assertions.assertEquals(Arrays.asList(new Pair<>("Иванов Андрей", 0.0),
                new Pair<>("Морозов Иван", 0.0),
                new Pair<>("Козлова Ольга", 0.0)), testAgency.getRatingList());
    }

    /**
     * тест некоректных значений
     */
    @Test
    public void testIncorrectData(){
        LiteraryAgency testAgency = new LiteraryAgency();
        testAgency.sendDataForRating(null);
        Assertions.assertNull(testAgency.getRatingList());
    }

}
