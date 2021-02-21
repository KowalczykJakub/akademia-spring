package akademiaspringweek3.service;

import akademiaspringweek3.model.Color;
import akademiaspringweek3.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<Vehicle> getVehiclesByColor(Color color) {
        return vehicleList.stream().filter(vehicle -> vehicle.getColor().equals(color)).collect(Collectors.toList());
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
    public boolean modifyMark(long id, String mark) {
        Optional<Vehicle> first = vehicleList.stream().filter(v -> v.getId() == id).findFirst();

        if (first.isPresent()) {

            first.get().setMark(mark);

            return true;

        }

        return false;

    }

    @Override
    public boolean modifyModel(long id, String model) {
        Optional<Vehicle> first = vehicleList.stream().filter(v -> v.getId() == id).findFirst();

        if (first.isPresent()) {

            first.get().setModel(model);

            return true;

        }

        return false;

    }

    @Override
    public boolean modifyColor(long id, Color color) {
        Optional<Vehicle> first = vehicleList.stream().filter(v -> v.getId() == id).findFirst();

        if (first.isPresent()) {

            first.get().setColor(color);

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
