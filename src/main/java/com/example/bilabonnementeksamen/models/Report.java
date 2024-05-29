package com.example.bilabonnementeksamen.models;

import java.time.LocalDate;

public class Report {
    private int reportId;
    private LocalDate date;
    private int numberOfCarsRented;
    private double totalRevenue;
    public Report() {

    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getNumberOfCarsRented() {
        return numberOfCarsRented;
    }

    public void setNumberOfCarsRented(int numberOfCarsRented) {
        this.numberOfCarsRented = numberOfCarsRented;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}