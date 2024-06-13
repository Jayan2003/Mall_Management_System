package mall_management_system;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class Mall_Managment_System extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button welcomeButton = new Button("Welcome to Our Mall");//creates a new object from class button
        welcomeButton.setOnAction(event -> showMainMenu(primaryStage));//tells the welcome button what to do when you click it.When you press the button, it will show the main menu.

        //This sets up the screen and places the welcome button in the center.
        StackPane root = new StackPane();
        root.getChildren().add(welcomeButton);
        StackPane.setAlignment(welcomeButton, Pos.CENTER);

        //This sets up the window size and title, and then shows the window
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Mall Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showMainMenu(Stage primaryStage) {//This part sets up the main menu that shows different options, like Restaurants, Activities, and Stores. 
        Button restaurantsButton = new Button("Restaurants");
        Button activitiesButton = new Button("Activities");
        Button storesButton = new Button("Stores");

        VBox mainMenu = new VBox(20);//This arranges the buttons vertically with some space in between
        mainMenu.setAlignment(Pos.CENTER);
        mainMenu.getChildren().addAll(restaurantsButton, activitiesButton, storesButton);

        Scene mainMenuScene = new Scene(mainMenu, 400, 300);//This sets up the scene with our main menu and updates the window.
        primaryStage.setScene(mainMenuScene);

        //These lines tell each button what to do when clicked
        restaurantsButton.setOnAction(event -> showRestaurantTypeOptions(primaryStage));
        activitiesButton.setOnAction(event -> openActivitiesWindow(primaryStage));
        storesButton.setOnAction(event -> showStoreOptions(primaryStage));
    }

    private void showRestaurantTypeOptions(Stage primaryStage) {//This method shows the different types of restaurants available.
        Button foodCourtButton = new Button("Food Court");
        Button fineDiningButton = new Button("Fine Dining");

        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(foodCourtButton, fineDiningButton);

        Scene scene = new Scene(vbox, 300, 250);
        primaryStage.setScene(scene);

        foodCourtButton.setOnAction(event -> {//This tells the Food Court button to show the food court menu when clicked.
            Restaurant restaurant = new Restaurant();
            displayMenu(primaryStage, restaurant);
        });

        fineDiningButton.setOnAction(event -> {//This tells the Food Court button to show the food court menu when clicked.
            Restaurant restaurant = new Restaurant();
            displayMenu(primaryStage, restaurant);
        });
    }
    private void displayMenu(Stage primaryStage, Restaurant restaurant) {
    TextArea menuTextArea = new TextArea();//This creates a text area to display the menu, which you can't edit
    menuTextArea.setEditable(false);
    menuTextArea.setPrefSize(300, 200);
    StringBuilder menuString = new StringBuilder();
    for (String dish : restaurant.getMenu().keySet()) {//builds the menu list by adding each dish and its price.
        menuString.append(dish).append(": $").append(restaurant.getMenu().get(dish)).append("\n");
    }
    menuTextArea.setText(menuString.toString());

    TextArea orderTextArea = new TextArea();
    orderTextArea.setPromptText("Enter your order here...");//creates a text area where you can type in your order.
    orderTextArea.setPrefSize(300, 100);

    TextArea billTextArea = new TextArea();//creates a text area to show your bill, which you can't edit.
    billTextArea.setEditable(false);
    billTextArea.setPrefSize(300, 100);

    Button placeOrderButton = new Button("Place Order");// creates a button that takes your order.
    placeOrderButton.setOnAction(event -> {
        String dishName = orderTextArea.getText();
        if (restaurant.getMenu().containsKey(dishName)) {
            double price = restaurant.getMenu().get(dishName);
            restaurant.addOrders("Order: " + dishName + " ($" + price + ")");
            billTextArea.setText("Your Order:\n" + "Order: " + dishName + " ($" + price + ")\nBill: $" + price);
        } else {
            billTextArea.setText("Sorry, the dish '" + dishName + "' is not available.");
        }
    });

    Button backButton = new Button("Back");// creates a back button that takes you back to the main menu when clicked.
    backButton.setOnAction(event -> showMainMenu(primaryStage));

    VBox vbox = new VBox(10);
    vbox.setAlignment(Pos.CENTER);
    vbox.getChildren().addAll(menuTextArea, orderTextArea, placeOrderButton, billTextArea, backButton);

    Scene menuScene = new Scene(vbox, 300, 400);
    primaryStage.setScene(menuScene);
}

     
    private void showStoreOptions(Stage primaryStage) {
        Button clothingStoreButton = new Button("Clothing Store");
        Button cosmeticsStoreButton = new Button("Cosmetics Store");
        Button toyStoreButton = new Button("Toy Store");
        Button bookStoreButton = new Button("Book Store");

        VBox optionsBox = new VBox(10);
        optionsBox.setAlignment(Pos.CENTER);
        optionsBox.getChildren().addAll(clothingStoreButton, cosmeticsStoreButton, toyStoreButton, bookStoreButton);

        Scene storeScene = new Scene(optionsBox, 400, 300);
        primaryStage.setScene(storeScene);

        clothingStoreButton.setOnAction(event -> openStoreWindow("Clothing Store", Arrays.asList("Bershka", "Pull and Bear", "H&M", "Zara", "Concrete")));
        cosmeticsStoreButton.setOnAction(event -> openStoreWindow("Cosmetics Store", Arrays.asList("Sephora","Mikyaji" ,"MAC", "Ulta", "Lush", "The Body Shop")));
        toyStoreButton.setOnAction(event -> openStoreWindow("Toy Store", Arrays.asList("Toys 'R' Us", "LEGO Store", "Disney Store", "Build-A-Bear Workshop", "Mattel Toy Store")));
        bookStoreButton.setOnAction(event -> openStoreWindow("Book Store", Arrays.asList("Barnes & Noble", "Books-A-Million", "Waterstones", "Indigo", "Foyles")));
    }
    //
    private void openStoreWindow(String storeType, List<String> availableShops) {//this method opens a new window showing different shops
        Stage storeStage = new Stage();
        storeStage.setTitle(storeType);//We write the name of the store on the top of the window.

        VBox storeLayout = new VBox(20);
        storeLayout.setPadding(new Insets(20));
        storeLayout.setAlignment(Pos.TOP_CENTER);

        Label storeLabel = new Label(storeType);
        storeLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");//We make the text big and bold so it stands out.

        VBox shopsBox = new VBox(10);
        for (String shop : availableShops) {
            Button shopButton = new Button(shop);
            shopButton.setMaxWidth(Double.MAX_VALUE);//The button stretches to fill the width.
            shopButton.setOnAction(event -> showShopDetails(storeType, shop));
            shopsBox.getChildren().add(shopButton);
        }

        storeLayout.getChildren().addAll(storeLabel, shopsBox);

        Scene storeScene = new Scene(storeLayout, 300, 400);
        storeStage.setScene(storeScene);
        storeStage.show();
        
    }

    private void showShopDetails(String storeType, String shop) {
        Stage detailsStage = new Stage();
        detailsStage.setTitle(shop + " Details");//title of window from top left

        VBox detailsLayout = new VBox(20);
        detailsLayout.setPadding(new Insets(20));
        detailsLayout.setAlignment(Pos.TOP_CENTER);

        Label shopLabel = new Label(shop);
        shopLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Label detailsLabel = new Label();
        //Depending on the type of store, we set the text of the details label to show specific information about the shop.
        if (storeType.equals("Clothing Store")) {
            detailsLabel.setText("Seasonal Collection: Summer 2024\nSpecial Offer: Buy 2 Get 1 Free");
        } else if (storeType.equals("Cosmetics Store")) {
            detailsLabel.setText("Featured Products: New Lipstick Collection\nSpecial Offer: 20% Off on All Skincare");
        } else if (storeType.equals("Toy Store")) {
            detailsLabel.setText("Popular Toys: LEGO Star Wars, Barbie Dreamhouse, Hot Wheels\nSpecial Offer: Buy 1 Get 1 Half Off");
        } else if (storeType.equals("Book Store")) {
            detailsLabel.setText("New Arrivals: 'The Great Adventure', 'Mystery of the Lost Island'\nSpecial Offer: 10% Off on Bestsellers");
        }

        detailsLayout.getChildren().addAll(shopLabel, detailsLabel);

        Scene detailsScene = new Scene(detailsLayout, 300, 200);
        detailsStage.setScene(detailsScene);
        detailsStage.show();
    }

    private void openActivitiesWindow(Stage primaryStage) {
        Stage activitiesStage = new Stage();
        activitiesStage.setTitle("Activities");

        Button cinemaButton = new Button("Cinema");
        Button hairSalonButton = new Button("Hair Salon");
        Button gymButton = new Button("Gym");
        Button magicPlanetButton = new Button("Magic Planet");

        VBox activitiesRoot = new VBox(10);
        activitiesRoot.setAlignment(Pos.CENTER);
        activitiesRoot.getChildren().addAll(cinemaButton, hairSalonButton, gymButton, magicPlanetButton);

        Scene activitiesScene = new Scene(activitiesRoot, 600, 400);
        activitiesStage.setScene(activitiesScene);
        activitiesStage.show();

        cinemaButton.setOnAction(event -> {
            Cinema cinema = new Cinema();
            cinema.showMovies();
        });

        hairSalonButton.setOnAction(event -> {
            HairSalon hairSalon = new HairSalon();
            openHairSalonOptionsWindow(hairSalon, activitiesStage);
        });

        gymButton.setOnAction(event -> {
            Gym gym = new Gym();
            openGymOptionsWindow(gym, activitiesStage);
        });

        magicPlanetButton.setOnAction(event -> {
            MagicPlanet magicPlanet = new MagicPlanet();
            openMagicPlanetWindow(magicPlanet, activitiesStage);
        });
    }

    private void openHairSalonOptionsWindow(HairSalon hairSalon, Stage previousStage) {
        Stage hairSalonOptionsStage = new Stage();
        hairSalonOptionsStage.setTitle("Hair Salon Options");//We write "Hair Salon Options" at the top left.

        Button hairStylesButton = new Button("Hair Styles");
        Button hairDyeColorsButton = new Button("Hair Dye Colors");
        Button backButton = new Button("Back");

        VBox hairSalonOptionsRoot = new VBox(10);
        hairSalonOptionsRoot.setAlignment(Pos.CENTER);
        hairSalonOptionsRoot.getChildren().addAll(hairStylesButton, hairDyeColorsButton, backButton);

        Scene hairSalonOptionsScene = new Scene(hairSalonOptionsRoot, 400, 300);
        hairSalonOptionsStage.setScene(hairSalonOptionsScene);
        hairSalonOptionsStage.show();

        hairStylesButton.setOnAction(event -> openHairStylesWindow(hairSalon, hairSalonOptionsStage));
        hairDyeColorsButton.setOnAction(event -> openHairDyeColorsWindow(hairSalon, hairSalonOptionsStage));
        backButton.setOnAction(event -> {
            hairSalonOptionsStage.close();
            previousStage.show();
        });

        previousStage.hide();
    }

    private void openHairStylesWindow(HairSalon hairSalon, Stage previousStage) {
        Stage hairstylesStage = new Stage();
        hairstylesStage.setTitle("Hair Styles");

        VBox hairstylesRoot = new VBox(10);
        hairstylesRoot.setAlignment(Pos.CENTER);

        hairSalon.displayHairStyles(hairstylesRoot);

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            hairstylesStage.close();
            previousStage.show();
        });
        hairstylesRoot.getChildren().add(backButton);

        Scene hairstylesScene = new Scene(hairstylesRoot, 400, 300);
        hairstylesStage.setScene(hairstylesScene);
        hairstylesStage.show();

        previousStage.hide();
    }

    private void openHairDyeColorsWindow(HairSalon hairSalon, Stage previousStage) {
        Stage hairDyeColorsStage = new Stage();
        hairDyeColorsStage.setTitle("Hair Dye Colors");

        VBox hairDyeColorsRoot = new VBox(10);
        hairDyeColorsRoot.setAlignment(Pos.CENTER);

        Label headerLabel = new Label("Hair Dye Colors:");
        hairDyeColorsRoot.getChildren().add(headerLabel);
        hairSalon.displayHairDyeColors(hairDyeColorsRoot);

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            hairDyeColorsStage.close();
            previousStage.show();
        });
        hairDyeColorsRoot.getChildren().add(backButton);

        Scene hairDyeColorsScene = new Scene(hairDyeColorsRoot, 400, 300);
        hairDyeColorsStage.setScene(hairDyeColorsScene);
        hairDyeColorsStage.show();

        previousStage.hide();
    }

    private void openGymOptionsWindow(Gym gym, Stage previousStage) {
        Stage gymOptionsStage = new Stage();
        gymOptionsStage.setTitle("Gym Options");

        Button classesButton = new Button("Classes");
        Button machinesButton = new Button("Machines");
        Button backButton = new Button("Back");

        VBox gymOptionsRoot = new VBox(10);
        gymOptionsRoot.setAlignment(Pos.CENTER);
        gymOptionsRoot.getChildren().addAll(classesButton, machinesButton, backButton);

        Scene gymOptionsScene = new Scene(gymOptionsRoot, 400, 300);
        gymOptionsStage.setScene(gymOptionsScene);
        gymOptionsStage.show();

        classesButton.setOnAction(event -> openGymClassesWindow(gym, gymOptionsStage));
        machinesButton.setOnAction(event -> openGymMachinesWindow(gym, gymOptionsStage));
        backButton.setOnAction(event -> {
            gymOptionsStage.close();
            previousStage.show();
        });

        previousStage.hide();
    }

    private void openGymClassesWindow(Gym gym, Stage previousStage) {
        Stage gymClassesStage = new Stage();
        gymClassesStage.setTitle("Gym Classes");

        VBox gymClassesRoot = new VBox(10);
        gymClassesRoot.setAlignment(Pos.CENTER);

        gym.displayClasses(gymClassesRoot);

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            gymClassesStage.close();
            previousStage.show();
        });
        gymClassesRoot.getChildren().add(backButton);

        Scene gymClassesScene = new Scene(gymClassesRoot, 400, 300);
        gymClassesStage.setScene(gymClassesScene);
        gymClassesStage.show();

        previousStage.hide();
    }

    private void openGymMachinesWindow(Gym gym, Stage previousStage) {
        Stage gymMachinesStage = new Stage();
        gymMachinesStage.setTitle("Gym Machines");

        VBox gymMachinesRoot = new VBox(10);
        gymMachinesRoot.setAlignment(Pos.CENTER);

        gym.displayMachines(gymMachinesRoot);

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            gymMachinesStage.close();
            previousStage.show();
        });
        gymMachinesRoot.getChildren().add(backButton);

        Scene gymMachinesScene = new Scene(gymMachinesRoot, 400, 300);
        gymMachinesStage.setScene(gymMachinesScene);
        gymMachinesStage.show();

        previousStage.hide();
    }

    private void openMagicPlanetWindow(MagicPlanet magicPlanet, Stage previousStage) {
        Stage magicPlanetStage = new Stage();
        magicPlanetStage.setTitle("Magic Planet");

        VBox magicPlanetRoot = new VBox(10);
        magicPlanetRoot.setAlignment(Pos.CENTER);

        magicPlanet.displayRides(magicPlanetRoot);

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            magicPlanetStage.close();
            previousStage.show();
        });
        magicPlanetRoot.getChildren().add(backButton);

        Scene magicPlanetScene = new Scene(magicPlanetRoot, 400, 300);
        magicPlanetStage.setScene(magicPlanetScene);
        magicPlanetStage.show();

        previousStage.hide();
    }

    public static void main(String[] args) {
        launch(args);
    }
}