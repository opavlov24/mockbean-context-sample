package tech.letscode.mockbean;

import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.GetQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.stereotype.Repository;

/**
 * @author Oleg Pavlov <oleg.pavlov@aol.com>
 */
@Repository
public class ElasticsearchRepository {

    private final ElasticsearchTemplate elasticsearchTemplate;

    public ElasticsearchRepository(ElasticsearchTemplate elasticsearchTemplate) {
        this.elasticsearchTemplate = elasticsearchTemplate;
    }

    public void save(SomeClass someClass) {
        this.elasticsearchTemplate.index(new IndexQueryBuilder().withObject(someClass).build());
    }

    public SomeClass findById(String id) {
        GetQuery query = new GetQuery();
        query.setId(id);
        return this.elasticsearchTemplate.queryForObject(query, SomeClass.class);
    }
}
