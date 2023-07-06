package com.devsling.testtechnique1.services;

import com.devsling.testtechnique1.entity.Car;
import com.devsling.testtechnique1.enums.TypeCarburant;
import javassist.NotFoundException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CarService {
    Car addCar(Car car);
    List<Car> searchForCarsByFuelTypeAndPricemax(TypeCarburant typeCarburant, double prixMax);
    List<Car> showAvailableCars();
    Car updateCarImage(Long carId, MultipartFile image) throws NotFoundException, IOException;
}
