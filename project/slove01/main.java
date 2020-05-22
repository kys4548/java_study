import java.util.Scanner;

abstract class GameObject{ //추상클래스
   protected int distance; //한번 이동 거리
   protected int x, y; // 현재위치(화면 맵 상의 위치)
   
   public GameObject(int startX, int startY, int distance) { //초기 위치와 이동거리 설정
      this.x=startX;
      this.y=startY;
      this.distance=distance;
   }
   public int getX() { return x; }
   public int getY() { return y; }
   
   public boolean collide(GameObject p) { // 이 객체가 객체 p와 충돌했으면 true리턴
      if(this.x == p.getX() && this.y == p.getY())
         return true;
      else 
         return false;
   }
   protected abstract void move(); // 이동한 후의 새로운 위치로 x, y변경
   protected abstract char getShape(); // 객체의 모양을 나타내는 문자리턴
} 
class Carrot extends GameObject{
   public Carrot(int startX, int startY, int distance) { //Carrot의 위치, 이동거리 설정
      super(startX, startY, distance);
   }
   @Override
   public void move() { // 한 번 움직이는 과정 전개
      // x좌표 설정
      int n = (int)(Math.random()*5); // 0,1,2,3,4 중에서 0인경우 +방향, 1인경우 -방향, 나머지 정지
      if(n==0) x+=distance;
      else if(n==1) x -= distance;
      
      if(x<0) x=0; // x위치값이 0보다 작은 수가 되면 0으로 정지
      if(x>=RaCaGame.MAX_X) x = RaCaGame.MAX_X-1; //x위치가 20이상이면 19로 정지
      //y좌표 코딩
      n = (int)(Math.random()*5);
      switch(n) {
      case 0: y+=distance;
            if(y>=RaCaGame.MAX_Y) y=RaCaGame.MAX_Y-1; //y위치가 10이상이면 9에 정지
      break;
      case 1: y-=distance;
            if(y<0) y=0; //y위치값이 0보다 작으면 0으로 정지
      break;
      }
      
   }
   @Override
   public char getShape() { // Carrot 모양 리턴
      return '@';
   }
}
class Rabbit extends GameObject{
   public Rabbit(int startX, int startY, int distance) { //Rabbit의 위치, 이동거리 설정
      super(startX, startY, distance);
   }
   @Override
   public void move() {
      System.out.print("왼쪽(a), 아래(s), 위(w), 오른쪽(d) >> "); //Rabbit 조종하기
      Scanner scan = new Scanner(System.in);//상하좌우 방향 처리, 범위안에서 움직이도록 처리
      String R = scan.next();
      char c = R.charAt(0);
      
      switch(c) {
      case 'a': //a가 입력되면 왼쪽이므로 x는 1감소
         x-=distance;
         if(x<0) x=0;
         break;
      case 's': //s가 입력되면 아래쪽이므로  y는 1증가
         y+=distance;
          if(y>=RaCaGame.MAX_Y) y=RaCaGame.MAX_Y-1;
          break;
      case 'w': //w가 입력되면 위쪽이므로 y는 1감소
         y-=distance;
          if(y<0) y=0;
          break;
      case 'd': //d가 입력되면 오른쪽이므로 x는 1증가
         x+=distance;
          if(x>=RaCaGame.MAX_X) x=RaCaGame.MAX_X-1;
          break;
      default: //a, s, w, d가 아닌 다른 값이 입력되면 출력
         System.out.println();
         System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
         System.out.println("   Warning!! 잘못 입력하셨습니다. ");
         System.out.println("  Rabbit이 Carrot을 먹도록 도와주세요!");
         System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
         break;
      }
   }
   @Override
   public char getShape() { //Rabbir 모양 리턴
      return 'R';
   }
}
class RaCaGame {

   public static final int MAX_X = 20; //게임판 20열 나타내기
   public static final int MAX_Y = 10; //게임판 10행 나타내기
   private char map[][] = new char [MAX_Y][MAX_X]; //게임판 '-'표현을 위한 배열
   
   private GameObject[] m = new GameObject[2];
   private int state; // 0: 게임 중, 1: Rabbit이 winner, 2: Carrot이 winner, 게임의 상태를 체크해주는 변수
   
   public RaCaGame() { // 게임판을 '-'로 채우고 Rabbit과 Carrot의 시작위치를 부여합니다.
      for(int i=0; i<MAX_Y; i++)
         for(int j=0; j<MAX_X; j++)
            map[i][j] = '-';
      
      m[0] = new Rabbit(0, 0, 1); //Rabbit의 시작위치, 이동거리 부여
      m[1] = new Carrot(5, 5, 2); //Carrot의 시작위치, 이동거리 부여
      state = 0; // 게임 중
   }
   
   public void run() { 
      int random=0;
      System.out.println("************************************ ");
      System.out.println("    Rabbit의 Carrot먹기 게임을 시작합니다. ");
      System.out.println("                 당근을 먹자! 당근을 먹자!    ");
      System.out.println("************************************");
      update();
      draw();
      while(Win()==false) { // 두 객체가 충돌하지 않았으면 실행
         clear(); // 두 객체 위치에 '-'로 표시
         
         int count = 0;
         for(int i=0; i<5; i++) {
            m[0].move();
            
            if(count >= 2) {
                continue;
            }

            if(m[1].move() == true) {
                count++;
            }
        }
         update();
         draw();   
         }
               
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println(" Rabbit Wins!!(state:1)");
      System.out.println("축하합니다! 게임을 종료합니다.");
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~ ");
      
         }
   
      public void update() { // Carrot부터 먼저 그려서 Carrot을 먹는 경우 Carrot이 보이지 않게 됩니다.
         for(int i=m.length-1; i>=0; i--)
            map[m[i].getY()][m[i].getX()] = m[i].getShape(); //Rabbit과 Carrot의 시작위치 설정
   }
      public void clear() { // Rabbit과 Carrot의  위치에 '-'표시합니다.
         for(int i=0; i<m.length; i++)
            map[m[i].getY()][m[i].getX()] = '-';
      }
      public void draw() { // 전체 게임판을 '-'로 출력
         System.out.println();
         for(int i=0; i<MAX_Y; i++) {
            for(int j=0; j<MAX_X; j++) {
               System.out.print(map[i][j]);}
            System.out.println();
         }
      }
      private boolean Win() {
         if(m[0].collide(m[1])) { //두 객체가 충돌하면 true 리턴
            return true;
         }
         return false;
      }
   
   public static void main(String[] args) {
      RaCaGame RG = new RaCaGame();
      RaCaGame RG1 = new RaCaGame();
      RG.run();
      System.out.println();
      System.out.print("한번 더 할 수 있습니다. 하시겠습니까?(y/n) "); //2번째 실행 여부 질문
      Scanner scan = new Scanner(System.in);
      String R = scan.next();
      
      System.out.println();
      char c = R.charAt(0);
      
      switch(c) {
      case 'Y': 
      case 'y': 
         RG1.run(); // Y또는 y가 입력되면 한번 더 게임실행
         break;
      case 'N':
      case 'n': 
         System.out.println("종료"); // N또는 n이 입력되면 종료
          break;
      default:
         System.out.println("   Warning!! 잘못 입력하였습니다. ");
         System.out.println("          게임이 종료됩니다.");
         break;
      }
   }
}