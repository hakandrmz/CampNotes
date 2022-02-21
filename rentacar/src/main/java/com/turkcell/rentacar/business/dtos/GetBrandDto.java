package com.turkcell.rentacar.business.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GetBrandDto {
    private int id;
    private String name;
}
