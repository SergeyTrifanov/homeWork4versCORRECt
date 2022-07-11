package pro.sky.homework4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework4.services.CalculatorServices;

import java.util.Objects;

@RestController
@RequestMapping("/calculator")

public class CalculatorController {
    private final CalculatorServices calculatorServices;

    public CalculatorController(CalculatorServices calculatorServices) {
        this.calculatorServices = calculatorServices;
    }
    @GetMapping
    public String greetings() {
        return calculatorServices.greetings();
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(value = "num1", required = false) Float a,
                       @RequestParam(value = "num2", required = false) Float b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return "не верно переданы параметры";
        }
        return buildString (a,b, calculatorServices.plus(a,b), "+");
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(value = "num1", required = false) Float a,
                       @RequestParam(value = "num2", required = false) Float b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return "не верно переданы параметры";
        }
        return buildString(a,b, calculatorServices.minus(a,b), "-");
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(value = "num1", required = false) Float a,
                       @RequestParam(value = "num2", required = false) Float b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return "не верно переданы параметры";
        }
        return buildString(a,b, calculatorServices.multiply(a,b), "*");
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(value = "num1", required = false) Float a,
                           @RequestParam(value = "num2", required = false) Float b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return "не верно переданы параметры";
        }
        if (b==0){
            return "на ноль делить нельзя";
        }
        return buildString(a,b, calculatorServices.divide(a,b), "/");
    }


    private String buildString(float a,
                               float b,
                               float result,
                               String operation) {
    return String.format("%.1f %s %.1f = %.1f", a,operation, b, result);
    }

}