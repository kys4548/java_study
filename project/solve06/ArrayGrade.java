import java.util.Scanner;

class ArrayGrade {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("6개의 학점을 빈 칸으로 분리 입력(A/B/C/D/F/) >> ");
        String input = sc.nextLine();
        String[] grades = input.split(" ");
        
        for(int i=0; i<6; i++) {
            System.out.println(grades[i]);
        }
    }
}