package hw_08;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HashSet<Character> seenCharacters = new HashSet<>();
        int validWordCounter = 0;

        System.out.println("---------- HOŞGELDİNİZ ----------");
        System.out.println("Kaç adet kelimeyi kontrol etmek istiyorsunuz?:");

        int counter = scanner.nextInt();
        scanner.nextLine();
        String[] words = new String[counter];

        for (int i = 0; i< counter; i++){
            System.out.println(i+1 + ". kelimeyi giriniz: ");
            words[i] = scanner.nextLine();
        }

        for (String word: words){
            HashSet<Character> repeatedCharacters = new HashSet<>();
            boolean addedNewChar = false;
            for (int i =0; i<word.length(); i++){
                char character = word.charAt(i);
                if (!repeatedCharacters.add(character)){
                    if (seenCharacters.add(character)){
                        addedNewChar =true;
                    }

                }
                else{
                    repeatedCharacters.add(character);
                }
            }
            if (repeatedCharacters.size()>=2 && addedNewChar){
                seenCharacters.addAll(repeatedCharacters);
                validWordCounter++;
                System.out.println("tekrar eden kelime: "+word);
            }
            if(validWordCounter >=2){
                break;
            }
        }

        System.out.println(seenCharacters);
    }

}

