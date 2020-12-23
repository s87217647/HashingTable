package hashTables;

import java.util.ArrayList;
import java.util.Random;

import cs1c.FHhashQP;
import cs1c.TimeConverter;

public class ExtraCreditTesting {
    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<Integer>();
        FHhashQP<Integer> intQP = new FHhashQP<Integer>();

        Random rand = new Random();
        int[] testingSizes = {10,100,1000,10000,100000,1000000,1000000};

        for(int currentSize : testingSizes){
            for(int i = 0; i < 1000; i++){
                int randomInt = rand.nextInt();
                intList.add(randomInt);
                intQP.insert(randomInt);
            }
            System.out.println("Size: " + currentSize);
            System.out.println( "Linear: " + linearAvg(intList) + " QP: " + QPAvg(intQP));
        }






    }

    public static String linearAvg(ArrayList<Integer> targetList){
        //Loop 1000 times to get the average value
        long startTime = System.nanoTime();
        Random rand = new Random();
        for (int k = 0; k < 10000; k++){
            sequentialFind(targetList, rand.nextInt());
        }
        return TimeConverter.convertTimeToString((System.nanoTime() - startTime)/10000);
    }

    public static String QPAvg(FHhashQP<Integer> targetQP){
        long startTime = System.nanoTime();
        Random rand = new Random();
        for (int k = 0; k < 10000; k++){
            targetQP.contains(rand.nextInt());
        }
        return TimeConverter.convertTimeToString((System.nanoTime() - startTime)/10000);
    }

    public static boolean sequentialFind(ArrayList<Integer> targetList, int targetVal){
        for( Integer currentInt: targetList){
            if(currentInt == targetVal)
                return true;
        }
        return false;
    }

}


