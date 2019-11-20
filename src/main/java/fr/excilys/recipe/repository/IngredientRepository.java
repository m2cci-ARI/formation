package fr.excilys.recipe.repository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import fr.excilys.recipe.model.Ingredient;
import fr.excilys.recipe.model.Recipe;

@Repository
public class IngredientRepository {
	@PersistenceContext
	private EntityManager entityManger;
	
	public IngredientRepository(EntityManager entityManger) {
		super();
		this.entityManger = entityManger;
	}

	public List<Ingredient> getAllIngredients() {
		Session session = entityManger.unwrap(Session.class);
		Query query = session.createQuery("from Ingredient", Recipe.class);
		return query.getResultList();
	}

	public Ingredient getIngredientById(long id) {
		Session session = entityManger.unwrap(Session.class);
		Ingredient ingredient = session.get(Ingredient.class, id);
		return ingredient;
	}
	
	public void addIngredient(Ingredient ingredient) {
		Session session = entityManger.unwrap(Session.class);
		session.saveOrUpdate(ingredient);
	}
	
	public void updateIngredient(Ingredient ingredient) {
			Session session = entityManger.unwrap(Session.class);
			session.merge(ingredient);
	
	}
	
	public void deleteIngredient(long id) {
		Session session = entityManger.unwrap(Session.class);
		Ingredient ingredient = getIngredientById(id);
		session.delete(ingredient);
	}
	
	

}
