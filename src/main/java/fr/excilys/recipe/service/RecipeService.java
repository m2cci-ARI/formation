package fr.excilys.recipe.service;
import static fr.excilys.recipe.dto.RecipeMapper.mapAllReciepes;

import java.util.List;
import  fr.excilys.recipe.dto.RecipeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.excilys.recipe.dto.RecipeDto;
import fr.excilys.recipe.model.Recipe;
import fr.excilys.recipe.repository.RecipeRepository;

@Service
public class RecipeService {
	
	private RecipeRepository recipeRepository;
	@Autowired
	public RecipeService(RecipeRepository recipeRepository) {
		super();
		this.recipeRepository = recipeRepository;
	}

	public List<RecipeDto> getAll() {
		List<Recipe> recipes=recipeRepository.getAllRecipes();
		return mapAllReciepes(recipes);

	}

	public RecipeDto getById(long id) {
		Recipe recipe=recipeRepository.getRecipeById(id);
		return RecipeMapper.mapToRecipeDto(recipe);
	}

	public void create(RecipeDto recipeDto) {
		Recipe recipe= RecipeMapper.mapToRecipe(recipeDto);
		recipeRepository.addRecipe(recipe);

	}

	public void update(RecipeDto recipeDto) {
		Recipe recipe= RecipeMapper.mapToRecipe(recipeDto);
		recipeRepository.updateRecipe(recipe);
	}

	public void deleteall() {
		recipeRepository.deletAll();
	}

	public void deleteRecipe(Long id) {
		recipeRepository.delete(id);
		
	}

}
