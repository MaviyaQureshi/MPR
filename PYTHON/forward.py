import numpy as np

# function for calculating divided differences
def divided_diff(x, y, n):
    for i in range(1, n):
        for j in range(i, n):
            y[j][i] = (y[j][i-1] - y[j-1][i-1]) / (x[j] - x[j-i])
            print(f"y{[j]}{[i]} = {y[j][i]}")
    return y

# function for calculating interpolated value
def newtons_forward_interpolation(x, y, n, xi):
    # calculating divided differences
    y = divided_diff(x, y, n)
    
    # calculating interpolated value using Newton's forward interpolation formula
    sum = y[0][0]
    term = 1
    for i in range(1, n):
        term *= (xi - x[i-1])
        print(f"term = {term}")
        sum += (y[i][i] * term)
        print(f"sum = {sum}")
    
    return sum

# taking input from user
n = int(input("Enter number of data points: "))
x = np.zeros(n)
y = np.zeros((n,n))

for i in range(n):
    x[i] = float(input(f"Enter value of x[{i}]: "))
    y[i][0] = float(input(f"Enter value of y[{i}]: "))

xi = float(input("Enter value of xi for which you want to find interpolated value: "))

# calculating interpolated value
interp_val = newtons_forward_interpolation(x, y, n, xi)

# displaying interpolated value
print(f"\nThe interpolated value at xi = {xi} is {interp_val:.4f}")
