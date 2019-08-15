최단경로 문제의 유형

-Single-source : (one-to-all)
하나의 출발 노드 s로부터 다른 모든 노드까지의 최단 경로를 찾아라.
ex) dijkstra의 알고리즘

-Single-destination : (all-to-one)
모든 노드로부터 하나의 목적지 노드까지의 최단 경로를 찾아라.
Single-source 문제와 동일
하나의 노드로부터 출발한 값을 반대로 뒤집으면 그 노드로부터 정점까지의 거리
방향이 없다면 u->v나 v->u는 같다.

-Single-pair : (one-to-one)
주어진 하나의 출발 노드 s로부터 하나의 목적지 노드 t까지의 최단경로를 찾아라.
최악의 경우 시간복잡도에서 Single-source 문제보다 나은 알고리즘이 없음
dijkstra알고리즘을 실행하다가 찾는 노드 t가 나오면 종료

-All-pair : (all-to-all)
모든 노드 쌍에 대해서 최단 경로를 찾아라.

-------------------------------------------------------------------------------
one-to-all

dijkstra알고리즘은 음수 가중치가 없다는 가정하에서만 사용할 수 있다.
경로에 만약 음수 사이클(negative cycle)이 있으면 최단 경로 자체가 정의되지 않는다.

최단 경로의 어떤 부분경로도 역시 최단 경로이다.
만약 u에서 v까지의 최단경로가 u - x - y- v 를 거쳐 간다면
x - y 가 x와 y의 최단경로가 된다.

입력 : 가중치 방향그래프 G = (V,E) 와 출발노드 s(V에 포함)
목적 : 각 노드 v(V에 포함)에 대해서 다음을 계산한다.

d[v]
처음에는 d[s] =0, d[v] =무한 으로 시작
알고리즘이 진행됨에 따라 감소해간다. 하지만 항상 d[v] >= delta(s,v)를 유지한다.
최종적으로는 d[v] = delta(s,v)가 된다.

pai[v] : s에서 v까지의 최단경로 상에서 v의 직전 노드(predecessor)
그런 노드가 없는 경우 pai(v) = NIL.

한정점으로부터 이어져잇는 정점들까지의 거리를 구한다.
가장 거리가 작은 정점에서 그 행위를 반복한다.
값을 바꿔준다.
-------------------------------------------------------------------------------
all-to-all

Floyd 알고리즘(동적계획법 사용)

모든 노드 쌍들간의 최단경로의 길이를 구함
dk[i,j] : 중간에 노드집합 {1,2.....,k}에 속한 노드들만 거쳐서 노드 i에서 j까지 가는
			최단 경로의 길이


d0[i,j] : 중간에 어떤 노드도 지날수 없다.  i,j가 직접 연결되어있어야 한다.
			직접 연결되어있다면 wij, 아니라면 무한대

dn[i,j] : 중간에 어떤 노드를 지나도 상관이 없다. => 최단 경로 길이
			우리가 구하려는 목표

dk[i,j] : min(dk-1[i,j],dk-1[i,k] +dk-1[k,j]);
		노드  k를 지나는 경우와 노드 k를 지나지 않는 경우 두가지가 있음.