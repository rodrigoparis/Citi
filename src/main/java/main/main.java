package main;

public class main {
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

}
