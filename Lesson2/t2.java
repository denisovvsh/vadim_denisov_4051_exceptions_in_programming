public class t2 {
    public static void main(String[] args) {
        try {
            int[] intArray = new int[10]; // Создаем и инициализируем массив
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }
}
