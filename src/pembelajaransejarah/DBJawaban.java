/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pembelajaransejarah;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javafx.collections.ObservableList;

/**
 *
 * @author Lenovo
 */
public class DBJawaban {
    
    private static final Map<Integer, String> correctAnswers = new HashMap<>();

    static {
        // Load correct answers from the database
        loadCorrectAnswers();
    }

    private static void loadCorrectAnswers() {
    try {
        Koneksi con = new Koneksi();
        con.bukaKoneksi();

        String query = "SELECT nosoal, jawaban FROM kuncijawaban"; // Correct table name
        PreparedStatement preparedStatement = con.dbKoneksi.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int questionNumber = resultSet.getInt("nosoal");
            String correctAnswer = resultSet.getString("jawaban");
            correctAnswers.put(questionNumber, correctAnswer);
        }

        con.tutupKoneksi();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    // Method to get correct answer for a specific question
    public static String getCorrectAnswer(int questionNumber) {
        return correctAnswers.get(questionNumber);
    }

    // Method to calculate marks based on user's selected answers
   public static int calculateMarks(Map<Integer, String> userAnswers) {
    int marks = 0;

    for (Map.Entry<Integer, String> entry : userAnswers.entrySet()) {
        int questionNumber = entry.getKey();
        String userAnswer = entry.getValue();

        // Get the correct answer for the question
        String correctAnswer = getCorrectAnswer(questionNumber);

        // Check if the user's answer is correct
        if (correctAnswer != null && correctAnswer.equals(userAnswer)) {
            marks += 20; // Each correct answer adds 20 marks (adjust as needed)
        }
    }

    return marks;
}

}
