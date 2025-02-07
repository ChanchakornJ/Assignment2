import java.util.*;
import java.io.*;
public class Assign2 {
    public static void main(String[] args) throws FileNotFoundException{
    Date date = new Date();
    File f = new File("input1.txt");
    
    CharacterCount(f);
    PalindromeCount(f);
    FindToken(f);
    EmoticonCount(f);
    LineCount(f);
    LongestToken(f);
    averageTokenLength(f);
    Date date2 = new Date();
    System.out.println("Execution time: " + (date2.getTime() - date.getTime()) + " milliseconds");
    }

    public static void FindToken(File f) throws FileNotFoundException {
    Scanner in = new Scanner(f);
    int totalTokens = 0;
    while (in.hasNextLine()) {
        String dataLine = in.nextLine().trim(); 
        StringTokenizer data = new StringTokenizer(dataLine, " ");
        totalTokens += data.countTokens(); 
    }
    System.out.println("Total Number of tokens: " + totalTokens);
}
    public static void CharacterCount(File f)throws FileNotFoundException {
        Scanner in = new Scanner(f);
        int totalCharacters = 0;
        while (in.hasNextLine()) {
            String dataLine = in.nextLine().trim();
            dataLine = dataLine.replaceAll(" ", "");
            totalCharacters += dataLine.length();
        }
        System.out.println("Total # Character count:" + totalCharacters);
    }

    public static void PalindromeCount(File f)throws FileNotFoundException{
        Scanner in = new Scanner(f);
        int totalPalindromes = 0;
        
        while (in.hasNextLine()) {
            String dataLine = in.nextLine().trim();
            StringTokenizer data = new StringTokenizer(dataLine, " ");
            while (data.hasMoreTokens()) {
                String token = data.nextToken();
                boolean isPalindrome = true;
                for (int i = 0; i < token.length() / 2; i++) {
                    if (token.charAt(i) != token.charAt(token.length() - i - 1)) {
                        isPalindrome = false;
                        break;
                    }
                }
                if (isPalindrome) {
                    totalPalindromes++;
                }
            }
        }
        System.out.println("Total # Palindrome found: " + totalPalindromes);
    }
    public static void EmoticonCount(File f)throws FileNotFoundException{
        Scanner in = new Scanner(f);
        int totalEmoticons = 0;
        while (in.hasNextLine()) {
            String dataLine = in.nextLine().trim();
            StringTokenizer data = new StringTokenizer(dataLine, " ");
            while (data.hasMoreTokens()) {
                String token = data.nextToken();
                if (token.contains(":)") || token.contains(":(") || token.contains(":-)") || token.contains(":-(") || token.contains(":D") || token.contains("D:")) {
                    totalEmoticons++;
                }
            }
        }
        System.out.println("Total Number of emoticon: " + totalEmoticons);
    }
    public static void LineCount(File f)throws FileNotFoundException{
        Scanner in = new Scanner(f);
        int totalLines = 0;
        while (in.hasNextLine()) {
            in.nextLine();
            totalLines++;
        }
        System.out.println("Total # of new line: " + totalLines);
    }
    public static void LongestToken(File f)throws FileNotFoundException{
        Scanner in = new Scanner(f);
        int longestTokenLength = 0;
        while (in.hasNextLine()) {
            String dataLine = in.nextLine().trim();
            StringTokenizer data = new StringTokenizer(dataLine, " ");
            while (data.hasMoreTokens()) {
                String token = data.nextToken();
                if (token.length() > longestTokenLength) {
                    longestTokenLength = token.length();
                }
            }
        }
        System.out.println("The length of the longest token: " + longestTokenLength);
    }
    public static void averageTokenLength(File f)throws FileNotFoundException{
        Scanner in = new Scanner(f);
        int totalTokenLength = 0;
        int totalTokens = 0;
        while (in.hasNextLine()) {
            String dataLine = in.nextLine().trim();
            StringTokenizer data = new StringTokenizer(dataLine, " ");
            while (data.hasMoreTokens()) {
                String token = data.nextToken();
                totalTokenLength += token.length();
                totalTokens++;
            }
        }
        System.out.println("The average length of the token: " + (double) totalTokenLength / totalTokens);
    }


}

