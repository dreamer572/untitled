import java.util.Scanner;
public class Main {
    public static boolean isAlpha(String s) {
        if (s == null)
            return false;
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z'))
                return false;
        }
        return true;
    }
    public static boolean isRoman(String n) {
        return n.indexOf('I') != -1 | n.indexOf('V') != -1 | n.indexOf('X') != -1;
    }

    public static int toArabic(String st) {//если число больше 10 метод выдаёт -1
        if (st.equals("I")) return 1;
        if (st.equals("II")) return 2;
        if (st.equals("III")) return 3;
        if (st.equals("IV")) return 4;
        if (st.equals("V")) return 5;
        if (st.equals("VI")) return 6;
        if (st.equals("VII")) return 7;
        if (st.equals("VIII")) return 8;
        if (st.equals("IX")) return 9;
        if (st.equals("X")) return 10;
        return -1;
    }
    public static String arabicToRoman(final int number) {
        if (number < 0 || 4000 <= number) {
            throw new IllegalArgumentException();
        }
        String[] nums = { "I", "V", "X", "L", "C", "D", "M" };
        int numCounter = 0;
        String result = "";
        StringBuilder partResult = new StringBuilder();
        int numeral;
        String stringNumber = String.valueOf(number);
        for (int i = stringNumber.length() - 1; i >= 0; i--) {
            partResult.delete(0, partResult.length());
            numeral = Integer.parseInt(stringNumber.substring(i, i + 1));
            if (1 <= numeral && numeral < 4) {
                for (int j = 0; j < numeral; j++) {
                    partResult.append(nums[numCounter]);
                }
                numCounter += 2;
            } else if (4 <= numeral && numeral < 9) {
                numCounter += 2;
                if (numeral == 4) {
                    partResult.append(nums[numCounter - 2]);
                }
                partResult.append(nums[numCounter - 1]);
                for (int j = 0; j < (numeral - 5); j++) {
                    partResult.append(nums[numCounter - 2]);
                }
            } else if (numeral == 9) {
                numCounter += 2;
                partResult.append(nums[numCounter - 2] + nums[numCounter]);
            } else if (numeral == 0) {
                numCounter += 2;
            }
            result = partResult.append(result).toString();
        }
        return result;
    }
    public static String calc(String input) throws Exception {
        String er = "throws Exception //";
        //если больше двух пробелов ошибка
        //если больше двух операндов ошибка
        char[] ops = {'+','-','*','/'};
        int amountOps = 0, amountSpaces = 0;
        for (int i = 0; i < input.length(); i++)
            if (input.charAt(i) == ' ')
                amountSpaces++;
            else
                for (int j = 0; j < ops.length; j++)
                    if (input.charAt(i) == ops[j])
                        amountOps++;
        if (amountSpaces == 0)
            throw new Exception(er+"т.к. строка не является математической операцией");
        if (amountOps != 1 | amountSpaces != 2)
            throw new Exception(er+"т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        if (input.indexOf('.') > 0 | input.indexOf(',') > 0)
            throw new Exception(er+"т.к нельзя использовать дробные числа");
        String st1 = input.substring(0,input.indexOf(' ')), st2 = input.substring(input.lastIndexOf(' ')+1, input.length());
        char op = input.charAt(input.indexOf(' ')+1);
        if (isRoman(st1) ^ isRoman(st2))
            throw new Exception(er+"используются одновременно разные системы счисления");
        int[] n = new int[2];
        if (isRoman(st1) & isRoman(st2)) {
            n[0] = toArabic(st1);
            n[1] = toArabic(st2);
        }
        else if (isAlpha(st1) | isAlpha(st2))
            throw new Exception(er+"т.к букв не должно быть");
        else {
            n[0] = Integer.parseInt(st1);
            n[1] = Integer.parseInt(st2);
        }
        for (int nn : n)
            if (nn > 10 | nn < 1)
                throw new Exception(er+"числа должны быть от 1 до 10 включительно");
        int res = 0;
        if (op == '+')
            res = n[0] + n[1];
        else if (op == '-')
            res = n[0] - n[1];
        else if (op == '*')
            res = n[0] * n[1];
        else if (op == '/')
            res = n[0] / n[1];
        if (isRoman(st1)) {
            if (res < 1)
                throw new Exception(er + "т.к. в римской системе нет отрицательных чисел");
            return arabicToRoman(res);
        }
        return String.valueOf(res);
    }
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String output = calc(input);
        System.out.println(output);
        in.close();
    }
}