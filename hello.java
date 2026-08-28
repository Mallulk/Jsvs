import java.util.Scanner;
class hello{
    public  static void main(String[] args) {
        Scanner ss=new Scanner(System.in);

        System.out.println("Enter pass");
        int pass=ss.nextInt();

        if(pass==1234){
            System.out.println("Wellcome to my calculation");
        System.out.println("Enter two num");
        int num1=ss.nextInt();
        int num2=ss.nextInt();
        System.out.println("press + for add /n press - for sub) /n press * for multiplication /n press / for division");
        char choise=ss.next().charAt(0);
        if(choise=='+'){
            System.out.println(num1+num2);
        }
        else if(choise=='-'){
            System.out.println(num1-num2);
        }
        else if(choise=='*'){
            System.out.println(num1*num2);
        }
        else if(choise=='/'){
            System.out.println(num1/num2);
        }
    }
     else{
            System.out.println("Invalid pass");
        }
}
}