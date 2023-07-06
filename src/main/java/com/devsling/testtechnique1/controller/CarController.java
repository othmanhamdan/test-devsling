package com.devsling.testtechnique1.controller;

import com.devsling.testtechnique1.entity.Car;
import com.devsling.testtechnique1.enums.TypeCarburant;
import com.devsling.testtechnique1.services.CarService;
import com.devsling.testtechnique1.util.FileUploadUtil;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    @Value("{$}")
    String FILE_DIRECTORY;


    public CarController(CarService carService) {
        this.carService = carService;
    }
    @PostMapping
    @ApiOperation("Ajouter une Voiture")
    public ResponseEntity<Car> addCars(@RequestBody Car car, @RequestParam MultipartFile image) throws IOException {
        if (!image.isEmpty()){
            car.setImage(image.getBytes());
            carService.addCar(car);
        }
        return ResponseEntity.ok(car);
    }

    @GetMapping
    @ApiOperation("récupérer les Voitures Par Type Carburant Et Prix Max")
    public ResponseEntity<List<Car>> rechercherVoituresParTypeCarburantEtPrixMax(
            @RequestParam TypeCarburant typeCarburant, @RequestParam double prixMax) {
        List<Car> cars = carService.searchForCarsByFuelTypeAndPricemax(typeCarburant, prixMax);
        return ResponseEntity.ok(cars);
    }
    @GetMapping("/available")
    @ApiOperation("Récupère toutes les voitures")
    public ResponseEntity<List<Car>> availableCars() {
        List<Car> cars = carService.showAvailableCars();
        return ResponseEntity.ok(cars);
    }
    @PutMapping("/{carId}/image")
    @ApiOperation("modification de l'image")
    public Car updateCarImage(@PathVariable Long carId, @RequestParam MultipartFile image) throws NotFoundException, IOException {
        return carService.updateCarImage(carId, image);
    }
}
