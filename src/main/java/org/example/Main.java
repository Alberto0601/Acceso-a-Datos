package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url="jdbc:postgresql://localhost:5432/postgres";
        String user="postgres";
        String pass="2026";
        try(Connection con = DriverManager.getConnection(url, user, pass)) {

            Statement st = con.createStatement();
            st.executeUpdate("update usuarios set nombre='Prueba'where nombre='Laura Gómez'");

            ResultSet cursor = st.executeQuery("select nombre from usuarios ");

            while (cursor.next()) {
                String curso = cursor.getString("nombre");
                System.out.println(curso);
            }

        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
