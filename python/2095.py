# Leitura de dados
import sys

dados = sys.stdin.read().split()

if not dados:
    exit()

n = int(dados[0])

q = [int(x) for x in dados[1 : n +1]]
s = [int(x) for x in dados[n+1 : 2*n+1]]

# Ordena os arrays
q.sort()
s.sort()

# Percorre o array e faz a contagem das vitórias
vitorias = 0

p_q = 0
p_s = 0

while p_s < n and p_q < n:
	if s[p_s] > q[p_q]:
		vitorias += 1
		p_s +=1
		p_q += 1
	else:
		p_s += 1

print(vitorias)