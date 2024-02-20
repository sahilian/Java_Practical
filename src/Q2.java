public class Q2 {
    public static int isBalanced(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if ((i % 2 == 0 && arr[i] % 2 != 0) || (i % 2 == 1 && arr[i] % 2 == 0)) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 1, 4, 3};  // Balanced
        int[] arr2 = {2, 1, 3};  // Not balanced

        System.out.println(isBalanced(arr1));  // Output: 1
        System.out.println(isBalanced(arr2));  // Output: 0
    }
}