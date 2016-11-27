/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avenuecode.controller;


import avenuecode.model.Image;
import avenuecode.model.Product;
import avenuecode.service.ProductService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * @author franqlin
 */
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     *
     a)Get all products excluding relationships (child products, images
     b)Get all products including specified relationships (child product and/or images
     c)Same as 1 using specific product identity
     d)Same as 2 using specific product identity
     e)Get set of child products for specific product
     f)Get set of images for specific product
     * @return
     */

    /**
     * a)Get all products excluding relationships (child products, images)
     */
    @RequestMapping(method = RequestMethod.GET, value = "/allProductsExcludingRelationships", produces = {"application/json"})
    Collection<Object> getAllProductsExcludingRelationships() {
        Collection<Object> products = productService.getAllProductExcludingRelationship();
        return products;
    }

    /**
     * b)Get all products including specified relationships
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/allProductsSpecifiedRelationships", produces = {"application/json"})
    Collection<Product> getAllProductsSpecifiedRelationships() {
        Collection<Product> products = productService.getAllProductIncludingRelationship();
        return products;
    }
    /**
     *  Same as 1 using specific product identity
     */

    @RequestMapping(method = RequestMethod.GET, value = "/productSpecifiedRelationships/{id}", produces = {"application/json"})
   Product getProductByIdSpecifiedRelationships(@PathVariable("id") Integer  id) {
        return productService.getProductById(id);
    }
    /**
     * d)Same as 2 using specific product identity
     */
    @RequestMapping(method = RequestMethod.GET, value = "/produtExcludingRelationships/{id}", produces = {"application/json"})
    Object getProductByIdExcludingRelationships(@PathVariable("id") Integer  id) {
        return productService.getProductExcludingRelationshipId(id);
    }
    /**
     *Get set of child products for specific product
     */
    @RequestMapping(method = RequestMethod.GET, value = "/childProductList/{id}", produces = {"application/json"})
    Collection<Product> getChildProductList(@PathVariable("id") Integer  id) {
        return productService.getChildProductList(id);
    }

    /**
     * Get set of images for specific product
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/imageList/{id}", produces = {"application/json"})
    Collection<Image> getImageList(@PathVariable("id") Integer  id) {
        return productService.getImageList(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/save")
    void save() {
        productService.insert();
    }

}
