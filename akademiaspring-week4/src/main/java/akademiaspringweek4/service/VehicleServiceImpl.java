package akademiaspringweek4.service;


import akademiaspringweek4.model.Color;
import akademiaspringweek4.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    private List<Vehicle> vehicleList;

    public VehicleServiceImpl() {
        vehicleList = new ArrayList<>();
        vehicleList.add(new Vehicle(1L, "Porsche", "Panamera", Color.BLACK));
        vehicleList.add(new Vehicle(2L, "Opel", "Vectra", Color.WHITE));
        vehicleList.add(new Vehicle(3L, "Fiat", "Punto", Color.BLACK));
        vehicleList.add(new Vehicle(4L, "Volkswagen", "Passat", Color.BLUE));
        vehicleList.add(new Vehicle(5L, "Volkswagen", "Golf", Color.YELLOW));
        vehicleList.add(new Vehicle(6L, "Toyota", "Yaris", Color.RED));
        vehicleList.add(new Vehicle(7L, "Dacia", "Sandero", Color.GREEN));

    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleList;
    }

    @Override
    public Optional<Vehicle> getVehicleById(long id) {
        return vehicleList.stream().filter(vehicle -> vehicle.getId() == id).findFirst();
    }

    @Override
    public boolean addVehicle(Vehicle vehicle) {
        return vehicleList.add(vehicle);
    }

    @Override
    public boolean modifyVehicle(Vehicle vehicle) {
        Optional<Vehicle> first = vehicleList.stream().filter(v -> v.getId() == vehicle.getId()).findFirst();

        if (first.isPresent()) {
            Vehicle v = first.get();
            v.setMark(vehicle.getMark());
            v.setModel(vehicle.getModel());
            v.setColor(vehicle.getColor());

            return true;

        }

        return false;

    }

    @Override
    public boolean deleteVehicle(long id) {
        Optional<Vehicle> first = vehicleList.stream().filter(v -> v.getId() == id).findFirst();

        return vehicleList.remove(first.get());
    }

}
