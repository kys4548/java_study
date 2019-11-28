Memoization vsDynamic Programming(Richard Bellman)

- 순환식의 값을 계산하는 기법들이다.
- 둘 다 동적계획법의 일종으로 보기도 한다.
- Memoization은 top-down 방식이며, 실제로 필요한 subproblem만을 푼다.
- 동적계획법은 bottom-up 방식이며, recursion에 수반되는 overhead가 없다.
------------------------------------------------------------------------------
Finonacci Numbers
int fib(int n){
	if (n==1 || n==2)
		return1;
	else
		return fib(n-2) + fib(n-1);
}

                f(5)
            f(4)      f(3)
          f(3) f(2) f(2) f(1)
        f(2) (f1)

==> 많은 계산이 중복됨

Memoization기법을 사용
재귀로 계산을 하다보니까 f(2)를 이미 계산했는데 또 다른 재귀문에 들어가 f(2)를 계산한다.
f(7)일때 f(5)의 계산을 두번한다.
--> 까먹지 말고 기억을 해놓자!!!

1) Memoization
중간 계산 결과를 caching 배열에 저장해 둔다.

int fib(int n){
	if (n==1 || n==2)
		return1;
	else if(f[n] >-1)
		return f[n];
	else{
		f[n] =  fib(n-2) + fib(n-1);
		return f[n];
	}

2) bottom-up방식
배열에 1 1 2 3 5 8 13 21 34 
쭉 계산해서 올라옴

int fib(int n){
	f[1] = f[2] = 1;
	for(int i=3; i<=n; i++)
		f[n] = f[n-1] + f[n-2];
	return f[n];
}

--------------------------------------------------------------------------

Binomial Coefficient (이항 계수)
int binomial(int n, int k){
	if(n==k || k==0)
		return1;
	else
		return binomial(n-1, k) + binomial(n-1, k-1);
}
==> 역시 많은 계산이 중복됨

1.Memoization
int binomial(int n, int k){
	if(k==n || k==0)
		return 1;
	else if(binom[n][k]>-1)
		return binom[n][k];
	else
		binom[n][k] = binomial(n-1,k) + binomial(n-1, k-1);
		return binom[n][k];
}

2.bottom-up
int binomial(int n, int k){
	for(int i=0; i<=n; i++){
		for(int j=0; j<=k && j<=i; j++){
			if(k==0 || k==n)
				binom[[i][j] = 1;
			else
			binom[i][j] = binom[i-1][j-1] + binom[i-1][j];
		}
	}
	return binom[n][k];
}

기본적인 값에서 계속 올라간다.
--------------------------------------------------------------------------------
행렬 최단 경로 문제 
6	7	12	5
5	3	11	18				오른쪽과 아래로만 움직일수 있다.
7	17	3	3
8	10	14	9 

dijkstra로도 풀 수 있지만 동적계획법으로 풀어보자.
1. 순환식을 먼저 세운다.
2. 계산 (Memoization, bottom-up)

관찰
(i,j)에 도달하기 위해서는 (i,j-1) 혹은 (i-1,j)를 거쳐야 한다.
또한 (i,j-1) 혹은 (i-1,j)까지는 최선의 방법으로 이동해야 한다.

순환식
L(i,j) = (1,1)에서 (i,j)까지 이르는 최소합
			->		mij							i=1, j=1
			->		L[i-1,j]+mij				j=1
L[i,j] 		->		L[i,j-1]+mij				i=1
			->		min(L[i-1,j],L[i,j-1])+mij 	i!=1, j!=1
재귀식 
int mat(int i, int j){
	if(i==1 && j==1)
		return m[i][j];
	else if(i==1)
		return mat(i,j-1) +m[i][j];
	else if(j==1)
		retrun mat(i-1,j) +m[i][j];
	else
		return Math.min(mat(i-1,j),mat(i,j-1))+m[i][j];
}
==> 매우 비효율적 m(4,4)를 계산하기 위해 엄청 많은 m(2,1)이 구해진다.

Memoization
int mat(int i, int j){
	if(L[i][j] != -1)
		return L[i][j];
	if(i==1 && j==1)
		L[i][j] = m[i][j];
	else if(i==1)
		L[i][j] = mat(i,j-1) +m[i][j];
	else if(j==1)
		L[i][j] = mat(i-1,j) +m[i][j];
	else
		L[i][j] = Math.min(mat(i-1,j),mat(i,j-1))+m[i][j];
	return L[i][j];
}

만약 (3,3)을 찾는다면 4이상의 값들은 찾을 필요가 없다.
실제 필요한 subproblem만 푼다.


bottom-up
int mat(){
	for(int i=1; i<=n; i++){
		for(int j=1; j<=n; j++){
			if(i==1 && j==1)
				L[i][j] = m[i][j];
			else if(i==1)
				L[i][j] = mat(i,j-1) +m[i][j];
			else if(j==1)
				L[i][j] = mat(i-1,j) +m[i][j];
			else
				L[i][j] = Math.min(mat(i-1,j),mat(i,j-1))+m[i][j];
		}
	}
	return L[n][n]
}


int mat(){
	for(int i=1; i<=n; i++){
		for(int j=1; j<=n; j++){
			if(i==1 && j==1)
				L[i][j] = m[i][j];
			else
				L[i][j] = Math.min(mat(i-1,j),mat(i,j-1))+m[i][j];
		}
	}
}
만약 i=0 or j=0 인 배열안의 값들은 무한으로 채워넣는다면 이렇게도 활용 가능
-----------------------------------------------------------------------
여태까지는 경로의 최소 합만을 구했다.
경로 구하기!!!

하나의 배열을 더 만든다.
그 값이 위에서 왔는지 왼쪽에서 왔는지를 적어준다.
(i,j)로 부터 처음 위치를 찾아간다.

int mat(){
	for(int i=1; i<=n; i++){
		for(int j=1; j<=n; j++){
			if(i==1 && j==1){
				L[i][j] = m[i][j];
				P[i][j] = '-';
			}
			else{
				if(L[i-1][j] < L[i][j-1]){
					L[i][j] = m[i][j] + L[i-1][j];
					P[i][j] = '<';
				}
				else{
					L[i][j] = m[i][j] + L[i][j-1];
					P[i][j] = '^';
				}
			}
		}
	}
	return L[n][n]
}

--------------------------------------------------------------------------
1. 일반적으로 최적화문제(optimisation problem) 혹은 카운팅(counting)문제에 적용
2. 주어진 문제에 대한 순환식(recurrence equation)을 정의한다.
3. 순환식을 memoization 혹은 bottom-up 방식으로 푼다.

분할정복법 vs 동적계획법

subproblem들을 풀어서 원래 문제를 푸는 방식. 그런의미에서 분할정복법과 공통성이있음

분할정복법에서는 분할된 문제들이 서로 disjoint하지만 동적계획법에서는 그렇지 않음.

즉 서로 overlapping 하는 subproblem들을 해결함으로써 원래 문제를 해결


quicksort의 경우
pivot을 기준으로 분할된 두 subproblem은 서로 disjoint하다.

---------------------------------------------------------------------------------
행렬의 곱셈
p*q와  q*r행렬 곱하기

void product(int[][] A, int[][] B, int[][] C){
	for(int i=0; i<p; i++){
		for(int j=0; j<r; j++){
			C[i][j] =0;
			for(int k=0; k<q; k++)
				C[i][j] += A[i][k] * B[k][j];
		}
	}
} 
연산횟수 =>pqr;

A 10*100 B 100*5 C 5*50
(AB)C : 7500번의 곱셈이 필요 (10*100*5 + 10*5*50)
A(BC) : 75000번의 곱셈 필요 (100*5*50 + 10*100*50)

행렬곱 ABCDEFG....을 계산하는 최적의 순서는?
최종결과 Z는 직전의 두 행렬 X,Y의 곱이다.
X : 처음부터 k까지의 곱
y : k+1부터 N까지의 곱

  1 2 3 4 5 6 7       1번째부터 7번째까지 더할떄 
1 0 X X X X X X       하나씩 계산한 결과를 먼저 구하고 
2   0 X X X X X		점점 갯수를 늘린 결과를 구한다. 
3  	  0 X X X X 		최종적으로 구하고 싶은 곳 (1,7)
4  	    0 X X X
5  	      0 X X
6  	        0 X
7  	          0


----------------------------------------------------------------------
Longest Common Subsequence(LCS)
bcdb는 문자열 abcbdab의 subsequence이다.
bca는 문자열 abcbdab 와 bdcaba의 common subsequence이다.

Longest Common Subsequence
common subsequence들 중 가장 긴것을 찾는 것
답은 bcba

X     ㅁㅁㅁㅁㅁㅁㅁㅁㅁAㅅㅅㅅㅅㅅ
LCS z ㅁㅁㅁㅁㅁㅁㅁA 
Y     ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁAㄴㄹㄷㄷ

LCS의 ㅁㅁㅁ부분은 X,Y의 ㅁㅁㅁㅁㅁ의 LCS이다.

두문자가 같은경우 L[i,j] = L[i-1,j-1] +1;
두문자가 다른경우 L[i,j] = max(L[i-1,j],L[i,j-1]);
i=0 or j=0 문자열을 다 찾았을때
-----------------------------------------------------------------------
knapsack problem

n개의 아이템과 배낭
각각의 아이템은 무게w 와 가격v를 가짐
배낭의 용량 W
목적 : 배낭의 용량을 초과하지 않으면서 가격이 최대가 되는 부분집합

i 	v 	w
1	1	1
2	6	2
3	18	5			weight limit W =11
4	22	6			최대값은 {3,4} 40
5	28	7

- 가격이 높은 것부터 선택
- 무게가 가벼운 것부터 선택
- 단위 무게당 가격이 높은 것 부터 선택 * greedy 근접 {5,2} 35

동적 계획법으로 푼다.

순환식 
OPT(i,w) : 배낭 용량이 W일 때 아이템 1,2,.....i로 얻을 수 있는 최대 이득

경우1 : 아이템 i를 선택하지 않은 경우
OPT(i,w) = OPT(i-1,w)
경우2 : 아이템 i를 선택하는 경우
OPT(i) = OPT(i-1, w-wi) +vi

			0									if i=0
OPT(i,w)	OPT(i-1,w)							if wi >w
			max(OPT(i-1,w), vi +OPT(i-1,w-wi))	otherwise