import java.util.Scanner;
public class Student {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the marks");
        int marks=sc.nextInt();
        if(marks>=90){
            System.out.println("Grade : A");
        }
        else if(marks>=80){
            System.out.println("Grade B");
        }
        else if(marks>=65){
            System.out.println("Grade C");
        }
        else if(marks>=45){
            System.out.println("Grade D");
        }
        else{
            System.out.println("Fail");
        }
    }
    
}
