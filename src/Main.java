import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Программа производит чтение данных из файла table.txt .");
        System.out.println("Выводит результаты в файл output.txt ");


        int[] arrYear = new int[6];
        String region = "Центральный";
        try (FileWriter writer = new FileWriter("src/output.txt", false);
             Scanner scanner = new Scanner(new FileInputStream("src/table1.txt"))) {


            writer.write("Рост урожая в регионе  " + region);
            writer.write("\n");
            writer.write("Более чем на 6 %.По городам и годам");
            writer.write("\n");


            int i = 0;
            // читаем строки из файла
            while (scanner.hasNextLine()) {
                i++;
                if (i == 1) {
                    String[] year = scanner.nextLine().split(";");

                    arrYear = stringArrInt(year); //Преобразуем строку в массив ,годы.


                } else {

                    String[] volumeInfo = scanner.nextLine().split(";");


                    if (townGet(volumeInfo[1]).trim().equals(region)) {
                        double[] arrVolume = stringArrDouble(volumeInfo);
                        for (int f = 0; f < arrVolume.length - 1; f++) {
                            if (compNum(arrVolume[f], arrVolume[f + 1])) {
                                String s1 = " Год ;" + arrYear[f] + ";" + arrYear[f + 1];
                                String s2 = townGet(volumeInfo[0]) + "  " + arrVolume[f] + " ; " + arrVolume[f + 1];

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


// Возвращает массив чисел из строки типа int

    public static int[] stringArrInt(String[] year1) {
        int[] yearNum;
        yearNum = new int[year1.length - 2];
        for (int k = 0; k < year1.length - 2; k++) {
            yearNum[k] = Integer.parseInt(year1[k + 2]);

        }
        return yearNum;

    }
    //Возвращает массив чисел типа double

    public static double[] stringArrDouble(String[] volume) {
        double[] volumeNum;
        volumeNum = new double[volume.length - 2];
        for (int k = 0; k < volume.length - 2; k++) {
            volumeNum[k] = Double.parseDouble(volume[k + 2]);

        }
        return volumeNum;

    }

    // Возвращает true,если в предыдущем году урожайность выше на 6 %
    public static boolean compNum(double num1, double num2) {

        try {
            if ((((num2 - num1) / num1) * 100) >= 6) return true;
        } catch (Exception e) {
            System.out.println("Деление на 0 " + e.getMessage());
            return false;
        }

        return false;


    }

    // Возвращает название города,т.к строка из 2 слов.
    public static String townGet(String regionTown) {
        String[] town = regionTown.split(" ");
        return town[0];
    }

}

