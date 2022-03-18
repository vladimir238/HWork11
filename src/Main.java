import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Программа производит чтение данных из файла table.txt .");
        System.out.println("Выводит результаты в файл output.txt ");
        NumOperation numOperation = new NumOperation();

        int[] arrYear = new int[6];
        String region = "Центральный";
        try (FileWriter writer = new FileWriter("src/output.txt", false);
             Scanner scanner = new Scanner(new FileInputStream("src/table.txt"))) {


            writer.write("Рост урожая в регионе  " + region);
            writer.write("\n");
            writer.write("Более чем на 6 %.По городам и годам");
            writer.write("\n");


            int i = 0;

            while (scanner.hasNextLine()) {
                i++;
                if (i == 1) {
                    String[] year = scanner.nextLine().split(";");

                    arrYear = numOperation.stringArrInt(year);


                } else {

                    String[] volumeInfo = scanner.nextLine().split(";");


                    if (numOperation.townGet(volumeInfo[1]).trim().equals(region)) {
                        double[] arrVolume = numOperation.stringArrDouble(volumeInfo);
                        for (int f = 0; f < arrVolume.length - 1; f++) {
                            if (numOperation.compNum(arrVolume[f], arrVolume[f + 1])) {
                                String s1 = " Год ;" + arrYear[f] + ";" + arrYear[f + 1];
                                String s2 = numOperation.townGet(volumeInfo[0]) + "  " + arrVolume[f] + " ; " + arrVolume[f + 1];

                                writer.write(s1);
                                writer.write("\n");
                                writer.write(s2);
                                writer.write("\n");
                                writer.flush();

                            }

                        }
                    }
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода " + e.getMessage());
            ;
        }

    }


}

