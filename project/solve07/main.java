class prob1 {
    public static class Rectangle{ 
       String name;
       int x; 
       int y;
       int width; int height; 
 
       public Rectangle(String name, int width, int height) {  
          this(name,0,0,width,height);
       }
       
       public Rectangle(String name, int x, int y, int width, int height) {
          this.name=name;
          this.x=x;
          this.y=y;
          this.width=width;
          this.height=height;
       }
 
       public int square() {
          return (width*height);
       }
       
       public void show() {
          System.out.println("x좌표: "+x+",y좌표: "+y);
          System.out.println(square());
       }
       
 
    }
    
    
    public static void main(String[] args) {
       // TODO Auto-generated method stub
       Rectangle r=new Rectangle("R",2,2,8,7);
       Rectangle s=new Rectangle("S",5,5,6,6);
       Rectangle t=new Rectangle("T",1,1,10,10);
       Rectangle u=new Rectangle("U",5,8);
       
       r.show();
       System.out.println("s의 면적은 "+s.square());
       s.show();
    }
 
 }