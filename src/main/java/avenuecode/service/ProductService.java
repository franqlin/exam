package avenuecode.service;
import avenuecode.model.Image;
import avenuecode.model.Product;
import java.util.List;

import org.springframework.stereotype.Service;



@Service
public interface ProductService {

	public List<Product> getAllProductIncludingRelationship();
	public List<Object> getAllProductExcludingRelationship();
    public Product getProductById(Integer  productId);
    public List<Product> getChildProductList(Integer  productId);
    public List<Image> getImageList(Integer  productId);
    public Object getProductExcludingRelationshipId(int productId);
    public void insert();
}
