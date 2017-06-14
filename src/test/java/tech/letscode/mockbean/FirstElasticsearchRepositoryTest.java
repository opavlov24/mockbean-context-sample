package tech.letscode.mockbean;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.GetQuery;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Oleg Pavlov <oleg.pavlov@aol.com>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FirstElasticsearchRepositoryTest {

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private ElasticsearchRepository elasticsearchRepository;

    @Test
    public void trySaveSomeObject() {
        SomeClass someObject = new SomeClass();
        this.elasticsearchRepository.save(someObject);
        Assert.assertNotNull(findById(someObject.getId()));
    }

    private SomeClass findById(String id)
    {
        GetQuery getQuery = new GetQuery();
        getQuery.setId(id);
        return this.elasticsearchTemplate.queryForObject(getQuery, SomeClass.class);
    }
}