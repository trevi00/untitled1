### 5️⃣ 문제 예제 정리
#### ✅ Example 1: Two Sum
> 배열에서 두 수의 합이 target이 되는 인덱스 반환
```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) {
            return new int[] { map.get(complement), i };
        }
        map.put(nums[i], i);
    }
    return new int[] { -1, -1 };
}
```
⏱ 시간복잡도: O(n), 공간복잡도: O(n)

***

#### ✅ Example 2: 첫 번째 중복 문자 찾기
```java
public char repeatedCharacter(String s) {
    Set<Character> seen = new HashSet<>();
    for (char c : s.toCharArray()) {
        if (seen.contains(c)) return c;
        seen.add(c);
    }
    return ' ';
}
```
⏱ 시간복잡도: O(n), 공간복잡도: O(1) (26자 제한 시)


***

#### ✅ Example 3: x ± 1 없는 숫자 찾기
> x + 1, x - 1이 모두 없는 숫자 찾기
```java
public List<Integer> findNumbers(int[] nums) {
    List<Integer> result = new ArrayList<>();
    Set<Integer> numSet = new HashSet<>();
    for (int num : nums) numSet.add(num);

    for (int num : numSet) {
        if (!numSet.contains(num + 1) && !numSet.contains(num - 1)) {
            result.add(num);
        }
    }

    return result;
}
```
⏱ 시간복잡도: O(n), 공간복잡도: O(n)

***

#### ✅ HashMap vs HashSet vs Array
| 기능       | 	Array |    	HashSet     |     HashMap |
|:---|:------:|:---------------:|------------:|
| 빠른 검색    | ❌ O(n) | ✅ O(1) |     ✅\ O(1) |
| 중복 허용    |   ✅    |        ❌        | ✅ (Key는 고유) |
|Key-Value 저장|	❌|	❌|	✅| |
|정렬 보장|	인덱스 순|	없음|	없음| (언어별 다름)|

#### 🎯 실전 팁
- "if ... in ..." 형태의 존재 확인은 Set/Map으로 리팩토링
- Map.get(k)은 없으면 null 반환 – NPE 주의
- 중복 여부만 따질 땐 Set 사용
- 값 추적, 빈도 수 등 필요하면 Map 사용 
- 가변 키(Array 등)는 문자열이나 Tuple로 변환해서 사용

#### 📌 기억해야 할 공간/시간 복잡도
- 연산	HashMap	HashSet
- 삽입	O(1)	O(1)
- 삭제	O(1)	O(1)
- 조회	O(1)	O(1)
- 존재 확인	O(1)	O(1)
- 공간	O(n)	O(n)
