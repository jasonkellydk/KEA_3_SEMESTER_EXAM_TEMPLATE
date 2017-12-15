package dk.kea.examples;

import dk.kea.ExampleInterface;

import java.util.Arrays;

public class QuickSortExample implements ExampleInterface
{
    @Override
    public String getDescription()
    {
        return "This example will sort an int array using quick sort";
    }

    @Override
    public String getName()
    {
        return "Quick sort";
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

        // quick sort

        start = System.nanoTime();

        int[] sorted = quickSort(array,0, array.length-1);

        stop = System.nanoTime();

        elapsed = stop - start;

        System.out.println();

        System.out.println("After sort");

        System.out.println(Arrays.toString(sorted));

        System.out.println();

        System.out.println("Sort time: " + elapsed);
    }

    /**
     * This function takes last element as pivot,
     * places the pivot element at its correct
     * position in sorted array, and places all
     * smaller (smaller than pivot) to left of
     * pivot and all greater elements to right
     * of pivot
     * @param array arrays to be sorted
     * @param low starting index
     * @param high ending index
     */
    private int partition(int array[], int low, int high)
    {
        int pivot = array[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j <= high - 1; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (array[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    /**
     *
     * @param array arrays to be sorted
     * @param low starting index
     * @param high ending index
     */
    private int[] quickSort(int array[], int low, int high)
    {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(array, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSort(array, low, pi-1);
            quickSort(array, pi+1, high);
        }

        return array;
    }
}
