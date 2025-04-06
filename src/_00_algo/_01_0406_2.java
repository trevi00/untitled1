package _00_algo;

public class _01_0406_2 {
    public static void main(String[] args) {
        int[] numbers = {2, 1, 3, 4, 1};
        Solution2 s2 = new Solution2();
        int[] result = s2.solution(numbers);

        for (int num : result) {
            System.out.print(num + " ");
        }
        // 출력: 2 3 4 5 6 7
    }
}

class Solution2 {
    public static int[] solution(int[] numbers) {
        int[] temp = new int[(numbers.length * (numbers.length - 1)) / 2];
        int index = 0;

        // 서로 다른 인덱스의 두 수를 더함
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];

                // 중복 확인 후만 추가
                if (!contains(temp, index, sum)) {
                    temp[index++] = sum;
                }
            }
        }

        // 필요한 만큼만 복사
        int[] result = new int[index];
        for (int i = 0; i < index; i++) {
            result[i] = temp[i];
        }

        // 정렬 (버블 정렬 사용)
        bubbleSort(result);

        return result;
    }

    // 배열 내 중복 확인
    private static boolean contains(int[] arr, int size, int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) return true;
        }
        return false;
    }

    // 버블 정렬
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped) break; // 이미 정렬되어 있음
        }
    }
}