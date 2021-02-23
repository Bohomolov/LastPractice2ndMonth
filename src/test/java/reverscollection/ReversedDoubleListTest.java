package reverscollection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class ReversedDoubleListTest {
    static Stream<Arguments> listDoubleReverseTestNominal() {
        ReversedDoubleList collection0 = new ReversedDoubleList();
        ReversedDoubleList collection1 = new ReversedDoubleList();
        ReversedDoubleList collection9 = new ReversedDoubleList();
        ReversedDoubleList collection10 = new ReversedDoubleList();
        ReversedDoubleList collection12 = new ReversedDoubleList();
        ReversedDoubleList collection36 = new ReversedDoubleList();

        collection1.add(1);

        collection9.init(new int[]{1, 9, 3, 4, 7, 7, 6, 5, -5});

        collection10.init(new int[]{1, 2, 9, 5, 0, -1, 6, 7, 9, 10});

        collection12.init(new int[]{2, 7, 3, 9, -9});

        collection36.init(new int[]{-8, -7, -6, 0, 1, 2, 3, 4, 5, 6});

        return Stream.of(
                arguments(collection9, new int[]{-5, 5, 6, 7, 7, 4, 3, 9, 1}),
                arguments(collection0, new int[]{}),
                arguments(collection1, new int[]{1}),
                arguments(collection10, new int[]{10, 9, 7, 6, -1, 0, 5, 9, 2, 1}),
                arguments(collection12, new int[]{-9, 9, 3, 7, 2}),
                arguments(collection36, new int[]{6, 5, 4, 3, 2, 1, 0, -6, -7, -8}),
                arguments(collection36, new int[]{-8, -7, -6, 0, 1, 2, 3, 4, 5, 6})
        );
    }

    @ParameterizedTest
    @MethodSource("listDoubleReverseTestNominal")
    void listSingleSortTest(ReversedDoubleList collection, int[] expected) {
        collection.reverse();
        int[] actual = collection.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

}