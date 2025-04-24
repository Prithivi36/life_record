package com.life.life_record.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Prescription {
    private String name;
    private String dosage;
    private String daily;
    private String duration;
    private String instructions;
}
