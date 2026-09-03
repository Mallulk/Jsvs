public class repeted {
    public static void main(String[] args){
        int arr[]={1,2,3,2,3,5};
            for(int i=0;i<arr.length;i++){
                int c=0;
                for(int j=0;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    c++;
                }
            }
            if(c==1){
                System.out.println(arr[i]);
            }
        }
    }
    
}
