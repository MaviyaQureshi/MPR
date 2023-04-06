import matplotlib.pyplot as plt

# Define the differential equation to solve
def f(x, y, a, b, c, d):
    return a*(x**c) + b*(y**d)

# Define the fourth-order Runge-Kutta method
def rk4(x0, y0, h, n, a, b, c, d):
    x = [x0]
    y = [y0]
    for i in range(n):
        k1 = h * f(x[i], y[i], a, b, c, d)
        k2 = h * f(x[i] + h/2, y[i] + k1/2, a, b, c, d)
        k3 = h * f(x[i] + h/2, y[i] + k2/2, a, b, c, d)
        k4 = h * f(x[i] + h, y[i] + k3, a, b, c, d)
        y_next = y[i] + (k1 + 2*k2 + 2*k3 + k4)/6
        y.append(y_next)
        x_next = x[i] + h
        x.append(x_next)
    return x, y

# Get user input for initial conditions and step size
x0 = float(input("Enter the initial value of x: "))
a = float(input("Enter coefficient of x: "))
c = float(input("Enter power of x: "))
y0 = float(input("Enter the initial value of y: "))
b = float(input("Enter coefficient of y: "))
d = float(input("Enter power of y: "))
xf = float(input("Enter the final value of x: "))
h = float(input("Enter the step size: "))

# Compute the solution using the fourth-order Runge-Kutta method
n = int((xf-x0)/h)
x, y = rk4(x0, y0, h, n, a, b, c, d)

print("x\ty")
for i in range(len(x)):
    print("{:.2f}\t{:.5f}".format(x[i], y[i]))

# Plot the solution
plt.plot(x, y , marker = 'o' , ms = 5 , mec = 'r' , mfc = 'r')
plt.xlabel("x")
plt.ylabel("y")
plt.title(f"Solution to f(x,y)")
plt.show()
