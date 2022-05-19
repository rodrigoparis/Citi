package main;

import java.util.ArrayList;

public class main {

    static int m,n;
    static String[][] matriz = new String[m][n];
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {

        //First Exercise
        int[] array = {0, 5, 6, 7, 89, 1, 55, 63, 100};
        getMax(array);
        //Second Exercice
        array = new int[]{6, 7, 5, 4, 3, 1, 2, 3, 5, 6, 7, 9, 0, 0, 1, 2, 4, 1, 2, 3, 5, 1, 2};
        analyzeRanges(13, array);
        //Third Exercise
        //Forth Exercise
        if (isPalindrom("neuquen")) {
            System.out.println("Your word is a palindrom");
        } else {
            System.out.println("Your word is not a palindrom");
        }
    }

    public static void getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("The max number in the array is : " + max);
    }

    public static void analyzeRanges(int num, int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) { //go through all posibiilities
            for (int j = i; j < array.length; j++) { //go through each posibility
                sum += array[j];
                if (sum == num) { //till sum is == to the result we seek
                    System.out.println("The values between(" + i + "," + j + ") add up to " + num);
                    break;
                }
                if (sum > num) { //or till we get more than expected
                    break;
                }
            }
            sum = 0;
        }
    }

    public static boolean isPalindrom(String originalWord) {
        StringBuilder reversedWord = new StringBuilder(originalWord);
        reversedWord.reverse();
        return originalWord.equalsIgnoreCase(reversedWord.toString());
    }

    public static boolean laberynth(int x, int y){
        boolean result;
        if (matriz[x][y].equals("x") || x<0 || y<0 ||x>(m-1) || y>(n-1))return false;
        if ( matriz[x][y].equals("*"))return false;
        if (x==(m-1)){ //base condition, arrive to the last row.
            matriz[x][y]="*";
            list.add(x+","+ y);
            return true;
        }
        // if i get here is because the spot is free
        matriz[x][y]="*"; //I set it as a non free spot
        list.add(x+","+ y); //and I add it to the right path
        result = laberynth((x+1), y); ////first recursive call (trying to move down)
        if (result) return true;
        result = laberynth((x), (y+1));////second recursive call (trying to move to theright)
        if (result) return true;
        if (matriz[x][y-1].equals("*")){ //if i'm comming back from where I came im in the wrong path
            list.remove(x+","+y); //drop it from list
            matriz[x][y]=" ";
        }
        result = laberynth(x, (y-1));//third recursive call (trying to move left)
        if (result){
            return true;
        }
        return false;
    }


}
