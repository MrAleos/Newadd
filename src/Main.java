import java.io.StringReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение без пробела от 1 до 10");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));

    }

    public static String calc (String input) throws Exception {
        int a = 0;
        int b = 0;
        String result = "";
        String mark = "";
        String [] numberSplit = input.split("[/+\\-*]");
        if (numberSplit.length != 2 ) throw new Exception ("Неверное выражение!");
        mark = mark(input);
        if (isProbablyArabic(numberSplit[0]) && isProbablyArabic(numberSplit[1])) {
            a = Integer.parseInt(numberSplit[0]);
            b = Integer.parseInt(numberSplit[1]);
            if (a > 10 && b > 10) throw new Exception("Неверное выражение!");
            int c = mathOperation(a,b,mark);
            result = String.valueOf(c);
        } else {
            a = romanNumber(numberSplit[0]);
            b = romanNumber(numberSplit[1]);
            if (a == 0 || b == 0) throw new Exception("Неверное выражение!");
            int c = mathOperation(a,b,mark);
            result = RomanNumber.toRoman(c);
        }
        return result;
    }
    public static boolean isProbablyArabic (String s) {
        boolean f = switch (s) {
            case "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" -> true;
            default -> false;
        };
        return f;
    }

    public static int romanNumber (String s) {
        int output = switch (s) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> 0;
        };
        return output;
    }

    public static String mark (String input) {
        String result = "";
        if (input.contains("+")) {
            result = "+";
        }
        else if (input.contains("-")) {
            result = "-";
        }
        else if (input.contains("*")) {
            result = "*";
        }
        else if (input.contains("/")) {
            result = "/";
        }
        return result;
    }

    public static int mathOperation (int number1, int number2, String mark) {
        int result = switch (mark) {
            case "+" -> number1 + number2;
            case "-" -> number1 - number2;
            case "*" -> number1 * number2;
            case "/" -> number1 / number2;
            default -> 0;
        };

        return result;
    }
}