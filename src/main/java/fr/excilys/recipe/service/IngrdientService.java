package fr.excilys.recipe.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import fr.excilys.recipe.dto.IngredientDto;
import fr.excilys.recipe.dto.RecipeMapper;
import fr.excilys.recipe.model.Ingredient;
import fr.excilys.recipe.repository.IngredientRepository;

public class IngrdientService {
	
	private IngredientRepository ingredientRepository;
	
	@Autowired
	public IngrdientService(IngredientRepository ingredientRepository) {
		super();
		this.ingredientRepository = ingredientRepository;
	}
	public List<IngredientDto> getAll() {
		List<Ingredient> ingredients= ingredientRepository.getAllIngredients();
		
		return RecipeMapper.mapAllIngredients(ingredients);

	}
	public IngredientDto getById(long id) {
		Ingredient ingredient = ingredientRepository.getIngredientById(id);
		return RecipeMapper.mapToIngredientDto(ingredient);
	}
	@Transactional
	public void create(IngredientDto ingredientDto) {
		Ingredient ingredient=RecipeMapper.mapToIngredient(ingredientDto);
		ingredientRepository.addIngredient(ingredient);
	}
	@Transactional
	public void update(IngredientDto ingredientDto) {
		Ingredient ingredient=RecipeMapper.mapToIngredient(ingredientDto);
		ingredientRepository.updateIngredient(ingredient);
	}

	public void deleteById(long id) {
		ingredientRepository.deleteIngredient(id);
	}
}
