import okio.BufferedSource;
import okio.Okio;

import java.nio.file.FileSystem;

import java.security.Key;
import java.util.*;
import java.io.*;
import java.lang.*;

public class practice {

    private static File input = new File("D://Practica_2course//input.txt");
    private static File output = new File("D://Practica_2course//output.txt");
    private static File key = new File("D://Practica_2course//key.txt");


    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);

        int choice;

        System.out.println("Choose one of the actions:");
        System.out.println("1 - Encrypt your file");
        System.out.println("2 - Decrypt your file");
        System.out.println("3 - Finish the program ");

        do {
            choice = in.nextInt();

                  if(choice == 1) {
                      try {
                          Encryption();
                      } catch (IOException ex1) {
                          ex1.printStackTrace();
                      }
                  }
                    else {
                    try {
                       Decryption();
                    }
                    catch (IOException ex1){
                        ex1.printStackTrace();
                    }
            }

        }
        while (choice != 3);
        System.out.println("Program has been closed");

    }

    private static String Input() throws FileNotFoundException {
        try {
            BufferedSource source = Okio.buffer(Okio.source(input));
            String result = source.readUtf8();
            source.close();

            return result;
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        return "Empty";

    }

    private static String InputKey() throws FileNotFoundException {
        try {
            BufferedSource source = Okio.buffer(Okio.source(key));
            String result = source.readUtf8();
            source.close();

            return result;
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        return "Empty";

    }

    private static String InputforOut() throws FileNotFoundException {
        try {
            BufferedSource source = Okio.buffer(Okio.source(output));
            String result = source.readUtf8();
            source.close();

            return result;
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        return "Empty";

    }

    public static void/*ArrayDeque<Integer>*/ Encryption() throws IOException {
        try {
           // ArrayDeque<Integer> KeyList = new ArrayDeque<>();
            ArrayList<Character> KeyList = new ArrayList<>();
            ArrayList<Character> XoredList1 = new ArrayList<>();

            String key, input;

            key = InputKey();

            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
               KeyList.add(c);
            }

            for (int i = 0; i <KeyList.size(); i++)
                System.out.print(KeyList.get(i));
            System.out.print("\n");

            input = Input();
            char[] text = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            text[i] = c;

        }
            /*for (int i = 0; i < text.length; i++)
                System.out.print(text[i]);
        System.out.println("\n");*/

            for (int i = 0; i < input.length(); i++) {

                XoredList1.add((char)(text[i]^KeyList.get(0)));
                KeyList.add((char)(KeyList.get(0)^KeyList.get(2)^KeyList.get(3)^KeyList.get(5)^KeyList.get(7)^KeyList.get(10)^KeyList.get(12)));
                KeyList.remove(0);

            }
            /*for (int i = 0; i < XoredList1.size(); i++)
                System.out.print(XoredList1.get(i));*/


            FileWriter out = null;
        try {
            out = new FileWriter("D://Practica_2course//output.txt");
            for (int j = 0; j < text.length; j++){
                out.write(XoredList1.get(j));}
        }
        finally {
            out.close();
        }


    }
        catch (FileNotFoundException ex) {
            ex.getMessage();
        }

}
    public static void Decryption() throws IOException{
        try {
            ArrayList<Character> Key = new ArrayList<>();
            ArrayList<Character> Xor = new ArrayList<>();

            String key, input;

            key = InputKey();

            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                Key.add(c);
            }


            input = InputforOut();
            char[] text1 = new char[input.length()];
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                text1[i] = c;
            }
            for (int i = 0; i < input.length(); i++) {

                Xor.add((char)(text1[i]^Key.get(0)));
                Key.add((char)(Key.get(0)^Key.get(2)^Key.get(3)^Key.get(5)^Key.get(7)
                        ^Key.get(10)^Key.get(12)));
                Key.remove(0);


            }
           /* for (int i = 0; i < input.length(); i++)
                System.out.print(Xor.get(i));*/
            FileWriter out2 = null;
            try {
                out2 = new FileWriter("D://Practica_2course//output.txt");
                for (int j = 0; j < text1.length; j++){
                    out2.write(Xor.get(j));}
            }
            finally {
                out2.close();
            }

        }
        catch (FileNotFoundException ex){
            ex.getMessage();
        }
    }
}
