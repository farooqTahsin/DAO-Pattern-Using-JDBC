package dao;

import java.sql.*;

class StudentDAO {
    Connection con = null;
    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/home", "root", "FarooqTahsin23");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public Student getStudent(int studentId) {
        try {
            String query = "select * from student where id="+studentId;
            Student s = new Student();
            s.studentID = studentId;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            s.studentName = rs.getString(2);
            return s;
        }catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public void addStudent (Student s) {
        String query = "insert into student values (?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, s.studentID);
            pst.setString(2, s.studentName);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void deleteStudent (int studentId) {
        String query = "delete from student where id = "+studentId;
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public void printSchema() {
        String query = "select * from student";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                System.out.println(rs.getInt(1)+" "+rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

