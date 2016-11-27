
package avenuecode.service.impl;

import avenuecode.dao.ProductDao;
import avenuecode.model.Image;
import avenuecode.model.Product;
import avenuecode.service.ProductService;

import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
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

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

  @Override
  public List<Product> getAllProductIncludingRelationship() {
    return em.createQuery("select p from Product p", Product.class).getResultList();
  }
    @Override
   public List<Object> getAllProductExcludingRelationship() {
        return em.createQuery("select p.id,p.description,p.name from Product p").getResultList();
   }
    @Override
    public Product getProductById(Integer  productId) {
        return em.find(Product.class,productId);
    }
    @Override
    public List<Product> getChildProductList(Integer  productId){
        return em.createQuery("select p from Product p where p.parentProduct.id = :productId", Product.class).setParameter("productId", productId).getResultList();
    }
    @Override
    public List<Image> getImageList(Integer  productId){
        return em.createQuery("select i from Image i where i.productId.id = :productId", Image.class).setParameter("productId", productId).getResultList();
    }
    @Override
    public Object getProductExcludingRelationshipId(int productId){
        return em.createQuery("select p.id,p.description,p.name from Product p where p.id= :productId").setParameter("productId", productId).getSingleResult();
    }
    @Override
    public void insert(){
        Product p = new Product();
        p.setName("Teste");
        em.persist(p);
    }

}
