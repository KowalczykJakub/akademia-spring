package akademiaspringweek3;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/vehicles",
        produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_XML_VALUE})
public class VehicleApi {

    private List<Vehicle> vehicleList;

    public VehicleApi() {

        vehicleList = new ArrayList<>();
        vehicleList.add(new Vehicle(1, "Porsche", "Panamera", Color.YELLOW));
        vehicleList.add(new Vehicle(2, "Fiat", "Punto", Color.RED));
        vehicleList.add(new Vehicle(3, "Honda", "Civic", Color.BLACK));
        vehicleList.add(new Vehicle(4, "Toyota", "Yaris", Color.BLACK));

    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getVehicles() {
        return new ResponseEntity<>(vehicleList, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable int id) {

        Optional<Vehicle> first = vehicleList.stream().filter(vehicle -> vehicle.getId() == id).findFirst();

        if (first.isPresent()) {
            return new ResponseEntity<>(first.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/color/{color}")
    public ResponseEntity<List<Vehicle>> getVehiclesById(@PathVariable Color color) {

        List<Vehicle> vehicleSubList = vehicleList.stream()
                .filter(vehicle -> vehicle.getColor() == color)
                .collect(Collectors.toList());

        if (vehicleSubList.size() != 0) {
            return new ResponseEntity<>(vehicleSubList, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity addVehicle(@RequestBody Vehicle vehicle) {

        boolean add = vehicleList.add(vehicle);

        if (add) {
            return new ResponseEntity(HttpStatus.CREATED);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);

    }

    @PutMapping
    public ResponseEntity editVehicle(@RequestBody Vehicle vehicle) {

        Optional<Vehicle> first = vehicleList.stream().filter(v -> v.getId() == vehicle.getId()).findFirst();

        if (first.isPresent()) {

            vehicleList.remove(first.get());
            vehicleList.add(vehicle);

            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity removeVehicleById(@PathVariable int id) {

        Optional<Vehicle> first = vehicleList.stream().filter(vehicle -> vehicle.getId() == id).findFirst();

        if (first.isPresent()) {

            vehicleList.remove(first.get());

            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
