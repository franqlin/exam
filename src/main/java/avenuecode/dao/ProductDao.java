package avenuecode.dao;

import avenuecode.model.Image;
import avenuecode.model.Product;
import java.util.List;



public interface ProductDao {

	public List<Product> getAllProductIncludingRelationship();
	
}