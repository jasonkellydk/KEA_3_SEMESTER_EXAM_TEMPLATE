package dk.kea.examples;

import dk.kea.ExampleInterface;

import java.util.Arrays;

public class MergeSortExample implements ExampleInterface
{
    @Override
    public String getDescription()
    {
        return "This example will sort an int array using merge sort";
    }

    @Override
    public String getName()
    {
        return "Merge sort";
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

        // merge sort

        start = System.nanoTime();

        int[] sorted = mergeSort(array,0, array.length-1);

        stop = System.nanoTime();

        elapsed = stop - start;

        System.out.println();

        System.out.println("After sort");

        System.out.println(Arrays.toString(sorted));

        System.out.println();

        System.out.println("Sort time: " + elapsed);
    }

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    private int[] merge(int array[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) {
            L[i] = array[l + i];
        }

        for (int j=0; j<n2; ++j) {
            R[j] = array[m + 1+ j];
        }


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }

            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }

        return array;
    }

    // Main function that sorts arr[l..r] using merge
    private int[] mergeSort(int array[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            mergeSort(array, l, m);
            mergeSort(array , m+1, r);

            // Merge the sorted halves
            merge(array, l, m, r);
        }

        return array;
    }
}
