package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.ColorService;
import com.turkcell.rentacar.business.dtos.ColorListDto;
import com.turkcell.rentacar.business.dtos.GetColorDto;
import com.turkcell.rentacar.business.requests.*;
import com.turkcell.rentacar.core.utilities.results.DataResult;
import com.turkcell.rentacar.core.utilities.results.Result;
import lombok.Data;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/colors")
public class ColorsController {

    private ColorService colorService;

    public ColorsController(ColorService colorService) {
        this.colorService = colorService;
    }

    @GetMapping("/getAll")
    public DataResult<List<ColorListDto>> getAll() {
        return colorService.getAll();
    }

    @PostMapping("/add")
    public Result save(@RequestBody CreateColorRequest createColorRequest) {
        return colorService.add(createColorRequest);
    }

    @GetMapping("/getById/{id}")
    public DataResult<GetColorDto> getColorById(@PathVariable Integer id) {
        return colorService.getById(id);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateColorRequest updateColorRequest) {
        return this.colorService.update(updateColorRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody DeleteColorRequest deleteColorRequest) {
        return this.colorService.delete(deleteColorRequest);
    }
}
