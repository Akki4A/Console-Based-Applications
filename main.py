from DB_query import D_B_H

def main():
    db = D_B_H()

    while True:
        print("********Greetings********")
        print()
        print("Press 1 to insert new user")
        print("Press 2 to display all users")
        print("Press 3 to delete user")
        print("Press 4 to update existing user")
        print("Press 5 to exit program")
        print()
        try:
            choose = int(input())
            if choose == 1:
                #insert new user
                uid = int(input("Enter User ID :"))
                un = input("Enter UserName here :")
                p = input("Enter Phone Number here :")
                db.insert(uid, un, p)
                
            elif choose == 2:
                #display all users
                db.fetch()

            elif choose == 3:
                #delete user
                uid = int(input("Enter User ID, for which you want to Delete all Data :"))
                db.delete_user(uid)
                 
            elif choose == 4:
                #update user
                uid = int(input("Enter User ID :"))
                un = input("Enter New UserName here :")
                p = input("Enter New Phone Number here :")
                db.Update_user(uid, un, p)

            elif choose == 5:
                break

            else:
                print("Invalid input! Try again")  
                      
        except Exception as e:
                print(e)
                print("Invalid Details !!!!!!!")

if __name__=="__main__":
    main()





