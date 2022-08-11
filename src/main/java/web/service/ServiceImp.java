package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ServiceImp implements Service {

    Car car1 = new Car("Audi", "Black", 2021);
    Car car2 = new Car("BMW", "White", 2020);
    Car car3 = new Car("Porsche", "Red", 2019);
    Car car4 = new Car("Ford", "Green", 2018);
    Car car5 = new Car("Infiniti", "Blue", 2017);

    @Override
    public List<Car> getCarsList(int count) {

        List<Car> cars = new ArrayList<>();

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);

        if(count > 0 && count <= cars.size()){
            return cars.stream().limit(count).collect(Collectors.toList());
        } else {
            throw new RuntimeException("Значение вне диапазона списка");
        }
    }
}
