import numpy as np

def gauss_seidel(A, b, x0, tol, max_iter):
    n = len(x0)
    x = x0.copy()
    it = 0
    err = tol + 1

    # Perform Gauss-Seidel iteration
    while err > tol and it < max_iter:
        x_old = x.copy()
        for i in range(n):
            s = 0
            for j in range(n):
                if j != i:
                    s += A[i,j] * x[j]
            x[i] = (b[i] - s) / A[i,i]
        err = np.linalg.norm(x - x_old)
        it += 1

        # Print matrix after each iteration
        print(f"Iteration {it}:")
        for i in range(n):
            for j in range(n):
                print(f"{A[i,j]:.6f}", end="\t")
            print(f" | {b[i]:.6f} | {x[i]:.6f}")
        print()

    return x, it, err

# Get input from user
n = int(input("Enter matrix size: "))
A = np.zeros((n, n))
b = np.zeros(n)
for i in range(n):
    row = input(f"Enter row {i+1} of the matrix (separate entries by spaces): ")
    entries = row.split()
    for j in range(n):
        A[i,j] = float(entries[j])
    b[i] = float(input(f"Enter the value for b_{i+1}: "))
x0 = np.zeros(n)
for i in range(n):
    x0[i] = float(input(f"Enter the initial guess for x_{i+1}: "))
tol = float(input("Enter the tolerance: "))
max_iter = int(input("Enter the maximum number of iterations: "))

# Perform Gauss-Seidel iteration
x, it, err = gauss_seidel(A, b, x0, tol, max_iter)

# Print results
if it == max_iter:
    print("Maximum iterations reached without convergence.")
else:
    print(f"Solution: {x}")
    print(f"Converged after {it} iterations with error {err:.6f}.")