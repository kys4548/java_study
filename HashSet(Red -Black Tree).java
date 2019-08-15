Binary Search Tree(BST)
검색, 삽입, 삭제의 시간이 O(h) h: tree의 높이
최악의 경우 n과 h가 같을수가 있다.


Red-Black Tree
BST의 최악의 경우를 방지하기 위해 만든 Tree

 이진탐색트리의 일종
 균형잡힌 트리 : 높이가 O(log2n)
 search, insert, delete 연산을 최악의 경우에도 o(log2n)시간에 지원

-각 노드는 하나의 vlaue, 왼쪽자식, 오른쪽 자식 그리고 부모노드의 주소를 저장
-자식 노드가 존재하지 않을 경우 NIL 노드라는 특수한 노드가 있다고 가정 (가상적인 개념)
-따라서 모든 리프노드는 NIL노드 
-루트의 부모도 NIL노드라고 가정
-노드들은 내부노드와 NIL노드로 분류


다음 조건을 만족하는 이진탐색트리
* 각 노드는 RED 혹은 BLACK
* 루트노드, 모든 리프노드(NIL)은 BLACK
* RED노드의 자식노드들은 전부 BLACK(즉 RED노드는 연속되어 나오지 않는다.)
* 모든 노드에 대해서 그 노드로부터 자손인 리프노드에 이르는 모든 경로에는 동일한
  개수의 BLACK의 노드가 존재한다. ==>가장 중요

left and right rotation 
시간 복잡도 O(1), 이진탐색트리의 특성을 유지
		x				y
	a 		y		x		r
		   b  r    a b


public boolean add(Object obj); 
//보관(같은 자료는 보관하지 않음)
public void clear();
//모든 요소 삭제
public Object clone(); 
//자신을 복제한 개체 반환
public boolean contains(Object obj);
//보관한 자료인지 판별
public boolean isEmpty();
//비어있는지 판별
public Iterator<Element> iterator();
//반복자 반환
public boolean remove(Object obj);
//보관한 자료를 제거
public int size();
//보관한 자료 개수 반환