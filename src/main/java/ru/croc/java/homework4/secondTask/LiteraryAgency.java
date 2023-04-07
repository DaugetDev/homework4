package ru.croc.java.homework4.secondTask;

import java.util.*;

public class LiteraryAgency {
    private  final List<Pair<String,Double>> allArticle = new ArrayList<>();

    private List<String> dataForRatingCalculator;
    private final Set<String> authors = new HashSet<>();
    boolean empty = true;

    public void sendDataForRating(List<String> dataForRatingCalculator){
        if (Objects.nonNull(dataForRatingCalculator)){
            this.dataForRatingCalculator = dataForRatingCalculator;
            empty = false;
        }
    }

    public List<Pair<String, Double>> getRatingList(){
        if (empty){
            return null;
        }
        List<Pair<String, Double>> report = new ArrayList<>();
        for (var str : dataForRatingCalculator){
            String[] articleData = str.split(";");
            allArticle.add(new Article(articleData[1], articleData[0], articleData[2]).getFrequencyWordUsage());
            authors.add(articleData[1]);
        }
        for (var author : authors) {
            double sum = 0, count = 0;
            for (var article : allArticle){
                if(article.getKey().equals(author)){
                    sum += article.getValue();
                    count++;
                }
            }
            report.add(new Pair<>(author, sum/count));
        }
        report.sort(((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())));
        return report;
    }

}
