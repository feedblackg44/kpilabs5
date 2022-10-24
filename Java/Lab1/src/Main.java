public class Main {
    public static void main(String[] args) {
        int result = GetResult(100);
        System.out.println("---------------");
        System.out.println(result);
    }
    public static int GetResult(int n) {
        if (n < 3)
            return -1;
        int number = 3;
        int amountOfZero = 0;
        for (int i = 3; i <= n; i++) {
            if (isPrime(i)) {
                int temp = Integer.toBinaryString(i).replaceAll("1", "").length();
                System.out.format("%d - %s\n", i, Integer.toBinaryString(i));
                if (temp > amountOfZero) {
                    amountOfZero = temp;
                    number = i;
                }
            }
        }
        return number;
    }
    public static boolean isPrime(int n)
    {
        if (n <= 1)
            return false;
        else if (n % 2 == 0)
            return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}