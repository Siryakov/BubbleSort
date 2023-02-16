import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        try {

            File fileIn = new File("D:/code/Java/BubbleSort/src/input.txt");
            File fileOut = new File("D:/code/Java/BubbleSort/src/Output.txt");

            FileReader fr = new FileReader(fileIn);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));
            while (line != null) {
                String[] buffer = line.split(" ");
                for (int i = 0; i < buffer.length - 1; i++) {
                    for (int j = 0; j < buffer.length - i - 1; j++) {
                        if (isGreater(buffer[j], buffer[j + 1])) {
                            // Swap elements
                            String temp = buffer[j];
                            buffer[j] = buffer[j + 1];
                            buffer[j + 1] = temp;
                        }
                    }
                }
                for (String element : buffer) {
                    writer.write(element + " ");
                }
                writer.write("\n");
                System.out.println(line);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }

            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static boolean isGreater(String a, String b) {
        try {
            int aInt = Integer.parseInt(a);
            int bInt = Integer.parseInt(b);
            return aInt > bInt;
        } catch (NumberFormatException e) {
            return a.compareTo(b) > 0;
        }
    }
}






