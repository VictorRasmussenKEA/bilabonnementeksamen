package com.example.bilabonnementeksamen.repositories;

import com.example.bilabonnementeksamen.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Car> getAllCars() {
        String query = "SELECT * from cars";
        RowMapper rowMapper = new BeanPropertyRowMapper(Car.class);
        return jdbcTemplate.query(query, rowMapper);
    }

    public List<Car> getAllCarsThatAreAvailable() {
        String query = "SELECT * FROM cars where status = 'AVAILABLE';";
        RowMapper rowMapper = new BeanPropertyRowMapper(Car.class);
        return jdbcTemplate.query(query, rowMapper);
    }

    public void createNewCar(String frameNumber, String brand, String model, int monthlyPrice, String registrationNumber, String status){
     String query ="insert into cars(frame_number, brand, model, monthly_price, registration_number, status) +" +
             " values(?,?,?,?,?,?)";
     jdbcTemplate.update(query, frameNumber, brand, model, monthlyPrice, registrationNumber, status);
    }
    public void updateCarStatus(int carId, String status) {
        String query = "UPDATE cars SET status = ? WHERE car_id = ?";
        jdbcTemplate.update(query, status, carId);
    }
     public Car getAllCarsReturned(int rentalContractCarId) {
        String query = "SELECT * FROM cars WHERE car_id = ? AND status = 'RENTED';";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper(Car.class);
        return jdbcTemplate.queryForObject(query, rowMapper, rentalContractCarId);
     }
     public Car getCar(int carId){
        String query = "SELECT * FROM car WHERE car_id = ?;";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        try {
            return jdbcTemplate.queryForObject(query, rowMapper, carId);
        } catch(EmptyResultDataAccessException e) {
            return null;
        }
     }
    public Car getCarRented(int carId) {
        String query = "SELECT * FROM cars WHERE car_id = ? AND status = 'RENTED';";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        try {
            return jdbcTemplate.queryForObject(query, rowMapper, carId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


     public Car getCarMaintenance(int carId){
        String query = "select * from cars where car_id  = ? and status = 'MAINTENANCE';";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        try {
            return jdbcTemplate.queryForObject(query, rowMapper, carId);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
     }

     public void changeCarToAvailable(int carId){
        String query = "update cars set status = 'AVAILABLE' where car_id = ?;";
        jdbcTemplate.update(query, carId);
     }

     public void changeCarToMaintenance(int carId){
        String query ="update cars set status = 'MAINTENANCE' where car_id = ?;";
        jdbcTemplate.update(query, carId);
     }

    public double getMonthlyPriceForCar(int carId) {
        String query = "SELECT monthly_price FROM cars WHERE car_id = ?;";
        Double price = jdbcTemplate.queryForObject(query, new Object[]{carId}, Double.class);
        return price != null ? price : 0.0;  // Håndtering af null værdi, i tilfælde af at ingen pris findes
     }
     public void updateCar(String frameNumber, String brand, String model, double monthlyPrice, String registrationNumber, String status, int carId){
        String query = "update cars set frame_number = ?, model = ?, monthly_price = ?, registration_number = ?, status = ? where car_id = ?;";
        jdbcTemplate.update(query, frameNumber, model, monthlyPrice, registrationNumber, status, carId);
     }

     public void deleteCar(int carId) {
        String query = "delete from cars where car_id = ?;";
        jdbcTemplate.update(query, carId);
     }
}
