n = int(input())

for _ in range(n):
	memo = {}
	ent = int(input())
	fib_atual = 0
	def calcula_fib(i):
		if i == 0:
			return (0, 0)
		if i == 1:
			return (0,1)
		if i in memo:
			return memo[i]
		
		chamadas_1, fib_1 = calcula_fib(i-1)
		chamadas_2, fib_2 = calcula_fib(i-2)
		
		chamadas_total = chamadas_1 + chamadas_2 + 2
		
		fib_atual = fib_1 + fib_2
		
		memo[i] = (chamadas_total, fib_atual)
		return (chamadas_total, fib_atual)
		
	total_chamadas, total_fib = calcula_fib(ent)
	
	print(f"fib({ent}) = {total_chamadas} calls = {total_fib}")