package _05_A;

/*주어진 정수 배열에서 특정 조건을 만족하는 원소들만 오름차순으로 정렬하고 나머지 원소들은 기존 순서를 유지하도록 배열을 재배열하는 프로그램을 작성해볼겁니다. 그러니까 조건이 짝수인 원소인 경우, 배열 내 모든 짝수 원소들만 정렬하고 홀수 원소들은 원래 순서를 변경하지 않아야 합니다.

입력으로 [7, 4, 5, 2, 9, 8]이 주어지면 조건이 짝수라면, 짝수 원소는 [4, 2, 8]이고 정렬하면 [2, 4, 8]이 됩니다.
홀수 원소 [7, 5, 9]는 원래 순서대로 남겨둡니다.

최종 배열을 구성할 때는 원래 배열에서 짝수였던 위치들에는 정렬된 짝수들이 순서대로 들어가고 홀수였던 위치들에는 원래 홀수 값을 그대로 둡니다.
그러면 결과 배열은 [7, 2, 5, 4, 9, 8]가 되겠죠. 프로그램은 조건부 정렬을 구현해야 합니다.

우리가 정렬을 하다 보면 아래 같은 복잡한 부분에서 어려움을 겪을 수 있습니다.
• 조건을 판별하여 별도의 자료구조에 저장한 뒤 정렬하는 로직
• 정렬된 원소들을 다시 원래 배열에 조건에 맞게 끼워 넣는 절차
• 정렬 과정에서 조건을 만족하지 않는 원소를 건너뛰는 방법
(예: 버블 정렬에서 인접한 두 원소를 비교할 때, 둘 중 하나만 조건 만족 대상인 경우 교환 로직을 조정해야 함)
일단 제가 작성한 이 문제에서는 특히 홀수와 짝수의 상대적 순서 유지와 같은 안정성을 고려해야 하기 때문에,
단순하게 버블 정렬을 수정하는 것뿐만 아니라 추가적인 배열 관리가 필요할것입니다. 그로 인해 사고할 요소가 많고,
구현에도 실수가 발생하기 쉽기 때문에 제대로 잡아보겠습니다.

입력
• 첫째 줄에 정수 N이 주어집니다. (1 ≤ N ≤ 1000)
• 둘째 줄에 N개의 정수가 공백으로 구분되어 주어집니다.
• 셋째 줄에 정렬의 조건이 주어집니다. (예: EVEN 또는 ODD 등 특정 조건을 나타내는 문자열)
• EVEN인 경우 짝수인 원소들만 정렬 대상이며, ODD인 경우 홀수인 원소들만 정렬 대상이라고 가정합니다. (다른 조건으로 확장 가능)
출력
• 조건부 정렬을 수행한 후의 배열을 한 줄에 공백으로 구분하여 출력합니다.
예제 입력
6
7 4 5 2 9 8

예제 출력
7 2 5 4 9 8

(위 입력에서 짝수인 원소들 [4, 2, 8]만을 추출해서 정렬하면 [2, 4, 8]이 돼요.
원래 배열의 짝수 위치들에 차례로 채워 넣으면 결과는 [7, 2, 5, 4, 9, 8]입니다. 홀수 원소인 7, 5, 9는 원래 순서를 그대로 유지했습니다.)
제약 조건
• 1 ≤ N ≤ 1000
• 배열 원소는 정수이며, 특정 조건은 문제에서 정의하는 값에 한합니다. (예제에서는 짝수/홀수로 한정)
• 추가적인 메모리를 사용하여 조건에 맞는 원소를 저장하고 정렬하는 것이 가능합니다.
• 시간 복잡도: 배열 전체에 대해 한 번 순회하면서 조건에 맞는 값을 수집(O(N)), 이를 정렬(O(M^2), M은 조건 만족 개수),
  다시 배열에 반영(O(N))하는 방식으로 충분히 해결 가능합니다. N=1000, M ≤ N이라도 수행 시간은 충분합니다.*/

import java.util.Scanner;

public class _02_bubbleSort5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        boolean[] visited = oddCheck(arr);

        bubbleSort(arr, visited);

        printResult(arr);
        sc.close();
    }

    public static boolean[] oddCheck(int[] arr){
        boolean[] visited = new boolean[arr.length];

        int cnt1 = 0;
        int cnt2 = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]%2 == 0){
                visited[i] = true;
            } else {
                visited[i] = false;
            }
        }
        return visited;
    }

    public static void bubbleSort(int[] arr, boolean[] visited) {
        int[] visArr = new int[arr.length];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if(visited[i]){
                visArr[idx] = arr[i];
                idx++;
            }
        }

        for (int i = 0; i < idx; i++) {
            boolean swapped = false;

            for (int j = 0; j < idx-1 - i; j++) {
                if(visArr[j] > visArr[j+1]){
                    int tmp = visArr[j];
                    visArr[j] = visArr[j+1];
                    visArr[j+1] = tmp;
                    swapped = true;
                }
            }

            if(!swapped){
                break;
            }
        }

        idx = 0;

        for (int i = 0; i < arr.length; i++) {
            if(visited[i]){
                arr[i] = visArr[idx++];
            }
        }
    }

    public static void printResult(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}