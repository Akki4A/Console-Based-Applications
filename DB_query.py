import mysql.connector as connector

class D_B_H:
    def __init__(self):
        self.con = connector.connect(host='localhost',
                                    user='AKKI4a',
                                    password='2019iscoming',
                                    database='pythontest')
        query = 'create table if not exists user(UserID int primary key,UserName varchar(200),Phone varchar(12))' 
        cur = self.con.cursor() 
        cur.execute(query)

    #Insert
    def insert(self,UserID,Username,Phone):
        query = "insert into user(UserID,Username,Phone) values('{}','{}','{}')".format(UserID, Username, Phone)
        cur1 = self.con.cursor()
        cur1.execute(query)
        self.con.commit()
        print("user is saved to DB")
        
    
    #fetch data
    def fetch(self):
        query = "select * from user"
        cur2 = self.con.cursor()
        cur2.execute(query)
        for i in cur2:
            print("UserID :", i[0])
            print("UserName :", i[1])
            print("Phone Number :", i[2])
            print()
            print()

    #delete        
    def delete_user(self,UserID):
        query = "delete from user where UserID = {}".format(UserID)
        cur3 = self.con.cursor()
        cur3.execute(query)
        self.con.commit()
        print("deleted")
    
    #Update
    def Update_user(self, UserID, NewName, Newphone):
        query = "update user set Username = '{}',Phone = '{}'where UserID = {}".format(NewName, Newphone, UserID)
        cur4 = self.con.cursor()
        cur4.execute(query)
        self.con.commit()
        print("User Added!!!!")
