package avenuecode.repository.projection;

import avenuecode.model.Product;
import org.springframework.data.rest.core.config.Projection;

/**
 * Created by fssantos on 28/11/2016.
 */
@Projection(name = "parent", types = { Product.class })
public interface ProductParentProjection {
    Long getId();
    String getDescription();
    String getName();
    Product getParentProduct();

}
