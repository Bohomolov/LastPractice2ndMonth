package collections;

public interface IList {
    void init(int[] array);
    int size();
    boolean add(int value);

    int[] toArray();

}