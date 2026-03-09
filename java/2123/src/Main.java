import java.util.Scanner;

public class Main {

    // Variáveis de grafo globais para facilitar o acesso no dfs
    static int[][] grafo;
    static int totalNos;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int instancia = 1;

        // 1. Ler a quantidade de cavalos, soldados e afinidades
        while (sc.hasNextInt()){
            int n = sc.nextInt(); // número de cavalos
            int m = sc.nextInt(); // número de soldados
            int k = sc.nextInt(); // número de afinidades
            // Crir grafo
            // Tamanho do grafo:
            // Fonte -> linha/coluna 0
            // Cavalo -> linhas/colunas 1 - n
            // Soldado -> linhas/colunas n + 1 - n + m
            // Sumidouro -> linha/coluna n + m + 1
            totalNos = n + m + 2;
            int fonte = 0;
            int sumidouro = n + m + 1;
            grafo = new int[totalNos][totalNos];

            // 2. Preencher com as capacidades dos cavalos
            for (int i = 1; i < n + 1; i++) {
                grafo[fonte][i] = sc.nextInt();
            }

            // 3. Ligar os cavalos com os soldados (afinidades)
            for( int i = 0; i < k; i++){
                int cavalo = sc.nextInt();
                int soldado = n + sc.nextInt();
                grafo[cavalo][soldado] = 1;
            }

            // 4. Ligar soldados com o sumidouro com a capacidade 1
            for (int i = 1; i < m + 1; i++){
                grafo[n + i][sumidouro] = 1;
            }

            // Aplicar o algoritmo de Ford Fulkerson
            // 5. Buscar um caminho
            // 6. Verificar a menor capacidade do caminho e guardar esse valor
            // 7. Calcular a capacidade residual de cada nó e fazer a substituição
            // 8. Fazer isso até que não haja caminho viável com a capacidade positiva
            // 9. Calcular o fluxo máximo
            // 10. Imprimir o resultado
            int fluxoMaximo = 0;
            // Passo 8 de fazer ate não haver caminho com capacidade positiva
            while (true){
                // Inicia o array de nós visitados
                boolean[] visitado = new boolean[totalNos];
                // Calcula o fluxo encontrado usando a função de dfs
                int fluxoEncontrado = dfs(0, Integer.MAX_VALUE, sumidouro, visitado);
                // Se for 0, significa que não há mais caminhos possíveis
                if (fluxoEncontrado == 0) break;
                // Se achou caminho e conseguiu alocar, soma-se ao total
                fluxoMaximo += fluxoEncontrado;
            }

            System.out.println("Instancia " + instancia);
            System.out.println(fluxoMaximo);
            System.out.println();

            instancia ++;

        }
    }

    // Função que realiza o dfs
    static int dfs(int noAtual, int gargalo, int sumidouro, boolean[] visitado){
        // 1. Condição de parada
        // Se estiver em uma saída (sumidouro), acabou e retorna o gargalo
        if (noAtual == sumidouro){
            return gargalo;
        }

        // 2. Marcar os nós que ja foram visitados utilizando o array de visitado
        visitado[noAtual] = true;

        // 3. Fazer um loop passando pelos vizinhos, por todos os nós do meu universo (do 0 até o total de nós)
        for (int vizinho = 0; vizinho < totalNos; vizinho++) {
            // 4. Para avançar:
            // Verificar se o vizinho ainda não foi visitado e se tiver algum caminho do local atual disponível para o vizinho
            if (!visitado[vizinho] && grafo[noAtual][vizinho] > 0){
                // 5. Calcular o novo gargalo, sendo o menor valor entre o fluxo e a capacidade residual
                int novoGargalo = Math.min(gargalo, grafo[noAtual][vizinho]);

                // 6. Chama a função dfs, mas o atual se torna o vizinho, e a resposta fica alocado em uma variável de fluxo alcançado
                int fluxoAlocado = dfs(vizinho, novoGargalo, sumidouro, visitado);

                // 7. Se o fluxo alcançado for maior que 0, siginfica que achou a saída
                // Necessário fazer o ajuste de:
                // Colocar o novo valor de capacidade: subtrair a ida e adicionar na volta
                // Retorna o fluxo alcançado
                if (fluxoAlocado > 0){
                    // Ajuste das capacidades

                    // Subtrair ida
                    grafo[noAtual][vizinho] -= fluxoAlocado;

                    // Adicionar na volta
                    grafo[vizinho][noAtual] += fluxoAlocado;

                    // Retorna o fluxo alocado
                    return fluxoAlocado;
                }
            }
        }
        // 8. Se o loop terminou e nenhum levou a saida, retorna 0 siginifcando que nesse caminho não há saída
        return 0;
    }
}