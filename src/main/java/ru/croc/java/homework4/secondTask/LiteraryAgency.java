package ru.croc.java.homework4.secondTask;


import java.util.*;

/**
 * класс литературного агенства
 */
public class LiteraryAgency {
    /**
     * все статьи, содержащие уже расчитанный процент
     * использования слов из названия
     */
    private  final List<Pair<String,Double>> allArticle = new ArrayList<>();
    /**
     * список строк по которому будет происходить составления рейтинга авторов
     */
    private List<String> dataForRatingCalculator;
    /**
     * список авторов
     */
    private final Set<String> authors = new HashSet<>();
    /**
     * проверка на пустой список строк
     */
    boolean empty = true;

    /**
     * конструктор который сохраняет список строк
     * @param dataForRatingCalculator список строк по которому
     *                                будет происходить составления рейтинга авторов
     */
    public void sendDataForRating(List<String> dataForRatingCalculator){
        if (Objects.nonNull(dataForRatingCalculator)){
            this.dataForRatingCalculator = dataForRatingCalculator;
            empty = false;
        }
    }

    /**
     * метод который считает среднее арифметическое всех статей каждого автора
     * @return список {@link Pair} где ключ это имя автора
     * а значение это среднее арифметическое процентного отношения слов названия статьи к тексту статьи
     * всех статей каждого автора
     */

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
