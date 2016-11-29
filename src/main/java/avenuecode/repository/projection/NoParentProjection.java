package avenuecode.repository.projection;

import avenuecode.model.Product;
import org.springframework.data.rest.core.config.Projection;

/**
 * Created by fssantos on 28/11/2016.
 */
@Projection(name = "noParent", types = { Product.class })
public interface NoParentProjection {
    String getDescription();
    String getName();

}
