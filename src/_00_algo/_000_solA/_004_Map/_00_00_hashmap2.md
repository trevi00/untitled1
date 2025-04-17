# 📚 Hashing 정리 (with Java Code Examples)

## 🔎 개요

**Hashing**은 데이터를 해시 함수를 통해 정수로 매핑하여 빠르게 검색, 삽입, 삭제 등을 수행할 수 있게 하는 기술입니다.  
이 기술은 **HashMap**과 **HashSet**과 같은 핵심 자료구조의 기반이 됩니다.

---

## 1️⃣ 해시 함수란?

- 입력(Key)을 **고정 범위의 정수**로 매핑하는 함수
- 같은 입력은 항상 같은 출력을 가짐
- 예시 해시 함수:
```java
int total = 0;
for (int i = 0; i < s.length(); i++) {
    char c = s.charAt(i);
    int charValue = c - 'a' + 1; // a = 1, b = 2, ..., z = 26
    total += charValue * (i + 1);
}
int hashValue = total % x;
```

## 2️⃣ HashMap이란?
- Key-Value 쌍 저장
- Key는 불변 객체여야 함 (예: String, Integer)
- 내부적으로 배열 + 해시함수를 조합하여 동작

### 💡 주요 메서드 (Java)
``` java
Map<Integer, String> map = new HashMap<>();

map.put(1, "One");              // 삽입
map.put(1, "Updated");          // 업데이트
String value = map.get(1);      // 조회
boolean exists = map.containsKey(1); // 존재 확인
map.remove(1);                  // 삭제
int size = map.size();          // 크기
```

### 반복 예시
```java
for (Integer key : map.keySet()) {
    System.out.println(key + ": " + map.get(key));
}

for (String val : map.values()) {
    System.out.println(val);
}
```

### 3️⃣ HashSet이란?
- 값(Value)만 저장
- 중복 X, 순서 X
- 내부적으로는 해시맵의 Key만 사용

### 💡 주요 메서드 (Java)
```java
Set<String> set = new HashSet<>();

set.add("apple");
set.contains("apple"); // true
set.remove("apple");
```

### 4️⃣ 충돌(Collision)과 해결
- 두 키가 같은 해시값 → 충돌 
- 해결 방법 중 하나: 체이닝(Chaining)
- → 같은 인덱스에 연결 리스트로 키-값 저장 
- 해시 테이블의 크기는 소수(prime number) 선택 추천 
- 10007, 1_000_003, 1_000_000_007 등

