package com.example.bilabonnementeksamen.repositories;

import com.example.bilabonnementeksamen.models.Car;
import com.example.bilabonnementeksamen.models.RentalContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class RentalContractRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public RentalContractRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public void createRentalContract(int customerId, int carId, LocalDate startDate, LocalDate endDate, double price, String pickUpLocation, String conditionOnDelivery, String conditionUponReturn) {
        String query = "insert into rental_contracts(customer_id, car_id, start_date, end_date, price, pick_up_location," +
                "condition_on_delivery, condition_upon_return) values(?,?,?,?,?,?,?,?);";
        jdbcTemplate.update(query, customerId, carId,startDate,endDate,price,pickUpLocation,conditionOnDelivery,conditionUponReturn, "no");
    }

    public List<Car> getRentedCarsCount(){
        String query = "SELECT * FROM cars where status = 'RENTED'";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        return jdbcTemplate.query(query, rowMapper);
    }

    public double getTotalRevenue() {
        String query = "SELECT SUM(price) FROM rental_contracts WHERE start_date <= CURDATE() AND end_date >= CURDATE()";
        Double result = jdbcTemplate.queryForObject(query, Double.class);
        return result != null ? result : 0.0;
    }


    public List<RentalContract> getAllRentalContractWhereTheCarHasBeenReturned(){
        String query = "SELECT * FROM rental_contracts WHERE end_date >= CURDATE() And is_rental_contract_ended = 'no';";
        RowMapper<RentalContract> rowMapper = new BeanPropertyRowMapper<>(RentalContract.class);
        return jdbcTemplate.query(query, rowMapper);
    }

    public List<RentalContract> getAllRentalContractsThatsActive(){
        String query = "SELECT * FROM rental_contracts WHERE is_rental_contract_ended = 'no';";
        RowMapper rowMapper = new BeanPropertyRowMapper<>(RentalContract.class);
        return jdbcTemplate.query(query, rowMapper);
    }

    public void concludeContract(int rentalContractId){
        String query = "update rental_contracts set is_rental_contract_ended = 'yes' where rental_contract_id = ?;";
        jdbcTemplate.update(query, rentalContractId);
    }

    public RentalContract getRentalContract(int rentalContractId){
        String query = "SELECT * FROM rental_contracts WHERE rental_contract_id = ?;";
        RowMapper<RentalContract> rowMapper = new BeanPropertyRowMapper<>(RentalContract.class);
        return jdbcTemplate.queryForObject(query, rowMapper, rentalContractId);
    }

    public void changeConditionUponReturn(int rentalContractId){
        String query = "update rental_contracts set condition_upon_return = 'had one or more damages' where rental_contract_id = ?;";
        jdbcTemplate.update(query, rentalContractId);
    }

    public void changeConditionUponReturnToDamaged(int rentalContractId) {
        String query = "update rental_contracts set condition_upon_return = 'had one or more damages' where rental_contract_id = ?;";
        jdbcTemplate.update(query, rentalContractId);}

    public List<RentalContract> getAllRentalContracts(){
        String query = "SELECT * FROM rental_contracts;";
        RowMapper<RentalContract> rowMapper = new BeanPropertyRowMapper<>(RentalContract.class);
        return jdbcTemplate.query(query, rowMapper);
    }

    public void deleteRentalContract(int rentalContractId){
        String query = "delete from rental_contracts where rental_contract_id = ?;";
        jdbcTemplate.update(query, rentalContractId);
    }
}
