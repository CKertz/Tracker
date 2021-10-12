package com.cooper.tracker.profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository <Profile, Long> {

    @Query("Select p from Profile p where p.profileName = ?1")
    Optional<Profile> findProfileByName (String name);



}
//    public static void main (String[]args){
//        String jdbcURL= "jdbc:postgresql://localhost:5432/leaguenotes";
//        jdbcURL= "jdbc:postgresql:aws://database-1-instance-1.ckb6rlftw01d.us-west-2.rds.amazonaws.com:5432/leaguenotes";
//        String username = "postgres";
//        //String password = "admin";
//        String password = "6xRDlSKu1IyZl6bfn9oF";
//        try {
//            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
//            getQuery(connection);
//            System.out.print("Connected to PostgreSQL server");
//
//            connection.close();
//        } catch (SQLException e) {
//            System.out.println("Error in connecting to PostgreSQL server");
//            e.printStackTrace();
//        }
//
//
//    }
//    public void insertQuery (Connection connection){
//        try{
//            String sql = "INSERT INTO entry () VALUES (?, ?, ?, ?";
//
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, "");
//            statement.setString(2, "");
//            statement.setString(3, "");
//            statement.setString(4, "");
//
//            int rows = statement.executeUpdate(sql);
//            if (rows > 0) {
//                System.out.println("A new entry has been inserted");
//            }
//            connection.close();
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//
//    public static void getQuery (Connection connection){
//        try{
//            String sql = "select * from entry";
//
//            Statement statement = connection.createStatement();
//            ResultSet result = statement.executeQuery(sql);
//
//            while (result.next()){
//                String matchHistoryLink = result.getString("match_history_link");
//                String vodLink = result.getString("vod_link");
//                System.out.println("match history link:" + matchHistoryLink + ",vod link:" + vodLink);
//                // and so on..
//            }
//
//            connection.close();
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//}
