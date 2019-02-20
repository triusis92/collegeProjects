import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;
import javafx.scene.layout.GridPane;

public class Main extends Application {

	Stage window;
	Animal product = new Animal();
	BorderPane layout,lostLayout,lostLayoutReports,foundLayout,foundLayoutReports,adoptionLayout,adoptionTransfer,adoptionInterested,displayAllAdoption,reportsForAdoption, maintenanceLayout,maintenanceLayout2,maintenanceLayout3,maintenanceLayout4,reportsLayout,reportsLayout2;
	TableView<Animal> table,table1,lostReportsTable,foundReportsTable,pictureTable,transferTable,adoptionTable,adoptionReportsTable,allAnimalsTable;
	TableView<Person> personTable,ownerTable,personTable2,sponsorTable;
	TextField nameInput,nameInput2,nameInput3, ageInput,ageInput2,ageInput3, breedInput,typeInput,locationInput,statusInput,personNameInput,personPhoneInput,personEmail,ownerNameInput,ownerPhoneInput,ownerEmail,interestedPersonName,interestedPersonPhone,interestedPersonEmail;
	TextArea description,description2,address,ownerAddress,interestedPersonAddress;
	ComboBox<String> comboBox1,comboBox2,comboBox3,comboBox4,comboBox5,comboBox6,comboBox7,comboBox8,comboBox9,comboBox10,comboBox11,comboBox12,comboBox13,comboBox14;
	ListView<String> listView,listView2,listView3,listView4;
	Scene scene,scene1,scene2,scene3,scene4,scene5,scene6,scene7,scene8,scene9,scene10,scene11,scene12;

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Main Window");

		/** ///////////////////////////////////////////////////////////////////////////////
		 *********************************************************************************
		/////////                         MENU SECTION                 //////////////
		 *********************************************************************************
		//////////////////////////////////////////////////////////////////////////////**/

		//Lost menu
		Menu fileMenu = new Menu("_Lost");
		MenuItem newFile = new MenuItem("Add Animal");
		newFile.setOnAction(e -> window.setScene(scene4));
		fileMenu.getItems().add(newFile);
		fileMenu.getItems().add(new SeparatorMenuItem());
		MenuItem lostReports = new MenuItem("Reports");
		lostReports.setOnAction(e -> window.setScene(scene6));
		fileMenu.getItems().add(lostReports);
		MenuItem newQuit = new MenuItem("Quit");
		newQuit.setOnAction(e -> window.close());
		fileMenu.getItems().add(newQuit);


		//Found menu
		Menu editMenu = new Menu("_Found");
		MenuItem newFound = new MenuItem("Add Animal");
		newFound.setOnAction(e -> window.setScene(scene5));
		editMenu.getItems().add(newFound);
		MenuItem foundReports = new MenuItem("Reports");
		foundReports.setOnAction(e -> window.setScene(scene7));
		editMenu.getItems().add(foundReports);





		//Adoption menu
		Menu adoptionMenu = new Menu("_Adoption");

		MenuItem transfer = new MenuItem("Transfer an Animal");
		transfer.setOnAction(e -> window.setScene(scene9));
		adoptionMenu.getItems().add(transfer);
		MenuItem newAdoption = new MenuItem("Add A Picture of Animal");
		newAdoption.setOnAction(e -> layout.setCenter(adoptionLayout));
		adoptionMenu.getItems().add(newAdoption);
		MenuItem interested = new MenuItem("Create Interested List");
		interested.setOnAction(e -> window.setScene(scene10));
		adoptionMenu.getItems().add(interested);

		adoptionMenu.getItems().add(new SeparatorMenuItem());
		MenuItem adoptionReports = new MenuItem("Reports");
		adoptionReports.setOnAction(e -> window.setScene(scene12));
		adoptionMenu.getItems().add(adoptionReports);
		MenuItem allAnimals = new MenuItem("Display All Animals");
		allAnimals.setOnAction(e -> window.setScene(scene11));
		adoptionMenu.getItems().add(allAnimals);


		//Maintenance menu
		Menu maintenanceMenu = new Menu("_Maintenance");
		MenuItem newMaintenance = new MenuItem("Animal Type...");
		newMaintenance.setOnAction(e ->  {
			window.setScene(scene1);
		});
		maintenanceMenu.getItems().add(newMaintenance);
		MenuItem newMaintenance2 = new MenuItem("Animal Breed...");
		newMaintenance2.setOnAction(e ->{
			window.setScene(scene2);
		});
		maintenanceMenu.getItems().add(newMaintenance2);
		MenuItem newMaintenance3 = new MenuItem("Animal Location...");
		newMaintenance3.setOnAction(e -> {
			window.setScene(scene3);
		});
		maintenanceMenu.getItems().add(newMaintenance3);
		MenuItem newMaintenance4 = new MenuItem("Animal Status...");
		newMaintenance4.setOnAction(e -> {
			window.setScene(scene8);
		});
		maintenanceMenu.getItems().add(newMaintenance4);

		//Reports menu
		Menu reportsMenu = new Menu("_Reports");
		MenuItem sponsors = new MenuItem("Display All Sponsors");
		sponsors.setOnAction(e -> layout.setCenter(reportsLayout));
		reportsMenu.getItems().add(sponsors);

		MenuItem allAnimalsByAge = new MenuItem("Display All Animals");
		allAnimalsByAge.setOnAction(e -> layout.setCenter(reportsLayout2));
		reportsMenu.getItems().add(allAnimalsByAge);


		//Main menu bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, editMenu, adoptionMenu,maintenanceMenu,reportsMenu);



		/** //////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////
		//////                                LOST SECTION                         ////////////
		//////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////**/

		Label lostTableLabel = new Label("Lost Animals table");
		lostTableLabel.setFont(new Font("Arial", 20));

		//ID Column
		TableColumn<Animal, Integer> idColumn2 = new TableColumn<>("Animal ID");
		idColumn2.setMaxWidth(100);
		idColumn2.setCellValueFactory(new PropertyValueFactory<>("ID"));

		//Name column
		TableColumn<Animal, String> nameColumn2 = new TableColumn<>("Name");
		nameColumn2.setMinWidth(200);
		nameColumn2.setCellValueFactory(new PropertyValueFactory<>("name"));

		//Age column
		TableColumn<Animal, Integer> ageColumn2 = new TableColumn<>("Age");
		ageColumn2.setMaxWidth(50);
		ageColumn2.setCellValueFactory(new PropertyValueFactory<>("age"));

		//Type column
		TableColumn<Animal, String> typeColumn2 = new TableColumn<>("Type");
		typeColumn2.setMinWidth(100);
		typeColumn2.setCellValueFactory(new PropertyValueFactory<>("aType"));

		//Breed column
		TableColumn<Animal, String> breedColumn2 = new TableColumn<>("Breed");
		breedColumn2.setMinWidth(100);
		breedColumn2.setCellValueFactory(new PropertyValueFactory<>("breed"));

		//Gender column
		TableColumn<Animal, Boolean> genderColumn2 = new TableColumn<>("Gender");
		genderColumn2.setMinWidth(100);
		genderColumn2.setCellValueFactory(new PropertyValueFactory<>("gender"));

		//Name input
		nameInput2 = new TextField();
		nameInput2.setPromptText("Name");
		nameInput2.setMinWidth(100);

		//Age input
		ageInput2 = new TextField();
		ageInput2.setPromptText("Age");

		//Breed input
		comboBox3 = new ComboBox<>();
		//comboBox3.getItems().addAll(listView2.getId());	
		comboBox3.setPromptText("Breed");

		//Type input
		comboBox4 = new ComboBox<>();
		//comboBox4.getItems().addAll(comboBox2.lookup("#2").toString());
		//comboBox4.setItems(listView.getItems());
		comboBox4.setPromptText("Type");

		//Animal Location
		comboBox6 = new ComboBox<>();

		comboBox6.setPromptText("Location");

		//Animal Gender
		comboBox7 = new ComboBox<>();
		comboBox7.getItems().addAll("Male","Female");
		comboBox7.setPromptText("Gender");


		//Lost Animal Description input
		description2=new TextArea();
		description2.setPromptText("Description");
		description2.setMaxWidth(100);
		description2.setMaxHeight(100);


		Label ownerTableLabel = new Label("Owner table");
		ownerTableLabel.setFont(new Font("Arial", 20));

		//Person Name column
		TableColumn<Person, String> ownerName = new TableColumn<>("Name");
		ownerName.setMinWidth(100);
		ownerName.setCellValueFactory(new PropertyValueFactory<>("name"));

		//Person phone number column
		TableColumn<Person, String> ownerPhone = new TableColumn<>("Phone Number");
		ownerPhone.setMinWidth(100);
		ownerPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));

		ownerTable = new TableView<>();
		ownerTable.setMaxHeight(400);
		ownerTable.getColumns().addAll(ownerName,ownerPhone);


		//Owner address input
		ownerAddress=new TextArea();
		ownerAddress.setPromptText("Address");
		ownerAddress.setMaxWidth(300);
		ownerAddress.setMaxHeight(400);

		//Owner name input
		ownerNameInput = new TextField();
		ownerNameInput.setPromptText("Enter Owner name");
		ownerNameInput.setMinWidth(100);

		//Owner phone input
		ownerPhoneInput = new TextField();
		ownerPhoneInput.setPromptText("Enter Owner phone number");
		ownerPhoneInput.setMinWidth(100);

		//Owner email input
		ownerEmail = new TextField();
		ownerEmail.setPromptText("Enter Owner email");
		ownerEmail.setMinWidth(100);


		final DatePicker dateLost = new DatePicker();
		dateLost.setPromptText("Date Animal Lost");

		//Button
		Button addButton2 = new Button("Add");
		addButton2.setMinSize(120, 30);
		addButton2.setOnAction(e -> addButtonClicked1());
		Button deleteButton2 = new Button("Delete");
		deleteButton2.setMinSize(120, 30);
		deleteButton2.setOnAction(e -> deleteButtonClicked1());
		Button saveButton2 = new Button("Save");
		saveButton2.setMinSize(120, 30);
		saveButton2.setOnAction(null);
		Button backButton2 = new Button("Back");
		backButton2.setMinSize(120, 30);
		backButton2.setOnAction(e -> window.setScene(scene));


		//Layout
		HBox hBoxLost = new HBox();
		hBoxLost.setPadding(new Insets(10,10,10,10));
		hBoxLost.setSpacing(10);
		hBoxLost.getChildren().addAll(nameInput2, ageInput2, comboBox4, comboBox3,comboBox6,comboBox7,description2);

		table1 = new TableView<>();
		table1.setItems(getProduct());
		table1.getColumns().addAll(idColumn2,nameColumn2, ageColumn2, typeColumn2, breedColumn2,genderColumn2);

		HBox buttonsLost=new HBox();
		buttonsLost.setPadding(new Insets(10,10,10,10));
		buttonsLost.setSpacing(20);
		buttonsLost.getChildren().addAll(addButton2, deleteButton2,saveButton2, backButton2);

		VBox vBoxLost = new VBox();
		vBoxLost.getChildren().addAll(lostTableLabel,table1,hBoxLost,dateLost,buttonsLost);
		vBoxLost.setSpacing(20);

		VBox ownerBox=new VBox();
		ownerBox.getChildren().addAll(ownerTableLabel,ownerTable,ownerNameInput,ownerPhoneInput,ownerEmail,ownerAddress);
		ownerBox.setSpacing(20);

		HBox hBox2Lost = new HBox();
		hBox2Lost.setPadding(new Insets(10,10,10,10));
		hBox2Lost.setSpacing(50);
		hBox2Lost.getChildren().addAll(vBoxLost,ownerBox);


		//////////LOST REPORTS SECTION////////////////

		//ID Column
		TableColumn<Animal, Integer> idColumn3 = new TableColumn<>("Animal ID");
		idColumn3.setMaxWidth(100);
		idColumn3.setCellValueFactory(new PropertyValueFactory<>("ID"));

		//Name column
		TableColumn<Animal, String> nameColumn3 = new TableColumn<>("Name");
		nameColumn3.setMinWidth(200);
		nameColumn3.setCellValueFactory(new PropertyValueFactory<>("name"));

		//Age column
		TableColumn<Animal, Integer> ageColumn3 = new TableColumn<>("Age");
		ageColumn3.setMaxWidth(50);
		ageColumn3.setCellValueFactory(new PropertyValueFactory<>("age"));

		//Type column
		TableColumn<Animal, String> typeColumn3 = new TableColumn<>("Type");
		typeColumn3.setMinWidth(100);
		typeColumn3.setCellValueFactory(new PropertyValueFactory<>("aType"));

		//Breed column
		TableColumn<Animal, String> breedColumn3 = new TableColumn<>("Breed");
		breedColumn3.setMinWidth(100);
		breedColumn3.setCellValueFactory(new PropertyValueFactory<>("breed"));

		//Gender column
		TableColumn<Animal, Boolean> genderColumn3 = new TableColumn<>("Gender");
		genderColumn3.setMinWidth(100);
		genderColumn3.setCellValueFactory(new PropertyValueFactory<>("gender"));

		comboBox8 = new ComboBox<>();
		//comboBox4.getItems().addAll(listView.getItems());
		comboBox8.setPromptText("Type");

		//Animal Location
		comboBox9 = new ComboBox<>();

		comboBox9.setPromptText("Location");


		final DatePicker dateLost2 = new DatePicker();
		dateLost2.setPromptText("Date Animal Lost");

		lostReportsTable = new TableView<>();
		lostReportsTable.setItems(getProduct());
		lostReportsTable.getColumns().addAll(idColumn3,nameColumn3, ageColumn3, typeColumn3, breedColumn3,genderColumn3);

		Button searchLost = new Button("Display");
		searchLost.setMinSize(120, 30);
		searchLost.setOnAction(null);
		Button exitLostReports = new Button("Back");
		exitLostReports.setMinSize(120, 30);
		exitLostReports.setOnAction(e -> window.setScene(scene));

		VBox vBoxLostReports = new VBox();
		vBoxLostReports.setPadding(new Insets(10,10,10,10));
		vBoxLostReports.setSpacing(20);
		vBoxLostReports.getChildren().addAll(lostReportsTable,comboBox8,comboBox9,dateLost2,searchLost,exitLostReports);





		/** ////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////
		//////                             FOUND SECTION                              /////////
		///////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////**/

		Label foundTableLabel = new Label("Found Animals table");
		foundTableLabel.setFont(new Font("Arial", 20));

		//ID column
		TableColumn<Animal, Integer> idColumn = new TableColumn<>("ID");
		idColumn.setMinWidth(100);
		idColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));

		//Name column
		TableColumn<Animal, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setMinWidth(200);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

		//Age column
		TableColumn<Animal, Integer> ageColumn = new TableColumn<>("Age");
		ageColumn.setMinWidth(100);
		ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

		//Type column
		TableColumn<Animal, String> typeColumn = new TableColumn<>("Type");
		typeColumn.setMinWidth(100);
		typeColumn.setCellValueFactory(new PropertyValueFactory<>("aType"));

		//Breed column
		TableColumn<Animal, String> breedColumn = new TableColumn<>("Breed");
		breedColumn.setMinWidth(100);
		breedColumn.setCellValueFactory(new PropertyValueFactory<>("breed"));

		//Gender column
		TableColumn<Animal, Boolean> genderColumn = new TableColumn<>("Gender");
		genderColumn.setMinWidth(100);
		genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));


		Label personTableLabel = new Label("Person table");
		personTableLabel.setFont(new Font("Arial", 20));


		//Person Name column
		TableColumn<Person, String> personName = new TableColumn<>("Name");
		personName.setMinWidth(100);
		personName.setCellValueFactory(new PropertyValueFactory<>("name"));

		//Person phone number column
		TableColumn<Person, String> personPhone = new TableColumn<>("Phone Number");
		personPhone.setMinWidth(100);
		personPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));

		personTable = new TableView<>();
		personTable.setMaxHeight(400);
		personTable.getColumns().addAll(personName,personPhone);



		//Animal Name input
		nameInput = new TextField();
		nameInput.setPromptText("Name");
		nameInput.setMinWidth(100);

		//Age input
		ageInput = new TextField();
		ageInput.setPromptText("Age");

		//Animal Breeds
		comboBox1 = new ComboBox<>();

		comboBox1.setPromptText("Select Breed");

		//Animal Types
		comboBox2 = new ComboBox<>();

		comboBox2.setPromptText("Select Type");

		//Animal Location
		comboBox5 = new ComboBox<>();
		//comboBox5.getItems().addAll(listView3.getItems().toString());
		comboBox5.setPromptText("Select Location");

		//Animal Gender
		comboBox12 = new ComboBox<>();
		comboBox12.getItems().addAll("Male","Female");
		comboBox12.setPromptText("Gender");

		//Animal Description input
		description=new TextArea();
		description.setPromptText("Description");
		description.setMaxWidth(100);
		description.setMaxHeight(100);


		//Person address input
		address=new TextArea();
		address.setPromptText("Address");
		address.setMaxWidth(300);
		address.setMaxHeight(400);

		//Person name input
		personNameInput = new TextField();
		personNameInput.setPromptText("Enter person name");
		personNameInput.setMinWidth(100);

		//Person phone input
		personPhoneInput = new TextField();
		personPhoneInput.setPromptText("Enter person phone number");
		personPhoneInput.setMinWidth(100);

		//Person email input
		personEmail = new TextField();
		personEmail.setPromptText("Enter person email");
		personEmail.setMinWidth(100);


		final DatePicker dateFound = new DatePicker();
		dateFound.setPromptText("Date Animal Found");

		//Buttons
		Button addButton = new Button("Add");
		addButton.setMinSize(120, 30);
		addButton.setOnAction(e -> addButtonClicked());
		Button deleteButton = new Button("Delete");
		deleteButton.setMinSize(120, 30);
		deleteButton.setOnAction(e -> deleteButtonClicked());
		Button saveButton = new Button("Save");
		saveButton.setMinSize(120, 30);
		saveButton.setOnAction(null);
		Button backButton = new Button("Back");
		backButton.setMinSize(120, 30);
		backButton.setOnAction(e -> window.setScene(scene));

		//Layout
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(10,10,10,10));
		hBox.setSpacing(10);
		hBox.getChildren().addAll(nameInput, ageInput, comboBox2, comboBox1,comboBox5,comboBox12,description);

		table = new TableView<>();
		table.setItems(getProduct());
		table.getColumns().addAll(idColumn,nameColumn, ageColumn, typeColumn, breedColumn,genderColumn);

		HBox buttons=new HBox();
		buttons.setPadding(new Insets(10,10,10,10));
		buttons.setSpacing(20);
		buttons.getChildren().addAll(addButton, deleteButton,saveButton, backButton);

		VBox vBox = new VBox();
		vBox.getChildren().addAll(foundTableLabel,table,hBox,dateFound,buttons);
		vBox.setSpacing(20);

		VBox personBox=new VBox();
		personBox.getChildren().addAll(personTableLabel,personTable,personNameInput,personPhoneInput,personEmail,address);
		personBox.setSpacing(20);

		HBox hBox2 = new HBox();
		hBox2.setPadding(new Insets(10,10,10,10));
		hBox2.setSpacing(50);
		hBox2.getChildren().addAll(vBox,personBox);



		//////////FOUND REPORTS SECTION////////////////

		//ID Column
		TableColumn<Animal, Integer> idColumn4 = new TableColumn<>("Animal ID");
		idColumn4.setMaxWidth(100);
		idColumn4.setCellValueFactory(new PropertyValueFactory<>("ID"));

		//Name column
		TableColumn<Animal, String> nameColumn4 = new TableColumn<>("Name");
		nameColumn4.setMinWidth(200);
		nameColumn4.setCellValueFactory(new PropertyValueFactory<>("name"));

		//Age column
		TableColumn<Animal, Integer> ageColumn4 = new TableColumn<>("Age");
		ageColumn4.setMaxWidth(50);
		ageColumn4.setCellValueFactory(new PropertyValueFactory<>("age"));

		//Type column
		TableColumn<Animal, String> typeColumn4 = new TableColumn<>("Type");
		typeColumn4.setMinWidth(100);
		typeColumn4.setCellValueFactory(new PropertyValueFactory<>("aType"));

		//Breed column
		TableColumn<Animal, String> breedColumn4 = new TableColumn<>("Breed");
		breedColumn4.setMinWidth(100);
		breedColumn4.setCellValueFactory(new PropertyValueFactory<>("breed"));

		//Gender column
		TableColumn<Animal, Boolean> genderColumn4 = new TableColumn<>("Gender");
		genderColumn4.setMinWidth(100);
		genderColumn4.setCellValueFactory(new PropertyValueFactory<>("gender"));

		comboBox10 = new ComboBox<>();
		//comboBox4.getItems().addAll(listView.getItems());
		comboBox10.setPromptText("Type");

		//Animal Location
		comboBox11 = new ComboBox<>();

		comboBox11.setPromptText("Location");


		final DatePicker dateFoundFrom = new DatePicker();
		dateFoundFrom.setPromptText("Date From..");

		final DatePicker dateFoundTo = new DatePicker();
		dateFoundTo.setPromptText("Date To..");

		foundReportsTable = new TableView<>();
		foundReportsTable.setItems(getProduct());
		foundReportsTable.getColumns().addAll(idColumn4,nameColumn4, ageColumn4, typeColumn4, breedColumn4,genderColumn4);

		Button searchFound = new Button("Display");
		searchFound.setMinSize(120, 30);
		searchFound.setOnAction(null);
		Button exitFoundReports = new Button("Back");
		exitFoundReports.setMinSize(120, 30);
		exitFoundReports.setOnAction(e -> window.setScene(scene));

		VBox vBoxFoundReports = new VBox();
		vBoxFoundReports.setPadding(new Insets(10,10,10,10));
		vBoxFoundReports.setSpacing(20);
		vBoxFoundReports.getChildren().addAll(foundReportsTable,comboBox10,comboBox11,dateFoundFrom,dateFoundTo,searchFound,exitFoundReports);




		/** //////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
/////////////                        MAINTENANCE SECTION				///////////////
//////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////**/

		///////////TYPE SECTION/////////

		Label types =new Label("Animal Types Table");
		types.setFont(new Font("Arial", 20));

		listView = new ListView<>();
		listView.setId("1");
		listView.setEditable(true);
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		//Type Input
		typeInput = new TextField();
		typeInput.setPromptText("Enter Animal Type..");


		Button addButton3 = new Button("Add");
		addButton3.setOnAction(e -> {
			listView.getItems().add(typeInput.getText());
			typeInput.clear();});
		Button removeButton = new Button("Remove");
		removeButton.setOnAction(e -> listView.getItems().remove(listView.getSelectionModel().getSelectedItem()));
		Button saveTypeButton = new Button("Save Changes");
		saveTypeButton.setOnAction(e -> saveTypeButtonClicked());
		Button backButton1 = new Button("Back");
		backButton1.setOnAction(e -> window.setScene(scene));


		HBox comboLayout = new HBox(10);
		comboLayout.setPadding(new Insets(20, 20, 20, 20));
		comboLayout.setSpacing(20);
		comboLayout.getChildren().addAll(listView,typeInput,addButton3,removeButton,saveTypeButton,backButton1);

		VBox typeSection=new VBox();
		typeSection.setSpacing(20);
		typeSection.getChildren().addAll(types,comboLayout);


		////////BREED SECTION//////////
		Label breeds =new Label("Animal Breeds Table");
		breeds.setFont(new Font("Arial", 20));

		breedInput = new TextField();
		breedInput.setPromptText("Enter Animal Breed..");

		listView2 = new ListView<>();
		listView2.setEditable(true);
		listView2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


		comboBox2 = new ComboBox<>();
		comboBox2.setId("2");
		comboBox2.setPromptText("Select Animal Type");
		comboBox2.setOnAction(e -> changeBreed());


		Button addButton4 = new Button("Add");
		addButton4.setOnAction(e -> {
			listView2.getItems().add(breedInput.getText());
			breedInput.clear();});
		Button removeButton2 = new Button("Remove");
		removeButton2.setOnAction(e -> listView2.getItems().remove(listView2.getSelectionModel().getSelectedItem()));
		Button saveBreedButton = new Button("Save Changes");
		saveBreedButton.setOnAction(e -> saveBreedButtonClicked());
		Button backButton3 = new Button("Back");
		backButton3.setOnAction(e -> window.setScene(scene));


		HBox comboLayout2 = new HBox(10);
		comboLayout2.setPadding(new Insets(20, 20, 20, 20));
		comboLayout2.setSpacing(20);
		comboLayout2.getChildren().addAll(listView2,breedInput,comboBox2, addButton4,removeButton2,saveBreedButton,backButton3);

		VBox breedSection=new VBox();
		breedSection.setSpacing(20);
		breedSection.getChildren().addAll(breeds,comboLayout2);


		/////////////LOCATION SECTION///////////
		Label locations =new Label("Animal Locations Table");
		locations.setFont(new Font("Arial", 20));

		locationInput = new TextField();
		locationInput.setPromptText("Enter Animal Location..");

		listView3 = new ListView<>();
		listView3.setEditable(true);
		listView3.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


		Button addButton5 = new Button("Add");
		addButton5.setOnAction(e -> {
			listView3.getItems().add(locationInput.getText());
			locationInput.clear();});
		Button removeLocationButton = new Button("Remove");
		removeLocationButton.setOnAction(e -> listView3.getItems().remove(listView3.getSelectionModel().getSelectedItem()));
		Button saveLocationButton = new Button("Save Changes");
		saveLocationButton.setOnAction(e -> saveLocationButtonClicked());
		Button backButton4 = new Button("Back");
		backButton4.setOnAction(e -> window.setScene(scene));


		HBox comboLayout3 = new HBox();
		comboLayout3.setPadding(new Insets(10, 10, 10, 10));
		comboLayout3.setSpacing(20);
		comboLayout3.getChildren().addAll(listView3,locationInput,addButton5,removeLocationButton,saveLocationButton,backButton4);

		VBox locationSection=new VBox();
		locationSection.setPadding(new Insets(10,10,10,10));
		locationSection.setSpacing(20);
		locationSection.getChildren().addAll(locations,comboLayout3);


		/////////////STATUS SECTION///////////
		Label status =new Label("Animal Status Table");
		status.setFont(new Font("Arial", 20));

		statusInput = new TextField();
		statusInput.setPromptText("Enter Animal Status..");

		listView4 = new ListView<>();
		listView4.setEditable(true);
		listView4.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


		Button addButton6 = new Button("Add");
		addButton6.setOnAction(e -> {
			listView4.getItems().add(statusInput.getText());
			statusInput.clear();});
		Button removeStatusButton = new Button("Remove");
		removeStatusButton.setOnAction(e -> listView4.getItems().remove(listView4.getSelectionModel().getSelectedItem()));
		Button saveStatusButton = new Button("Save Changes");
		saveStatusButton.setOnAction(e -> saveStatusButtonClicked());
		Button backButton5 = new Button("Back");
		backButton5.setOnAction(e -> window.setScene(scene));


		HBox comboLayout4 = new HBox();
		comboLayout4.setPadding(new Insets(10, 10, 10, 10));
		comboLayout4.setSpacing(20);
		comboLayout4.getChildren().addAll(listView4,statusInput,addButton6,removeStatusButton,saveStatusButton,backButton5);

		VBox statusSection=new VBox();
		statusSection.setPadding(new Insets(10,10,10,10));
		statusSection.setSpacing(20);
		statusSection.getChildren().addAll(status,comboLayout4);


		/** /////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////
		//***********                       ADOPTION SECTION					***************
		///////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////**/


		//////// ADD PICTURE SECTION/////////

		//ID Column
		TableColumn<Animal, Integer> idColumn5 = new TableColumn<>("Animal ID");
		idColumn5.setMaxWidth(100);
		idColumn5.setCellValueFactory(new PropertyValueFactory<>("ID"));

		//Name column
		TableColumn<Animal, String> nameColumn5 = new TableColumn<>("Name");
		nameColumn5.setMinWidth(200);
		nameColumn5.setCellValueFactory(new PropertyValueFactory<>("name"));

		pictureTable = new TableView<>();
		pictureTable.getColumns().addAll(idColumn5,nameColumn5);

		Button openButton = new Button("Select a Picture...");
		openButton.setOnAction(e -> {
			picture();
		});

		//Image image = new Image(getClass().getResourceAsStream("cit.jpg")); 
		//Label lbl = new Label("a String", new ImageView(image));

		Button addButton0 = new Button("Add");
		addButton0.setOnAction(null);


		HBox comboLayout1 = new HBox(10);
		comboLayout1.setPadding(new Insets(20, 20, 20, 20));
		comboLayout1.autosize();
		comboLayout1.getChildren().addAll(pictureTable,openButton,addButton0);


		/////////TRANSFER ANIMAL SECTION///////////////
		//ID Column
		TableColumn<Animal, Integer> idColumn6 = new TableColumn<>("Animal ID");
		idColumn6.setMaxWidth(100);
		idColumn6.setCellValueFactory(new PropertyValueFactory<>("ID"));

		//Name column
		TableColumn<Animal, String> nameColumn6 = new TableColumn<>("Name");
		nameColumn6.setMinWidth(200);
		nameColumn6.setCellValueFactory(new PropertyValueFactory<>("name"));

		//Age column
		TableColumn<Animal, Integer> ageColumn6 = new TableColumn<>("Age");
		ageColumn6.setMaxWidth(50);
		ageColumn6.setCellValueFactory(new PropertyValueFactory<>("age"));

		//Type column
		TableColumn<Animal, String> typeColumn6 = new TableColumn<>("Type");
		typeColumn6.setMinWidth(100);
		typeColumn6.setCellValueFactory(new PropertyValueFactory<>("aType"));

		//Breed column
		TableColumn<Animal, String> breedColumn6 = new TableColumn<>("Breed");
		breedColumn6.setMinWidth(100);
		breedColumn6.setCellValueFactory(new PropertyValueFactory<>("breed"));

		//Gender column
		TableColumn<Animal, Boolean> genderColumn6 = new TableColumn<>("Gender");
		genderColumn6.setMinWidth(100);
		genderColumn6.setCellValueFactory(new PropertyValueFactory<>("gender"));

		//Gender column
		TableColumn<Animal, Date> dateColumn = new TableColumn<>("Date Found");
		dateColumn.setMinWidth(100);
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("d"));

		transferTable = new TableView<>();
		transferTable.getColumns().addAll(idColumn6,nameColumn6,ageColumn6,typeColumn6,breedColumn6,genderColumn6,dateColumn);

		Button transferButton = new Button("Transfer");
		transferButton.setOnAction(null);
		Button backFromTransferButton = new Button("Back");
		backFromTransferButton.setOnAction(e -> window.setScene(scene));


		HBox transferAdoptionLayout = new HBox(10);
		transferAdoptionLayout.setPadding(new Insets(20, 20, 20, 20));
		transferAdoptionLayout.autosize();
		transferAdoptionLayout.getChildren().addAll(transferTable,transferButton,backFromTransferButton);

		/////////////INTERESTED IN ADOPTION SECTION/////////////////////////

		Label interestedPersonTableLabel = new Label("Interested People table");
		interestedPersonTableLabel.setFont(new Font("Arial", 20));

		Label interestedPersonTableLabel2 = new Label("Enter Details of Interested People");
		interestedPersonTableLabel2.setFont(new Font("Arial", 20));


		//Person Name column
		TableColumn<Person, String> personName2 = new TableColumn<>("Name");
		personName2.setMinWidth(100);
		personName2.setCellValueFactory(new PropertyValueFactory<>("name"));

		//Person phone number column
		TableColumn<Person, String> personPhone2 = new TableColumn<>("Phone Number");
		personPhone2.setMinWidth(100);
		personPhone2.setCellValueFactory(new PropertyValueFactory<>("phone"));
		//Person phone number column
		TableColumn<Person, String> personEmail2 = new TableColumn<>("Email");
		personEmail2.setMinWidth(100);
		personEmail2.setCellValueFactory(new PropertyValueFactory<>("email"));
		//Person phone number column
		TableColumn<Person, String> personAddress2 = new TableColumn<>("Address");
		personAddress2.setMinWidth(100);
		personAddress2.setCellValueFactory(new PropertyValueFactory<>("address"));


		personTable2 = new TableView<>();
		personTable2.setMaxHeight(400);
		personTable2.getColumns().addAll(personName2,personPhone2,personEmail2,personAddress2);

		//Person address input
		interestedPersonAddress=new TextArea();
		interestedPersonAddress.setPromptText("Address");
		interestedPersonAddress.setMaxWidth(300);
		interestedPersonAddress.setMaxHeight(300);

		//Person name input
		interestedPersonName = new TextField();
		interestedPersonName.setPromptText("Enter person name");
		interestedPersonName.setMinWidth(100);

		//Person phone input
		interestedPersonPhone = new TextField();
		interestedPersonPhone.setPromptText("Enter person phone number");
		interestedPersonPhone.setMinWidth(100);

		//Person email input
		interestedPersonEmail = new TextField();
		interestedPersonEmail.setPromptText("Enter person email");
		interestedPersonEmail.setMinWidth(100);

		Button addInterestedPerson = new Button("Add");
		addInterestedPerson.setOnAction(null);
		Button removeInterestedPerson = new Button("Remove");
		removeInterestedPerson.setOnAction(null);
		Button saveInterestedPerson = new Button("Save");
		saveInterestedPerson.setOnAction(null);
		Button backFromInterestedButton = new Button("Back");
		backFromInterestedButton.setOnAction(e -> window.setScene(scene));


		HBox interestedButtons=new HBox();
		interestedButtons.setPadding(new Insets(10,10,10,10));
		interestedButtons.setSpacing(20);
		interestedButtons.getChildren().addAll(addInterestedPerson,removeInterestedPerson,saveInterestedPerson,backFromInterestedButton);

		VBox interestedInputs=new VBox();
		interestedInputs.setPadding(new Insets(10,10,10,10));
		interestedInputs.setSpacing(20);
		interestedInputs.getChildren().addAll(interestedPersonTableLabel2,interestedPersonName,interestedPersonPhone,interestedPersonEmail,interestedPersonAddress,interestedButtons);

		VBox interestedTable=new VBox();
		interestedTable.setPadding(new Insets(10,10,10,10));
		interestedTable.setSpacing(20);
		interestedTable.getChildren().addAll(interestedPersonTableLabel,personTable2);

		HBox interestedLayout=new HBox();
		interestedLayout.setPadding(new Insets(10,10,10,10));
		interestedLayout.setSpacing(20);
		interestedLayout.getChildren().addAll(interestedTable,interestedInputs);


		/////////DISPLAY ALL ANIMALS FOR ADOPTION SECTION///////////////

		Label adoptionTableLabel = new Label("Adoption Table");
		adoptionTableLabel.setFont(new Font("Arial", 20));

		//ID Column
		TableColumn<Animal, Integer> idColumn7 = new TableColumn<>("Animal ID");
		idColumn7.setMaxWidth(100);
		idColumn7.setCellValueFactory(new PropertyValueFactory<>("ID"));

		//Name column
		TableColumn<Animal, String> nameColumn7 = new TableColumn<>("Name");
		nameColumn7.setMinWidth(200);
		nameColumn7.setCellValueFactory(new PropertyValueFactory<>("name"));

		//Age column
		TableColumn<Animal, Integer> ageColumn7 = new TableColumn<>("Age");
		ageColumn7.setMaxWidth(50);
		ageColumn7.setCellValueFactory(new PropertyValueFactory<>("age"));

		//Type column
		TableColumn<Animal, String> typeColumn7 = new TableColumn<>("Type");
		typeColumn7.setMinWidth(100);
		typeColumn7.setCellValueFactory(new PropertyValueFactory<>("aType"));

		//Breed column
		TableColumn<Animal, String> breedColumn7 = new TableColumn<>("Breed");
		breedColumn7.setMinWidth(100);
		breedColumn4.setCellValueFactory(new PropertyValueFactory<>("breed"));

		//Gender column
		TableColumn<Animal, Boolean> genderColumn7 = new TableColumn<>("Gender");
		genderColumn7.setMinWidth(100);
		genderColumn7.setCellValueFactory(new PropertyValueFactory<>("gender"));

		//Gender column
		TableColumn<Animal, Date> dateColumn2 = new TableColumn<>("Date Adopted");
		dateColumn2.setMinWidth(100);
		dateColumn2.setCellValueFactory(new PropertyValueFactory<>("d"));

		adoptionTable = new TableView<>();
		adoptionTable.getColumns().addAll(idColumn7,nameColumn7,ageColumn7,typeColumn7,breedColumn7,genderColumn7,dateColumn2);

		Button removeButton3 = new Button("Remove");
		removeButton3.setOnAction(null);
		Button backFromAdoptionButton = new Button("Back");
		backFromAdoptionButton.setOnAction(e -> window.setScene(scene));


		VBox adoptionAnimalsLayout = new VBox(10);
		adoptionAnimalsLayout.setPadding(new Insets(20, 20, 20, 20));
		adoptionAnimalsLayout.autosize();
		adoptionAnimalsLayout.getChildren().addAll(adoptionTableLabel,adoptionTable,removeButton3,backFromAdoptionButton);


		///////////ADOPTION REPORTS SECTION/////////////////////
		//Name column
		TableColumn<Animal, String> nameColumn8 = new TableColumn<>("Name");
		nameColumn8.setMinWidth(200);
		nameColumn8.setCellValueFactory(new PropertyValueFactory<>("name"));

		//Age column
		TableColumn<Animal, Integer> ageColumn8 = new TableColumn<>("Age");
		ageColumn8.setMaxWidth(50);
		ageColumn8.setCellValueFactory(new PropertyValueFactory<>("age"));

		//Type column
		TableColumn<Animal, Integer> typeColumn8 = new TableColumn<>("Type");
		typeColumn8.setMaxWidth(50);
		typeColumn8.setCellValueFactory(new PropertyValueFactory<>("aType"));

		adoptionReportsTable = new TableView<>();
		adoptionReportsTable.getColumns().addAll(nameColumn8,ageColumn8,typeColumn8);

		//Animal Location
		comboBox13 = new ComboBox<>();
		comboBox13.getItems().addAll("Ready","In Training");
		comboBox13.setPromptText("Status");

		comboBox14=new ComboBox<>();
		comboBox14.setPromptText("Type");

		nameInput3=new TextField();
		nameInput3.setMinWidth(100);
		nameInput3.setPromptText("Name");

		ageInput3=new TextField();
		ageInput3.setMaxWidth(50);
		ageInput3.setPromptText("Age");

		Button displayButton = new Button("Display");
		displayButton.setOnAction(null);
		Button backFromAdoptionReportsButton = new Button("Back");
		backFromAdoptionReportsButton.setOnAction(e -> window.setScene(scene));

		HBox adoptionReportsLayout = new HBox(10);
		adoptionReportsLayout.setPadding(new Insets(20, 20, 20, 20));
		adoptionReportsLayout.autosize();
		adoptionReportsLayout.getChildren().addAll(adoptionReportsTable,nameInput3,ageInput3,comboBox14,comboBox13,displayButton,backFromAdoptionReportsButton);


		/** ///////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////
		/////////                        GENERAL REPORTS SECTION					///////////////
		///////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////**/

		///////////DISPLAY SPONSORS SECTION/////////////////
		Label sponsorTableLabel = new Label("Sponsors table");
		sponsorTableLabel.setFont(new Font("Arial", 20));


		//Person Name column
		TableColumn<Person, String> personName3 = new TableColumn<>("Name");
		personName3.setMinWidth(100);
		personName3.setCellValueFactory(new PropertyValueFactory<>("name"));

		//Person phone number column
		TableColumn<Person, String> personPhone3 = new TableColumn<>("Phone Number");
		personPhone3.setMinWidth(100);
		personPhone3.setCellValueFactory(new PropertyValueFactory<>("phone"));
		//Person phone number column
		TableColumn<Person, String> personEmail3 = new TableColumn<>("Email");
		personEmail3.setMinWidth(100);
		personEmail3.setCellValueFactory(new PropertyValueFactory<>("email"));
		//Person phone number column
		TableColumn<Person, String> personAddress3 = new TableColumn<>("Address");
		personAddress3.setMinWidth(100);
		personAddress3.setCellValueFactory(new PropertyValueFactory<>("address"));


		sponsorTable = new TableView<>();
		sponsorTable.getColumns().addAll(personName3,personPhone3,personEmail3,personAddress3);


		VBox sponsorReportsLayout = new VBox(10);
		sponsorReportsLayout.setPadding(new Insets(20, 20, 20, 20));
		sponsorReportsLayout.autosize();
		sponsorReportsLayout.getChildren().addAll(sponsorTableLabel,sponsorTable);

		/////////ALL ANIMAL REPORTS SECTION///////////////
		Label allAnimalsTableLabel = new Label("All Animals Organised by Age table");
		allAnimalsTableLabel.setFont(new Font("Arial", 20));

		//ID Column
		TableColumn<Animal, Integer> idColumn8 = new TableColumn<>("Animal ID");
		idColumn6.setMaxWidth(100);
		idColumn6.setCellValueFactory(new PropertyValueFactory<>("ID"));

		//Name column
		TableColumn<Animal, String> nameColumn9 = new TableColumn<>("Name");
		nameColumn6.setMinWidth(200);
		nameColumn6.setCellValueFactory(new PropertyValueFactory<>("name"));

		//Age column
		TableColumn<Animal, Integer> ageColumn9 = new TableColumn<>("Age");
		ageColumn6.setMaxWidth(50);
		ageColumn6.setCellValueFactory(new PropertyValueFactory<>("age"));

		//Type column
		TableColumn<Animal, String> typeColumn9 = new TableColumn<>("Type");
		typeColumn6.setMinWidth(100);
		typeColumn6.setCellValueFactory(new PropertyValueFactory<>("aType"));

		//Breed column
		TableColumn<Animal, String> breedColumn8 = new TableColumn<>("Breed");
		breedColumn6.setMinWidth(100);
		breedColumn6.setCellValueFactory(new PropertyValueFactory<>("breed"));

		//Gender column
		TableColumn<Animal, Boolean> genderColumn8 = new TableColumn<>("Gender");
		genderColumn6.setMinWidth(100);
		genderColumn6.setCellValueFactory(new PropertyValueFactory<>("gender"));


		allAnimalsTable = new TableView<>();
		allAnimalsTable.getColumns().addAll(idColumn8,nameColumn9,ageColumn9,typeColumn9,breedColumn8,genderColumn8);


		VBox allAnimalsReportsLayout = new VBox(10);
		allAnimalsReportsLayout.setPadding(new Insets(20, 20, 20, 20));
		allAnimalsReportsLayout.autosize();
		allAnimalsReportsLayout.getChildren().addAll(allAnimalsTableLabel,allAnimalsTable);

		/** ///////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////
		/////////                          LAYOUT SECTION						///////////////
		///////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////**/

		layout = new BorderPane();
		lostLayout=new BorderPane();
		lostLayout.setCenter(hBox2Lost);
		lostLayoutReports=new BorderPane();
		lostLayoutReports.setCenter(vBoxLostReports);

		foundLayout=new BorderPane();
		foundLayout.setCenter(hBox2);
		foundLayoutReports=new BorderPane();
		foundLayoutReports.setCenter(vBoxFoundReports);


		maintenanceLayout=new BorderPane();
		maintenanceLayout.setCenter(typeSection);
		maintenanceLayout2=new BorderPane();
		maintenanceLayout2.setCenter(breedSection);
		maintenanceLayout3=new BorderPane();
		maintenanceLayout3.setCenter(locationSection);
		maintenanceLayout4=new BorderPane();
		maintenanceLayout4.setCenter(statusSection);

		adoptionLayout=new BorderPane();
		adoptionLayout.setLeft(comboLayout1);
		adoptionTransfer=new BorderPane();
		adoptionTransfer.setCenter(transferAdoptionLayout);
		adoptionInterested=new BorderPane();
		adoptionInterested.setCenter(interestedLayout);
		displayAllAdoption=new BorderPane();
		displayAllAdoption.setCenter(adoptionAnimalsLayout);
		reportsForAdoption=new BorderPane();
		reportsForAdoption.setCenter(adoptionReportsLayout);

		reportsLayout=new BorderPane();
		reportsLayout.setCenter(sponsorReportsLayout);
		reportsLayout2=new BorderPane();
		reportsLayout2.setCenter(allAnimalsReportsLayout);

		layout.setTop(menuBar);

		scene = new Scene(layout, 1200, 800);
		scene.getStylesheets().add("Style.css");

		scene1 = new Scene(maintenanceLayout, 1200, 800);
		scene1.getStylesheets().add("Style.css");
		scene2 = new Scene(maintenanceLayout2, 1200, 800);
		scene2.getStylesheets().add("Style.css");
		scene3 = new Scene(maintenanceLayout3, 1200, 800);
		scene3.getStylesheets().add("Style.css");
		scene8 = new Scene(maintenanceLayout4, 1200, 800);
		scene8.getStylesheets().add("Style.css");
		scene4=new Scene(lostLayout,1200,800);
		scene4.getStylesheets().add("Style.css");
		scene5=new Scene(foundLayout,1200,800);
		scene5.getStylesheets().add("Style.css");
		scene6 = new Scene(lostLayoutReports,1200,800);
		scene6.getStylesheets().add("Style.css");
		scene7=new Scene(foundLayoutReports,1200,800);
		scene7.getStylesheets().add("Style.css");
		scene9=new Scene(adoptionTransfer,1200,800);
		scene9.getStylesheets().add("Style.css");
		scene10=new Scene(adoptionInterested,1200,800);
		scene10.getStylesheets().add("Style.css");
		scene11=new Scene(displayAllAdoption,1200,800);
		scene11.getStylesheets().add("Style.css");
		scene12=new Scene(reportsForAdoption,1200,800);
		scene12.getStylesheets().add("Style.css");

		window.setScene(scene);
		window.show();
		loadFromFile();


	}


	/** ///////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////
	/////////                          FUNCTIONS					///////////////
	///////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////**/

	//When selecting a type in breed section, loads list of breeds from a file
	//depending on which animal type is selected
	private void changeBreed() 
	{
		listView2.getItems().removeAll(listView2.getItems());
		File myBreedFile = new File(comboBox2.getSelectionModel().getSelectedItem()+"_Breeds.txt");
		Scanner breeds;
		try {
			breeds = new Scanner(myBreedFile);

			while(breeds.hasNextLine())
			{
				listView2.getItems().add(breeds.nextLine());
			}

			breeds.close();
		}
		catch (FileNotFoundException e) 
		{

		}
	}

	//Add button clicked populates table with animal information entered
	public void addButtonClicked()
	{
		//Animal product = new Animal();
		product.setName(nameInput2.getText());
		product.setAge(Integer.parseInt(ageInput.getText()));
		product.setBreed(comboBox2.getSelectionModel().getSelectedItem());
		product.setType(comboBox1.getValue());
		product.setGender(comboBox12.getSelectionModel().getSelectedItem().equals(comboBox12.getValue().toString()));
		product.getNumber();
		table.getItems().add(product);

		nameInput2.clear();
		ageInput.clear();

	}
	//Delete button clicked
	public void deleteButtonClicked()
	{
		ObservableList<Animal> productSelected, allProducts;
		allProducts = table.getItems();
		productSelected = table.getSelectionModel().getSelectedItems();


		productSelected.forEach(allProducts::remove);
	}

	public void addButtonClicked1()
	{
		//Animal product2 = new Animal();

		product.setName(nameInput.getText());
		product.setAge(Integer.parseInt(ageInput.getText()));
		product.setBreed(comboBox3.getSelectionModel().getSelectedItem());
		product.setType(comboBox4.getValue());
		product.setGender(comboBox7.getSelectionModel().getSelectedItem().equals(comboBox7.getValue().toString()));
		product.getNumber();
		table1.getItems().add(product);

		nameInput.clear();
		ageInput.clear();

	}
	//Delete button clicked deletes an animal from table
	public void deleteButtonClicked1()
	{
		ObservableList<Animal> productSelected2, allProducts2;
		allProducts2 = table1.getItems();
		productSelected2 = table1.getSelectionModel().getSelectedItems();


		productSelected2.forEach(allProducts2::remove);
	}

	//Get all of the products
	public ObservableList<Animal> getProduct()
	{
		ObservableList<Animal> products = FXCollections.observableArrayList();
		products.add(new Animal(5,"Yorkie",true,"Rocky","Black","Dog"));

		return products;
	}
	public void picture()
	{
		FileChooser fileChooser = new FileChooser();
		File selectedFile = fileChooser.showOpenDialog(null);
		String path=selectedFile.getAbsolutePath();
		String imageName=selectedFile.getName();

		if (selectedFile != null) 
		{

			Image image3 = new Image("file:"+path, 400, 200, true, true);
			ImageView iv1 = new ImageView();
			iv1.setImage(image3);

			Hyperlink link = new Hyperlink(imageName);

			HBox picture = new HBox(10);
			picture.setPadding(new Insets(20, 20, 20, 20));
			picture.autosize();
			picture.getChildren().addAll(link);
			adoptionLayout.setCenter(picture);

			VBox next=new VBox();
			next.getChildren().addAll(iv1);
			link.setOnAction(e -> adoptionLayout.setCenter(next));
		}
	}
	//Saves all animal types to a file that are currently displayed in the list
	private void saveTypeButtonClicked()
	{
		PrintWriter outputFile;
		try {
			outputFile = new PrintWriter("AnimalType.txt");

			for (String s : listView.getItems()) 	  
			{

				outputFile.println(s);
			}
			outputFile.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	//Saves all animal breeds to a file corresponding to animal type that are currently in the list
	private void saveBreedButtonClicked(){
		File file = new File(comboBox2.getSelectionModel().getSelectedItem() + "_Breeds.txt");
		PrintWriter outputFile;

		try
		{
			outputFile = new PrintWriter(file);
			for(int i = 0; i < listView2.getItems().size(); i++)
			{
				outputFile.println(listView2.getItems().get(i));
			}

			outputFile.close();
		}

		catch(FileNotFoundException e)
		{
			System.out.println("Error");
		}
	}

	//Saves all animal locations to a file that are currently displayed in the list
	private void saveLocationButtonClicked(){
		PrintWriter outputFile;
		try {

			outputFile = new PrintWriter("AnimalLocation.txt");

			for (String s : listView3.getItems()) 	  
			{

				outputFile.println(s);
			}
			outputFile.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	//Saves all animal statuses to a file that are currently displayed in the list
	private void saveStatusButtonClicked(){
		PrintWriter outputFile;
		try {

			outputFile = new PrintWriter("AnimalStatuses.txt");

			for (String s : listView4.getItems()) 	  
			{

				outputFile.println(s);
			}
			outputFile.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}
	// Reads animal types and animal locations from a file and loads them to list tables
	private void loadFromFile()
	{
		listView.getItems().removeAll(listView.getItems());
		listView3.getItems().removeAll(listView3.getItems());
		listView4.getItems().removeAll(listView4.getItems());
		try {

			File myTypeFile = new File("AnimalType.txt");
			Scanner types = new Scanner(myTypeFile);
			while(types.hasNextLine())
			{
				listView.getItems().add(types.nextLine());
				comboBox2.setItems(listView.getItems());
			}
			types.close();

			File myLocationFile = new File("AnimalLocation.txt");
			Scanner locations = new Scanner(myLocationFile);
			while(locations.hasNextLine())
			{

				listView3.getItems().add(locations.nextLine());
			}

			locations.close();

			File myStatusFile = new File("AnimalStatuses.txt");
			Scanner statuses = new Scanner(myStatusFile);
			while(statuses.hasNextLine())
			{

				listView4.getItems().add(statuses.nextLine());
			}

			statuses.close();
		} 
		catch (Exception e1) {
			System.out.println("Sorry but there is no such file");
		}	
	}


}


