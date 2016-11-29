package codeavenue;

import avenuecode.model.Image;
import avenuecode.model.Product;
import avenuecode.service.ProductService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration({"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductTest {

    private EmbeddedDatabase db;
    @Autowired
    private ProductService productService;
    @Autowired
    //private ImageService imageService;

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
        Product p = productService.getProductById(new Long(1));
        Assert.assertEquals(1, p.getId().longValue());
        Assert.assertEquals("Boxing", p.getName());
    }


    @After
    public void tearDown() {
        db.shutdown();
    }

}