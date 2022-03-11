package com.turkcell.rentacar.business.abstracts;

import java.util.List;

import com.turkcell.rentacar.business.dtos.rental.RentalDtoById;
import com.turkcell.rentacar.business.dtos.rental.RentalListDto;
import com.turkcell.rentacar.business.requests.rental.CreateRentalRequest;
import com.turkcell.rentacar.business.requests.rental.UpdateRentalRequest;
import com.turkcell.rentacar.core.utilities.results.DataResult;
import com.turkcell.rentacar.core.utilities.results.Result;

public interface RentalService {
	DataResult<List<RentalListDto>> getAll();
	DataResult<List<RentalListDto>> getAllByCarCarId(int id);
	Result add(CreateRentalRequest createRentalRequest);
	DataResult<RentalDtoById> getById(int id);
	Result update(UpdateRentalRequest updateRentalRequest);
	Result delete(int rentalId);
}
