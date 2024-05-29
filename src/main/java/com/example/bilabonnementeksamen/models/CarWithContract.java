package com.example.bilabonnementeksamen.models;

import java.util.List;

public class CarWithContract {
    private Car car;
    private int rentalContractId;
    private List<Damage> damages;


    public CarWithContract() {
    }

    public CarWithContract(Car car, int rentalContractId) {
        this.car = car;
        this.rentalContractId = rentalContractId;
    }

    public CarWithContract(Car car, int rentalContractId, List<Damage> damages) {
        this.car = car;
        this.rentalContractId = rentalContractId;
        this.damages = damages;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getRentalContractId() {
        return rentalContractId;
    }

    public void setRentalContractId(int rentalContractId) {
        this.rentalContractId = rentalContractId;
    }

    public List<Damage> getDamages() {
        return damages;
    }

    public void setDamages(List<Damage> damages) {
        this.damages = damages;
    }
}
