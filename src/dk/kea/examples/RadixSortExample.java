package dk.kea.examples;

import dk.kea.ExampleInterface;

import java.util.Arrays;

public class RadixSortExample implements ExampleInterface
{
    @Override
    public String getDescription()
    {
        return "This example will sort an int array using radix sort";
    }

    @Override
    public String getName()
    {
        return "Radix sort";
    }

    @Override
    public void runExample()
    {
        long start = 0;
        long stop = 0;
        long elapsed = 0;

        int[] array = {10,34,2,56,7,67,88,42,81,123,51,1234,12348,12347,912,2341,1958,12347,1282,123,5861,2349,234,613,7};

        System.out.println("Before sort");

        System.out.println(Arrays.toString(array));

        // selection sort

        start = System.nanoTime();

        int[] sorted = radixSort(array, array.length);

        stop = System.nanoTime();

        elapsed = stop - start;

        System.out.println();

        System.out.println("After sort");

        System.out.println(Arrays.toString(sorted));

        System.out.println();

        System.out.println("Sort time: " + elapsed);
    }

    /**
     * @param array array to get max value
     * @param n length
     * @return max value
     */
    private int getMax(int array[], int n)
    {
        int mx = array[0];

        for (int i = 1; i < n; i++) {
            mx = array[i];
        }

        return mx;
    }

    /**
     * A function to do counting sort of an array
     * According to the digit represented by exp
     * @param array array to count and sort
     * @param n length
     * @param exp
     */
    private void countSort(int array[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];

        Arrays.fill(count,0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++) {
            count[ (array[i]/exp)%10 ]++;
        }

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[ (array[i]/exp)%10 ] - 1] = array[i];
            count[ (array[i]/exp)%10 ]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++) {
            array[i] = output[i];
        }
    }

    /**
     * The main function that sorts the array of size n
     * @param array source array that needs to be sorted
     * @param n index
     */
    private int[] radixSort(int array[], int n)
    {
        // Find the maximum number to know number of digits
        int max = getMax(array, n);

        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; max/exp > 0; exp *= 10) {
            countSort(array, n, exp);
        }

        return array;
    }
}
