from tkinter import *
from tkinter import ttk
import numpy as np

master = Tk()
master.geometry("600x450+500+200")

master.title("Numerical Techniques")

e1 = Entry(master)
ll = Label(master,text="Select a Mathematical Technique",font=("Arial",16))
ll.place(relx = 0.15,rely=0.2)
l1 = Label(master,text="Enter dimension of matrix :")
b1 = Button()
l2 = Label()
global aEntries, bEntries
entrycanva = Canvas(master, width=450, height=600)


def callBack(event):
    c = event.widget.get()
    if c == "Gauss Elimination":
        ll.destroy()
        gauss_elimination()
    elif c == "Inverse using Gauss Elimination":
        ll.destroy()
        InverseUsingGaussEli()
    elif c == "Runge-Kutta Method":
        ll.destroy()
        RungeKuttaMethod()
    elif c == "Euler Method":
        ll.destroy()
        EulerMethod()


def clear():
    l1.destroy()
    e1.destroy()
    l2.destroy()
    b1.destroy()
    cb.destroy()
    entrycanva.destroy()
    cb1 = ttk.Combobox(master, values=l, width=30)
    cb1.place(relx=1, anchor=NE)
    cb1.bind("<<ComboboxSelected>>", callBack)


def gauss_elimination():
    entrycanva1 = Canvas(master, width=600, height=450)

    def getVal(label):
        if label.get() == '':
            return 0
        else:
            return float(label.get())

    def clear():
        l1.destroy()
        e1.destroy()
        l2.destroy()
        b1.destroy()
        entrycanva1.destroy()
        cb1 = ttk.Combobox(master, values=l, width=30)
        cb1.place(relx=1, anchor=NE)
        cb1.bind("<<ComboboxSelected>>", callBack)

    def u():
        
        n = int(e1.get())

        def createOutLabels(n):
            global outLabels1, outLabels2, outLabels3
            outLabels1 = [[None for i in range(n)]for j in range(n)]
            outLabels2 = [[None for i in range(1)]for j in range(n)]
            outLabels3 = [None for i in range(n)]

            for i in range(n):
                for j in range(n):
                    outLabels1[i][j] = Label(entrycanva1)
                    outLabels1[i][j].grid(row=i+n+7, column=j)
                outLabels2[i] = Label(entrycanva1)
                outLabels2[i].grid(row=i+n+7, column=n)

            for i in range(n):
                outLabels3[i] = Label(entrycanva1)
                outLabels3[i].grid(row=18, column=i)
                
        def createLabel1():
            l = Label(entrycanva1,text="=====Row echelon form====",font=("Arial",11))
            l.grid(row=8,column=1)

        def createLabel2():
            l = Label(entrycanva1, text="Values of x :",font=("Arial",11))
            l.grid(row=16, column=0)

        def solve():
            createOutLabels(n)
            a = [[None for i in range(n)]for j in range(n)]
            b = [None for i in range(n)]
            for i in range(n):
                for j in range(n):
                    a[i][j] = getVal(aEntries[i][j])
                b[i] = getVal(bEntries[i])

            m = len(b)

            # Perform Gaussian elimination
            for i in range(m):
                # Find pivot row
                max_row = i
                for j in range(i+1, m):
                    if abs(a[j][i]) > abs(a[max_row][i]):
                        max_row = j

                # Swap rows if necessary
                if max_row != i:
                    a[i], a[max_row] = a[max_row], a[i]
                    b[i], b[max_row] = b[max_row], b[i]

                # Eliminate all entries below pivot
                for j in range(i+1, m):
                    factor = a[j][i] / a[i][i]
                    b[j] -= factor * b[i]
                    for k in range(i, m):
                        a[j][k] -= factor * a[i][k]
            
            createLabel1()

            for row in range(m):
                for col in range(m):
                    outLabels1[row][col].config(text=f"{a[row][col]:.3f}",font=("Arial",11))
                    outLabels2[row].config(text=f"{b[row]:.3f}",font=("Arial",11))

            # Back substitution
            x = [0] * m
            for i in range(m-1, -1, -1):
                x[i] = b[i]
                for j in range(i+1, n):
                    x[i] -= a[i][j] * x[j]
                x[i] /= a[i][i]

            createLabel2()

            for i in range(len(x)):
                outLabels3[i].config(text=f"x{i+1} = {x[i]:.3f}",font=("Arial",11))

        if e1.get() != "":
            cb.destroy()
            e1.destroy()
            l1.destroy()
            b1.destroy()
            entrycanva1.pack(pady=60)
            aEntries = [[None for j in range(n)]for i in range(n)]
            bEntries = [None for i in range(n)]
            for i in range(n):
                for j in range(n):
                    aEntries[i][j] = Entry(entrycanva1)
                    aEntries[i][j].grid(row=i, column=j)
                bEntries[i] = Entry(entrycanva1)
                bEntries[i].grid(row=i, column=n)

            solve = Button(entrycanva1, text="Solve", command=solve)
            solve.grid(column=1)
            solve.rowconfigure(8, weight=1)
    e1 = Entry(master)
    l1 = Label(master,text="Enter dimension of matrix :")
    l1.place(rely=0.148)
    e1.place(rely=0.15, relx=0.26)
    b1 = Button(master, text="OK", command=lambda: u())
    b1.place(rely=0.145, relx=0.5)
    button = Button(master, text="clear", command=lambda: clear())
    button.place(relx=1, rely=1, anchor=SE)


def EulerMethod():
    entrycanva5 = Canvas(master,width=600, height=450)
    entrycanva6 = Canvas(master,width=600,height=450)
    
    def createLabel1():
        label1 = Label(entrycanva6,text="----Euler's First Order Method----")
        label1.place(relx=0.13)
    
    def createLabel2():
        label2 = Label(entrycanva6,text="----Euler's Modified Method----")
        label2.place(relx=0.63)
    
    def clear():
        l1.destroy()
        e1.destroy()
        l2.destroy()
        b1.destroy()
        entrycanva5.destroy()
        entrycanva6.destroy()

    # Define the differential equation to solve
    def f(x, y, a, b, c, d):
        return a*(x**c) + b*(y**d)

    # Define the fourth-order Runge-Kutta method
    x0=StringVar()
    a=StringVar()
    c=StringVar()
    y0=StringVar()
    b=StringVar()
    d=StringVar()
    xf=StringVar()
    h=StringVar()
    
    def calculate():
        
        x_initial = float(x0.get())
        x_coeff = float(a.get())
        x_power = float(c.get())
        y_initial = float(y0.get())
        y_coeff = float(b.get())
        y_power = float(d.get())
        x_final = float(xf.get())
        step = float(h.get())
        m = int((x_final - x_initial)/step)
        x = [x_initial]
        y = [y_initial]
        y_modified = [y_initial]
        for i in range(m):
            k1 = step * f(x[i], y[i], x_coeff, x_power, y_coeff, y_power)
            x_next = x[i] + step
            x.append(x_next)
            y_next_ = int(y[i] + k1)
            y_next = y[i] + (step/2)*(f(x[i], y[i], x_coeff, x_power, y_coeff, y_power)+f(x[i+1],y_next_, x_coeff, x_power, y_coeff, y_power))
            y.append(y_next_)
            y_modified.append(y_next)
        entrycanva5.destroy()
        entrycanva6.grid()
        button = Button(master, text="clear", command=lambda: clear())
        button.place(relx=1, rely=1, anchor=SE)
        result = Label(entrycanva6,text = "x\t\ty").place(relx=0.16,rely=0.05)
        yk = 0.05
        
        createLabel1()
        
        for i in range(len(x)):
            lk = Label(entrycanva6)
            lk.place(relx=0.15,rely=yk+0.04)
            lk.config(text = "{:.2f}\t\t{:.4f}".format(x[i],y[i]))
            yk = yk + 0.04
        result2 = Label(entrycanva6,text = "x\t\ty").place(relx=0.66,rely=0.05)
        yk2 = 0.05
        
        createLabel2()
        
        for i in range(len(x)):
            lk1 = Label(entrycanva6)
            lk1.place(relx=0.65,rely=yk2+0.04)
            lk1.config(text = "{:.2f}\t\t{:.4f}".format(x[i],y_modified[i]))
            yk2 = yk2+ 0.04
            
    entrycanva5.grid()
    x0label = Label(entrycanva5, text="Enter the initial value , coefficient , power of x : ").place(rely=0.148)
    x0entry = Entry(entrycanva5, width=12,textvariable=x0).place(rely=0.15, relx=0.42)
    aentry = Entry(entrycanva5, width=12,textvariable=a).place(rely=0.15, relx=0.55)
    centry = Entry(entrycanva5, width=12,textvariable=c).place(rely=0.15, relx=0.68)
    y0label = Label(entrycanva5, text="Enter the initial value , coefficient , power of y : ").place(rely=0.248)
    y0entry = Entry(entrycanva5, width=12,textvariable=y0).place(rely=0.25, relx=0.42)
    bentry = Entry(entrycanva5, width=12,textvariable=b).place(rely=0.25, relx=0.55)
    dentry = Entry(entrycanva5, width=12,textvariable=d).place(rely=0.25, relx=0.68)
    xflabel = Label(entrycanva5, text="Enter the final value of x : ").place(rely=0.348)
    xfentry = Entry(entrycanva5, width=12,textvariable=xf).place(rely=0.35, relx=0.26)
    hlabel = Label(entrycanva5, text="Enter the step size : ").place(rely=0.448)
    hentry = Entry(entrycanva5, width=12,textvariable=h).place(rely=0.45, relx=0.26)
    calc = Button(entrycanva5, text="Calculate", command=lambda :calculate()).place(rely=0.53, relx=0.27)
    btn = Button(entrycanva5, text="clear", command=lambda: clear())
    btn.place(relx=0.98, rely=0.98, anchor=SE)


def RungeKuttaMethod():
    entrycanva3 = Canvas(master,width=600, height=450)
    entrycanva4 = Canvas(master,width=600,height=450)
    
    def clear():
        l1.destroy()
        e1.destroy()
        l2.destroy()
        b1.destroy()
        entrycanva3.destroy()
        entrycanva4.destroy()

    # Define the differential equation to solve
    def f(x, y, a, b, c, d):
        return a*(x**c) + b*(y**d)

    # Define the fourth-order Runge-Kutta method
    x0=StringVar()
    a=StringVar()
    c=StringVar()
    y0=StringVar()
    b=StringVar()
    d=StringVar()
    xf=StringVar()
    h=StringVar()
    
    def calculate():
        
        x_initial = float(x0.get())
        x_coeff = float(a.get())
        x_power = float(c.get())
        y_initial = float(y0.get())
        y_coeff = float(b.get())
        y_power = float(d.get())
        x_final = float(xf.get())
        step = float(h.get())
        m = int((x_final - x_initial)/step)
        x = [x_initial]
        y = [y_initial]
        for i in range(m):
            k1 = step * f(x[i], y[i], x_coeff, x_power, y_coeff, y_power)
            k2 = step * f(x[i] + step/2, y[i] + k1/2, x_coeff, x_power, y_coeff, y_power)
            k3 = step * f(x[i] + step/2, y[i] + k2/2, x_coeff, x_power, y_coeff, y_power)
            k4 = step * f(x[i] + step, y[i] + k3, x_coeff, x_power, y_coeff, y_power)
            y_next = int(y[i] + (k1 + 2*k2 + 2*k3 + k4)/6)
            y.append(y_next)
            x_next = x[i] + step
            x.append(x_next)
        entrycanva3.destroy()
        entrycanva4.grid()
        button = Button(master, text="clear", command=lambda: clear())
        button.place(relx=1, rely=1, anchor=SE)
        result = Label(entrycanva4,text = "x\t\ty",font=("Arial",11)).place(relx=0.26)
        yk = 0
        for i in range(len(x)):
            lk = Label(entrycanva4)
            lk.place(relx=0.25,rely=yk+0.06)
            lk.config(text = "{:.2f}\t\t{:.2f}".format(x[i],y[i]),font=("Arial",11))
            yk = yk + 0.04
            
    entrycanva3.grid()
    x0label = Label(entrycanva3, text="Enter the initial value , coefficient , power of x : ").place(rely=0.148)
    x0entry = Entry(entrycanva3, width=12,textvariable=x0).place(rely=0.15, relx=0.42)
    aentry = Entry(entrycanva3, width=12,textvariable=a).place(rely=0.15, relx=0.55)
    centry = Entry(entrycanva3, width=12,textvariable=c).place(rely=0.15, relx=0.68)
    y0label = Label(entrycanva3, text="Enter the initial value , coefficient , power of y : ").place(rely=0.248)
    y0entry = Entry(entrycanva3, width=12,textvariable=y0).place(rely=0.25, relx=0.42)
    bentry = Entry(entrycanva3, width=12,textvariable=b).place(rely=0.25, relx=0.55)
    dentry = Entry(entrycanva3, width=12,textvariable=d).place(rely=0.25, relx=0.68)
    xflabel = Label(entrycanva3, text="Enter the final value of x : ").place(rely=0.348)
    xfentry = Entry(entrycanva3, width=12,textvariable=xf).place(rely=0.35, relx=0.26)
    hlabel = Label(entrycanva3, text="Enter the step size : ").place(rely=0.448)
    hentry = Entry(entrycanva3, width=12,textvariable=h).place(rely=0.45, relx=0.26)
    calc = Button(entrycanva3, text="Calculate", command=lambda :calculate()).place(rely=0.53, relx=0.27)
    btn = Button(entrycanva3, text="clear", command=lambda: clear())
    btn.place(relx=0.98, rely=0.98, anchor=SE)


def InverseUsingGaussEli():
    entrycanva2 = Canvas(master, width=600, height=450)
    
    def createLabel():
        l = Label(entrycanva2,text="=====Inverse Matrix====",font=("Arial",11))
        l.grid(row=8,column=1)

    def getVal(label):
        if label.get() == '':
            return 0
        else:
            return float(label.get())
        
    def clear():
        l1.destroy()
        e1.destroy()
        l2.destroy()
        b1.destroy()
        entrycanva2.destroy()
        cb2 = ttk.Combobox(master, values=l, width=30)
        cb2.place(relx=1, anchor=NE)
        cb2.bind("<<ComboboxSelected>>", callBack)

    def u():
        n = int(e1.get())

        def createOutLabels(n):
            global outLabels3
            outLabels3 = [[None for i in range(n)]for j in range(n)]

            for i in range(n):
                for j in range(n):
                    outLabels3[i][j] = Label(entrycanva2)
                    outLabels3[i][j].grid(row=i+n+7, column=j)

        def solve():
            createOutLabels(n)
            a = np.zeros((n, n))
            for i in range(n):
                for j in range(n):
                    a[i][j] = getVal(aEntries[i][j])

            m = a.shape[0]
            # Augment the matrix with identity matrix
            A_aug = np.hstack((a, np.identity(m)))

            # Perform forward elimination
            for i in range(m):
                # Pivot row i if necessary
                pivot_row = i
                for j in range(i+1, m):
                    if abs(A_aug[j, i]) > abs(A_aug[pivot_row, i]):
                        pivot_row = j
                if pivot_row != i:
                    A_aug[[i, pivot_row], :] = A_aug[[pivot_row, i], :]
                # Reduce all rows below row i
                for j in range(i+1, m):
                    factor = A_aug[j, i] / A_aug[i, i]
                    A_aug[j, :] -= factor * A_aug[i, :]

            # Perform backward substitution
            for i in range(m-1, -1, -1):
                A_aug[i, :] /= A_aug[i, i]
                for j in range(i-1, -1, -1):
                    factor = A_aug[j, i]
                    A_aug[j, :] -= factor * A_aug[i, :]
                    
            createLabel()

            for i in range(len(A_aug)):
                for j in range(len(A_aug)):
                    outLabels3[i][j].config(text=f"{A_aug[i][m+j]:.3f}",font=("Arial",11))

        if e1.get() != "":
            cb.destroy()
            e1.destroy()
            l1.destroy()
            b1.destroy()
            entrycanva2.pack(pady=60)
            aEntries = [[None for j in range(n)]for i in range(n)]
            for i in range(n):
                for j in range(n):
                    aEntries[i][j] = Entry(entrycanva2)
                    aEntries[i][j].grid(row=i, column=j)

            solve = Button(entrycanva2, text="Solve", command=solve)
            solve.grid(column=1)
            solve.rowconfigure(8, weight=1)
    e1 = Entry(master)
    l1 = Label(master,text="Enter dimension of matrix :")
    l1.place(rely=0.148)
    e1.place(rely=0.15, relx=0.26)
    b1 = Button(master, text="OK", command=lambda: u())
    b1.place(rely=0.145, relx=0.5)
    button = Button(master, text="clear", command=lambda: clear())
    button.place(relx=1, rely=1, anchor=SE)


def update():
    if cb.get() == "Gauss Elimination":
        label.destroy()
        gauss_elimination()
    elif cb.get() == "Euler Method":
        label.destroy()
        EulerMethod()
    elif cb.get() == "Runge-Kutta Method":
        label.destroy()
        RungeKuttaMethod()
    elif cb.get() == "Inverse using Gauss Elimination":
        label.destroy()
        InverseUsingGaussEli()
    else:
        label.destroy()
        label.config(text="Please select a valid option!!")


l = ["Gauss Elimination", "Inverse using Gauss Elimination","Runge-Kutta Method", "Euler Method"]
cb = ttk.Combobox(master, values=l, width=30)
cb.place(relx=1, anchor=NE)
cb.bind("<<ComboboxSelected>>", callBack)


label = Label(master)
master.columnconfigure(1, weight=1)

master.mainloop()