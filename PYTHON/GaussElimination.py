def gauss_elimination(A, b):
    n = len(b)

    # Perform Gaussian elimination
    for i in range(n):
        # Find pivot row
        max_row = i
        for j in range(i+1, n):
            if abs(A[j][i]) > abs(A[max_row][i]):
                max_row = j

        # Swap rows if necessary
        if max_row != i:
            A[i], A[max_row] = A[max_row], A[i]
            b[i], b[max_row] = b[max_row], b[i]

        # Eliminate all entries below pivot
        for j in range(i+1, n):
            factor = A[j][i] / A[i][i]
            b[j] -= factor * b[i]
            for k in range(i, n):
                A[j][k] -= factor * A[i][k]

        # print(f"Step {i+1}:")

    # Print matrix after elimination step
    print("==== Row echelon form ====")
    for row in range(n):
        for col in range(n):
            print(f"{A[row][col]:.2f}", end="\t")
        print(f"| {b[row]:.2f}")
    print()
    
    # Back substitution
    x = [0] * n
    for i in range(n-1, -1, -1):
        print(f"b{i} = {b[i]}")
        x[i] = b[i]
        for j in range(i+1, n):
            x[i] -= A[i][j] * x[j]
        x[i] /= A[i][i]

    return x


# Get matrix size and coefficients from user
n = int(input("Enter the size of the matrix: "))
A = [[0] * n for i in range(n)]
b = [0] * n
for i in range(n):
    for j in range(n):
        A[i][j] = float(input(f"Enter the coefficient of x{i+1}{j+1}: "))
    b[i] = float(input(f"Enter the constant term for equation {i+1}: "))

print("\n=== Matrix ===\n")
for i in range(n):
    for j in range(n):
        print(f"{A[i][j]:.0f}", end="  ")
    print(f"{b[i]:.0f}")
print("\n")

# Solve system using Gauss elimination
x = gauss_elimination(A, b)

# Print solution
if x is None:
    print("The system has no unique solution.")
else:
    print("The solution for the system is:")
    for i in range(n):
        print(f"x{i+1} = {x[i]:.4f}")
