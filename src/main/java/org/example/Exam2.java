package org.example;
import java.util.*;
/*
* Пусть дан список сотрудников:
Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.*/
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

        return listRepeat;
    }
    public static void sortMap2(HashMap <String, Integer> mapRepeat){
        int [] array = new int[mapRepeat.size()];
        LinkedHashMap<String, Integer> resultMap = new LinkedHashMap<>();
        int i = 0;
            for (Map.Entry<String, Integer> stringStringEntry : mapRepeat.entrySet()) {
                array[i] = stringStringEntry.getValue();
                i++;
            }
        int temp = 0;
        for(int j = 0; j < array.length; j++){
            for(int o = 0; o < array.length - 1; o++){
                if(array[o] < array[o + 1]){
                    temp = array[o];
                    array[o] = array[o + 1];
                    array[o + 1] = temp;
                }
            }
        }
        for(int index = 0; index < array.length; index++){
            for (Map.Entry<String, Integer> stringStringEntry : mapRepeat.entrySet()) {
                if(array[index] == stringStringEntry.getValue()){
                    resultMap.put(stringStringEntry.getKey(), stringStringEntry.getValue());
                }
            }
        }
        System.out.println(resultMap);

    }
    public static void main(String[] args) {
        HashMap <String, String> list = addData();
        LinkedList <String> linkedList = uniqueNames(list);
        System.out.println(linkedList);
        HashMap <String, Integer> mapRepeat = findRepetition(list, linkedList);
        sortMap2(mapRepeat);
    }

    }
