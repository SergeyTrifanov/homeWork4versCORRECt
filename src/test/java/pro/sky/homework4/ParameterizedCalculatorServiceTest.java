package pro.sky.homework4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.homework4.exception.DivideByZeroException;
import pro.sky.homework4.services.CalculatorServices;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class ParameterizedCalculatorServiceTest {


    private final CalculatorServices calculatorServices = new CalculatorServices();


    @ParameterizedTest
    @MethodSource("paramsForPlus")
    public void plusTest(Integer a,
                         Integer b,
                         Integer expected) {
        assertThat(calculatorServices.plus(a, b)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("paramsForMinus")
    public void minusTest(Integer a,
                          Integer b,
                          Integer expected) {
        assertThat(calculatorServices.minus(a, b)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("paramsForMultiply")
    public void multiplyTest(Integer a,
                             Integer b,
                             Integer expected) {
        assertThat(calculatorServices.multiply(a, b)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("paramsForMultiply")
    public void divideTest(Integer a,
                           Integer b,
                           Integer expected) {
        if (b==0){
            assertThatExceptionOfType(DivideByZeroException.class)
                    .isThrownBy(()->calculatorServices.divide(a, b))
                    .withMessage("Делить на ноль нельзя!" );

        }else {
            assertThat(calculatorServices.divide(a,b)).isEqualTo(expected);
        }

    }
    public static Stream<Arguments> paramsForPlus(){
        return Stream.of(
                Arguments.of(1,2,3),
                Arguments.of(-1,2,1),
                Arguments.of(-10,-6,-16),
                Arguments.of(1,-5,-4),
                Arguments.of(0,0,0)
        );
    }

    public static Stream<Arguments> paramsForMinus() {
        return Stream.of(
                Arguments.of(1, 2, -1),
                Arguments.of(-1, 2, -3),
                Arguments.of(-10, -6, -4),
                Arguments.of(1, -5, 6),
                Arguments.of(0, 0, 0)
        );
    }
    public static Stream<Arguments> paramsForMultiply() {
        return Stream.of(
                Arguments.of(1, 2, 2),
                Arguments.of(-1, 2, -2),
                Arguments.of(-10, -6, 60),
                Arguments.of(1, -5, -5),
                Arguments.of(0, 0, 0)
        );
    }

    public static Stream<Arguments> paramsForDivide() {
        return Stream.of(
                Arguments.of(1, 2, 0.5),
                Arguments.of(1, 2, -0.5),
                Arguments.of(-1, 2, -2),
                Arguments.of(-10, -6, 5D / 3),
                Arguments.of(1, -5, null),
                Arguments.of(0, 0, null)
        );
    }

}
