print('Gaussian Elimination Algorithm Test')
    
def solve(a,b):
    n = len(b)
    for k in range(0,n):
        # find pivot row
        max = k
        for i in range (k+1,n):
            if abs(a[i][k]) > abs(a[max][k]):
                max = i
        # swap row in A matrix
        temp = a[k]
        a[k] = a[max]
        a[max] = temp
            
        # swap corresponding values in constants matrix
        t = b[k]
        b[k] = b[max]
        b[max] = t
            
        # pivot factor within A and B
        for i in range (k+1,n):
            factor = a[i][k] / a[k][k]
            b[i] -= factor * int(b[k])
            for j in range (k,n):
                a[i][j] -= factor * a[k][j]
            
        
    # Print upper-triangular matrix
    upperTraingular(a,b)
        
    # back substitution
    solution = [n]
    for i in range(n-1,0,-1):
        sum = 0.0
        for j in range (i+1,n,1):
            sum += a[i][j] * solution[j]
        solution[i] = (b[i]-sum)/a[i][i]
            
    # print solution
    printSolution(solution)
        
def upperTraingular(a,b):
    n = len(b)
    print('Upper Triangle Matrix : ')
    for i in range (0,n):
        for j in range(0,n):
            print("%.3f",a[i][j])
        print("| %.3f",b[i])
            
def printSolution(solution):
    n = len(solution)
    print('Solution : ')
    for i in range (0,n):
        print("%.3f",solution(i))       
            
    

def GaussEli():
    n = int(input('Enter the number of variables : '))
    b = []
    matrix = []
    matrix2 = []
    print("Enter ",n,"equations coefficients : ")
    for i in range (n):
        a = []
        for j in range (n):
            a.append(int(input()))
        matrix.append(a)
                
    print("\nEnter ",n,"solutions : ")
    for i in range(0,n):
        b.append(int(input()))
        matrix2.append(b)
        
    # print Augmented matrix
    print('The Augmented Matrix is : ')
    for i in range (n):
        for j in range (n):
            print(matrix[i][j],end = " ")
        print(" | ",matrix2[i][i])
            
    solve(matrix,matrix2)
    
GaussEli()