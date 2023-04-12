package org.example;

public class Exam4 {

    public static String [][] fillArray(){
        String [][] array = new String[8][8];
        for(int i = 0 ;i < array.length; i++){
            for(int j = 0 ;j < array.length; j++){
                array[i][j] = "0";
            }
        }
        return array;
    }

    public static void setFigure(String [][] array){
        /*for(int i = 0 ;i < array.length; i++){
            for(int j = 0 ;j < array.length; j++){}*/
        array[1][0] = "X";
        array[3][1] = "X";
        array[5][2] = "X";
        array[7][3] = "X";
        array[2][4] = "X";
        array[0][5] = "X";
        array[6][6] = "X";
        array[4][7] = "X";
        for(int i = 0 ;i < array.length; i++){
            for(int j = 0 ;j < array.length; j++){
                System.out.print(array[j][i] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        String [][] array = fillArray();
        setFigure(array);
    }
}
