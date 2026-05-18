instancia = 0
while True:
	n, t = map(int, input().split())
	if n == 0:
		break
	instancia +=1
	dp = [[0 for _ in range(t + 1)] for _ in range(n + 1)]
	tempos = [0]
	pontos = [0]
	for _ in range(n):
		d, p = map(int, input().split())
		tempos.append(d)
		pontos.append(p)
	
	for i in range(1, n+1):
		for j in range(1, t +1):
			if tempos[i] <= j:
                # Como a "mochila" é ilimitada eu não preciso analisar a opção anterior, mas posso analisar a mesma opção mas com a quantidade diferente e ver qual é o melhor caso
				dp[i][j] = max(dp[i-1][j], dp[i][j - tempos[i]] + pontos[i])
			else:
				dp[i][j] = dp[i-1][j]
	
	print(f"Instancia {instancia}")
	print(dp[n][t])
	print()