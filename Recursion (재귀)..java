https://www.youtube.com/watch?v=ln7AfppN7mY&list=PL52K_8WQO5oUuH06MLOrah4h05TZ4n38l&index=1 
참고

Recursion (재귀)

-무한루프에 빠지지 않을 요구사항 
Base case : 적어도 하나의 recursion에 빠지지 않는 경우가 존재해야 한다.
			base case는 여러개도 가능하다. 
Recursive case : recursion을 반복하다보면 결국 모든 case는 base case로 수렴해야 한다.

수학적 귀납법으로 증명할 수 있다.

 n까지의 합
 0! = 1
 n! = n* (n-1)!

 -length 구하는법
 public static int length(String str){
 	if(str.equals.(""))
 		return 0;
 	else
 		return 1+length(str.substring(1));
 }

-문자열의 프린트
public static void printChars(String str){
	if(str.length()==0)
		retrun;
	else{
		System.out.println(str.charAt(0));
		printChars(str.substring(1));
	}
}

-문자열을 뒤집어 프린트
public static void printCharsReverse(String str){
	if(str.length()==0)
		return;
	else{
		printCharsReverse(str.substring(1));
		System.out.println(str.charAt(0));
	}
}

-문자열을 뒤집어 반환
public static String reverseString(String str){
	if(str.length()==0)
		return "";
	else{
		return str.charAt(0)+reverseString(str.substring(1));

	}
}

-2진수로 변환하여 반환
public static void reverseBinary(int n){
	if(n<2)
		System.out.print(n);
	else{
		reverseBinary(n/2);
		System.out.println(n%2);
	}
}

-배열의 합 구하기

public static int sum(int n, int[] data){
	if(n<=0)
		return data[0];
	else
		return data[n-1] + sum(n-1,data);

}

-데이터파일로 부터 n개의 정수 읽어오기 
public void readFrom(int n, int[] data, Scanner in){
	if(n==0)
		return;
	else{
		readFrom(n-1, data,in);
		data[n-1] = in.nextInt();
	}
}

재귀함수는 복잡한 알고리즘을 단순하고 알고쉽게 표현하는 것을 가능하게 함
하지만 함수 호출에 따른 오버헤드가 있음 (매개 변수 전달, 액티베이션 프레임 생성 등)

------------------------------------------------------------------------------

재귀함수 설계방법 

-암시적(implicit) 매개변수를 명시적(explicit) 매개변수로 바꾸어라.

순차탐색
for문 사용
int search(int[] data, int n, int target){
	for(int i=0; i<n; i++){
		if(data[i]==target)
			return i;
	}
	return -1;
}

이 함수의 미션은 data[0]에서 data[n-1] 사이에서 target을 검색하는 것이다.
하지만 검색 구간의 시작 인덱스 0은 보통 생략한다. 즉 암시적 매개변수이다. [0, n-1]

재귀함수 사용
int search(int[] data, int begin, int end, int target){
	if(begin > end)
		return -1;
	else if(target ==data[begin])
		return begin;
	else
		return search(data, begin+1, end, target);
}
즉, 검색구간의 시작점을 명시적(explicit)으로 지정한다.

다른버전

int search(int[] data, int begin, int end, int target){
	if(begin > end)
		return -1;
	else if(target ==data[end])
		return end;
	else
		return search(data, begin, end -1, target);
}

int search(int[] data, int begin, int end, int target){
	if(begin > end)
		return -1;
	else{
		int middle = (begin+end)/2;
		if(data[middle] == target)
			return middle;
			int index = search(data, begin, middle-1, target);
			if(inde != -1)
				return index;
			else
				return search(data, middle+1, end, target);
	}
}

----------------------------------------------------------------
-최대값 찾기

int findMax(int[] data, int begin, int end){
	if(begin==end)
		return data[begin];
	else
		 return Math.max(data[begin],findMax(data, begin+1, end));
}

-Binary Search (이미 정렬되어 있다고 가정) 
public static int binarySearch(String[] data, String target, int begin, int end){
	if(begin > end)
		return -1;
	else{
		int middle = (begin+ end)/2;
		int compResult = target.compareTo(data[middle]);
		if(compResult == 0)
			return middle;
		else if(comResult <0)
			return binarySearch(data, target, begin, middle-1); 
		else
			return binarySearch(data, target, middle+1, end);
	}
}
--------------------------------------------------------------------------------
-미로찾기 (Decision Problem : 출구까지의 경로가있는지 없는지 true, false로 반환)
시작 (0, 0) 출구(n-1, n-1)

현재 위치에서 출구까지 가는 경로가 있으려면
1) 현재 위치가 출구거나 혹은
2) 이웃한 셀들 중 하나에서 현재 위치를 지나지 않고 출구까지 가는 경로가 있거나

수도코드
boolean findPath(x,y){
	if(x,y) is the exit  //(x,y) 가 출구라면 true 반환
		return true;
	else{
		mark (x,y) as a visited cell; // (x,y)를 방문했다고 마크 
		for each neighbouring cell (x',y') of (x,y) do // (x,y)에 인접한 cell에 대해
			if(x',y') is on the pathway and not visited //길이 맞고 방문하지 않았다면
				if(findPath(x',y') //출구거나 출구까지 가는 경로가 있는가
					return true;
		return false;
	}
}

임의의 점(x,y)에서 출구까지 가는 경로가 있는지 확인
PATHWAY_COLOUT = 0 -> 아직 지나지 않은 길 (벽 X)
WALL = 1 -> 벽
PATH_COLOUR =2 //방문한 길 -> 최종적으로 목표하는 길
BLOCKED_COLOUR =3 //막힌길
maze = int[][] // 전역 

public static void main(String[] args){
	findMazePath(0,0);
}

public static boolean findMazePath(int x, int y){
	if(x<0 || y<0 || x>=N || y>= N) //미로 범위를 벗어난 경우
		return false;
	else if(maze[x][y] != PATHWAY_COLOUR) // 현재 위치가 방문했거나 벽인경우
		return false;
	else if(x ==N-1 && Y == N-1){ //현재 위치가 출구인 경우
		maze[x][y] = PATH_COLOUR;
		return true;
	}
	else{
		maze[x][y] = PATH_COLOUR; //방문
		if(findMazePath(x-1,y) || findMazePath(x,y+1) || findMazePath(x+1,y)
			|| findMazePath(x,y-1)){
			return true;
			}
		maze[x][y] = BLOCKED_COLOUR;
		return false;
	}
}
------------------------------------------------------------------------------
Counting Cell in a Bolb
입력 :	N*N 크기의 2차원 데이터
		하나의 좌표(x,y)

출력 :	픽셀 (x,y)가 포함된 blob의 크기
		(x,y)가 어떤  blob에도 속하지 않는 경우에는 0

한 픽셀이 속한 blob의 크기를 카운트 하려면

현재 픽셀이 image color가 아니라면
	0을 반환한다.
현재 픽셀이 image color라면
	먼저 현재 픽섹을 카운트한다 (count =1).
	현재 픽셀이 중복 카운트되는 것을 방지하기 위해 다른 색으로 칠한다.
	현재 픽셀에 이웃한 모든 픽셀들에 대해서 
		그 픽셀이 속한 blob의 크기를 카운트하여 카운트에 더해준다.
	카운터를 반환한다.

수도코드
countCells(x,y)
if the pixel(x,y) is outside the grid
	the result is 0;	// 픽셀이 범위에서 벗어났을 때 0 반환
else if pixel(x,y) is not an image pixel or already counted
	the result is 0; // 픽셀이 이미지 픽셀이 아니거나 이미 카운트 되었다면 0반환
else //이미지 픽셀이라면
	set the colour of the pixel(x,y) to a red colour; //색을 변경 
	the result is 1 plus the number of cells in each piece of the blob
	that includes a nearest neighbour; //카운트에 1을 더해주고 주변 픽셀을 조회한다.



private static int B_C =0 , I_C =1, A_C =2;

public int countCells(int x, int y){
	int result;
	if(x<0 || x>=N || y<0 || y>=N)
		return 0;
	else if(data[x][x] != I_C)
		return 0;
	else{
		data[x][y] = A_C;
		return 1+ countCells() 8가지 경우의 수 
	}
}

------------------------------------------------------------------
n-queens problem (Backtracking 사용)
체스판에 말을 두는데 동일한 행, 열, 대각선에 둘수 없다.
N*N의 판에 N개의 말을 둬야 한다.

트리구조로 볼수있다.					root
						1,1		1,2		1,3		1,4
				2,1	2,2	3,2	4,2     ..................

즉 해가 존재한다면 그것은 반드시 이 트리의 어떤 한 노드에 해당함
따라서 이 트리를 체계적으로 탐색하면 해를 구할 수 있음

깊이우선탐색을 하는데  Backtracking을 사용한다.

디자인 구조

매개변수는 내가 현재 트리의 어떤 노드에 있는지를 지정해야 한다.
retrun-type queens(arguments){
	if non-promising //더이상 깊이 탐색할 필요가 없는 노드인가
		report failure and return;
	else if success // 내가 찾고있던 노드인가 
		report answer ans return;
	else  // 자식들을 순서대로 방문한다.
		visit children recursively;
}

int[] cols = new int[N+1];
boolean queens(int level){
	if(!promising(level)) // 놓을수 있는지 확인하는 코드
		return false;
	else if (level==N){
		for(int i=1; i<=N; i++)
			System.out.println(cols[i]);
		return true;
	}
	for(int i=1; i<=N; i++){
		cols[level+1] =i;
		if(queens(level+1))
			return true;
	}
}
cols[level] : level번째 말이 몇번째 행에 놓여졌는지 적혀있다.
이전 level말들 간의 충돌이 없음이 보장되어 있어야한다.
따라서 마지막에 놓인 말이 이전에 놓인 다른 말들과 충돌하지는 검사하는것으로 충분

boolean promising(int level){
	for(int i=1; i<level; i++){
		if(cols[i] == cols[level]) //같은 행에 놓여있다면
			return false;
		else if(level- i == Math.abs(cols[level] - cols[i])) 
		// 같은 대각선에 놓여있다면
			return false;
	}
}
-----------------------------------------------------------------------