public class NumOperation {

    public int[] stringArrInt(String[] year1) {
        int[] yearNum;
        yearNum = new int[year1.length - 2];
        for (int k = 0; k < year1.length - 2; k++) {
            yearNum[k] = Integer.parseInt(year1[k + 2]);

        }
        return yearNum;

    }

    public static double[] stringArrDouble(String[] volume) {
        double[] volumeNum;
        volumeNum = new double[volume.length - 2];
        for (int k = 0; k < volume.length - 2; k++) {
            volumeNum[k] = Double.parseDouble(volume[k + 2]);

        }
        return volumeNum;
    }
    public static boolean compNum(double num1, double num2) {

        try {
            if ((((num2 - num1) / num1) * 100) >= 6) return true;
        } catch (Exception e) {
            System.out.println("Деление на 0 " + e.getMessage());
            return false;
        }

        return false;


    }
    public static String townGet(String regionTown) {
        String[] town = regionTown.split(" ");
        return town[0];
    }
}
