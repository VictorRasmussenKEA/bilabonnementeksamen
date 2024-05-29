package com.example.bilabonnementeksamen.models;

import com.example.bilabonnementeksamen.enums.CarStatus;

    public class Car {
        private int carId;
        private String frameNumber;
        private String brand;
        private String model;
        private double monthlyPrice;
        private String registrationNumber;
        private CarStatus status;

        public Car() {
        }

        public int getCarId() {
            return carId;
        }

        public void setCarId(int carId) {
            this.carId = carId;
        }

        public String getFrameNumber() {
            return frameNumber;
        }

        public void setFrameNumber(String frameNumber) {
            this.frameNumber = frameNumber;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public double getMonthlyPrice() {
            return monthlyPrice;
        }

        public void setMonthlyPrice(double monthlyPrice) {
            this.monthlyPrice = monthlyPrice;
        }

        public String getRegistrationNumber() {
            return registrationNumber;
        }

        public void setRegistrationNumber(String registrationNumber) {
            this.registrationNumber = registrationNumber;
        }

        public CarStatus getStatus() {
            return status;
        }

        public void setStatus(CarStatus status) {
            this.status = status;
        }
    }