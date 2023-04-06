import tkinter as tk
import numpy as np

class GaussEliminationApp:
    def __init__(self, master):
        self.master = master
        self.master.title("Gauss Elimination")
        
        # Create input matrix label and entry boxes
        self.input_label = tk.Label(master, text="Enter matrix (separate entries by spaces):")
        self.input_label.pack()
        self.input_entries = []
        for i in range(3):
            row_entries = []
            for j in range(3):
                entry = tk.Entry(master, width=8)
                entry.grid(row=i+1, column=j)
                row_entries.append(entry)
            self.input_entries.append(row_entries)
        
        # Create button to perform Gauss elimination
        self.button = tk.Button(master, text="Perform Gauss Elimination", command=self.perform_gauss_elimination)
        self.button.pack(pady=10)
        
        # Create output matrix label and text box
        self.output_label = tk.Label(master, text="Output matrix:")
        self.output_label.pack()
        self.output_text = tk.Text(master, height=3, width=30)
        self.output_text.pack()
        
    def perform_gauss_elimination(self):
        # Get input matrix
        A = np.zeros((3, 3))
        for i in range(3):
            for j in range(3):
                A[i,j] = float(self.input_entries[i][j].get())

        # Create window to display matrix after each operation
        self.display_window = tk.Toplevel(self.master)
        self.display_window.title("Gauss Elimination Steps")
        
        # Perform Gauss elimination
        n = A.shape[0]
        # Augment the matrix with identity matrix
        A_aug = np.hstack((A, np.identity(n)))

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

            # Display matrix after each step
            step_label = tk.Label(self.display_window, text=f"After step {i+1}:")
            step_label.pack()
            for k in range(n):
                for l in range(2*n):
                    step_entry = tk.Entry(self.display_window, width=8)
                    step_entry.grid(row=k+1, column=l)
                    step_entry.insert(tk.END, f"{A_aug[k,l]:.2f}")
            self.display_window.update()
            
        # Perform backward substitution
        for i in range(n-1, -1, -1):
            A_aug[i,:] /= A_aug[i,i]
            for j in range(i-1, -1, -1):
                factor = A_aug[j,i]
                A_aug[j,:] -= factor * A_aug[i,:]

        # Display resulting matrix
        self.output_text.delete(1.0, tk.END)
        for i in range(n):
            for j in range(n):
                self.output_text.insert(tk.END, f"{A_aug[i,j]:.2f}\t")

# Create GUI window
root = tk.Tk()
app = GaussEliminationApp(root)
root.mainloop()
