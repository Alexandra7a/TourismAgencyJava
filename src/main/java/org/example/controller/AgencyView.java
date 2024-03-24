package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.model.Client;
import org.example.model.Employee;
import org.example.model.Reservation;
import org.example.model.Trip;
import org.example.service.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

public class AgencyView {

    @FXML
    TableView<Trip> tableTrip;
    @FXML
    TableColumn<Float,Trip> price;
    @FXML
    TableColumn<String,Trip> transportCompany;
    @FXML
    TableColumn<String,Trip> place;
    @FXML
    TableColumn<String, Trip>departure;
    @FXML
    TableColumn<Integer,Trip> noSeatsAvailable;

    @FXML
    TableView<Trip> tableTripFiltered;
    @FXML
    TableColumn<Float,Trip> priceFiltered;
    @FXML
    TableColumn<String,Trip> transportCompanyFiltered;
    @FXML
    TableColumn<String,Trip> placeFiltered;
    @FXML
    TableColumn<String, Trip>departureFiltered;
    @FXML
    TableColumn<Integer,Trip> noSeatsAvailableFiltered;

    @FXML
    DatePicker dateStartPicker;
    @FXML
    DatePicker dateEndPicker;
    @FXML
    ComboBox<Integer> hour2Combo;
    @FXML
    ComboBox<Integer> hour1Combo;
    @FXML
    TextField placeField;
    @FXML
    ListView<Client> clientList;

    @FXML
    TextField clientNameField;
    @FXML
    TextField phoneNumberField;
    @FXML
    TextField noSeatsField;


    private Service service;
    private Stage primaryStage;
    private Employee responsibleEmployee;
    public void setService(Stage primaryStage,Service service,Employee responsibleEmployee) {
        this.service=service;
        this.primaryStage=primaryStage;
        this.responsibleEmployee=responsibleEmployee;
        loadData();
        loadClientsData();
    }

    private void loadClientsData() {
        clientList.getItems().clear();
        for (Client client:service.getAllClients()) {
            clientList.getItems().add(client);

        }
    }

    private void loadData() {
        tableTrip.getItems().clear();
        for (Trip trip:service.getAllTrips()) {
            int availableSeats=trip.getTotalSeats()-service.getAllReservationsAt(trip.getId());
            trip.setTotalSeats(availableSeats);
            tableTrip.getItems().add(trip);
        }
    }
    private void loadFilteredData(String placeToVisit, LocalDateTime startTime, LocalDateTime endTime) {
        tableTripFiltered.getItems().clear();
        for (Trip trip:service.findAllTripPlaceTime(placeToVisit,startTime,endTime)) {
            int availableSeats=trip.getTotalSeats()-service.getAllReservationsAt(trip.getId());
            trip.setTotalSeats(availableSeats);
            tableTripFiltered.getItems().add(trip);
        }
    }

    /**
     * Not sure if my approach is right TODO: ask about it
     * I have filtered the trips by date and hours and place*/
    public void tripFilterButton(ActionEvent actionEvent) {
        try
        {
            String place=placeField.getText();
            LocalDate dateStart=dateStartPicker.getValue();
            LocalDate dateEnd=dateEndPicker.getValue();
            int hour2= hour1Combo.getValue();
            int hour1= hour2Combo.getValue();
            LocalDateTime startlocalDateTime=dateStart.atTime(hour1,0);
            LocalDateTime endlocalDateTime=dateEnd.atTime(hour2,0);
            loadFilteredData(place,startlocalDateTime,endlocalDateTime);

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }




    public void execButton(ActionEvent actionEvent) {
    }

    public void cancelExecButton(ActionEvent actionEvent) {
    }

    public void addButton(ActionEvent actionEvent) {
    }

    public void deleteButton(ActionEvent actionEvent) {
    }

    public void updateButton(ActionEvent actionEvent) {
    }

    public void cancelButton(ActionEvent actionEvent) {
    }

    public void handleAddTaskRunner(ActionEvent actionEvent) {
    }

    public void handleExecuteOne(ActionEvent actionEvent) {
    }

    public void handleExecuteALL(ActionEvent actionEvent) {
    }
    @FXML
    public void initialize(){
       ArrayList<Integer> list=new ArrayList<>();
        for (int i=0;i<24;i++)
            list.add(i);
        hour1Combo.setItems(FXCollections.observableList(list));
        hour2Combo.setItems(FXCollections.observableList(list));
    }


    public void LogOutHandler(ActionEvent actionEvent) {
        primaryStage.close();
    }

    public void onReserveButtonClicked(ActionEvent actionEvent) {
        //todo: check all fields to be filled
        String clientName=clientNameField.getText() ;
        String phoneNumber=phoneNumberField.getText();
        int noSeats=Integer.parseInt(noSeatsField.getText());
        Client client=clientList.getSelectionModel().getSelectedItem();
        var selection1= tableTripFiltered.getSelectionModel().getSelectedItem();
        var selection2= tableTrip.getSelectionModel().getSelectedItem();
        Trip trip;
        if (selection1!=null) {
            trip=selection1;
        } else trip=selection2;

        System.out.println(clientName);
        System.out.println(phoneNumber);
        System.out.println(noSeats);
        System.out.println(trip.getId());
        System.out.println(client.toString());
        try {
            Optional<Reservation> result=service.reserveTicet(clientName,phoneNumber,noSeats,trip,responsibleEmployee,client);
            MessageAlert.showMessage(primaryStage, Alert.AlertType.INFORMATION,"Info","Successful reservation...");

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            MessageAlert.showMessage(primaryStage, Alert.AlertType.ERROR,"Error","Could not save the reservation...");
        }
    }

    public void onRefreshButtonClicked(ActionEvent actionEvent) {
        loadData();
    }
}
