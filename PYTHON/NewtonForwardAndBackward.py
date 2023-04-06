def newton_forward(x, y):
    n = len(x)
    f = [[0] * n for i in range(n)]
    f[0] = y

    # Compute forward difference table
    for i in range(1, n):
        for j in range(n-i):
            f[i][j] = (f[i-1][j+1] - f[i-1][j]) / (x[j+i] - x[j])

    # Print difference table
    print("Forward difference table:")
    for i in range(n):
        for j in range(n-i):
            print(f"{f[j][i]:.6f}", end="\t")
        print(0)

    return f[0]

def newton_backward(x, y):
    n = len(x)
    f = [[0] * n for i in range(n)]
    f[0] = y

    # Compute backward difference table
    for i in range(1, n):
        for j in range(i, n):
            f[i][j] = (f[i-1][j] - f[i-1][j-1]) / (x[j] - x[j-i])

    # Print difference table
    print("Backward difference table:")
    for i in range(n):
        for j in range(i, n):
            print(f"{f[i][j]:.6f}", end="\t")
        print(0)

    return f[0]

# Get interpolation type and data from user
type = input("Enter interpolation type (forward/backward): ")
n = int(input("Enter the number of data points: "))
x = [0] * n
y = [0] * n
for i in range(n):
    x[i] = float(input(f"Enter x{i}: "))
    y[i] = float(input(f"Enter y{i}: "))

# Interpolate using selected method
if type == "forward" or type == 'Forward' or type == 'FORWARD':
    interp = newton_forward(x, y)
elif type == "backward" or type == 'Backward' or type == 'BACKWARD':
    interp = newton_backward(x, y)
else:
    print("Invalid interpolation type. Please enter 'forward' or 'backward'.")
    interp = None

# Print interpolated values
if interp is not None:
    print("Interpolated values:")
    for i in range(n):
        print(f"f({x[i]}) = {interp[i]:.6f}")
