import java.sql.*;

public class StudentDatabase {

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection =null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url ="jdbc:mysql://localhost:3306/school";
        String user ="root";
        String pass ="admin";
        connection= DriverManager.getConnection(url,user,pass);
        if (connection != null){
            System.out.println("Connected to database");
        }
        else {
            System.out.println("Not Connected");
        }
        return connection;


    }
    public void getAllStudentDetails() throws SQLException, ClassNotFoundException {
        Statement st = getConnection().createStatement();
        String sql="Select * from student";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()){
          String names = rs.getString(1);
          int rollNo = rs.getInt(2);
          String email= rs.getString(3);
          String grade = rs.getString(4);
            System.out.println(names +" "+rollNo+" "+email +" "+grade );



        }


    }

    public static void main(String[] args) {
        StudentDatabase s1 =new StudentDatabase();
        try {
            s1.getAllStudentDetails();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }

}
