package assn02;

import java.util.Scanner;

public class Practice {


        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);

            String[] categoriesList = {"phone", "laptop", "smart_watch"};
            double hourlyRate = 16.0;

            int n = s.nextInt();
            s.nextLine();

            String dateT[] = new String[n];
            String timeT[] = new String[n];
            String categoryT[] = new String[n];
            double Assembling_fee[] = new double[n];
            int quantityT[] = new int[n];
            double Assembling_Time[] = new double[n];
            double Energy_and_Device_Cost[] = new double[n];

            for (int i = 0; i < n; i++) {
                String[] entire = s.nextLine().split(" ");
                dateT[i] = entire[0];
                timeT[i] = entire[1];
                categoryT[i] = entire[2];
                Assembling_fee[i] = Double.parseDouble(entire[3]);
                quantityT[i] = Integer.parseInt(entire[4]);
                Assembling_Time[i] = Double.parseDouble(entire[5]);
                Energy_and_Device_Cost[i] = Double.parseDouble(entire[6]);
            }

            int highestItemIndex = getMaxPriceIndex(Assembling_fee);
            int lowestItemIndex = getMinPriceIndex(Assembling_fee);

            System.out.println(dateT[highestItemIndex]);
            System.out.println(timeT[highestItemIndex]);
            System.out.println(categoryT[highestItemIndex]);
            System.out.printf("%.2f%n", Assembling_fee[highestItemIndex]);

            System.out.println(dateT[lowestItemIndex]);
            System.out.println(timeT[lowestItemIndex]);
            System.out.println(categoryT[lowestItemIndex]);
            System.out.printf("%.2f%n", Assembling_fee[lowestItemIndex]);

            double[] totalFees = new double[categoriesList.length];
            double[] totalProfits = new double[categoriesList.length];
            int[] totalQuantities = new int[categoriesList.length];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < categoriesList.length; j++) {
                    if (categoryT[i].equals(categoriesList[j])) {
                        totalFees[j] += Assembling_fee[i] * quantityT[i];
                        totalProfits[j] += (Assembling_fee[i] - Energy_and_Device_Cost[i] / quantityT[i] - (Assembling_Time[i] / quantityT[i] * hourlyRate)) * quantityT[i];
                        totalQuantities[j] += quantityT[i];
                    }
                }
            }

            for (int j = 0; j < categoriesList.length; j++) {
                if (totalQuantities[j] > 0) {
                    System.out.println(categoriesList[j]);
                    System.out.println(totalQuantities[j]);
                    System.out.printf("%.2f%n", totalFees[j] / totalQuantities[j]);
                    System.out.printf("%.2f%n", totalProfits[j] / totalQuantities[j]);
                }
            }
        }

        static int getMaxPriceIndex(double[] priceT) {
            int maxIndex = 0;
            for (int i = 1; i < priceT.length; i++) {
                if (priceT[i] >= priceT[maxIndex]) {
                    maxIndex = i;
                }
            }
            return maxIndex;
        }

        static int getMinPriceIndex(double[] priceT) {
            int minIndex = 0;
            for (int i = 1; i < priceT.length; i++) {
                if (priceT[i] <= priceT[minIndex]) {
                    minIndex = i;
                }
            }
            return minIndex;
        }
    }