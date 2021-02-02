package CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class CRUD_Test {
    public static void main(String[] args) {
        CRUD_Test objTest=new CRUD_Test();
        //insert data
//        objTest.create_data(8, "Karan", "karan@gmail.com", "Delhi","6325413655", "Developer","360000");
//        objTest.create_data(9, "Arjun", "arjun@gmail.com", "Haryana","6325419755", "Developer","360000");
//        objTest.create_data(10, "Kiran", "kiran@gmail.com", "Delhi","6325413655", "Developer","360000");
//        objTest.create_data(11, "Shabaana", "shabaana@gmail.com", "Uttar Pradesh","6325416785", "Developer","360000");
        //read data
//        objTest.read_data();
        //update data
//        objTest.update_data(6, "Sushma", "sushma@gmail.com", "Muradabad","6325412545", "HR","400000");
        //delete data
//        objTest.delete_data(7);
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
//            System.out.println(e);
            System.out.println("Employee Already Existed in the DATABASE!");
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
            System.out.println("Employee's Information is Updated.");
        } catch (Exception e) {
            System.out.println("Employee has Never Existed in the DATABASE!");
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
