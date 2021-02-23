package sortcollection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class SortedDoubleListTest {

    static Stream<Arguments> listDoubleSortTestNominal() {
        SortedDoubleList collection0 = new SortedDoubleList();
        SortedDoubleList collection1 = new SortedDoubleList();
        SortedDoubleList collection9 = new SortedDoubleList();
        SortedDoubleList collection10 = new SortedDoubleList();
        SortedDoubleList collection12 = new SortedDoubleList();
        SortedDoubleList collection36 = new SortedDoubleList();

        collection1.add(1);

        collection9.init(new int[]{1, 9, 3, 4, 7, 7, 6, 5, -5});

        collection10.init(new int[]{1, 2, 9, 5, 0, -1, 6, 7, 9, 10});

        collection12.init(new int[]{2, 7, 3, 9, -9});

        collection36.init(new int[]{-8, -7, -6, 0, 1, 2, 3, 4, 5, 6});

        return Stream.of(
                arguments(collection0, new int[]{}),
                arguments(collection1, new int[]{1}),
                arguments(collection9, new int[]{-5, 1, 3, 4, 5, 6, 7, 7, 9}),
                arguments(collection10, new int[]{-1, 0, 1, 2, 5, 6, 7, 9, 9, 10}),
                arguments(collection12, new int[]{-9, 2, 3, 7, 9}),
                arguments(collection36, new int[]{-8, -7, -6, 0, 1, 2, 3, 4, 5, 6})
        );
    }

    @ParameterizedTest
    @MethodSource("listDoubleSortTestNominal")
    void listSingleSortTest(SortedDoubleList collection, int[] expected) {
        collection.sort();
        int[] actual = collection.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }
}