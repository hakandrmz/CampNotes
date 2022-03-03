package com.turkcell.rentacar.dataAccess.abstracts;

import com.turkcell.rentacar.entities.concretes.CarMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarMaintenanceDao extends JpaRepository<CarMaintenance,Integer> {
    boolean existsCarMaintenanceById(Integer id);
    List<CarMaintenance> findMaintenanceByReturnDateIsNull();
}
