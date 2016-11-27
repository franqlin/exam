package avenuecode.dao.impl;

import avenuecode.dao.ProductDao;
import avenuecode.model.Image;
import avenuecode.model.Product;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository("productDao")

public class ProductDaoImpl implements ProductDao {
	     //@Autowired(required = true)
        // private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
        @Override
	public List<Product> getAllProductIncludingRelationship() {
		//Session session = sessionFactory.getCurrentSession();
		//List<Product> result = session.createCriteria(Product.class).list();
		return null;
	}
}
