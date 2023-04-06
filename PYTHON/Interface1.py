# Importing Tkinter libraries
from tkinter import *
from tkinter import ttk

# Creating main window
master = Tk()

# Setting title for main window
master.title("Sparse Matrix: Enter dimensions")

# Opening the calculator menu
def matWindowCreate(m1, n1, m2, n2):
    global matWindow
    matWindow = Toplevel(master)
    matWindow.title("Sparse Matrix: Enter matrices and choose operation")
    
    # Header row labels
    matLabelA = Label(matWindow, text = "1st matrix")
    matLabelB = Label(matWindow, text = "2nd matrix")
    
    # Adding header row to grid
    matLabelA.grid(row = 0, column = 0, columnspan = n1)
    matLabelB.grid(row = 0, column = n1 + 1, columnspan = n2)
    
    # Blank spacing (separator) between the 2 matrices
    separatorLabel = Label(matWindow, text = "\t\t")
    separatorLabel.grid(row = 0, column = n1, rowspan = max(m1, m2) + 1)
    
    # Creating 2D arrays to store entries
    global aEntries, bEntries
    aEntries = [[None for j in range(n1)] for i in range(m1)]
    bEntries = [[None for j in range(n2)] for i in range(m2)]
    
    # Creating entries, appending them to the list and adding them to the grid (matrix 1)
    for i in range(m1):
        for j in range(n1):
            aEntries[i][j] = Entry(matWindow)
            aEntries[i][j].grid(row = i + 1, column = j)
            
    # Creating entries, appending them to the list and adding them to the grid (matrix 2)
    for i in range(m2):
        for j in range(n2):
            bEntries[i][j] = Entry(matWindow)
            bEntries[i][j].grid(row = i + 1, column = j + n1 + 1)
            
    # Creating output header
    global resultLabel
    resultLabel = Label(matWindow)
    resultLabel.grid(row = max(m1, m2) + 3, column = 0)
    
    # Creating buttons for functions and addiing them to the grid
    btnAdd = ttk.Button(matWindow, text = "Add", command = lambda: add(m1, n1, m2, n2))
    btnAdd.grid(row = max(m1, m2) + 2, column = 0)
    btnSub = ttk.Button(matWindow, text = "Subtract", command = lambda: sub(m1, n1, m2, n2))
    btnSub.grid(row = max(m1, m2) + 2, column = 1)
    btnMult = ttk.Button(matWindow, text = "Multiply", command = lambda: mult(m1, n1, m2, n2))
    btnMult.grid(row = max(m1, m2) + 2, column = 2)

# Calculate output size for generating output labels
def calcOutSize(m1, n1, m2, n2):
    outSize = []
    if (m1 == m2 and n1 == n2):
        outSize.append(m1)
        outSize.append(n1)
    elif (n1 == m2):
        outSize.append(m1)
        outSize.append(n2)
    else:
        outSize.append(-1)
    return outSize

# Generate output labels
def createOutLabels(m1, n1, m2, n2):
    global outLabels
    if (calcOutSize(m1, n1, m2, n2)[0] == -1):
        outLabels = [[Label(matWindow)]]
    else:
        outRows = calcOutSize(m1, n1, m2, n2)[0]
        outCols = calcOutSize(m1, n1, m2, n2)[1]
        outLabels = [[None for j in range(outCols)] for i in range(outRows)]
        for i in range(outRows):
            for j in range(outCols):
                outLabels[i][j] = Label(matWindow)
                outLabels[i][j].grid(row = i + max(m1, m2) + 4, column = j)

# Addition function
def add(m1, n1, m2, n2):
    createOutLabels(m1, n1, m2, n2)
    if (m1 == m2 and n1 == n2):
        resultLabel.config(text = "Resulting matrix:")
        for i in range(m1):
            for j in range(n1):
                outLabels[i][j].config(text = getVal(aEntries[i][j]) + getVal(bEntries[i][j]))
    else:
        resultLabel.config(text = "Invalid sizes")

# Subtraction function
def sub(m1, n1, m2, n2):
    createOutLabels(m1, n1, m2, n2)
    if (m1 == m2 and n1 == n2):
        resultLabel.config(text = "Resulting matrix:")
        for i in range(m1):
            for j in range(n1):
                outLabels[i][j].config(text = getVal(aEntries[i][j]) - getVal(bEntries[i][j]))
    else:
        resultLabel.config(text = "Invalid sizes")

# Multiplication function
def mult(m1, n1, m2, n2):
    createOutLabels(m1, n1, m2, n2)
    if (n1 == m2):
        resultLabel.config(text = "Resulting matrix:")
        for i in range(m1):
            for j in range(n2):
                element = 0
                for k in range(m2):
                    element += getVal(aEntries[i][k]) * getVal(bEntries[k][j])
                outLabels[i][j].config(text = element)
    else:
        resultLabel.config(text = "Invalid sizes")

# Get value of cell (depending on whether there is any data entered or not)
def getVal(label):
    if label.get() == '':
        return 0
    else:
        return int(label.get())

# Header row labels
blankLabel = Label(master)
rowLabel = Label(master, text = "Rows")
colLabel = Label(master, text = "Columns")

# Labels for matrix sizes
sizeLabelA = Label(master, text = "Enter dimensions of the 1st matrix: ")
sizeLabelB = Label(master, text = "Enter dimensions of the 2nd matrix: ")

#Entry fields for matrix sizes
m1 = Entry(master)
n1 = Entry(master)
m2 = Entry(master)
n2 = Entry(master)

# Adding labels and entry fields to the grid
colLabel.grid(row = 0, column = 0)
rowLabel.grid(row = 0, column = 1)
colLabel.grid(row = 0, column = 2)
sizeLabelA.grid(row = 1, column = 0)
m1.grid(row = 1, column = 1)
n1.grid(row = 1, column = 2)
sizeLabelB.grid(row = 2, column = 0)
m2.grid(row = 2, column = 1)
n2.grid(row = 2, column = 2)

# Create button to open matrix entry window
btnEntry = ttk.Button(master, text = "OK", command = lambda: matWindowCreate(getVal(m1), getVal(n1), getVal(m2), getVal(n2)))

# Add button to grid
btnEntry.grid(row = 3, column = 2)

# Display main window until termination
master.mainloop()