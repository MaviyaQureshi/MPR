
print("Enter number of variables : ")
n = int(input(''))
a = [[None for i in range(n)]for j in range(n)]
b = [None for i in range(n)]

for i in range(n):
    for j in range(n):
        a[i][j] = float(input(''))
    b[i] = float(input(''))
    
print("Enter the number of iterations : ")
itr = int(input(''))
    
x = [0]*n

for j in range(itr):
    for i in range(n):
        s = sum(a[i][j]*x[j] for j in range(n) if i != j)
        x[i] = (b[i]-s)/a[i][i]
        print(x[i])

# print("The values of variables are : ")
# for i in range(n):
#     print(f"x{i+1} = {x[i]}")