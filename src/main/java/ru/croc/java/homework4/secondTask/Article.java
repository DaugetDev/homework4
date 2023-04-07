package ru.croc.java.homework4.secondTask;

import java.util.HashMap;
import java.util.Map;

public class Article {
    private final String authorName;
    private final String[] wordsInTitle;
    private final String[] massWords;
    private final int countWords;
    private final Map<String, Integer> countRepeatWords = new HashMap<>();

    public Article(String authorName, String articleTitle, String articleText) {
        this.authorName = authorName;
        this.wordsInTitle = articleTitle.toLowerCase().split("\\s+");
        this.massWords = articleText.replaceAll("\\p{P}", " ").toLowerCase().split("\\s+");
        this.countWords = massWords.length;
    }

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
