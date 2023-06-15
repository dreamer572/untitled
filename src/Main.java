import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String output = calc(input);
        System.out.println(output);
    }

    public static boolean isRoman(String n) {
        return n.indexOf('I') > 0 | n.indexOf('V') > 0 | n.indexOf('X') > 0;
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
        if (amountOps != 1 | amountSpaces != 2)
            throw new Exception(er+"т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");




        String n1 = input.substring(0,input.indexOf(' ')), n2;
        char op = input.charAt(input.indexOf(' ')+1);



        if (input.charAt(0) == 'g') throw new Exception("ggg");

        /*
        обработаем эти исключения здесь
        чтобы в калькуляторе было два операнда один оператор
        чтобы была одна система счисления
        чтобы числа были от 1 до 10
        чтобы числа были целые
         */
        return input;
    }
}