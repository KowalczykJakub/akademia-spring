package akademiaspringweek3.controller;

import akademiaspringweek3.model.Color;
import akademiaspringweek3.model.Vehicle;
import akademiaspringweek3.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleApi {

    private VehicleService vehicleService;

    @Autowired
    public VehicleApi(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        return new ResponseEntity<>(vehicleService.getAllVehicles(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable long id) {

        Optional<Vehicle> vehicleById = vehicleService.getVehicleById(id);

        return vehicleById.map(vehicle -> new ResponseEntity<>(vehicle, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @GetMapping("/color/{color}")
    public ResponseEntity<List<Vehicle>> getVehiclesByColor(@PathVariable Color color) {

        List<Vehicle> vehiclesByColor = vehicleService.getVehiclesByColor(color);

        if (vehiclesByColor.size() != 0) {

            return new ResponseEntity<>(vehiclesByColor, HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping
    public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {

        if (vehicleService.addVehicle(vehicle)) {

            return new ResponseEntity<>(HttpStatus.CREATED);

        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @PutMapping
    public ResponseEntity<Vehicle> modifyVehicle(@RequestBody Vehicle vehicle) {

        if (vehicleService.modifyVehicle(vehicle)) {

            return new ResponseEntity<>(HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PatchMapping("/{id}/mark/{mark}")
    public ResponseEntity<Vehicle> modifyMark(@PathVariable long id, @PathVariable String mark) {

        if (vehicleService.modifyMark(id, mark)) {

            return new ResponseEntity<>(HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PatchMapping("/{id}/model/{model}")
    public ResponseEntity<Vehicle> modifyModel(@PathVariable long id, @PathVariable String model) {

        if (vehicleService.modifyModel(id, model)) {

            return new ResponseEntity<>(HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PatchMapping("/{id}/color/{color}")
    public ResponseEntity<Vehicle> modifyColor(@PathVariable long id, @PathVariable Color color) {

        if (vehicleService.modifyColor(id, color)) {

            return new ResponseEntity<>(HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Vehicle> removeCar(@PathVariable long id) {

        if (vehicleService.deleteVehicle(id)) {

            return new ResponseEntity<>(HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}
