package com.turkcell.rentacar.business.abstracts;

import java.util.List;

import com.turkcell.rentacar.business.dtos.carmaintenance.CarMaintenanceByIdDto;
import com.turkcell.rentacar.business.dtos.carmaintenance.CarMaintenanceListDto;
import com.turkcell.rentacar.business.requests.carmaintenance.CreateCarMaintenanceRequest;
import com.turkcell.rentacar.business.requests.carmaintenance.UpdateCarMaintenanceRequest;

import com.turkcell.rentacar.core.utilities.results.DataResult;
import com.turkcell.rentacar.core.utilities.results.Result;

public interface CarMaintenanceService {
	DataResult<List<CarMaintenanceListDto>> getAll();
    Result add(CreateCarMaintenanceRequest createCarMaintenanceRequest);
    Result update(UpdateCarMaintenanceRequest updateCarMaintenanceRequest);
    DataResult<CarMaintenanceByIdDto> getById(int carMaintenanceId);
    Result deleteById(int id);
	DataResult<List<CarMaintenanceListDto>> getByCarId(int carId);
}
