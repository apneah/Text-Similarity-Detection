package com.text.similarity.project.analysis;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class PossibleSource implements Comparable<PossibleSource>{
    private String id;
    private List<String> textsFromSource;
    private Map<String, Double> textsFromSourceValues;
    private double sumOfRates;

    public PossibleSource(String id){
        this.id = id;
        this.textsFromSource = new ArrayList<String>();
        this.textsFromSourceValues = new HashMap<String, Double>();
        this.sumOfRates = 0;
    }

    public void add(String id, double rate){
        textsFromSource.add(id);
        textsFromSourceValues.put(id, rate);
        sumOfRates += rate;
    }

    public double getSumOfRates(){
        return sumOfRates;
    }
    public int getNumberOfPlagiates(){
        return textsFromSource.size();
    }

    public String getId() {
        return id;
    }
/*
    //TODO
    public void sortMap(){
        Map<Integer, Double> sortedMap =
                textsFromSourceValues.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));
        textsFromSourceValues.clear();
        textsFromSourceValues = sortedMap;
        //return sortedMap;
    }
*/
    public static void printMap(Map mp) {}

    public String getListToString(){
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = textsFromSourceValues.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            stringBuilder.append(pair.getKey() + " ");
            it.remove(); // avoids a ConcurrentModificationException
        }
        return stringBuilder.toString();
    }

    @Override
    public int compareTo(PossibleSource o) {
        int result = -((Integer)this.getNumberOfPlagiates()).compareTo(o.getNumberOfPlagiates());
        if(result == 0 ){
            result = -((Double)sumOfRates).compareTo(o.getSumOfRates());
        }
        return result;
    }
}
