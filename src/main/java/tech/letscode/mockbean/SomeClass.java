package tech.letscode.mockbean;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.UUID;

/**
 * @author Oleg Pavlov <oleg.pavlov@aol.com>
 */
@Document(indexName = "someclassed", type = "someclass")
class SomeClass {

    @Id
    private String id;

    SomeClass() {
        this.id = UUID.randomUUID().toString();
    }

    String getId() {
        return id;
    }
}
