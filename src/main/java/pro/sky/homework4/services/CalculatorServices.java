package pro.sky.homework4.services;

import org.springframework.stereotype.Service;
import pro.sky.homework4.exception.DivideByZeroException;
import pro.sky.homework4.interfaces.CalculatorInterface;

@Service
public class CalculatorServices implements CalculatorInterface {

    public String greetings(){
        return "Добро пожаловать в калькулятор";
    }

    public float plus(float a, float b){
        return a+b;
    }

    public float minus(float a, float b){
        return a-b;
    }

    public float multiply(float a, float b){
        return a*b;
    }

    public float divide(float a, float b){
        if (b==0){
            throw new DivideByZeroException("delit na 0 nelzya");
        }
        return a / b;
    
    }

}
