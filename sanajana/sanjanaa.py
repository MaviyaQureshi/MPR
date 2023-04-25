from multiprocessing import Value
from tkinter import *
from tkinter import ttk
from attr import validate
import mysql.connector
import sanajana.sanjanagui as sn

screen = Tk()
screen.geometry("600x900")
screen.title("Python Form")
heading = Label(text="Python Form", bg="cyan")
heading.pack()


def register():
    sn.fname_info = fname.get()
    lname_info = lname.get()
    age_info = str(age_entry.get())
    gender_info = gender.get()
    favlang_info = favLang_entry.get()
    preEditor_info = radio.get()

    if check1.get():
        learnPf_info = "You Tube"
    elif check2.get():
        learnPf_info = "Udemy"
    else:
        learnPf_info = "Coursera"


print(f"First_name:{sn.fname_info}\nLast_name:{sn.lname_info}\nAge: {sn.age_info}\nGender: {sn.gender_info}\nProgramming_Lang: {sn.favlang_info}\nEditor: {sn.preEditor_info}\nLearning_platform: {sn.learnPf_info}\n")

conn_obj = mysql.connector.connect(
host="localhost", user="root",passwd="Yogi24112002@", database="New_PythonDB")
cur_obj = conn_obj.cursor()
query = "INSERT INTO STUDENTS (FIRST_NAME, LAST_NAME, AGE, GENDER, PROGRAMMING_LANG,EDITOR,LEARNING_PLATFORM) VALUES(%s,%s,%s,%s,%s,%s,%s)"
Val = (sn.fname_info, sn.lname_info, sn.age_info , sn.gender_info, sn.favlang_info, sn.preEditor_info, sn.learnPf_info)
cur_obj.execute(query, validate)
conn_obj.commit()  
print (cur_obj.rowcount,"Record inserted!")
 
 #Labels
fname_text = Label (text = "First Name * ",bg='pink') 
lname_text = Label (text = "Last name * ",bg='pink') 
age_text = Label (text = "Age * ",bg='pink') 
gender_text = Label (text = "Gender * ",bg='pink') 
favLang_text = Label (text = "Favorite Programming Language *",bg='pink') 
prefEditor_text = Label (text = "Preferred Code Editor *",bg='pink') 
learnPf_text = Label (text = "Preferred Learning Platofrm *",bg='pink')

#  Variables
fname = StringVar() 
lname = StringVar() 
age = IntVar() 
gender = StringVar() 
favLang = StringVar() 
radio = StringVar() 
check1 = StringVar()
check2 = StringVar()
check3 = StringVar()
options = ["Male","Female"]  
#Text Areas
fname_entry = Entry (textvariable = fname, width="30") 
lname_entry = Entry (textvariable = lname, width ="30") 
#Spinbox 
age_entry = Spinbox(screen, from_=0, to=100)
# Option menu 
gender_entry = OptionMenu(screen, gender, *options) 
#Combobox 
favLang_entry = ttk.Combobox(screen, width = 20) 
favLang_entry['values'] = (' C++ ', ' Python',' Java',' C#') 

#Radiobuttons 
prefEditor_entry1=Radiobutton(screen, text="VS Code",variable=radio, value="VS Code")
prefEditor_entry2=Radiobutton(screen,text="SublimeText", variable=radio,value="Sublime Text") 
prefEditor_entry3 = Radiobutton(screen, text="Atom",variable=radio, value ="Atom") 
#Checkbuttons 
learnPf_entry1 = Checkbutton(screen, text = "YouTube", variable=check1) 
learnPf_entry2 = Checkbutton(screen, text = "Udemy", variable=check2) 
learnPf_entry3 = Checkbutton(screen, text = "Coursera", variable=check3) 
#Submit Button 
submit = Button (screen, text="Submit", width=10, height=2, bg='orange', command = register) 
#Placing the Components 
fname_text.place(x = 40, y = 20)
lname_text.place(x = 40, y = 50)
age_text.place(x = 40, y = 100)
gender_text.place(x = 40, y = 150)
favLang_text.place(x = 40, y = 200)
prefEditor_text.place(x = 40, y =250)
learnPf_text.place(x = 40, y = 300)
fname_entry.place(x = 350, y = 20)
lname_entry.place(x = 350, y = 50)

age_entry.place(x = 350, y = 100)
gender_entry.place(x = 350, y =150)
favLang_entry.place(x = 350, y =200)
prefEditor_entry1.place(x = 220, y =250)
prefEditor_entry2.place(x = 300, y = 250)
prefEditor_entry3.place(x = 400, y = 250)
learnPf_entry1.place(x = 220, y = 300)
learnPf_entry2.place(x = 300, y = 300)
learnPf_entry3.place(x = 400, y = 300)
submit.place(x = 300, y = 400)
  
screen.mainloop()