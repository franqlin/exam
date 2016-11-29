package avenuecode.repository;


import avenuecode.repository.projection.NoParentProjection;
import avenuecode.repository.projection.ProductParentProjection;
import avenuecode.model.Image;
import avenuecode.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

//@Repository(itemResourceRel = "products",collectionResourceRel = "products", path = "products",excerptProjection = ProductParentProjection.class)
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findById(@Param("id") Long id);
    List<Product> findByName(@Param("name") String name);
    @Query("select p from Product p")
    List<Product> findAllWithRelationship();
    @Query("select p from Product p where p.parentProduct.id = :productId")
    public List<Product> findChildProductListById(@Param("productId") Long productId);
    @Query("select i from Image i where i.productId.id = :productId")
    public List<Image> getImageList(@Param("productId") Long productId);
    //No Relationship
    @Query("select p from Product p")
    public List<NoParentProjection> getAllProductExcludingRelationship();
    @Query("select p from Product p where p.id= :productId")
    public NoParentProjection getProductExcludingRelationship(@Param("productId") Long productId);


}
