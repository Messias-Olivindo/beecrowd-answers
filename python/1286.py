while True:
    n = int(input())
    if n == 0: 
        break
    p_max = int(input())
    memo = [[ 0 for _ in range(p_max + 1)] for _ in range(n + 1)]
    
    pizzas = [0]
    tempos = [0]
    for _ in range(n):
        t, p = map(int, input().split())
        pizzas.append(p)
        tempos.append(t)
    
    for i in range(1, n + 1):
        for j in range(1, p_max + 1):
            if pizzas[i] <= j:
                memo[i][j] = max(memo[i-1][j], memo[i-1][j - pizzas[i]] + tempos[i])
            else:
                memo[i][j] = memo[i -1][j]

    print(f"{memo[n][p_max]} min.")