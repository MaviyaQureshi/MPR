from multiprocessing import Value
from tkinter import *
from tkinter import ttk
screen = Tk()
screen.geometry("600x900")
screen.title("Python Form")
heading = Label(text="Python Form", bg="cyan")
heading.pack()


def register():
    fname_info = fname.get()
    lname_info = lname.get()
    age_info = str(age.get())
    gender_info = gender.get()
    prefEditor_info = prefEditor.get()
    learnPf_info = learnPf.get()
    print(fname_info, lname_info, age_info, gender_info, favLang)
    file = open("user", "r")
    file.write(fname_info)
    file.write("\n")
    file.write(lname_info)
    file.write("\n")
    file.write(age_info)
    file.write("\n")
    file.write(gender_info)
    file.write("\n")
    file.write(prefEditor_info)
    file.write("\n")
    file.write(learnPf_info)
# Labels
fname_info = Label()
fname_text = Label(text = "First Name * ",)
lname_text = Label(text = "Last name * ",)
age_text = Label(text = "Age * ",)
gender_text = Label(text = "Gender * ",)
favLang_text = Label(text = "Favorite Programming Language *",)
prefEditor_text = Label(text = "Preferred Code Editor *",)
learnPf_text = Label(text = "Preferred Learning Platform *",)
# Variables
fname = StringVar()
lname = StringVar()
age = IntVar()
gender = StringVar()
favLang = StringVar()
prefEditor = StringVar()
learnPf = StringVar()
options = ["Male","Female"]
#Text Areas
fname_entry = Entry(textvariable = fname, width="30")
lname_entry = Entry(textvariable = lname, width ="30")
#Spinbox
age_entry = Spinbox(screen, from_=0, to = 100)
# Optionmenu
gender_entry = OptionMenu(screen, gender, *options)
#Combobox
favLang_entry = ttk.Combobox(screen, width = 20)
favLang_entry['values'] = (' C++ ', ' Python',' Java',' C#')
#Radiobuttons
prefEditor_entry1 = Radiobutton(screen, text="VS Code", value=Value)
prefEditor_entry2 = Radiobutton(screen, text="Sublime Text",value=Value)
prefEditor_entry3 = Radiobutton(screen, text="Atom", value = Value)
#Checkbuttons
learnPf_entry1 = Checkbutton(screen, text = "YouTube", variable=1)
learnPf_entry2 = Checkbutton(screen, text = "Udemy", variable=2)
learnPf_entry3 = Checkbutton(screen, text = "Coursera", variable=3)
#Submit Button
submit = Button(screen, text = "Submit" , command = register)
#Placing the Components
fname_text.place(x = 40, y = 100)
lname_text.place(x = 40, y = 200)
age_text.place(x = 40, y = 300)
gender_text.place(x = 40, y = 400)
favLang_text.place(x = 40, y = 500)
prefEditor_text.place(x = 40, y = 600)
learnPf_text.place(x = 40, y = 700)
fname_entry.place(x = 350, y = 100)
lname_entry.place(x = 350, y = 200)
age_entry.place(x = 350, y = 300)
gender_entry.place(x = 350, y = 400)
favLang_entry.place(x = 350, y = 500)
prefEditor_entry1.place(x = 220, y =600 )
prefEditor_entry2.place(x = 300, y = 600)
prefEditor_entry3.place(x = 400, y = 600)
learnPf_entry1.place(x = 220 , y = 700)
learnPf_entry2.place(x = 300 , y = 700)
learnPf_entry3.place(x = 400 , y = 700)
submit.place(x = 300, y = 750)
screen.mainloop()