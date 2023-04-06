import numpy as np

def gauss_elimination(A):
    n = A.shape[0]
    # Augment the matrix with identity matrix
    A_aug = np.hstack((A, np.identity(n)))
    print("\n=== Augmented Matrix ===")
    for i in range(n):
        for j in range(n*2):
            print(f"{A_aug[i][j]:.0f}", end="  ")
        print()

    # Perform forward elimination
    for i in range(n):
        # Pivot row i if necessary
        pivot_row = i
        for j in range(i+1, n):
            if abs(A_aug[j,i]) > abs(A_aug[pivot_row,i]):
                pivot_row = j
        if pivot_row != i:
            A_aug[[i,pivot_row], :] = A_aug[[pivot_row,i], :]
        # Reduce all rows below row i
        for j in range(i+1, n):
            factor = A_aug[j,i] / A_aug[i,i]
            A_aug[j,:] -= factor * A_aug[i,:]

        # Print matrix after each step
        print(f"After step {i+1}:")
        for k in range(n):
            for l in range(2*n):
                print(f"{A_aug[k,l]:.6f}", end="\t")
            print()
        print()

    # Perform backward substitution
    for i in range(n-1, -1, -1):
        A_aug[i,:] /= A_aug[i,i]
        for j in range(i-1, -1, -1):
            factor = A_aug[j,i]
            A_aug[j,:] -= factor * A_aug[i,:]

    # Return inverse of A
    return A_aug[:,n:]

# Get input from user
n = int(input("Enter matrix size: "))
A = np.zeros((n, n))
for i in range(n):
    row = input(f"Enter row {i+1} of the matrix (separate entries by spaces): ")
    entries = row.split()
    for j in range(n):
        A[i,j] = float(entries[j])
print("\n=== Matrix ===")
for i in range(n):
    for j in range(n):
        print(f"{A[i][j]:.0f}", end="  ")
    print()
# Perform Gauss elimination to find inverse
A_inv = gauss_elimination(A)

# Print inverse
print("\n=== Inverse Matrix ===")
for i in range(n):
    for j in range(n):
        print(f"{A_inv[i,j]:.3f}", end="\t")
    print()