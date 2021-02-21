package akademiaspringweek3.service;

import akademiaspringweek3.model.Color;
import akademiaspringweek3.model.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {

    List<Vehicle> getAllVehicles();

    Optional<Vehicle> getVehicleById(long id);

    List<Vehicle> getVehiclesByColor(Color color);

    boolean addVehicle(Vehicle vehicle);

    boolean modifyVehicle(Vehicle vehicle);

    boolean modifyMark(long id, String mark);

    boolean modifyModel(long id, String model);

    boolean modifyColor(long id, Color color);

    boolean deleteVehicle(long id);

}
