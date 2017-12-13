package dk.kea;

public interface ExampleInterface
{
    /**
     * Tell the public what the purpose of this interface
     */
    public String purpose = "To create a common way for examples to be run";

    /**
     * What does the class do?
     * @return String
     */
    public String getDescription();

    /**
     * what is the name of the example
     * @return String
     */
    public String getName();

    /**
     * Run the given code example
     */
    public void runExample();
}