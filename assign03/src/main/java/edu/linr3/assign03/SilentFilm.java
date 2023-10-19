package edu.linr3.assign03;
import java.util.Scanner;
public class SilentFilm
{
    public static Narrator askForNarration(Scanner input)
    {
        String allLines[];
        char b;
        System.out.println("Enter boundary character:");
        b = input.nextLine().charAt(0);
        System.out.println("Enter number of lines:");
        int numLines = Integer.parseInt(input.nextLine());
        System.out.println("Enter lines:");
        allLines = new String[numLines];
        for(int i = 0;i < numLines;i++)
        {
            allLines[i]=input.nextLine();
        }
        Narrator n = new Narrator(allLines, b);
        return n;
    }
    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);
        Narrator n = askForNarration(input);
        System.out.println("Our story begins...");
        System.out.println(n);
    }

}
