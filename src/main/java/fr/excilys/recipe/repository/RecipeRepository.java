package fr.excilys.recipe.repository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import fr.excilys.recipe.model.Recipe;
@Repository
public class RecipeRepository {
	
	@PersistenceContext
	private EntityManager entityManger;
	public RecipeRepository(EntityManager entityManger) {
		super();
		this.entityManger = entityManger;
	}
	public List<Recipe> getAllRecipes() {
		Session session = entityManger.unwrap(Session.class);
		Query query = session.createQuery("from Recipe", Recipe.class);
		return query.getResultList();
	}

	public Recipe getRecipeById(long id) {
		Session session = entityManger.unwrap(Session.class);
		Recipe recipe = session.get(Recipe.class, id);
		return recipe;
	}

	public void addRecipe(Recipe recipe) {
		Session session = entityManger.unwrap(Session.class);
		session.save(recipe);
	}
	public void updateRecipe(Recipe recipe) {
		Session session = entityManger.unwrap(Session.class);
		Transaction transaction = session.beginTransaction();
		session.update(recipe);
		transaction.commit();
	}
	public void deletAll() {
		Session session = entityManger.unwrap(Session.class);
		Query query = session.createQuery("delete Recipe", Recipe.class);
	}
	public void delete(Long id) {
		Session session = entityManger.unwrap(Session.class);
		Recipe recipe = getRecipeById(id);
		session.delete(recipe);
	}
}
