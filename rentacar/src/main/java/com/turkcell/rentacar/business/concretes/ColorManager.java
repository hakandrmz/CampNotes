package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.ColorService;
import com.turkcell.rentacar.business.dtos.CarGetDto;
import com.turkcell.rentacar.business.dtos.ColorListDto;
import com.turkcell.rentacar.business.dtos.GetColorDto;
import com.turkcell.rentacar.business.requests.CreateColorRequest;
import com.turkcell.rentacar.business.requests.DeleteColorRequest;
import com.turkcell.rentacar.business.requests.UpdateColorRequest;
import com.turkcell.rentacar.core.exceptions.BrandNotFoundException;
import com.turkcell.rentacar.core.exceptions.ColorAlreadyExistException;
import com.turkcell.rentacar.core.exceptions.ColorNotfoundException;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.core.utilities.results.*;
import com.turkcell.rentacar.dataAccess.abstracts.ColorDao;
import com.turkcell.rentacar.entities.concretes.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ColorManager implements ColorService {

    private ColorDao colorDao;
    private ModelMapperService modelMapperService;

    @Autowired
    public ColorManager(ColorDao colorDao,ModelMapperService modelMapperService) {
        this.colorDao = colorDao;
        this.modelMapperService=modelMapperService;
    }

    @Override
    public DataResult<List<ColorListDto>> getAll() {
        List<Color> result = this.colorDao.findAll();

        List<ColorListDto> response = result.stream()
                .map(product -> this.modelMapperService
                        .forDto()
                        .map(product,ColorListDto.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<>(response);
    }

    @Override
    public Result add(CreateColorRequest createColorRequest) {
        if(this.colorDao.existsColorByName(createColorRequest.getName())) {
            return new ErrorResult("Aynı isimde renk kayıtlı");
        }else {
            Color color = this.modelMapperService
                    .forRequest().map(createColorRequest,Color.class);
            this.colorDao.save(color);
            return new SuccessResult("Renk kaydedildi");
        }
    }

    @Override
    public DataResult<GetColorDto> getById(Integer id){
        if(this.colorDao.existsById(id)) {
            Color foundColor = colorDao.getById(id);
            GetColorDto response = this.modelMapperService.forDto().map(foundColor, GetColorDto.class);
            return new SuccessDataResult<>(response);
        }else {
            return new ErrorDataResult<>("Bu id'de renk bulunamadı");
        }
    }

    @Override
    public Result update(UpdateColorRequest updateColorRequest) {
        if (this.colorDao.existsById(updateColorRequest.getId())) {
            Color color = this.modelMapperService.forRequest().map(updateColorRequest, Color.class);
            colorDao.save(color);
            return new SuccessResult("Renk güncellendi");
        }else {
            return new ErrorResult("Renk bulunamadı");
        }
    }

    @Override
    public Result delete(DeleteColorRequest deleteColorRequest) {
        if (this.colorDao.existsById(deleteColorRequest.getId())) {
            colorDao.deleteById(deleteColorRequest.getId());
            return new SuccessResult("Renk silindi");
        }else {
            return new ErrorResult("Renk bulunamadı");
        }
    }
}
