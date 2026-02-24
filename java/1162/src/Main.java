import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        int temp;

        for(int i = 0; i < times; i++){
            int l = sc.nextInt();
            int[] order = new int[l];
            for(int m = 0; m<l; m++){
                order[m] = sc.nextInt();
                //System.out.println(order[m]);
            }
            int s = 0;
            for(int j = 0; j < l; j++){
                for(int k = j; k < l; k++){
                    if(order[j] > order[k]){
                        temp = order[j];
                        order[j] = order[k];
                        order[k] = temp;
                        s++;
                    }
                }
            }
            System.out.println("Optimal train swapping takes " + s + " swaps.");
            s=0;
        }
        sc.close();
    }
}