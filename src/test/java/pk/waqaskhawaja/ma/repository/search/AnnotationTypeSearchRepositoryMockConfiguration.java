package pk.waqaskhawaja.ma.repository.search;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;

/**
 * Configure a Mock version of {@link AnnotationTypeSearchRepository} to test the
 * application without starting Elasticsearch.
 */
@Configuration
public class AnnotationTypeSearchRepositoryMockConfiguration {

    @MockBean
    private AnnotationTypeSearchRepository mockAnnotationTypeSearchRepository;

}
