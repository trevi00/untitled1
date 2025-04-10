# 자바 코딩 테스트 대비 배열 메서드 정리

```java
Arrays.sort(arr);  // 오름차순 정렬

// 내림차순
Integer[] arr = {5, 3, 1, 4};
Arrays.sort(arr, Collections.reverseOrder());

// 배열 복사
int[] copy = Arrays.copyOf(arr, arr.length); // 전체 복사
int[] partial = Arrays.copyOfRange(arr, 1, 3); // arr[1] ~ arr[2]


// 배열 채우기
Arrays.fill(arr, 7);         // 전체를 7로 채움
Arrays.fill(arr, 2, 4, 9);   // 인덱스 2~3을 9로 채움


// 배열 최대 최소
int min = Arrays.stream(arr).min().getAsInt();
int max = Arrays.stream(arr).max().getAsInt();

// 배열 합계 평균
int sum = Arrays.stream(arr).sum();
double avg = Arrays.stream(arr).average().getAsDouble();


// 배열을 스트림으로 정렬 & 필터링
int[] sorted = Arrays.stream(arr).sorted().toArray();

int[] even = Arrays.stream(arr)
                   .filter(n -> n % 2 == 0)
                   .toArray();


// 배열에 값이 있는지 확인
boolean hasThree = Arrays.stream(arr).anyMatch(n -> n == 3);

// 배열을 리스트로 전환
int[] arr = {1, 2, 3};
List<Integer> list = Arrays.stream(arr)
                           .boxed()
                           .collect(Collectors.toList());

// 다차원 배열 정렬
// 좌표 정렬
int[][] points = {{1, 2}, {3, 1}, {2, 2}};
Arrays.sort(points, (a, b) -> {
    if (a[0] == b[0]) return a[1] - b[1]; // x 같으면 y 오름차순
    return a[0] - b[0]; // x 오름차순
});

// 배열 뒤집기
Collections.reverse(Arrays.asList(arr));

// int[] 배열 뒤집기
for (int i = 0; i < arr.length / 2; i++) {
    int tmp = arr[i];
    arr[i] = arr[arr.length - 1 - i];
    arr[arr.length - 1 - i] = tmp;
}

/*⚠️ 참고 사항
  Arrays.sort()의 시간 복잡도는 O(n log n)
  Arrays.stream()은 가독성과 편의성은 좋지만, 성능이 중요한 코딩 테스트에선 for문이 더 유리할 수 있음*/
```
