import java.util.Scanner;
public class main {
    public static void main(String [] args){
        Scanner ss=new Scanner(System.in);
        System.out.println("Enter pass:");
        int pass=ss.nextInt();
        if(pass==1234){
            System.out.println("Welcome to my application");
            System.out.println("Enter two numbers");
            int num1=ss.nextInt();
            int num2=ss.nextInt();
            System.out.println("press + for add /n press - for subs /n press * for multiplication /n pres / for division");
        char choice=ss.next().charAt(0);
        if(choice=='+'){
            System.out.println(num1+num2);
        }  
        else if(choice=='-'){
            System.out.println(num1-num2);
        }  
        else if(choice=='*'){
            System.out.println(num1*num2);
        }
        else if(choice=='/'){
            System.out.println(num1/num2);

        }
         
    }
    else{
            System.out.println("Invalid pass");
        }
        
    }    
}
