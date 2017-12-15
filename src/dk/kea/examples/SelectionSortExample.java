package dk.kea.examples;

import dk.kea.ExampleInterface;
import java.util.Arrays;

public class SelectionSortExample implements ExampleInterface
{
    @Override
    public String getDescription()
    {
        return "This example will sort an int array using selection sort";
    }

    @Override
    public String getName()
    {
        return "Selection Sort";
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

        int[] sorted = selectionSort(array);

        stop = System.nanoTime();

        elapsed = stop - start;

        System.out.println();

        System.out.println("After sort");

        System.out.println(Arrays.toString(sorted));

        System.out.println();

        System.out.println("Sort time: " + elapsed);
    }

    /**
     * Selection sort example
     * @param array
     * @return
     */
    private int[] selectionSort(int[] array)
    {
        // Start at the beginning of the array
        for (int i = 0; i < array.length - 1; i++)
        {
            // Default value of the lowest element index
            int index = i;

            // Loop from the beginning of the unsorted zone
            for (int j = i + 1; j < array.length; j++) {
                // Compare current to lowest
                if (array[j] < array[index]) {
                    index = j;
                }
            }

            // Swap the two values
            int smallerNumber = array[index];

            array[index] = array[i];
            array[i] = smallerNumber;
        }

        // Return sorted array
        return array;
    }
}
