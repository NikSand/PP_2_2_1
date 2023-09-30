package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user, Car car);
    List<User> listUsers();

    List<Car> listCars();

    List <User> findUserByCar (String carName, int carSeries);
}