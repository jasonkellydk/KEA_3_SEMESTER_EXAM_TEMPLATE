package dk.kea;

import dk.kea.examples.*;

import java.util.Scanner;

public class ExampleNavigator
{
    /**
     * Define all the examples in this array
     */
    public ExampleInterface[] objectArray = {};

    /**
     * Give a list of examples
     * @return
     */
    public void examples() {
        System.out.println("Lets choose and exercise");
        System.out.println();

        int index = 0;
        for (ExampleInterface example : objectArray) {
            index++;
            System.out.println(index + ": " + example.getName());
        }

        System.out.println();
        System.out.println("-1: exit");

        int exampleNumber = choseExample();

        ExampleInterface chosenExample = objectArray[exampleNumber];

        System.out.println();
        System.out.println();
        System.out.println((char)27 + "[32m" + chosenExample.getDescription());

        int dots = 0;

        while (true) {
            try {
                if (dots == 6) {
                    break;
                }

                System.out.print(".");
                Thread.sleep(1000);
                dots++;
            } catch (Exception exception) {

            }
        }

        System.out.println();
        System.out.println();
        System.out.println();

        chosenExample.runExample();

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("-----------------------------");
    }

    /**
     * Chose an example
     * @return
     */
    private int choseExample()
    {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                int exampleId = sc.nextInt();

                if (exampleId == -1) {
                    System.out.println("EXITED");
                    System.exit(0);
                }

                if (exampleId == 0) {
                    throw new Exception();
                }

                if (objectArray.length < exampleId) {
                    throw new Exception();
                }

                return exampleId - 1;
            } catch (Exception exception) {
                System.out.println("OOPS.. Wrong input");
            }
        }
    }
}
