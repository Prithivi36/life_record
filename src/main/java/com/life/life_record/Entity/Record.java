package com.life.life_record.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "life_record")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Record {
    @Id
    private String _id;
    private String title;
    private boolean followUp;
    private String followUpDate;
    private Doctor doctor;
    private String hospital;
    private List<String> symptoms;
    private List<Prescription> prescriptions;
    private String doctorNotes;
}
