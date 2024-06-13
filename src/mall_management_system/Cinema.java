package mall_management_system;

import java.util.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import java.time.LocalDate;
import javax.swing.JOptionPane;


public class Cinema extends Activity {
    List<Movie> movies;//Aggregation
    int hallnumbers[];
    List<String> food;
    
    //Default constructor
    public Cinema() {
        super();
        movies = new ArrayList<>();
        hallnumbers = new int[5];
        food = new ArrayList<>();
    }
    //Argument-based constructor
    public Cinema(List<Movie> movies, int[] hallnumbers, List<String> food, double registration_fee, int phonenumber, String email, Manager manager, String opening_hour, String closing_hour, Employee employee) {
        super(registration_fee, phonenumber, email, manager, opening_hour, closing_hour, employee);
        this.movies = movies;//shallow copy
        this.hallnumbers = hallnumbers;
        this.food = food;
    }
    //Copy constructor
    public Cinema(Cinema c) {
        super(c);
        movies = c.movies;
        hallnumbers = c.hallnumbers;
        food = c.food;
    }

    public void displayfood() {
        for (String f : food) {
            System.out.println(f.toString());
        }
    }

    public void AddFood(String f) {
        food.add(f);
    }

    public void removefood(String f) {
        food.remove(f);
    }

    public void displaymovies() {
        for (Movie m : movies) {
            System.out.println(m.toString());
        }
    }
    public void Welcome()
    {
        System.out.println("Welcome to Vox Cinema");
    }

    public void showMovies() {
        movies.add(new Movie());
        movies.add(new Movie("Scream", "Horror", LocalDate.of(2004, 12, 12), "120 min", 12));
        movies.add(new Movie("Love Hard", "Romantic", LocalDate.of(2020, 12, 12), "140 min", 10));

        Stage moviesStage = new Stage();
        moviesStage.setTitle("Available Movies");

        VBox moviesRoot = new VBox(10); // Add spacing between each movie
        moviesRoot.setAlignment(Pos.CENTER);

        for (Movie movie : movies) {
            VBox movieDetails = new VBox(5);
            movieDetails.setAlignment(Pos.CENTER);
            movieDetails.setStyle("-fx-padding: 10;"); // Add padding to each movie details box

            Label nameLabel = new Label("Name: " + movie.getMovie_name());
            Label genreLabel = new Label("Genre: " + movie.getMovie_genre());
            Label dateLabel = new Label("Release Date: " + movie.getRelease_date());
            Label durationLabel = new Label("Duration: " + movie.getRunning_time());

            movieDetails.getChildren().addAll(nameLabel, genreLabel, dateLabel, durationLabel);

            moviesRoot.getChildren().add(movieDetails);
        }

        // VBox for "Enter Number of Tickets" label and text field
        VBox ticketsBox = new VBox(5);
        ticketsBox.setAlignment(Pos.CENTER); // Center the VBox
        Label ticketsLabel = new Label("Enter Number of Tickets:");
        TextField ticketsTextField = new TextField();
        ticketsTextField.setAlignment(Pos.CENTER); // Center text field
        ticketsBox.getChildren().addAll(ticketsLabel, ticketsTextField);

        // VBox for "Enter Movie" label and text field
        VBox movieBox = new VBox(5);
        movieBox.setAlignment(Pos.CENTER); // Center the VBox
        Label movieLabel = new Label("Enter Movie:");
        TextField movieTextField = new TextField();//takes string only
        movieTextField.setAlignment(Pos.CENTER); // Center text field
        movieBox.getChildren().addAll(movieLabel, movieTextField);

        // Button for "Get Tickets"
        Button getTicketsButton = new Button("Get Tickets");
        getTicketsButton.setAlignment(Pos.CENTER); // Center button

        // Add them to the layout
        moviesRoot.getChildren().addAll(ticketsBox, movieBox, getTicketsButton);

        // Action for the "Get Tickets" button
        getTicketsButton.setOnAction(event -> {
            String numberOfTickets = ticketsTextField.getText();
            String movieName = movieTextField.getText();
            System.out.println("Number of Tickets: " + numberOfTickets);
            System.out.println("Movie: " + movieName);

            // Check if the entered movie is available
            boolean movieAvailable = false;
            for (Movie movie : movies) {
                if (movie.getMovie_name().equalsIgnoreCase(movieName)) {
                    movieAvailable = true;
                    break;
                }
            }

            if (movieAvailable) {
                // Calculate the total price
                double totalPrice = getRegistration_fee() * Integer.parseInt(numberOfTickets);

                // Display success message using JOptionPane
                JOptionPane.showMessageDialog(null, "Tickets successfully booked!");

                // Create a label to display the total price
                Label totalPriceLabel = new Label("Total Price: $" + totalPrice);
                totalPriceLabel.setAlignment(Pos.CENTER);

                // Create a new stage to display the total price
                Stage totalPriceStage = new Stage();
                totalPriceStage.setTitle("Total Price");
                VBox totalPriceRoot = new VBox(10);
                totalPriceRoot.setAlignment(Pos.CENTER);
                totalPriceRoot.getChildren().add(totalPriceLabel);
                Scene totalPriceScene = new Scene(totalPriceRoot, 300, 200);
                totalPriceStage.setScene(totalPriceScene);
                totalPriceStage.show();
            } else {
                // Display message using JOptionPane that the movie is not available
                JOptionPane.showMessageDialog(null, "The movie is not available.");
            }
        });

        // Create a larger scene with a scroll pane to accommodate all components
        ScrollPane scrollPane = new ScrollPane(moviesRoot);
        VBox layout = new VBox(scrollPane);
        layout.setAlignment(Pos.CENTER); // Center the layout VBox
        Scene moviesScene = new Scene(layout, 600, 400); // Larger scene size
        moviesStage.setScene(moviesScene);

        // Size the stage to the scene's preferred size
        moviesStage.sizeToScene();

        // Center the stage on the screen
        moviesStage.centerOnScreen();

        // Show the stage
        moviesStage.show();
    }
}
