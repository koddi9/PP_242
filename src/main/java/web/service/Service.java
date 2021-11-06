package web.service;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;

public interface Service {
    public List<Car> getCarsList(String count);
}
