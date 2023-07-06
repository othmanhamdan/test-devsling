package com.devsling.testtechnique1.services.Impl;

import com.devsling.testtechnique1.entity.Car;
import com.devsling.testtechnique1.enums.TypeCarburant;
import com.devsling.testtechnique1.repository.CarRepository;
import com.devsling.testtechnique1.services.CarService;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car addCar(Car car) {
        // Check if the car is registered from 2015
        if (car.getDateEnregistrement().isBefore(LocalDate.of(2015, 1, 1))) {
            throw new IllegalArgumentException("Only cars registered from 2015 are allowed.");
        }
        return carRepository.save(car);
    }
    public List<Car> searchForCarsByFuelTypeAndPricemax(TypeCarburant typeCarburant, double priceMax) {
        return carRepository.findByTypeCarburantAndPrixLessThanEqual(typeCarburant, priceMax);
    }
    public List<Car> showAvailableCars() {
        return carRepository.findAll();
    }
    public Car updateCarImage(Long carId, MultipartFile image) throws NotFoundException, IOException {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new NotFoundException("Car not found"));
        car.setImage(image.getBytes());
        return carRepository.save(car);
    }
}
