package com.javaMongo.introducingJavaMongo.repositories;

import com.javaMongo.introducingJavaMongo.document.JobListDocument;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EspecialSearchRepository {

    List<JobListDocument> findByEspecial(String text);
}
