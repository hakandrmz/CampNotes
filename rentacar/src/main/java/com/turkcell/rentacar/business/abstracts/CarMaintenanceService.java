package com.turkcell.rentacar.business.abstracts;


import com.turkcell.rentacar.business.dtos.CarMaintenanceListDto;
import com.turkcell.rentacar.business.dtos.GetCarMaintenanceDto;
import com.turkcell.rentacar.business.requests.CreateCarMaintenanceRequest;
import com.turkcell.rentacar.business.requests.DeleteCarMaintenanceRequest;
import com.turkcell.rentacar.business.requests.UpdateCarMaintenanceRequest;
import com.turkcell.rentacar.core.utilities.results.DataResult;
import com.turkcell.rentacar.core.utilities.results.Result;

import java.util.List;

public interface CarMaintenanceService {
    DataResult<List<CarMaintenanceListDto>> getAll();
    Result add(CreateCarMaintenanceRequest createCarMaintenanceRequest);
    DataResult<GetCarMaintenanceDto> getById(Integer id);
    Result update(UpdateCarMaintenanceRequest updateCarMaintenanceRequest);
    Result delete(DeleteCarMaintenanceRequest deleteCarMaintenanceRequest);
    DataResult<List<CarMaintenanceListDto>> getListedCars();
}

