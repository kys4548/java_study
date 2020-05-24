import java.util.Scanner;class Test { 
   public static void main(String[] args) {  
      Scanner input = new Scanner(System.in);
      int i, j, n, count;
      count = 0;
      System.out.print("숫자 : ");
      n = input.nextInt();
      
      for (i = 0; i < n; i++) {   
          if (i==0 || i == n/2){  
             for (j = 0; j < n; j++) {    
                      System.out.print("*");
             }
          }else if(i>n/2) {
             System.out.print("*");
             for(j=0; j< n-1; j++) {
                System.out.print(" ");
             }
          } else {  
             for (j = 0; j < n; j++) {    
                      if (j==0 || j==n-1){ 
                    System.out.print("*");
                 } else {  
                          System.out.print(" ");
                 }
             }   
          }
          System.out.print(" ");
          if ( i == n/2){  
            for (j = 0; j < n; j++) {    
                     System.out.print("*");
            }
         } else {  
            for (j = 0; j < n; j++) {    
                     if ( j ==  n-1 || j==0){  
                   System.out.print("*");
                } else {  
                         System.out.print(" ");
                }
            }   
         }
         System.out.print(" ");
         if (i==n/2){  
            for (j = 0; j < n; j++) {    
                     System.out.print("*");
            }
         } else if(i>n/2){
           
            for (j = 0; j < n; j++) {    
               if ( j == n/2)
               {
                  System.out.print("*");
               } else {
                       System.out.print(" ");
                   }  
            }    
         } else { 
             for (j = 0; j < n; j++) {    
               if ( j == 0 || j==n-1 )
               {
                  System.out.print("*");
               } else {
                       System.out.print(" ");
                   }  
            }    
           }
           System.out.println();  
         }
     }
  }