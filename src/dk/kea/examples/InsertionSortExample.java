package dk.kea.examples;

import dk.kea.ExampleInterface;

import java.util.Arrays;

public class InsertionSortExample implements ExampleInterface
{
    @Override
    public String getDescription()
    {
        return "This example will sort an int array using insertion sort";
    }

    @Override
    public String getName()
    {
        return "Insertion sort";
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

        // insertion sort

        start = System.nanoTime();

        int[] sorted = insertionSort(array);

        stop = System.nanoTime();

        elapsed = stop - start;

        System.out.println();

        System.out.println("After sort");

        System.out.println(Arrays.toString(sorted));

        System.out.println();

        System.out.println("Sort time: " + elapsed);
    }

    public int[] insertionSort(int[] array)
    {
        int temp;

        // Run through the length of the array
        for (int i = 1; i < array.length; i++) {
            // Run through the unsorted part
            for (int j = i ; j > 0 ; j--) {
                if (array[j] < array[j-1]) {
                    temp = array[j]; // remove first unsorted element

                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }

        return array;
    }
}
