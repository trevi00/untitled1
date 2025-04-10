### 🧠 Java에서 HashMap<K, V> 핵심 정리
#### 동작	메서드	설명
> 선언	Map<K, V> map = new HashMap<>();	제네릭을 통해 키/값 타입 지정
> 값 추가	put(key, value)	키가 없으면 추가, 있으면 갱신
> 값 조회	get(key)	키에 해당하는 값 리턴 (null일 수 있음)
> 존재 확인	containsKey(key)	키가 있는지 확인
> 삭제	remove(key)	해당 키 제거
> 크기 확인	size()	현재 키-값 쌍의 수
> 전체 키 반복	keySet()	모든 키 반복
> 전체 값 반복	values()	모든 값 반복

