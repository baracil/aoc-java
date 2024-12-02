package fpc.aoc.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static fpc.aoc.common.Transformation.of;

public class TransformationTest {


  public static Stream<Arguments> rotationTests() {
    return Stream.of(
        Arguments.of(of(Rotation._000, Flipping.NONE), Rotation._000, of(Rotation._000, Flipping.NONE)),
        Arguments.of(of(Rotation._090, Flipping.NONE), Rotation._000, of(Rotation._090, Flipping.NONE)),
        Arguments.of(of(Rotation._180, Flipping.NONE), Rotation._000, of(Rotation._180, Flipping.NONE)),
        Arguments.of(of(Rotation._270, Flipping.NONE), Rotation._000, of(Rotation._270, Flipping.NONE)),

        Arguments.of(of(Rotation._000, Flipping.NONE), Rotation._090, of(Rotation._090, Flipping.NONE)),
        Arguments.of(of(Rotation._090, Flipping.NONE), Rotation._090, of(Rotation._180, Flipping.NONE)),
        Arguments.of(of(Rotation._180, Flipping.NONE), Rotation._090, of(Rotation._270, Flipping.NONE)),
        Arguments.of(of(Rotation._270, Flipping.NONE), Rotation._090, of(Rotation._000, Flipping.NONE)),

        Arguments.of(of(Rotation._000, Flipping.NONE), Rotation._180, of(Rotation._180, Flipping.NONE)),
        Arguments.of(of(Rotation._090, Flipping.NONE), Rotation._180, of(Rotation._270, Flipping.NONE)),
        Arguments.of(of(Rotation._180, Flipping.NONE), Rotation._180, of(Rotation._000, Flipping.NONE)),
        Arguments.of(of(Rotation._270, Flipping.NONE), Rotation._180, of(Rotation._090, Flipping.NONE)),

        Arguments.of(of(Rotation._000, Flipping.NONE), Rotation._270, of(Rotation._270, Flipping.NONE)),
        Arguments.of(of(Rotation._090, Flipping.NONE), Rotation._270, of(Rotation._000, Flipping.NONE)),
        Arguments.of(of(Rotation._180, Flipping.NONE), Rotation._270, of(Rotation._090, Flipping.NONE)),
        Arguments.of(of(Rotation._270, Flipping.NONE), Rotation._270, of(Rotation._180, Flipping.NONE)),

        Arguments.of(of(Rotation._000, Flipping.HORIZONTAL), Rotation._000, of(Rotation._000, Flipping.HORIZONTAL)),
        Arguments.of(of(Rotation._090, Flipping.HORIZONTAL), Rotation._000, of(Rotation._090, Flipping.HORIZONTAL)),
        Arguments.of(of(Rotation._180, Flipping.HORIZONTAL), Rotation._000, of(Rotation._180, Flipping.HORIZONTAL)),
        Arguments.of(of(Rotation._270, Flipping.HORIZONTAL), Rotation._000, of(Rotation._270, Flipping.HORIZONTAL)),

        Arguments.of(of(Rotation._000, Flipping.HORIZONTAL), Rotation._090, of(Rotation._090, Flipping.VERTICAL)),
        Arguments.of(of(Rotation._090, Flipping.HORIZONTAL), Rotation._090, of(Rotation._180, Flipping.VERTICAL)),
        Arguments.of(of(Rotation._180, Flipping.HORIZONTAL), Rotation._090, of(Rotation._270, Flipping.VERTICAL)),
        Arguments.of(of(Rotation._270, Flipping.HORIZONTAL), Rotation._090, of(Rotation._000, Flipping.VERTICAL)),

        Arguments.of(of(Rotation._000, Flipping.HORIZONTAL), Rotation._180, of(Rotation._180, Flipping.HORIZONTAL)),
        Arguments.of(of(Rotation._090, Flipping.HORIZONTAL), Rotation._180, of(Rotation._270, Flipping.HORIZONTAL)),
        Arguments.of(of(Rotation._180, Flipping.HORIZONTAL), Rotation._180, of(Rotation._000, Flipping.HORIZONTAL)),
        Arguments.of(of(Rotation._270, Flipping.HORIZONTAL), Rotation._180, of(Rotation._090, Flipping.HORIZONTAL)),

        Arguments.of(of(Rotation._000, Flipping.HORIZONTAL), Rotation._270, of(Rotation._270, Flipping.VERTICAL)),
        Arguments.of(of(Rotation._090, Flipping.HORIZONTAL), Rotation._270, of(Rotation._000, Flipping.VERTICAL)),
        Arguments.of(of(Rotation._180, Flipping.HORIZONTAL), Rotation._270, of(Rotation._090, Flipping.VERTICAL)),
        Arguments.of(of(Rotation._270, Flipping.HORIZONTAL), Rotation._270, of(Rotation._180, Flipping.VERTICAL)),

        Arguments.of(of(Rotation._000, Flipping.HORIZONTAL), Rotation._000, of(Rotation._180, Flipping.VERTICAL)),
        Arguments.of(of(Rotation._090, Flipping.HORIZONTAL), Rotation._000, of(Rotation._270, Flipping.VERTICAL)),
        Arguments.of(of(Rotation._180, Flipping.HORIZONTAL), Rotation._000, of(Rotation._000, Flipping.VERTICAL)),
        Arguments.of(of(Rotation._270, Flipping.HORIZONTAL), Rotation._000, of(Rotation._090, Flipping.VERTICAL))
    );
  }

  @ParameterizedTest
  @MethodSource("rotationTests")
  public void testRotationComposition(Transformation input, Rotation rotation, Transformation expected) {
    Assertions.assertEquals(expected, input.compose(rotation));

  }
}
