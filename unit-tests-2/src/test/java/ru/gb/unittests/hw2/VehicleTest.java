package ru.gb.unittests.hw2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VehicleTest {
    Car car;
    Motorcycle motorcycle;

    @BeforeEach
    void setup() {
        car = new Car("Toyota", "Corolla", 2006);
        motorcycle = new Motorcycle("Yamaha", "WR250R", 2021);
    }

    //Проверить, что экземпляр объекта Car также является экземпляром транспортного средства
    // (используя оператор instanceof).
    @Test
    void isInstance_Correct() {
        assertThat(car).isInstanceOf(Vehicle.class);
    }

    // Проверить, что объект Car создается с 4-мя колесами.
    @Test
    void carHasFourWheels_Correct() {
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    // Проверить, что объект Motorcycle создается с 2-мя колесами.

    @Test
    void motorcycleHasTwoWheels() {
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }

    // Проверить, что объект Car развивает скорость 60 в режиме тестового вождения (используя метод testDrive()).
    @Test
    void carHasSpeed60WhileTestDriving() {
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    // Проверить, что объект Motorcycle развивает скорость 75 в режиме тестового вождения (используя метод testDrive()).

    @Test
    void motorcycleHasSpeed75WhileTestDriving() {
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    // Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта)
    // машина останавливается (speed = 0).

    @Test
    void carStopsWhileParking() {
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isZero();
    }


    // Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта)
    // мотоцикл останавливается (speed = 0).
    @Test
    void motorcycleStopsWhileParking() {
        motorcycle.testDrive();
        motorcycle.park();
        assertThat(motorcycle.getSpeed()).isZero();
    }

}
