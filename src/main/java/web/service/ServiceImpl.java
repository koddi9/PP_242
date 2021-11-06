package web.service;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceImpl implements Service{

    @Override
    public List<Car> getCarsList(String count) {
        if (count==null){
            count="5";
        }
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW",5,"gray"));
        cars.add(new Car("2",2,"black"));
        cars.add(new Car("3",3,"white"));
        cars.add(new Car("4",4,"green"));
        cars.add(new Car("5",5,"red"));

        return cars.stream().limit(Integer.parseInt(count)).collect(Collectors.toList());
    }
}
