package akademiaspringweek4.service;

import akademiaspringweek4.model.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {

    List<Vehicle> getAllVehicles();

    Optional<Vehicle> getVehicleById(long id);

    boolean addVehicle(Vehicle vehicle);

    boolean modifyVehicle(Vehicle vehicle);

    boolean deleteVehicle(long id);

}
