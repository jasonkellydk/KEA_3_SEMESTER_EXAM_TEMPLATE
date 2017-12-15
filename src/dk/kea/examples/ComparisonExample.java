package dk.kea.examples;

import dk.kea.ExampleInterface;

public class ComparisonExample implements ExampleInterface
{
    @Override
    public String getDescription()
    {
        return "In this example we will compare sorting with every algorithme";
    }

    @Override
    public String getName()
    {
        return "Compare them all";
    }

    @Override
    public void runExample()
    {
        InsertionSortExample insertionSortExample = new InsertionSortExample();
        MergeSortExample mergeSortExample = new MergeSortExample();
        QuickSortExample quickSortExample = new QuickSortExample();
        RadixSortExample radixSortExample = new RadixSortExample();
        SelectionSortExample selectionSortExample = new SelectionSortExample();
        ShellSortExample shellSortExample = new ShellSortExample();

        System.out.println(insertionSortExample.getName());
        System.out.println();
        insertionSortExample.runExample();

        System.out.println(mergeSortExample.getName());
        System.out.println();
        mergeSortExample.runExample();

        System.out.println(quickSortExample.getName());
        System.out.println();
        quickSortExample.runExample();

        System.out.println(radixSortExample.getName());
        System.out.println();
        radixSortExample.runExample();

        System.out.println(selectionSortExample.getName());
        System.out.println();
        selectionSortExample.runExample();

        System.out.println(shellSortExample.getName());
        System.out.println();
        shellSortExample.runExample();
    }
}
