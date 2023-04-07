package ru.croc.java.homework4.secondTask;

import java.util.HashMap;
import java.util.Map;

/**
 * класс работающий с статьями
 */
public class Article {
    /**
     * имя автора статьи
     */
    private final String authorName;
    /**
     * слова, содержащиеся в названии
     */
    private final String[] wordsInTitle;
    /**
     * масссив слов в тексте
     */
    private final String[] massWords;
    /**
     * количество слов в тексте
     */
    private final int countWords;
    /**
     * {@link Map} для подсчета кол-ва слов
     */
    private final Map<String, Integer> countRepeatWords = new HashMap<>();

    /**
     * Конструктор статьи
     * @param authorName имя автора
     * @param articleTitle название статьи
     * @param articleText текст статьи
     */

    public Article(String authorName, String articleTitle, String articleText) {
        this.authorName = authorName;
        this.wordsInTitle = articleTitle.toLowerCase().split("\\s+");
        this.massWords = articleText.replaceAll("\\p{P}", " ").toLowerCase().split("\\s+");
        this.countWords = massWords.length;
    }

    /**
     * подсчет процента использования слов названия в тексте
     * @return {@link Pair} где ключ - автор статьи а значение процент
     * использования слов названия в тексте
     */
    public Pair<String, Double> getFrequencyWordUsage(){
        Double countRepeatWordsInTitle = 0.0;
        for (var word : massWords) {
            if(!countRepeatWords.containsKey(word)){
                countRepeatWords.put(word, 0);
            }
            countRepeatWords.put(word, countRepeatWords.get(word) + 1);
        }
        for (var word : wordsInTitle){
            countRepeatWordsInTitle += countRepeatWords.getOrDefault(word, 0);
        }
        return new Pair<>(authorName, Double.parseDouble(String.format("%.2f",
                (countRepeatWordsInTitle/countWords) * 100).replace(',','.')));
    }
}
