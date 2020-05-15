/**Main class to implement the sorting methods
 * 
 */

package sort;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jacob Hesker Assn 7 
 */
public class Sort
{
    /**Main class to execute program
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //running list creation and converting obj array back to Integer arrays
        Object[] lists = listCreation();
        Integer[] list1 = (Integer[]) lists[0];
        Integer[] list2 = (Integer[]) lists[1];
        Integer[] list3 = (Integer[]) lists[2];
        //begining print statment
        System.out.print("Starting sort #1...");
        //running first bubbleSort
        long[][] time2d = new long[3][3]; 
        long startTime = System.nanoTime();
        Integer[] sortedList11 = bubbleSort(list1);
        long endTime = System.nanoTime();
        time2d[0][0] = (endTime - startTime)/1000000;
        // printing bubble sort time
        double time = time2d[0][0];
        System.out.println();
        System.out.printf("        %s %3.1f","Bubble Sort Time",
                time);
        //running first insertion sort
        startTime = System.nanoTime();
        Integer[] sortedList12 = insertionSort(list1);
        endTime = System.nanoTime();
        time2d[1][0] = (endTime - startTime)/1000000;
        // printing insertion sort time
        time = time2d[1][0];
        System.out.println();
        System.out.printf("        %s %3.1f","Insertion Sort Time",
                time);
        //running first quick sort
        startTime = System.nanoTime();
        Integer[] sortedList13 = quickSort(list1, 0, list1.length - 1);
        endTime = System.nanoTime();
        time2d[2][0] = (endTime - startTime)/1000000;
        // printing quick sort time
        time = time2d[2][0];
        System.out.println();
        System.out.printf("        %s %3.1f","Quick Sort Time",
                time);
        //running sort validation
        validateSort(sortedList11,sortedList12,sortedList13);
        
        
        System.out.print("Starting sort #2...");
        //running second bubbleSort 
        startTime = System.nanoTime();
        Integer[] sortedList21 = bubbleSort(list2);
        endTime = System.nanoTime();
        time2d[0][1] = (endTime - startTime)/1000000;
        // printing bubble sort time
        time = time2d[0][1];
        System.out.println();
        System.out.printf("        %s %3.1f","Bubble Sort Time",
                time);
        //running second insertion sort
        startTime = System.nanoTime();
        Integer[] sortedList22 = insertionSort(list2);
        endTime = System.nanoTime();
        time2d[1][1] = (endTime - startTime)/1000000;
        // printing insertion sort time
        time = time2d[1][1];
        System.out.println();
        System.out.printf("        %s %3.1f","Insertion Sort Time",
                time);
        //running second quick sort
        startTime = System.nanoTime();
        Integer[] sortedList23 = quickSort(list2, 0, list1.length - 1);
        endTime = System.nanoTime();
        time2d[2][1] = (endTime - startTime)/1000000;
        // printing quick sort time
        time = time2d[2][1];
        System.out.println();
        System.out.printf("        %s %3.1f","Quick Sort Time",
                time);
        //running sort validation
        validateSort(sortedList21,sortedList22,sortedList23);
        
        
        System.out.print("Starting sort #3...");
        //running third bubbleSort
        startTime = System.nanoTime();
        Integer[] sortedList31 = bubbleSort(list3);
        endTime = System.nanoTime();
        time2d[0][2] = (endTime - startTime)/1000000;
        // printing bubble sort time
        time = time2d[0][2];
        System.out.println();
        System.out.printf("        %s %3.1f","Bubble Sort Time",
                time);
        //running third insertion sort
        startTime = System.nanoTime();
        Integer[] sortedList32 = insertionSort(list3);
        endTime = System.nanoTime();
        time2d[1][2] = (endTime - startTime)/1000000;
        // printing insertion sort time
        time = time2d[1][2];
        System.out.println();
        System.out.printf("        %s %3.1f","Insertion Sort Time",
                time);
        //running third quick sort
        startTime = System.nanoTime();
        Integer[] sortedList33 = quickSort(list3, 0, list1.length - 1);
        endTime = System.nanoTime();
        time2d[2][2] = (endTime - startTime)/1000000;
        // printing quick sort time
        time = time2d[2][2];
        System.out.println();
        System.out.printf("        %s %3.1f","Quick Sort Time",
                time);
        //running sort validation
        validateSort(sortedList31,sortedList32,sortedList33);
        createReport(time2d);
    }
    /**bubbleSort code to sort random array via bubble sort methodology
     * 
     * @param list
     * @return newSorted list;
     */
    public static Integer[] bubbleSort(Integer[] list)
    {
        int temp;
        for (int i = 0; i < list.length - 1; i++) 
        {
            for (int j = 1; j < list.length - i; j++) 
            {
                if (list[j - 1] > list[j]) 
                {
                    temp = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = temp;
                }
            }
        }
	return list;
    }
    /**insertionSort code to sort random arrays via the Insertion sort 
     * methodology 
     * 
     * @param list
     * @return new sorted list
     */
    public static Integer[] insertionSort(Integer[] list)
    {
        for (int i = 1; i < list.length; i++)
        {
            for(int j = i ; j > 0 ; j--){
                if(list[j] < list[j-1]){
                    int temp = list[j];
                    list[j] = list[j-1];
                    list[j-1] = temp;
                }
            }
        }
        return list;
    }
    /**mergeSort code to sort random arrays via the merge sort methodology
     * 
     * @param list
     * @param lowIdx
     * @param highIdx
     * @return new sorted list
     */
    public static Integer[] quickSort(Integer[] list, int lowIdx,int highIdx)
    {   
        int low = lowIdx;
        int high = highIdx;
        int pivot = list[lowIdx +(highIdx - lowIdx)/ 2];
        while (low <= high)
        {
            while(list[low]< pivot)
            {
                low++;
            }
            while(list[high]> pivot)
            {
                high--;
            }
            if( low <= high)
            {
                int temp = list[low];
                list[low] = list[high];
                list[high] = temp;
                low++;
                high--;
            }
        }
        if(lowIdx < high)
        {
            quickSort(list, lowIdx, high);
        }
        if(low < highIdx)
        {
            quickSort(list, low, highIdx);
        } 
        return list;
    }
    /**listCreation creates the list to be sorted
     * 
     * @return object array with thee equal randomized lists
     */
    public static Object[] listCreation()
    {
        java.util.Random random = new java.util.Random();
        int numElements = 50000;
        Integer[] list1 = new Integer[numElements];
        Integer[] list2 = new Integer[numElements];
        Integer[] list3 = new Integer[numElements];
        for(int count = 0; count < numElements; count++ )
        {
            list1[count] = list2 [count] = list3[count]= random.nextInt(100000);
        }
        return new Object[]{list1,list2,list3};      
    }
    /**validateSort validates the that the lists are sorted and displays output
     * to tell if any issues were detected
     * 
     * @param list1
     * @param list2
     * @param list3
     */
    public static void validateSort(Integer[] list1, Integer[] list2,
            Integer[] list3 )
    { 
        int currVal;
        int nextVal;
        for(int i = 0; i < list1.length - 1; i++)
        {
            currVal = list1[i];
            nextVal = list1[i + 1];
            if (currVal <= nextVal)
            {
            }
            else
            {
                System.out.println("\nSorting ERROR: caused By bubble sort" + 
                        " at index " + currVal + " idx " + i + nextVal);
                break;
            }
        }
        for(int i = 0; i < list1.length - 1; i++)
        {
            currVal = list2[i];
            nextVal = list2[i + 1];
            if (currVal <= nextVal)
            {
            }
            else
            {
                System.out.println("\nSorting ERROR: caused By Insertion sort" + 
                        " at index " + currVal + " idx " + i + nextVal);
                break;
            }
        }
        for(int i = 0; i < list1.length - 1; i++)
        {
            currVal = list3[i];
            nextVal = list3[i + 1];
            if (currVal <= nextVal)
            {
            }
            else
            {
                System.out.println("\nSorting ERROR: caused By Quick sort" + 
                        " at index " + currVal + " idx " + i + nextVal);
                break;
            }
        }
        System.out.println("\n           Sorts Validated");
    }
    /**createReport creates report
     * 
     * @param time2d 
     */
    public static void createReport(long[][] time2d)
    {
        PrintWriter pw;
        try 
        {
            String fileName = "output/sortResults.txt";
            pw = new PrintWriter(new File(fileName));
            pw.print("SORTING RESULTS");
            pw.println("---------------");
            String run = "Run ";
            pw.println();
            pw.format("%24s%9s%9s%11s",run +1,run +2,run +3,"Average");
            double bubbleAve =(time2d[0][0] + time2d[0][1] +time2d[0][2])/3;
            double insertAve =(time2d[1][0] + time2d[1][1] +time2d[1][2])/3;
            double quickAve =(time2d[2][0] + time2d[2][1] +time2d[2][2])/3;
            double run1 = time2d[0][0];
            double run2 = time2d[0][1];
            double run3 = time2d[0][2]; 
            pw.println();
            pw.format("Bubble Sort      %7.1f  %7.1f  %7.1f    %7.1f",
                    run1, run2, run3, bubbleAve);
            run1 = time2d[1][0];
            run2 = time2d[1][1];
            run3 = time2d[1][2];
            pw.println();
            pw.format("Insertion Sort   %7.1f  %7.1f  %7.1f    %7.1f",
                    run1, run2, run3, insertAve);
            run1 = time2d[2][0];
            run2 = time2d[2][1];
            run3 = time2d[2][2];
            pw.println();
            pw.format("Quick Sort       %7.1f  %7.1f  %7.1f    %7.1f",
                    run1, run2, run3, quickAve);
            pw.close();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Sort.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
       
    }
}
