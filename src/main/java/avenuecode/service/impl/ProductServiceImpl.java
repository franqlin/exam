
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
     NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Resource(name= "productRepository")
    private ProductRepository productRepository;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

  @Override
  public List<Product> getAllProductIncludingRelationship() {
    //return em.createQuery("select p from Product p", Product.class).getResultList();
    return productRepository.findAllWithRelationship();
  }
    @Override
   public List<NoParentProjection> getAllProductExcludingRelationship() {
        //return em.createQuery("select p.id,p.description,p.name from Product p").getResultList();
        return productRepository.getAllProductExcludingRelationship();
   }
    @Override
    public Product getProductById(Long  productId) {
        //return em.find(Product.class,productId);
        return productRepository.findById(productId);
    }
    @Override
    public List<Product> getChildProductList(Long  productId){
        return productRepository.findChildProductListById(productId);
        //return em.createQuery("select p from Product p where p.parentProduct.id = :productId", Product.class).setParameter("productId", productId).getResultList();
    }
    @Override
    public List<Image> getImageList(Long  productId){
        return productRepository.getImageList(productId);
        //return em.createQuery("select i from Image i where i.productId.id = :productId", Image.class).setParameter("productId", productId).getResultList();
    }
    @Override
    public NoParentProjection getProductExcludingRelationshipId(Long productId){
        //return em.createQuery("select p.id,p.description,p.name from Product p where p.id= :productId").setParameter("productId", productId).getSingleResult();
        return productRepository.getProductExcludingRelationship(productId);
    }
    @Override
    public List<NoParentProjection>  teste(){

        return productRepository.getAllProductExcludingRelationship();
    }

}
