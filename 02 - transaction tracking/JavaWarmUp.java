package assn02;
import java.util.Scanner;


public class JavaWarmUp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] categoriesList = {"phone", "laptop", "smart_watch"};

        int n = s.nextInt();
        // MM/DD/YY, HH:MM, Name, Price, Quantity, Rating, Duration

        String[] dateT = new String[n];
        String[] timeT = new String[n];
        String[] categoryT = new String[n];
        double[] Assembling_fee = new double[n];
        int[] quantityT = new int[n];
        double[] Assembling_Time = new double[n];
        double[] Energy_and_Device_Cost = new double[n];

        for(int i=0; i<n; i++) {
            dateT[i] = s.next();
            timeT[i] = s.next();
            categoryT[i] = s.next();
            Assembling_fee[i] = s.nextDouble();
            quantityT[i] = s.nextInt();
            Assembling_Time[i] = s.nextDouble();
            Energy_and_Device_Cost[i] = s.nextDouble();

        }

        int highestItemIndex = getMaxPriceIndex(Assembling_fee);
        int lowestItemIndex = getMinPriceIndex(Assembling_fee);


        System.out.println(dateT[highestItemIndex]);
        System.out.println(timeT[highestItemIndex]);
        System.out.println(categoryT[highestItemIndex]);
        System.out.println(Assembling_fee[highestItemIndex]);

        System.out.println(dateT[lowestItemIndex]);
        System.out.println(timeT[lowestItemIndex]);
        System.out.println(categoryT[lowestItemIndex]);
        System.out.println(Assembling_fee[lowestItemIndex]);


        int[] numOfCategoriesC = new int[categoriesList.length];
        double[] totPriceC = new double[categoriesList.length];
        int[] totQuantityC = new int[categoriesList.length];
        double[] totAssembling_TimeC = new double[categoriesList.length];
        double[] totEnergy_and_Device_CostC = new double[categoriesList.length];
        double[] avgAssemblingFee = new double[categoriesList.length];


        int catIndex[] = new int[categoryT.length];
        for (int i = 0; i < categoriesList.length; i++) {
            for (int j = 0; j < categoryT.length; j++) {
                if (categoriesList[i].equals(categoryT[j])) {
                    totPriceC[i] += (Assembling_fee[j] * quantityT[j]);
                    totQuantityC[i] += quantityT[j];
                    totAssembling_TimeC[i] += Assembling_Time[j];
                    totEnergy_and_Device_CostC[i] += Energy_and_Device_Cost[j];
                }

            }
            System.out.println(categoriesList[i]);
            System.out.println(totQuantityC[i]);
            System.out.println(String.format("%.2f", totPriceC[i] / totQuantityC[i]) );
            System.out.println(String.format("%.2f",( totPriceC[i] -( totAssembling_TimeC[i] * 16 )- totEnergy_and_Device_CostC[i] ) /totQuantityC[i] )) ;
            }
        }


    static int getMaxPriceIndex(double[] priceT){
        int maxIndex = 0;
        for (int i = 1; i < priceT.length; i++) {
            if (priceT[i] > priceT[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
                }


    static int getMinPriceIndex(double[] priceT){
        int minIndex = 0;
        for (int i = 1; i < priceT.length; i++) {
            if (priceT[i] < priceT[minIndex]) {
                minIndex = i;
            }
        }

        return(minIndex);
                }
            }
