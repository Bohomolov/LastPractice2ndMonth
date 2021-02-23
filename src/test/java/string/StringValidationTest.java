package string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StringValidationTest {
    private final StringValidator stringValidator;

    StringValidationTest() {
        stringValidator = new StringValidator();
    }

    static Stream<Arguments> stringValidationTest() {
        return Stream.of(
                Arguments.arguments("[]", true),
                Arguments.arguments("{}", true),
                Arguments.arguments("()", true),
                Arguments.arguments("[](){}", true),
                Arguments.arguments("[()]{}", true),
                Arguments.arguments("[[]]", true),
                Arguments.arguments("{(())}{[]}", true),
                Arguments.arguments("([]){}{()}{[]}", true),
                Arguments.arguments("([]{{[]()}}{()})", true),
                Arguments.arguments("][", false),
                Arguments.arguments("}", false),
                Arguments.arguments("[)", false),
                Arguments.arguments("[){}", false),
                Arguments.arguments("[(]{}", false),
                Arguments.arguments("[[]", false),
                Arguments.arguments("{}{", false),
                Arguments.arguments("[][}", false),
                Arguments.arguments(null, false)
        );
    }

    @ParameterizedTest
    @MethodSource("stringValidationTest")
    void StringValidationTestMain(String str, boolean expected) {
        assertEquals(expected, stringValidator.chekString(str));
    }
}