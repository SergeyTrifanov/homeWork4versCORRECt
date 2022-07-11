package pro.sky.homework4;

import org.junit.jupiter.api.Test;
import pro.sky.homework4.exception.DivideByZeroException;
import pro.sky.homework4.services.CalculatorServices;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class CalculatorServiceTest {


    private final CalculatorServices calculatorServices = new CalculatorServices();

    @Test
    public void plusTest() {
        Number actual = calculatorServices.plus(2, 3);
        assertThat(actual).isEqualTo(5);

        actual = calculatorServices.plus(-3, 1);
        assertThat(actual).isEqualTo(-2);
    }

    @Test
    public void minusTest() {
        Number actual = calculatorServices.minus(2, 3);
        assertThat(actual).isEqualTo(-1);

        actual = calculatorServices.minus(-3, 1);
        assertThat(actual).isEqualTo(-4);
    }
    @Test
    public void multiplyTest() {
        Number actual = calculatorServices.multiply(2, 3);
        assertThat(actual).isEqualTo(6);

        actual = calculatorServices.multiply(-3, 1);
        assertThat(actual).isEqualTo(-3);
    }

    @Test
    public void dividePositiveTest() {
        Number actual = calculatorServices.divide(1, 2);
        assertThat(actual).isEqualTo(0.5);

        actual = calculatorServices.divide(-3, 1);
        assertThat(actual).isEqualTo(-3D);
    }

    @Test
    public void divideNegativeTest(){
        assertThatExceptionOfType(DivideByZeroException.class)
                .isThrownBy(()->calculatorServices.divide(1, 0))
                .withMessage("делить на ноль нельзя!");


        assertThatExceptionOfType(DivideByZeroException.class)
                .isThrownBy(()->calculatorServices.divide(-1, 0))
                .withMessage("делить на ноль нельзя!");

    }

}
