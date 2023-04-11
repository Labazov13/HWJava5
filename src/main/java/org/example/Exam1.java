package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
public class Exam1 {

    public static void menu(HashMap <String, String> phoneBook) {
        int operation = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Выберите действие: \n");
        System.out.println("1 - добавить новый контакт");
        System.out.println("2 - добавить номер в существующий контакт");
        System.out.println("3 - показать контакты на экране");
        System.out.println("4 - выход");

        while (true) {
            if (sc.hasNextInt()) {
                operation = sc.nextInt();
            }
            if (operation == 1) {
                addNumber(phoneBook);
            }
            if (operation == 2) {
                if (phoneBook.isEmpty()) {
                    System.out.println("Ни одного контакта нет! Добавьте его, нажав 1");
                } else {
                    String findParametr = null;
                    System.out.println("Введите искомый контакт в формате (Имя, Фамилия): ");
                    findParametr = sc.next();
                    choiceName(phoneBook, findParametr);
                }
            }
            if (operation == 3) {
                if (phoneBook.isEmpty()) {
                    System.out.println("Ни одного контакта нет! Добавьте его, нажав 1");
                } else {
                    printPhoneBook(phoneBook);
                }
            }
            if (operation == 4) {
                System.out.println("До встречи!:)");
                break;
            }
        }
    }

    // Добавление нового контакта ***************************************************************
    public static String enterName(){
        Scanner sc = new Scanner(System.in);
        String name = null;
        System.out.print("Введите имя, фамилию: ");
        if(sc.hasNextLine()){
            name = sc.nextLine();
        }
        return name;
    }
    public static String enterNumber(){
        Scanner sc = new Scanner(System.in);
        String number = null;
        System.out.print("Введите номер контакта: ");
        if(sc.hasNextLine()){
            number = sc.nextLine();
        }
        return number;
    }

    public static HashMap <String, String> addNumber(HashMap <String, String> phoneBook){
        phoneBook.put(enterNumber(), enterName());
        System.out.println("Готово!");
        control();
        return phoneBook;
    }

    // *****************************************************************************************************

    // Добавление еще одного номера в существующий контакт *************************************************

    public static void choiceName(HashMap <String, String> phoneBook, String name){
        String findName = null;
            for (Map.Entry<String, String> stringStringEntry : phoneBook.entrySet()) {
                if(stringStringEntry.getValue().equals(name)){
                    findName = stringStringEntry.getValue();
                }
            }
        newNumber(phoneBook, findName);

    }

    public static HashMap <String, String> newNumber(HashMap <String, String> phoneBook, String findName){
        phoneBook.put(enterNumber(), findName);
        System.out.println("Готово!");
        control();
        return phoneBook;

    }
    // *****************************************************************************************************

    // Показать все контакты *******************************************************************************

    public static void printPhoneBook(HashMap <String, String> phoneBook){
            int count = 1;
            for (Map.Entry<String, String> stringStringEntry : phoneBook.entrySet()) {
                System.out.println(count + " контакт: номер - " + stringStringEntry.getKey() + " Имя, фамилия - " + stringStringEntry.getValue());
                count++;
            }
            control();
        }

    // *****************************************************************************************************

    public static void control(){
        System.out.print("Выберите действие: \n");
        System.out.println("1 - добавить новый контакт");
        System.out.println("2 - добавить номер в существующий контакт");
        System.out.println("3 - показать контакты на экране");
        System.out.println("4 - выход");
    }

    public static void main(String[] args) {
        HashMap <String, String> phoneBook = new HashMap<>();
        menu(phoneBook);


    }

}
