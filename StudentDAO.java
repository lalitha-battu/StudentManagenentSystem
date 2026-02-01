package com.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {

    // INSERT
    public void addStudent(Student s) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO students VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getCourse());
            ps.setDouble(4, s.getMarks());

            ps.executeUpdate();
            con.close();
            System.out.println("Student added to database");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // VIEW
    public void viewStudents() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM students";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("course") + " | " +
                    rs.getDouble("marks")
                );
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
