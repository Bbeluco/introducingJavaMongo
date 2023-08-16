package com.javaMongo.introducingJavaMongo.implementations;

import com.javaMongo.introducingJavaMongo.document.JobListDocument;
import com.javaMongo.introducingJavaMongo.repositories.EspecialSearchRepository;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class EspecialSearchImpl implements EspecialSearchRepository {

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter mongoConverter;

    @Override
    public List<JobListDocument> findByEspecial(String text) {
        List<JobListDocument> jobs = new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("Bbeluco");
        MongoCollection<Document> collection = database.getCollection("JobAvailables");
        AggregateIterable<Document> result = collection.aggregate(
                Arrays.asList(new Document("$search",
                                new Document("text",
                                new Document("query", text)
                                        .append("path", Arrays.asList("desc", "techs")))),
                                new Document("$sort",
                                new Document("field1", 1L)),
                                new Document("$limit", 5L)));

        result.forEach(doc -> jobs.add(mongoConverter.read(JobListDocument.class, doc)));

        return jobs;
    }
}
