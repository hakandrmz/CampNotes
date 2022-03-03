package com.turkcell.rentacar.business.concretes;


import com.turkcell.rentacar.business.abstracts.CarMaintenanceService;
import com.turkcell.rentacar.business.dtos.CarMaintenanceListDto;
import com.turkcell.rentacar.business.dtos.GetCarMaintenanceDto;
import com.turkcell.rentacar.business.requests.CreateCarMaintenanceRequest;
import com.turkcell.rentacar.business.requests.DeleteCarMaintenanceRequest;
import com.turkcell.rentacar.business.requests.UpdateCarMaintenanceRequest;
import com.turkcell.rentacar.core.exceptions.CarNotFoundException;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.core.utilities.results.*;
import com.turkcell.rentacar.dataAccess.abstracts.CarMaintenanceDao;
import com.turkcell.rentacar.entities.concretes.CarMaintenance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarMaintenanceManager implements CarMaintenanceService {

    private CarMaintenanceDao carMaintenanceDao;
    private ModelMapperService modelMapperService;

    @Autowired
    public CarMaintenanceManager(CarMaintenanceDao carMaintenanceDao, ModelMapperService modelMapperService) {
        this.carMaintenanceDao = carMaintenanceDao;
        this.modelMapperService = modelMapperService;
    }


    @Override
    public DataResult<List<CarMaintenanceListDto>> getAll() {
        List<CarMaintenance> result = this.carMaintenanceDao.findAll();
        List<CarMaintenanceListDto> response = result.stream()
                .map(carMaintenance -> this.modelMapperService
                        .forDto()
                        .map(carMaintenance, CarMaintenanceListDto.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<List<CarMaintenanceListDto>>(response, "Veriler listelendi");
    }

    @Override
    public Result add(CreateCarMaintenanceRequest createCarMaintenanceRequest) {
        CarMaintenance carMaintenance = this.modelMapperService.forRequest().map(createCarMaintenanceRequest, CarMaintenance.class);
        this.carMaintenanceDao.save(carMaintenance);
        return new SuccessResult("Bakım eklendi");
    }

    @Override
    public DataResult<GetCarMaintenanceDto> getById(Integer id) {
        if (carMaintenanceDao.existsCarMaintenanceById(id)) {
            CarMaintenance carMaintenance = carMaintenanceDao.getById(id); //Optional<Car> car = carDao.findById(id);
            GetCarMaintenanceDto response = modelMapperService.forDto().map(carMaintenance, GetCarMaintenanceDto.class);
            return new SuccessDataResult<GetCarMaintenanceDto>(response, "Id'ye göre listelendi");
        } else {
            throw new CarNotFoundException("Bu Id'de bakım bulunamadı");
        }
    }

    @Override
    public Result update(UpdateCarMaintenanceRequest updateCarMaintenanceRequest) {
        if (carMaintenanceDao.existsCarMaintenanceById(updateCarMaintenanceRequest.getId())) {
            CarMaintenance carMaintenance = this.modelMapperService.forRequest().map(updateCarMaintenanceRequest, CarMaintenance.class);
            this.carMaintenanceDao.save(carMaintenance);
            return new SuccessResult("Bakım güncellendi");
        } else {
            throw new CarNotFoundException("Bakım bulunamadı");
        }
    }

    @Override
    public Result delete(DeleteCarMaintenanceRequest deleteCarMaintenanceRequest) {
        if (this.carMaintenanceDao.existsCarMaintenanceById(deleteCarMaintenanceRequest.getId())) {
            this.carMaintenanceDao.deleteById(deleteCarMaintenanceRequest.getId());
            return new SuccessResult("Bakım güncellendi");
        } else {
            return new ErrorResult("Bakım bulunamadı");
        }
    }

    @Override
    public DataResult<List<CarMaintenanceListDto>> getListedCars() {
        List<CarMaintenance> result = this.carMaintenanceDao.findMaintenanceByReturnDateIsNull();
        List<CarMaintenanceListDto> response = result.stream()
                .map(carMaintenance -> this.modelMapperService
                        .forDto()
                        .map(carMaintenance, CarMaintenanceListDto.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<List<CarMaintenanceListDto>>(response, "Veriler listelendi");
    }
}

