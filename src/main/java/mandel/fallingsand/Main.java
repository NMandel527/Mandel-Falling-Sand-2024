package mandel.fallingsand;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sand sand = new Sand(50, 10);
        Scanner input = new Scanner(System.in);
        sand.randomSand(50);
        while (true) {
            System.out.println("Enter");
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
