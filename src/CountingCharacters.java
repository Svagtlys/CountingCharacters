import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CountingCharacters {

    /**
     *
     * @param givenString
     * @return {}givenString - found characters, charCount as string}
     */
    private static String[] countFirstChar(String givenString){
        int charCount = 0;
        String finalString = "";
        char searchTerm = Character.toLowerCase(givenString.charAt(0));

        for(char i:givenString.toCharArray())
        {
            if(Character.toLowerCase(i) == searchTerm)
            {
                charCount += 1;
                continue;
            }

            finalString += i;
        }

        return new String[]{finalString, String.valueOf(searchTerm), String.valueOf(charCount)};
    }

    public static void main(String[] args)
    {

        String givenString = "Example";
//        SEARCH HARD CODED STRING
//        givenString = "If the product of two terms is zero then common sense says at least one of the two terms has " +
//                "to be zero to start with. So if you move all the terms over to one side, you can put the quadratics into a " +
//                "form that can be factored allowing that side of the equation to equal zero. Once you’ve done that, it’s pretty " +
//                "straightforward from there.";

        // SEARCH USER INPUTTED STRING
//        Scanner input = new Scanner(System.in);
//        System.out.println("Enter the text you would like to see all alphabetic character counts for:");
//        givenString = input.nextLine();

        // SEARCH FILE INPUTTED STRING
        try {
            File readIn = new File("src/input.txt");
            Scanner input = new Scanner(readIn);
            input.useDelimiter("\\Z");
            givenString = input.next();
        }catch(FileNotFoundException e){
            System.out.println("Sorry, that file was not found. Ending program...");
            return;
        }

        HashMap<Character, Integer> foundChars = new HashMap<>();

        String newString = givenString;

        while(newString.length() > 0){
            String[] returnPair = countFirstChar(newString);
            newString = returnPair[0];
            if(returnPair[1].charAt(0) >= 97 && returnPair[1].charAt(0) <= 122)
            {
                foundChars.put(returnPair[1].toUpperCase().charAt(0), Integer.parseInt(returnPair[2]));
            }
        }

        for (Character c : foundChars.keySet()) {
            System.out.println(c+": "+foundChars.get(c));
        }



    }
}
