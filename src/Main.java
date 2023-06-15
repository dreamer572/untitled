import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String output = calc(input);
        System.out.println(output);
    }


    public static String calc(String input) throws Exception {

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