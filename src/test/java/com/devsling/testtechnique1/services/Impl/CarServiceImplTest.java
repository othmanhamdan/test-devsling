package com.devsling.testtechnique1.services.Impl;

import com.devsling.testtechnique1.entity.Car;
import com.devsling.testtechnique1.enums.Transmission;
import com.devsling.testtechnique1.enums.TypeCarburant;
import com.devsling.testtechnique1.repository.CarRepository;
import com.devsling.testtechnique1.services.CarService;
import javassist.NotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CarServiceImplTest {
    @Mock
    private CarRepository carRepository;
    private CarService carService;
    AutoCloseable autoCloseable;
    Car car;

    @Before
    public void setUp() throws Exception {
        autoCloseable = MockitoAnnotations.openMocks(this);
        carService = new CarServiceImpl(carRepository);
        car = new Car(null,"WWW","AUDI", LocalDate.of(2020 ,01,01),2235.3, TypeCarburant.DIESEL,1234, Transmission.AUTOMATIQUE,null);

    }
    @After
    public void tearDown() throws Exception {
        autoCloseable.close();
    }


    @Test
    public void addCar() {
        mock(Car.class);
        mock(CarRepository.class);
        when(carRepository.save(car)).thenReturn(car);
        Assertions.assertThat(carService.addCar(car)).isEqualTo(car);
    }

    @Test
    public void searchForCarsByFuelTypeAndPricemax() {
        mock(Car.class);
        mock(CarRepository.class);
        when(carRepository.save(car)).thenReturn(car);
        Assertions.assertThat(carService.searchForCarsByFuelTypeAndPricemax(car.getTypeCarburant(),car.getPrix())).isEqualTo(car);
    }

    @Test
    public void showAvailableCars() {
        mock(Car.class);
        mock(CarRepository.class);
        when(carRepository.save(car)).thenReturn(car);
        Assertions.assertThat(carService.showAvailableCars()).isEqualTo(car);
    }

    @Test
    public void updateCarImage() throws NotFoundException, IOException {
        mock(Car.class);
        mock(CarRepository.class);
        when(carRepository.save(car)).thenReturn(car);
        Assertions.assertThat(carService.updateCarImage(car.getId(),null)).isEqualTo(car);
    }
}