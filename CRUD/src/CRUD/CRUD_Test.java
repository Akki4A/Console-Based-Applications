package CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CRUD_Test {
    public static void main(String[] args) {
        CRUD_Test objTest = new CRUD_Test();
        Scanner sc = new Scanner(System.in);
        boolean condition = true;
        while (condition==true) {
            System.out.println("********Greetings********");
            System.out.println();
            System.out.println("Press 1 to insert new Employee");
            System.out.println("Press 2 to display all Employee");
            System.out.println("Press 3 to display one Specific Employee");
            System.out.println("Press 4 to update existing Employee");
            System.out.println("Press 5 to delete existing Employee");
            System.out.println("Press 6 to exit program");
            System.out.println();
            try {
                int choose = sc.nextInt();
                //insert data
                if (choose == 1) {
                    System.out.println("Enter Employee's User ID :");
                    int userID = sc.nextInt();
                    System.out.println("Enter Name of the Employee :");
                    String name = sc.next();
                    System.out.println("Enter Email of the Employee :");
                    String email = sc.next();
                    System.out.println("Enter Address of the Employee :");
                    String address = sc.next();
                    System.out.println("Enter Phone Number of the Employee :");
                    String phone = sc.next();
                    System.out.println("Enter Designation of the Employee :");
                    String designation = sc.next();
                    System.out.println("Enter Salary of the Employee :");
                    String salary = sc.next();
                    objTest.create_data(userID, name, email, address, phone, designation, salary);
                }
                //read data for All Employee
                if (choose == 2) {
                    objTest.read_data();
                }
                //read data for Specific Employee
                if (choose == 3) {
                    System.out.println("Enter User ID :");
                    int userID = sc.nextInt();
                    objTest.read_data(userID);

                }
                //update data
                if (choose == 4) {
                    System.out.println("Enter Employee's User ID you want to change:");
                    int userID = sc.nextInt();
                    System.out.println("Enter Name of the Employee :");
                    String name = sc.next();
                    System.out.println("Enter Email of the Employee :");
                    String email = sc.next();
                    System.out.println("Enter Address of the Employee :");
                    String address = sc.next();
                    System.out.println("Enter Phone Number of the Employee :");
                    String phone = sc.next();
                    System.out.println("Enter Designation of the Employee :");
                    String designation = sc.next();
                    System.out.println("Enter Salary of the Employee :");
                    String salary = sc.next();
                    objTest.update_data(userID, name, email, address, phone, designation, salary);
//                    System.out.println("Employee's Information is Updated.");
                }
                //delete data
                if (choose == 5) {
                    System.out.println("Enter Employee's User ID :");
                    int userID = sc.nextInt();
                    objTest.delete_data(userID);
                }
                //exit
                if (choose == 6) {
                    condition = false;
                }

            }
            catch (Exception e){
                System.out.println(e);
                System.out.println("Something went wrong! Check your input");
            }
        }
    }

    public void create_data(int userID,String name,String email,String address,String phone,String designation,String salary){
        DB_Connection obj_DB_Connection=new DB_Connection();
        Connection connection=obj_DB_Connection.get_connection();
        PreparedStatement ps=null;
        try {
            String query="insert into employee(userID,name,email,address,phone,designation,salary) values (?,?,?,?,?,?,?)";
            ps=connection.prepareStatement(query);
            ps.setInt(1, userID);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, address);
            ps.setString(5, phone);
            ps.setString(6, designation);
            ps.setString(7, salary);
//            System.out.println(ps);
            ps.executeUpdate();
            System.out.println("New Employee is Inserted Into DATABASE.");
        } catch (Exception e) {
            System.out.println(e);
//            System.out.println("Employee Already Existed in the DATABASE!");
        }
    }

    public void read_data(int userID){
        DB_Connection obj_DB_Connection=new DB_Connection();
        Connection connection=obj_DB_Connection.get_connection();
        System.out.println("Creating Connection with DATABASE...");
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            String query="select * from employee where userID=?";
            ps=connection.prepareStatement(query);
            ps.setInt(1, userID);
//            System.out.println(ps);
            rs=ps.executeQuery();
            while(rs.next()){
                System.out.println("Getting Data for Employee Having userID : "+userID);
                System.out.println("userID -"+rs.getInt("userID"));
                System.out.println("name -"+rs.getString("name"));
                System.out.println("email -"+rs.getString("email"));
                System.out.println("address -"+rs.getString("address"));
                System.out.println("phone -"+rs.getString("phone"));
                System.out.println("designation -"+rs.getString("designation"));
                System.out.println("salary -"+rs.getString("salary"));
                System.out.println("---------------");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void read_data(){
        DB_Connection obj_DB_Connection=new DB_Connection();
        Connection connection=obj_DB_Connection.get_connection();
        System.out.println("Creating Connection with DATABASE...");
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            String query="select * from employee";
            ps=connection.prepareStatement(query);
//            System.out.println(ps);
            System.out.println("Getting Data for All the Employees");
            rs=ps.executeQuery();
            while(rs.next()){

                System.out.println("userID -"+rs.getInt("userID"));
                System.out.println("name -"+rs.getString("name"));
                System.out.println("email -"+rs.getString("email"));
                System.out.println("address -"+rs.getString("address"));
                System.out.println("phone -"+rs.getString("phone"));
                System.out.println("designation -"+rs.getString("designation"));
                System.out.println("salary -"+rs.getString("salary"));
                System.out.println("---------------");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void update_data(int userID,String name,String email,String address,String phone,String designation,String salary){
        DB_Connection obj_DB_Connection=new DB_Connection();
        Connection connection=obj_DB_Connection.get_connection();
        PreparedStatement ps=null;
        try {
            String query="update employee set name=?,email=?,address=?,phone=?,designation=?,salary=? where userID=?";
            ps=connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, address);
            ps.setString(4, phone);
            ps.setString(5, designation);
            ps.setString(6, salary);
            ps.setInt(7, userID);
//            System.out.println(ps);
            ps.executeUpdate();
        } catch (Exception e) {
//            System.out.println("Employee has Never Existed in the DATABASE!");
            System.out.println(e);
        }
    }

    public void delete_data(int userID){
        DB_Connection obj_DB_Connection=new DB_Connection();
        Connection connection=obj_DB_Connection.get_connection();
        PreparedStatement ps=null;
        try {
            String query="delete from employee where userID=?";
            ps=connection.prepareStatement(query);
            ps.setInt(1, userID);
//            System.out.println(ps);
            System.out.println("Employee Deleted!");
            ps.executeUpdate();
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }
}
