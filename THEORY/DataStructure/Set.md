<h1>set</h1> 

**Intro**
1. [**set 이란?**](#set-이란)
2. [**set은 되고 list는 안되는 이유**](#set은-되고-list는-안되는-이유)
3. [**HashSet 내부 작동 과정**](#hashset-내부-작동-과정)
4. [**마치며**](#마치며)


### Intro

사실 set을 사용하는 일은 극히 드물다. 특별한 상황을 제외하면 대부분 array나 list에 담아서 사용하기 때문에    
중복제거 외에는 딱히 쓸 일이 생각 나지 않는다. 하지만 set의 특징을 알고 잘 활용한다면 생각보다 쓰임이 많을 것이다.   
우선 이 문제를 풀어보자.

<img src="https://static.solved.ac/tier_small/7.svg" width="14" height="14">[11723.듣보잡](https://boj.kr/1764)

단순한 탐색 문제로 배열에 넣으면 *시간 초과*로 실패가 된다. 물론 탐색 알고리즘으로 해결 할 수 있지만   
set을 이용하면 이 문제는 간단히 해결된다. 

### set 이란?

set을 구현하는 클래스에는 HashSet,TreeSet,LinkedHashSet이 있는데 공통적인 특징으로는 다음과 같다.

- 중복을 허용하지 않는다.
- 입력 순서를 보장하지 않는다.(LinkedHashSet은 입력 순서가 보장된다.)

그리고 공통적으로 사용 가능한 메소드는 다음과 같다.(인덱스로 관리하지 않기 때문에 인덱스를 매개값으로 하는 메소드는 없다.)


<table>
    <tr>
        <th>기능</th>
        <th>메소드</th>
        <th>설명</th>
    </tr>
    <tr>
        <td>객체 <br>추가 </td>
        <td> boolean add(E e)</td>
        <td> 주어진 객체 저장</td>
    </tr>
    <tr>
        <td rowspan="3">객체 <br>검색 </td>
        <td> boolean contians(Object o)</td>
        <td> 저장되어 있는지 여부</td>
    </tr>
    <tr>
        <td> int size()</td>
        <td> 저장되어 있는 객체 수</td>
    </tr>
    <tr>
        <td> boolean isEmpty()</td>
        <td> 비어 있는지 여부</td>
    </tr>
    <tr>
        <td rowspan="2">객체 <br>삭제 </td>
        <td>void clear()</td>
        <td>저장된 모든 객체 삭제</td>
    </tr>
    <tr>
        <td> blooean remove(Object o)</td>
        <td> 주어진 객체를 삭제</td>
    </tr>
</table>

[더알고 싶다면 여기로 가보자](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Set.html)

그럼 다시 문제로 돌아가서 문제를 풀기위해 코드를 어떻게 짜면 좋을까?

```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N =Integer.parseInt(st.nextToken());
        int M =Integer.parseInt(st.nextToken());

        Set<String> set= new HashSet();
        StringBuilder sb = new StringBuilder();
        int count=0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            set.add(s);
        }

        ArrayList<String> str = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String s1 =br.readLine();
            if(set.contains(s1)){
                count++;
               str.add(s1);
            }
        }
        Collections.sort(str);
        System.out.println(count);
        str.stream().forEach(s -> System.out.println(s));
    }
}


```
### set은 되고 list는 안되는 이유

사실 이글을 쓴 이유는 왜 set은 되고 list는 안될까가 궁금해서다. 그래서 list와 set Contains 메소드 시간 복잡도를 알아보았다.
>list

Contains    : O(n)

>set

Contains    : O(1)

라고 하는데 사실 정확히 말해서 set이 빠르게 탐색가능한 이유는 hashmap을 사용하기 때문이다.(treeMap을 사용하는 TreeSet은   
O(log n)이다.)    

혹시 hash에 대해 알고 싶다면 이 문제를 풀어보자.

<img src="https://static.solved.ac/tier_small/4.svg" width="14" height="14">[15829.Hashing](https://boj.kr/1764)

### HashSet 내부 작동 과정
```java
public class HashSet<E>
    extends AbstractSet<E>
    implements Set<E>, Cloneable, java.io.Serializable {
    static final long serialVersionUID = -5024744406713321676L;

    private transient HashMap<E, Object> map;//transient는 Serializable에서 제외하고 싶을떄

    // Dummy value to associate with an Object in the backing Map
    private static final Object PRESENT = new Object();

    /**
     * Constructs a new, empty set; the backing <tt>HashMap</tt> instance has
     * default initial capacity (16) and load factor (0.75).
     */
    public HashSet() {
        map = new HashMap<>();
    }
}
```
탐색
```java
public boolean contains(Object o) {
        return map.containsKey(o);
    }// 특별한게 있는 줄 알았는데 그냥 이거 밖에 없다
```
추가
```java
 public boolean add(E e) {
        return map.put(e, PRESENT)==null;
    }
```
HashSet은 내부적으로 HashMap으로 구현되어 있다. Key Object에 저장하고 Value Object에는 dummy data(PRESENT)를 집어 넣는다.   
key Object는 고유해야 하기 때문에 중복으로 저장되는 일은 없다. HashSet이 중복없이 Set을 만드는 과정은 다음과 같다.

- 저장하려는 객체의 hashCode()를 호출
- 저장된 객체 중 같은 hashCode()가 있는지 판단
- 같은 hashCode() 객체가 있다면 equals()로 동일성 여부 판단
- 만약 equals() 반환값이 true라면 동일한 객체로 판단하고 저장하지 않는다.

### 마치며

그래서 결국 set 탐색뿐만 아니라 기초적인 작동들(add, remove and size) 속도가 빠른 이유는 hashmap을 마치 인덱스값을 알고 있는 배열처럼  생각하면 될 것 같다  
앞으로 빠르게 탐색할 일이 있다면 set을 사용해보자. 그리고 아는게 많이 없어서 뭔가 추가적으로 알아낸것이 있다면 더 추가 해야될듯 하다
set을 온전히 이해하기 위해서 map에 대한 이해가 선행되야 될거 같다.

