public class ArrayPossibilitiesChecker {
    public static int isAllPossibilities(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        boolean[] visited = new boolean[A.length];

        for (int num : A) {
            if (num < 0 || num >= A.length || visited[num]) {
                return 0;
            }
            visited[num] = true;
        }
        for (boolean visit : visited) {
            if (!visit) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] arr1 = {0, 1, 2, 3};
        int[] arr2 = {0, 2, 3};

        System.out.println(isAllPossibilities(arr1)); // Output: 1
        System.out.println(isAllPossibilities(arr2)); // Output: 0
    }
}
