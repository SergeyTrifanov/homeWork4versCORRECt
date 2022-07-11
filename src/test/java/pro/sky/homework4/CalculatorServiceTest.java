package pro.sky.homework4;

import org.junit.jupiter.api.Test;
import pro.sky.homework4.services.CalculatorServices;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorServiceTest {


    private final CalculatorServices calculatorServices = new CalculatorServices();

    @Test
    public void plusTest(){
        Number actual = calculatorServices.plus(2, 3);
        assertThat(actual).isEqualTo(5);

        actual = calculatorServices.plus(-3, 1);
        assertThat(actual).isEqualTo(-2);

    }
}
