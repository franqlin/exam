package avenuecode.service;
import avenuecode.model.Image;
import avenuecode.model.Product;
import java.util.List;

import avenuecode.repository.projection.NoParentProjection;
import org.springframework.stereotype.Service;



@Service
public interface ProductService {

	public List<Product> getAllProductIncludingRelationship();
	public List<NoParentProjection> getAllProductExcludingRelationship();
    public Product getProductById(Long  productId);
    public List<Product> getChildProductList(Long  productId);
    public List<Image> getImageList(Long  productId);
    public NoParentProjection getProductExcludingRelationshipId(Long productId);
    public List<NoParentProjection> teste();
}
