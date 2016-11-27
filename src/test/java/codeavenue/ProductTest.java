package codeavenue;

import avenuecode.model.Image;
import avenuecode.model.Product;
import avenuecode.service.ProductService;
import avenuecode.service.impl.ProductServiceImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;


import javax.persistence.PersistenceContext;
import java.util.List;

@ContextConfiguration({"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductTest {

    private EmbeddedDatabase db;
    @Autowired
    private ProductService service;
    @Before
    public void setUp() {
      db = new EmbeddedDatabaseBuilder()
    		.setType(EmbeddedDatabaseType.DERBY)
    		//addScript("db/sql/schema.sql")
    		.addScript("db/sql/insert.sql")
    		.build();
    }

    @Test
    public void testFindProductById() {
        Product p = service.getProductById(1);
        Assert.assertEquals(1, p.getId().intValue());
        Assert.assertEquals("Boxing", p.getName());
    }

    @After
    public void tearDown() {
        db.shutdown();
    }

}