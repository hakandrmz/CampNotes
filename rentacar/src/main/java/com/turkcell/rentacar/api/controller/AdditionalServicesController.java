package com.turkcell.rentacar.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.turkcell.rentacar.business.abstracts.AdditionalServiceService;
import com.turkcell.rentacar.business.dtos.additionalservice.AdditionalServiceByIdDto;
import com.turkcell.rentacar.business.dtos.additionalservice.AdditionalServiceListDto;
import com.turkcell.rentacar.business.requests.additionalservice.CreateAdditionalServiceRequest;

import com.turkcell.rentacar.business.requests.additionalservice.UpdateAdditionalServiceRequest;
import com.turkcell.rentacar.core.exceptions.BusinessException;
import com.turkcell.rentacar.core.utilities.results.DataResult;
import com.turkcell.rentacar.core.utilities.results.Result;

@RestController
@RequestMapping("/api/additional-services")
public class AdditionalServicesController {
    private AdditionalServiceService additionalServiceService;

    @Autowired
    public AdditionalServicesController(AdditionalServiceService additionalServiceService) {
        this.additionalServiceService = additionalServiceService;
    }

    @GetMapping("/getall")
    public DataResult<List<AdditionalServiceListDto>> getAll() {
        return this.additionalServiceService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateAdditionalServiceRequest createAdditionalServiceRequest) {
        return this.additionalServiceService.add(createAdditionalServiceRequest);
    }

    @GetMapping("/getById")
    public DataResult<AdditionalServiceByIdDto> getById(int id) {
        return this.additionalServiceService.getById(id);
    }

    @PutMapping("/update")
    public Result update(@RequestBody @Valid UpdateAdditionalServiceRequest updateAdditionalServiceRequest) {
        return this.additionalServiceService.update(updateAdditionalServiceRequest);
    }

    @DeleteMapping("/delete")
    public Result deleteById(@RequestParam int additionalServiceId) {
        return this.additionalServiceService.deleteById(additionalServiceId);
    }

}
