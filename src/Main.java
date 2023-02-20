import java.io.*;

public class Main {
    public static void main(String[] args) {
        File fileIn = new File("D:/code/Java/BubbleSort/src/input.txt");
        File fileOut = new File("D:/code/Java/BubbleSort/src/Output.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(fileIn));
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut))) {

            String line;
            while ((line = reader.readLine()) != null) {
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
            }

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



