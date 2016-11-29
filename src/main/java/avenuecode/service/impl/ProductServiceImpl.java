
package avenuecode.service.impl;

import avenuecode.model.Image;
import avenuecode.model.Product;
import avenuecode.repository.ProductRepository;
import avenuecode.repository.projection.NoParentProjection;
import avenuecode.service.ProductService;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;



@Component("productService")
@Transactional
public class ProductServiceImpl implements ProductService {
	 @PersistenceContext 
     private EntityManager em;
    @Resource(name= "productRepository")
    private ProductRepository productRepository;



  @Override
  public List<Product> getAllProductIncludingRelationship() {
    return productRepository.findAllWithRelationship();
  }
    @Override
   public List<NoParentProjection> getAllProductExcludingRelationship() {
        return productRepository.getAllProductExcludingRelationship();
   }
    @Override
    public Product getProductById(Long  productId) {
        return productRepository.findById(productId);
    }
    @Override
    public List<Product> getChildProductList(Long  productId){
        return productRepository.findChildProductListById(productId);
    }
    @Override
    public List<Image> getImageList(Long  productId){
        return productRepository.getImageList(productId);
    }
    @Override
    public NoParentProjection getProductExcludingRelationshipId(Long productId){
        return productRepository.getProductExcludingRelationship(productId);
    }
    @Override
    public List<NoParentProjection>  teste(){
     return productRepository.getAllProductExcludingRelationship();
    }

}
