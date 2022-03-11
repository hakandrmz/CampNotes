package com.turkcell.rentacar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turkcell.rentacar.business.abstracts.AdditionalServiceService;
import com.turkcell.rentacar.business.dtos.additionalservice.AdditionalServiceByIdDto;
import com.turkcell.rentacar.business.dtos.additionalservice.AdditionalServiceListDto;
import com.turkcell.rentacar.business.requests.additionalservice.CreateAdditionalServiceRequest;
import com.turkcell.rentacar.business.requests.additionalservice.UpdateAdditionalServiceRequest;
import com.turkcell.rentacar.core.exceptions.BusinessException;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.core.utilities.results.DataResult;
import com.turkcell.rentacar.core.utilities.results.Result;
import com.turkcell.rentacar.core.utilities.results.SuccessDataResult;
import com.turkcell.rentacar.core.utilities.results.SuccessResult;
import com.turkcell.rentacar.dataAccess.abstracts.AdditionalServiceDao;
import com.turkcell.rentacar.entities.concretes.AdditionalService;


@Service
public class AdditionalServiceManager implements AdditionalServiceService {

    private AdditionalServiceDao additionalServiceDao;
    private ModelMapperService modelMapperService;

    @Autowired
    public AdditionalServiceManager(AdditionalServiceDao additionalServiceDao, ModelMapperService modelMapperService) {
        this.additionalServiceDao = additionalServiceDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<List<AdditionalServiceListDto>> getAll() {
        List<AdditionalService> result = this.additionalServiceDao.findAll();
        List<AdditionalServiceListDto> response = result.stream()
                .map(additionalService -> this.modelMapperService.forDto().map(additionalService, AdditionalServiceListDto.class))
                .collect(Collectors.toList());

        return new SuccessDataResult(response, "Additional Services are listed successfully.");
    }

    @Override
    public Result add(CreateAdditionalServiceRequest createAdditionalServiceRequest) throws BusinessException {
        AdditionalService additionalService = this.modelMapperService.forRequest().map(createAdditionalServiceRequest, AdditionalService.class);
        checkIfAdditionalServiceNameIsExists(createAdditionalServiceRequest.getAdditionalServiceName());
        this.additionalServiceDao.save(additionalService);
        return new SuccessResult("Additional Service is added.");

    }

    @Override
    public DataResult<AdditionalServiceByIdDto> getById(int id) throws BusinessException {

        checkIfAdditionalServiceExists(id);
        AdditionalService additionalService = this.additionalServiceDao.getById(id);

        AdditionalServiceByIdDto response = this.modelMapperService.forDto().map(additionalService, AdditionalServiceByIdDto.class);
        return new SuccessDataResult(response, "Additional Service is found by id: " + id);
    }

    @Override
    public Result update(UpdateAdditionalServiceRequest updateAdditionalServiceRequest) throws BusinessException {
        checkIfAdditionalServiceExists(updateAdditionalServiceRequest.getAdditionalServiceId());
        AdditionalService additionalService = this.modelMapperService.forRequest().map(updateAdditionalServiceRequest, AdditionalService.class);
        checkIfAdditionalServiceNameIsExists(updateAdditionalServiceRequest.getAdditionalServiceName());
        this.additionalServiceDao.save(additionalService);
        return new SuccessResult("Additional Service is updated");
    }

    @Override
    public Result deleteById(int additionalServiceId) throws BusinessException {
        checkIfAdditionalServiceExists(additionalServiceId);
        this.additionalServiceDao.deleteById(additionalServiceId);
        return new SuccessResult("Additional Service is deleted successfully.");
    }


    private void checkIfAdditionalServiceNameIsExists(String additionalServiceName) throws BusinessException {
        for (AdditionalServiceListDto additionalServiceElement : this.getAll().getData()) {
            if (additionalServiceElement.getAdditionalServiceName().equalsIgnoreCase(additionalServiceName)) {
                throw new BusinessException("There can not be more than one AdditionalService with the same name.");
            }
        }
    }

    private boolean checkIfAdditionalServiceExists(int id) throws BusinessException {
        if (additionalServiceDao.existsById(id) == false) {
            throw new BusinessException("Additional service does not exist by id:" + id);
        }
        return true;
    }

}
