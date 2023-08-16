package com.javaMongo.introducingJavaMongo.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("JobAvailables")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class JobListDocument {
    @Id
    private String id;
    private String desc;
    private int exp;
    private String profile;
    private String[] techs;

    public JobListDocument(String desc, int exp, String profile, String[] techs) {
        this.desc = desc;
        this.exp = exp;
        this.profile = profile;
        this.techs = techs;
    }
}
