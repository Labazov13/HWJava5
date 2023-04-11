package org.example;

import java.util.*;

/*
* Пусть дан список сотрудников:
Иван Иванов
Светлана Петрова
Кристина Белова
Анна Мусина
Анна Крутова
Иван Юрин
Петр Лыков
Павел Чернов
Петр Чернышов
Мария Федорова
Марина Светлова
Мария Савина
Мария Рыкова
Марина Лугова
Анна Владимирова
Иван Мечников
Петр Петин
Иван Ежов
написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.*/
public class Exam2 {

    public static HashMap <String, String> addData(){
        HashMap <String, String> list = new HashMap<>();
        list.put("Иванов", "Иван");
        list.put("Петрова", "Светлана");
        list.put("Белова", "Кристина");
        list.put("Мусина", "Анна");
        list.put("Крутова", "Анна");
        list.put("Юрин", "Иван");
        list.put("Лыков", "Петр");
        list.put("Чернов", "Павел");
        list.put("Чернышов", "Петр");
        list.put("Федорова", "Мария");
        list.put("Светлова", "Марина");
        list.put("Савина", "Мария");
        list.put("Рыкова", "Мария");
        list.put("Лугова", "Марина");
        list.put("Владимирова", "Анна");
        list.put("Мечников", "Иван");
        list.put("Петин", "Петр");
        list.put("Ежов", "Иван");
        return list;
    }

    public static LinkedList <String> uniqueNames(HashMap <String, String> list){
        LinkedList <String> linkedList = new LinkedList<>();
        for (Map.Entry<String, String> stringStringEntry : list.entrySet()) {
            if(!linkedList.contains(stringStringEntry.getValue())){
                linkedList.add(stringStringEntry.getValue());
            }
        }
        return linkedList;
    }

    public static HashMap <String, Integer> findRepetition(HashMap <String, String> list, LinkedList <String> linkedList){
        HashMap<String, Integer> listRepeat = new HashMap<>();
        int count = 0;
        for(String item : linkedList){
            for (Map.Entry<String, String> stringStringEntry : list.entrySet()) {
                if(stringStringEntry.getValue().contains(item)){
                    count++;
                }
            }
            System.out.println("Имя " + item + " встречалось " + count + " раз");
            listRepeat.put(item, count);
            count = 0;
        }
        System.out.println(listRepeat);
        return listRepeat;
    }

    public static void sortMap(HashMap <String, Integer> mapRepeat){
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        mapRepeat.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue())); //Пожалуйста, объясните все, что после sorted идет) я этот кусок кода взял в интернете и понял только до этого момента(
        System.out.println(sortedMap);
    }
    public static void main(String[] args) {
        HashMap <String, String> list = addData();
        LinkedList <String> linkedList = uniqueNames(list);
        System.out.println(linkedList);
        HashMap <String, Integer> mapRepeat = findRepetition(list, linkedList);
        sortMap(mapRepeat);
    }

    }
