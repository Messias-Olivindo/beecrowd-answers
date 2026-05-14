n = int(input()) # Indica o número de testes que vai acontecer
limit = 50

# Faz de acordo com o número des testes que vai ocorrer/
for _ in range(n):
    pac = int(input()) #quantidade de pacotes
    matriz = [[0 for _ in range(pac + 1)] for _ in range(limit+1)] # Inicializa a matriz, sendo que as linhas indicam os pacotes e as colunas são os intervalos baseados no limite de peso da mochila, nesse caso é divido no intervalo de tamanho 1, além disso a primeira linha e coluna devem ser 0 pq o computador começa a contagem do 0

    # Criação do array de suporte com os valores de pesos e quantidade dos brinquedos
    # Primeiro elemento tem que ser 0 para que a primeira linha e coluna sejam 0 também
    pesos = [0]
    qtd_brinq = [0]

    # Pega os outros valores de quantidade e peso de cada um dos brinquedos
    for _ in range(pac):
        # Faz a divisão do input a partir de um split no espaço
        q, p = map(int, input().split())
        pesos.append(p)
        qtd_brinq.append(q)

        # Fazer o loop para preencher a matriz:
        for i in range(1, pac+1):
            for j in range(1, limit+1):
                # Primeira validação é saber se o pacote não execede a capacidade da mochila
                if pesos[i] <= j:
                    # Agora tem que fazer a comparação do caso antigo de qtd de brinquedos do caso antigo com a inserção da nova quantidade de brinquedos. E o maior valor é preenchido na célula da matriz
                    antigo = matriz[i-1][j]
                    novo = matriz[i-1][j - pesos[i]] + qtd_brinq[i]
                    if antigo > novo:
                        matriz[i][j] = antigo
                    else:
                        matriz[i][j] = novo

                # Caso o pacote seja maior que a capacidade ele deve repetir o valor da célula que está acima dele
                else:
                    matriz[i][j] = matriz[i - 1][j]

    # Fazer o backtrack para encontrar a solução
    # Declarar as variáveis que serão encontradas no final
    peso_total = 0
    pac_usados = 0
    j = limit
    # Fazer o loop que vai percorrer a solução na matriz
    for i in range(pac, 0, -1):
        # Caso o valor da célula seja maior que na de cima, significa que ele foi adicionado na mochila, se não for isso indica que ele só não foi adicionado e pula para a outra linha para ver se ele entrou
        if matriz[i][j] > matriz[i-1][j]:
            # Atualiza o peso total, o ponteiro que analise a capacidade/peso ocupado da mochila e qtd de pac usados
            peso_total += pesos[i]
            j -= pesos[i]
            pac_usados += 1

    print(f"{matriz[pac][limit]} brinquedos")
    print(f"Peso: {peso_total} kg")
    print(f"sobra(m) {(pac -pac_usados)} pacote(s)")