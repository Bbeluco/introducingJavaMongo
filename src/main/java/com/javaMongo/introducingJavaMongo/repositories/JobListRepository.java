package com.javaMongo.introducingJavaMongo.repositories;

import com.javaMongo.introducingJavaMongo.document.JobListDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobListRepository extends MongoRepository<JobListDocument, String> {
}
