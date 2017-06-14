package tech.letscode.mockbean;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Oleg Pavlov <oleg.pavlov@aol.com>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SecondElasticsearchRepositoryTest {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private ElasticsearchRepository elasticsearchRepository;

    @MockBean
    private DummyServiceToMock dummyServiceToMock;

    @Test
    public void tryToGetSomeObject() {
        SomeClass someObject = new SomeClass();
        saveObject(someObject);
        Assert.assertNotNull(this.elasticsearchRepository.findById(someObject.getId()));
    }

    private void saveObject(SomeClass someObject)
    {
        IndexQuery index = new IndexQueryBuilder().withObject(someObject).build();
        this.elasticsearchTemplate.index(index);
    }
}
