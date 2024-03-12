package mandel.fallingsand;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sand sand = new Sand(50, 10);
        sand.randomSand(50);
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("enter");
            String enter = input.nextLine();
            if (enter.isEmpty()) {
                sand.fall();
                System.out.println(sand.toString());
            } else {
                break;
            }
        }
    }
}
