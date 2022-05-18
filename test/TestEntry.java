package test;

public class TestEntry {
    public double value;
    public Test key;

    /**
     * Defualt cnstructor
     *
     * @param rank is the rank
     * @param testEntry is the testEntry
     */
    public TestEntry(double rank, Test testEntry) {
        this.value = rank;
        this.key = testEntry;
    }

    /**
     * Copy constructor
     */
    public TestEntry(TestEntry t)
    {
        this.value = t.value;
        this.key = t.key;
    }

    // /**
    //  * @return the key/value pair as a String in form of (Test, rank)
    //  */
    // @Override
    // public String toString() {
    //     return "(" + Test.toString() + ", " + value.toString() + ")";
    // }

}
