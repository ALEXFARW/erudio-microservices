package br.com.erudio.request.converters;

public class ConverterUtils {

    public static Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0d;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0d;
    }

    public static boolean isNumeric(String strNumber) {
        if (strNumber==null) return  false;
        String str = strNumber.replaceAll(",",".");
        return str.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
