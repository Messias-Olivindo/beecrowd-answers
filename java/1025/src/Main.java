import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // Número de bolinhas de gude
        int q = sc.nextInt(); // Número de perguntas
        int count = 1;
        int i, result = 0;
        boolean found = false; // flag pra saber quando um palpite foi encontrado
        while (n != 0 || q != 0) { // Verifica se o caso não é igual a 0 0, que indica quando acaba
            int[] array = new int[n]; // Cria o array de bolinhas de gude

            for (i = 0; i < n; i++) { // preenche o array
                array[i] = sc.nextInt();
            }
            // Ordena o array


            int[] palpite = new int[q]; // Cria array de palpites
            for (i = 0; i < q; i++) {
                palpite[i] = sc.nextInt(); // preenche o array
            }

            System.out.println("CASE# " + count + ":"); // indica o case

            // Solução chula com complexidade O(n * k)
//            for (i = 0; i < palpite.length; i ++){
//                for (l = 0; l < array.length; l ++) {
//                    if(palpite[i] == array[l]) { // faz a comparação e indica em que posição o palpite foi encontrado
//                        System.out.println(palpite[i] + " found at " + (l + 1));
//                        found = true;
//                        break;
//                    }
//                }
//                    if(!found){ // Caso o palpite não seja encontrado aparece a mensagem de não encontrado
//                        System.out.println(palpite[i] + " not found");
//                    } else {
//                        found = false;
//                    }
//
//            }

            // Busca binária
            for(i = 0; i < palpite.length; i++) {
                int lo = 0;
                int hi = array.length - 1;
                int middle;
                while(lo <= hi) {
                    middle = (lo + hi)/2;
                    if (palpite[i] == array[middle]) {
                        result = middle;
                        found = true;
                        hi = middle - 1;
                    }
                    else if (palpite[i] > array[middle]) {
                        lo = middle + 1;
                    } else {
                        hi = middle - 1;
                    }
                }
                if(!found){ // Caso o palpite não seja encontrado aparece a mensagem de não encontrado
                    System.out.println(palpite[i] + " not found");
                } else {
                    System.out.println(palpite[i] + " found at " + (result + 1));
                    found = false;
                }
            }

            n = sc.nextInt();
            q = sc.nextInt();
            count++;
        }


        sc.close();
    }
}
