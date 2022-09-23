package br.com.erudio.controller;

import br.com.erudio.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;
import static br.com.erudio.math.Operations.*;
import static br.com.erudio.request.converters.ConverterUtils.convertToDouble;
import static br.com.erudio.request.converters.ConverterUtils.isNumeric;

/**
 * Udemy conta: alexfarw@gmail.com
 * curso Microsserviços do 0 com Spring Cloud, Spring Boot e Docker
 * 09/23/2022
 *
 * Aprendendo como funciona um controller Spring, como mapear as URIs por classe ou
 * métodos; passar parâmetros;
 */
@RestController
public class MathController {

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) {
        if ( !isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a valid number!");
        }
        return soma(convertToDouble(numberOne),convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}",
                    method = RequestMethod.GET)
    public Double subtrair(@PathVariable("numberOne") String numberOne,
                           @PathVariable("numberTwo") String numberTwo) {
        if ( !isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a valid number!");
        }
        return subtrai(convertToDouble(numberOne),convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}",
                    method = RequestMethod.GET)
    public Double div(@PathVariable("numberOne") String numberOne,
                           @PathVariable("numberTwo") String numberTwo) {
        if ( !isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a valid number!");
        }
        //division by zero
        if (numberTwo.equals("0")) {
            throw new UnsupportedMathOperationException("Attention numberTwo cannot be zero!");
        }
        return divide(convertToDouble(numberOne),convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/multiply/{numberOne}/{numberTwo}",
                    method = RequestMethod.GET)
    public Double multiply(@PathVariable("numberOne") String numberOne,
                           @PathVariable("numberTwo") String numberTwo) {
        if ( !isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a valid number!");
        }
        return multiplica(convertToDouble(numberOne),convertToDouble(numberTwo));
    }
}
