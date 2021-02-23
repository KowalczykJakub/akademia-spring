package akademiaspringweek4.controller;

import akademiaspringweek4.model.Vehicle;
import akademiaspringweek4.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/vehicles")
public class VehicleController {

    private VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/get")
    public String getAllVehicles(Model model) {
        model.addAttribute("newVehicle", new Vehicle());
        model.addAttribute("vehicles", vehicleService.getAllVehicles());
        return "getVehicles";
    }

    @PostMapping("/getModifyingForm")
    public String getModifyingForm(@ModelAttribute Vehicle vehicle) {

        vehicleService.modifyVehicle(vehicle);

        return "redirect:/vehicles/get";
    }

    @PostMapping("/add")
    public String addVehicle(@ModelAttribute Vehicle vehicle) {

        vehicleService.addVehicle(vehicle);

        return "redirect:/vehicles/get";

    }

    @GetMapping("/modify/{id}")
    public String modifyVehicle(@PathVariable long id, Model model) {

        Vehicle vehicle = vehicleService.getVehicleById(id).get();

        model.addAttribute("vehicleToModify", vehicle);

        return "modifyVehicle";

    }

    @GetMapping("/delete/{id}")
    public String removeCar(@PathVariable long id, Model model) {

        vehicleService.deleteVehicle(id);

        return "redirect:/vehicles/get";

        }

    }

