import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static boolean playing;
    public static String quit = "quit";
    public static int counter = 0;

    public static void main(String[] args) {
	// write your code here

        playing = true;
        String input = "";

        println("Input string:");

        do{
            input = scanner.nextLine();
            println(input);
            String[] temp = swap3Letters(input);
            for(String anagram : temp) {
                counter++;
                print(counter + " ");
                println(anagram);
            }
            String[] temp2 = anagram4(temp[temp[0].length()-1]);


            /*for(int i = 0; i < temp2.length-2; i++) {
                String[] temp3 = swap3Letters(temp2[i]);
                for(String anagram2 : temp3) {
                    counter++;
                    print(counter + " ");
                    println(anagram2);
                }

            }*/

            
            
            
            
            if(input.equalsIgnoreCase(quit))
                System.exit(0);
        } while (playing);


    }

    public static void println(String string){
        System.out.println(string);
    }

    public static void print(String string){
        System.out.print(string);
    }

    public static String[] anagram4(String string){
        char[] array = string.toCharArray();
        char[][] matrix = new char[6][string.length()];
        String[] anagrams = new String[6];

        for(char[] anagram : matrix){
            anagram[string.length() - 4] = array[string.length() - 4];
            anagram[string.length() - 3] = array[string.length() - 3];
            anagram[string.length() - 2] = array[string.length() - 2];
            anagram[string.length() - 1] = array[string.length() - 1];

        }

        for(int i = 0; i < 6; i++){
            // cycles through anagram list

            // if first one. skip
            if(i == 0) {
                String str = Character.toString(matrix[i][0]) + Character.toString(matrix[i][1]) + Character.toString(matrix[i][2]) + Character.toString(matrix[i][3]);
                anagrams[i] = str;
                println("");
                continue;
            }

            char temp;
            String str = " ";
            switch (i){

                case 1:
                    swap2Letters(matrix, i, string.length() - 4, string.length() - 1);
                    str = Character.toString(matrix[i][0]) + Character.toString(matrix[i][1]) + Character.toString(matrix[i][2]) + Character.toString(matrix[i][3]);
                    print3(anagrams, str);
                    break;
                case 2:
                    swap2Letters(matrix, i, string.length() - 4, string.length() -2);
                    str = Character.toString(matrix[i][0]) + Character.toString(matrix[i][1]) + Character.toString(matrix[i][2]) + Character.toString(matrix[i][3]);
                    print3(anagrams, str);
                    break;
                case 3:
                    swap2Letters(matrix, i,string.length() -4, string.length() -3);
                    str = Character.toString(matrix[i][0]) + Character.toString(matrix[i][1]) + Character.toString(matrix[i][2]) + Character.toString(matrix[i][3]);
                    print3(anagrams, str);
                    break;


            }
            str = Character.toString(matrix[i][0]) + Character.toString(matrix[i][1]) + Character.toString(matrix[i][2]) + Character.toString(matrix[i][3]);
            anagrams[i] = str;
        }



        return anagrams;
    }


    public static void print3(String[] anagrams, String stringToSwap){
        anagrams = swap3Letters(stringToSwap);
        for(String anagram : anagrams) {
            counter++;
            print(counter + " ");
            println(anagram);
        }
        println("");
    }

    public static String[] swap3Letters(String string){
        char[] array = string.toCharArray();
        char[][] matrix = new char[6][string.length()];
        String[] anagrams = new String[6];

        for(char[] anagram : matrix){
            anagram[string.length() - 4] = array[string.length() - 4];
            anagram[string.length() - 3] = array[string.length() - 3];
            anagram[string.length() - 2] = array[string.length() - 2];
            anagram[string.length() - 1] = array[string.length() - 1];

        }

        for(int i = 0; i < 6; i++){
            // cycles through anagram list

            // if first one. skip
            if(i == 0) {
                String str = Character.toString(matrix[i][0]) + Character.toString(matrix[i][1]) + Character.toString(matrix[i][2]) + Character.toString(matrix[i][3]);
                anagrams[i] = str;
                continue;
            }

                char temp;
                switch (i){
                    case 1:
                        swap2Letters(matrix, i,(string.length() - 2), (string.length() - 1) );
                        break;
                    case 2:
                        swap2Letters(matrix, i,(string.length() - 3), (string.length() - 2) );
                        break;
                    case 3:
                        swap2Letters(matrix, i,(string.length() - 3), (string.length() - 1) );
                        break;
                    case 4:
                        swap2Letters(matrix, i,(string.length() - 2), (string.length() - 1) );
                        break;
                    case 5:
                        swap2Letters(matrix, i,(string.length() - 3), (string.length() - 1) );
                        break;
                    case 6:
                        swap2Letters(matrix, i,(string.length() - 2), (string.length() - 1) );
                        break;

                }

                String str = Character.toString(matrix[i][0]) + Character.toString(matrix[i][1]) + Character.toString(matrix[i][2]) + Character.toString(matrix[i][3]);
                anagrams[i] = str;



            }






    return anagrams;

    }

    public static char[][] swap2Letters(char[][] word, int index, int index1, int index2){

        char temp = word[index][index1];
        word[index][index1] = word[index][index2];
        word[index][index2] = temp;


        return word;
    }
}
