package dao;

import java.sql.*;

public class JdbcDao {
    public static void main (String []args) {

        // creat dao object
        StudentDAO dao = new StudentDAO();
        dao.connect();

        // get name of student using id
        Student s1 = dao.getStudent(2141467);
        System.out.println(s1.studentName);

        // add new student to the table
        Student s2 = new Student();
        s2.studentName = "Ashraf Essa";
        s2.studentID = 2083922;
        dao.addStudent(s2);

        // delete a student from table
        dao.deleteStudent(2083922);

        // print all rows in the table
        dao.printSchema();
    }
}
