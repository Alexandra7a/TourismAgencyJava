package org.example.model;


import java.time.LocalDateTime;

public class Trip extends Entityy<Long> {
    private String place;
    private String transportCompanyName;
    private LocalDateTime departure;
    private float price;
    private int totalSeats;

    public Trip(String place, String transportCompanyName, LocalDateTime departure, float price, int totalSeats) {
        this.place = place;
        this.transportCompanyName = transportCompanyName;
        this.departure = departure;
        this.price = price;
        this.totalSeats = totalSeats;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTransportCompanyName() {
        return transportCompanyName;
    }

    public void setTransportCompanyName(String transportCompanyName) {
        this.transportCompanyName = transportCompanyName;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "place='" + place + '\'' +
                ", transportCompanyName='" + transportCompanyName + '\'' +
                ", departure=" + departure +
                ", price=" + price +
                ", totalSeats=" + totalSeats +
                '}';
    }
}
