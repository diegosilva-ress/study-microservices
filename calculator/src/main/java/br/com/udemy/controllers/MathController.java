package br.com.udemy.controllers;

import br.com.udemy.converters.NumberConverter;
import br.com.udemy.exception.UnsupportedMathOperationException;
import br.com.udemy.math.SimpleMath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @Autowired
    private SimpleMath math;

    @Autowired
    private NumberConverter converter;


    @RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        validateInput(numberOne, numberTwo);
        return math.sum(converter.convertToDouble(numberOne), converter.convertToDouble(numberTwo));
    }

    @RequestMapping(value="/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        validateInput(numberOne, numberTwo);
        return math.subtraction(converter.convertToDouble(numberOne), converter.convertToDouble(numberTwo));
    }

    @RequestMapping(value="/multiplication/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        validateInput(numberOne, numberTwo);
        return math.multiplication(converter.convertToDouble(numberOne), converter.convertToDouble(numberTwo));
    }

    @RequestMapping(value="/division/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        validateInput(numberOne, numberTwo);
        return math.division(converter.convertToDouble(numberOne), converter.convertToDouble(numberTwo));
    }


    @RequestMapping(value="/mean/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        validateInput(numberOne, numberTwo);
        return math.mean(converter.convertToDouble(numberOne), converter.convertToDouble(numberTwo));
    }

    @RequestMapping(value="/squareRoot/{number}", method=RequestMethod.GET)
    public Double squareRoot(@PathVariable("number") String number) {
        validateInput(number);
        return math.squareRoot(converter.convertToDouble(number));
    }

    private void validateInput(String number) {
        if (!converter.isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
    }

    private void validateInput(String numberOne, String numberTwo) {
        if (!converter.isNumeric(numberOne) || !converter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
    }
}
