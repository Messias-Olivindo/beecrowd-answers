while True:
	# quantidade de casos de teste, e quantidade de tipos de produtos tbm
	t = int(input())
	#Condição de parada
	if t == 0:
		break
	# Criar os arrays de preços e pesos
	precos = [0]
	pesos = [0]
	for _ in range(t):
		pr, pe = map(int, input().split())
		precos.append(pr)
		pesos.append(pe)
	
	# pega o valor do peso maximo
	peso_max = int(input())
	
	# Criar matriz e preencher ela com a quantidade
	matriz = [[0 for _ in range(peso_max + 1)] for _ in range(t+1)]
	for i in range(1, t+1):
		for j in range(1, peso_max + 1):
			if pesos[i] <= j:
				antigo = matriz[i - 1][j]
				novo = matriz[i - 1][j - pesos[i]] + precos[i]
				matriz[i][j] = max(antigo, novo)
			else:
				matriz[i][j] = matriz[i - 1][j]
				
	# Fala a quantidade total dos produtos:
	print(matriz[t][peso_max])