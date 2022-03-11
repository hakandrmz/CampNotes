package com.turkcell.rentacar.business.abstracts;

import java.util.List;

import com.turkcell.rentacar.business.dtos.additionalservice.AdditionalServiceByIdDto;
import com.turkcell.rentacar.business.dtos.additionalservice.AdditionalServiceListDto;
import com.turkcell.rentacar.business.requests.additionalservice.CreateAdditionalServiceRequest;
import com.turkcell.rentacar.business.requests.additionalservice.UpdateAdditionalServiceRequest;
import com.turkcell.rentacar.core.utilities.results.DataResult;
import com.turkcell.rentacar.core.utilities.results.Result;

public interface AdditionalServiceService {
    DataResult<List<AdditionalServiceListDto>> getAll();
    Result add(CreateAdditionalServiceRequest createAdditionalServiceRequest);
    DataResult<AdditionalServiceByIdDto> getById(int id);
    Result update(UpdateAdditionalServiceRequest updateAdditionalServiceRequest);
    Result deleteById(int additionalServicesId);
}
