package com.turkcell.rentacar.api.controllers;


import com.turkcell.rentacar.business.abstracts.CarMaintenanceService;
import com.turkcell.rentacar.business.dtos.CarMaintenanceListDto;
import com.turkcell.rentacar.business.dtos.GetCarMaintenanceDto;
import com.turkcell.rentacar.business.requests.CreateCarMaintenanceRequest;
import com.turkcell.rentacar.business.requests.DeleteCarMaintenanceRequest;
import com.turkcell.rentacar.business.requests.UpdateCarMaintenanceRequest;
import com.turkcell.rentacar.core.utilities.results.DataResult;
import com.turkcell.rentacar.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/carMaintenances")
public class CarMaintenanceController {
    private CarMaintenanceService carMaintenanceService;

    public CarMaintenanceController(CarMaintenanceService carMaintenanceService) {
        this.carMaintenanceService = carMaintenanceService;
    }

    @GetMapping("/getall")
    public DataResult<List<CarMaintenanceListDto>> getAll() {
        return this.carMaintenanceService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateCarMaintenanceRequest createCarMaintenanceRequest) {
        return this.carMaintenanceService.add(createCarMaintenanceRequest);
    }

    @GetMapping("/{carMaintenanceId}")
    public DataResult<GetCarMaintenanceDto> getByCarId(@PathVariable("carMaintenanceId") Integer id) {
        return this.carMaintenanceService.getById(id);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody @Valid DeleteCarMaintenanceRequest deleteCarMaintenanceRequest) {
        return this.carMaintenanceService.delete(deleteCarMaintenanceRequest);

    }
    @PutMapping("/update")
    public Result update(@RequestBody @Valid UpdateCarMaintenanceRequest updateCarMaintenanceRequest) {
        return this.carMaintenanceService.update(updateCarMaintenanceRequest);
    }

   @GetMapping("/getalllistedCar")
    public DataResult<List<CarMaintenanceListDto>> getAllActiveCars() {
        return this.carMaintenanceService.getListedCars();
    }
}

