import math

def backward_interpolation(x, y, x_val):
    # Calculate the backward difference table
    n = len(x)
    dy = [[0 for i in range(n)] for j in range(n)]
    for i in range(n):
        dy[i][0] = y[i]
    for i in range(1, n):
        for j in range(n - i):
            dy[j][i] = dy[j+1][i-1] - dy[j][i-1]

    # Use the table to calculate the value at x = x_val
    h = x[1] - x[0]
    u = (x_val - x[-1]) / h
    y_val = dy[-1][0]
    for i in range(1, n):
        product_term = 1
        for j in range(i):
            product_term *= (u + j)
        y_val += (dy[-1-i][i] / math.factorial(i)) * product_term

    return y_val

# Example usage
x = [10, 15, 20, 22.5, 30]
y = [0.1736, 0.2588, 0.3420, 0.3827, 0.5]

print("Backward Interpolation")
x_val = float(input("Enter the value for which Y has to be calculated: "))
y_val = backward_interpolation(x, y, x_val)
print(f"The value at x = {x_val} is {y_val}")
