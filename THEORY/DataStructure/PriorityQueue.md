# 우선순위 큐(Priority Queue)


## 인트로 🙋‍♂
난이도있는 BFS 문제를 풀다가 갑작스럽게 우선순위 큐를 만나게 됐다.
자료구조에서 배웠던 것 같은데.. 알고리즘 문제에 실제로 적용해본적이 없다보니
너무 낯설고 복잡해보이는 구현과정이 정리가 되지 않아 이번 알고리즘 첫 이론 주제로 조금이나마 정리해보자 !



##  우선순위 큐가 뭐야 ? 🤔
우리가 자료구조에서 배우는 큐와 달리 우선순위 큐는 저장된 데이터중에서 우선순위를 매겨
정렬된 데이터로 사용할 수 있게 해주는데 일반적으로 힙(Heap)이라는 자료구조를 이용해서
구현돼요.



### PriorityQueue 함수들 ✔️

<table>
    <tr>
        <th>메서드</th>
        <th>기능</th>
        <th>비고</th>
    </tr>
    <tr>
        <td>queue.offer(E e)</td>
        <td>값 추가</td>
        <td>queue.add(E e)</td>
    </tr>
    <tr>
        <td>queue.poll()</td>
        <td>우선순위 값 꺼내기</td>
        <td></td>
    </tr>
    <tr>
        <td>queue.remove(Object o)</td>
        <td>해당 인덱스 값 제거</td>
        <td></td>
    </tr>
    <tr>
        <td>queue.clear()</td>
        <td>큐 초기화</td>
        <td></td>
    </tr>
    <tr>
        <td>queue.peak()</td>
        <td>우선순위 가장 높은 값 출력</td>
        <td>stack.peak()</td>
    </tr>
    <tr>
        <td>queue.size()</td>
        <td>현재 큐 크기 출력</td>
        <td></td>
    </tr>
</table>


## PriorityQueue 사용하기✍️
PriorityQueue 객체는 컬렉션 객체이므로 제너릭으로 데이터 타입을 명시해주어야 해요!

```java
PriorityQueue<Integer> queue = new PriorityQueue<>();
PriorityQueue<Integer> queue = new PriorityQueue<>(
                          Collections.reverseOrder());
```
기본적으로 우선순위가 낮은 순으로 정렬이 되지만 reverseOrder() 메서드를 통해
우선순위를 바꿀 수 있어요 !

또 다른 방법으로는 클래스에 Comparable&#60;T>  인터페이스를 상속하는 방법이 있어요.
Comparable&#60;T> 인터페이스에 정의된 CompareTo 메서드를 통해 객체를 큐로 다루게 될 때 우선순위를 조건에 맞게 정의할 수 있어요.

```java
static class Node implements Comparable<Node> {
    int v;
    int w;

    public Node(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return this.w - o.w;
    }
}
 public static void main(String[] args) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(1, 2));
    pq.offer(new Node(2, 1));
    pq.offer(new Node(3, 4));
    pq.offer(new Node(4, 8));

    int size = pq.size();
    for (int i = 0; i < size; i++) {
        System.out.print(pq.poll().v + " ");
    }
}
```

결과 : 2 1 3 4


## 마무리 ✍
- 기존 큐에 우선순위 조건이 들어간 방식으로 가중치와 같은 추가적인 조건에서 유리해요.
- 우선순위 큐를 다루기 위해 큐(Queue)의 구조와 힙(Heap)의 구조를 알고 있는 것이 좋아요.



