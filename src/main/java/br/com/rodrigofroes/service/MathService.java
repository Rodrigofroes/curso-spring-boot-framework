package br.com.rodrigofroes.service;

import br.com.rodrigofroes.exception.UnsupportedMathOperationException;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    private final static String ERROR_MESSAGE = "Please set a numeric value";

    public Double sum(String numberOne, String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException(ERROR_MESSAGE);
        }

        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    public Double subtraction(String numberOne, String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException(ERROR_MESSAGE);
        }

        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    public Double multiplication(String numberOne, String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException(ERROR_MESSAGE);
        }

        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    public Double division(String numberOne, String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException(ERROR_MESSAGE);
        }

        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    public Double mean(String numberOne, String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException(ERROR_MESSAGE);
        }

        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }

    public Double squareRoot(String number) throws Exception {
        if(!isNumeric(number)) {
            throw new UnsupportedMathOperationException(ERROR_MESSAGE);
        }

        return Math.sqrt(convertToDouble(number));
    }

    private Double convertToDouble(String strNumber) throws Exception {
        if(strNumber == null || strNumber.isEmpty()){
            throw new UnsupportedMathOperationException(ERROR_MESSAGE);
        }

        return Double.parseDouble(strNumber);
    }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()) return false;

        String number = strNumber.replace(",", ".");

        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
