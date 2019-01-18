package exercises;

import java.util.Date;

public class StringManipulator {

    // Sprawdza, czy słowo jest palindromem, tzn. czy czytane od końca i początku jest identyczne
    // Przykład: "oko", "kajak"
    public static boolean isPalindrome(String word) {
        if(word == null) {
            throw new IllegalArgumentException("Word argument has to be provided");
        }

        String reversedWord="";

        for(int i=0;i<word.length();i++)
        {
            reversedWord = word.charAt(i) + reversedWord; // TODO: Use StringBuilder
        }

        return reversedWord.equalsIgnoreCase(word);
    }

    public static Integer findIndex(String word, String substring){ // TODO: Use Optional
        if(word == null) {
            throw new IllegalArgumentException("Word argument has to be provided");
        }

        if(substring == null) {
            throw new IllegalArgumentException("Substring argument has to be provided");
        }

        int index = word.indexOf(substring);
        return index >= 0
                ? index
                : null;
    }

    public static String toUniqueString(String text){
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c != 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String displayTimePeriod(Date firstDate, Date secondDate) {
        double differenceInDays = (firstDate.getTime() - secondDate.getTime()) / 24 * 60 * 60 * 1000;
        return String.format("Różnica w datach wynosi %i dni", differenceInDays);
    }
}
