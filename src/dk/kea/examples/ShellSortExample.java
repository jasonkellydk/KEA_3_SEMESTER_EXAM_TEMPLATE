package dk.kea.examples;

import dk.kea.ExampleInterface;

import java.util.Arrays;

public class ShellSortExample implements ExampleInterface
{
    @Override
    public String getDescription()
    {
        return "This example will sort an int array using shell sort";
    }

    @Override
    public String getName()
    {
        return "Shell Sort";
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

        int[] sorted = shellSort(array);

        stop = System.nanoTime();

        elapsed = stop - start;

        System.out.println();

        System.out.println("After sort");

        System.out.println(Arrays.toString(sorted));

        System.out.println();

        System.out.println("Sort time: " + elapsed);
    }

    private int[] shellSort(int array[])
    {
        int n = array.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for (int i = gap; i < n; i += 1) {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int temp = array[i];

                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;

                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }

                // put temp (the original a[i]) in its correct
                // location
                array[j] = temp;
            }
        }

        return array;
    }
}
