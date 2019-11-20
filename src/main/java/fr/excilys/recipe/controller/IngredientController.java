package fr.excilys.recipe.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fr.excilys.recipe.dto.IngredientDto;
import fr.excilys.recipe.dto.RecipeMapper;
import fr.excilys.recipe.model.Ingredient;
import fr.excilys.recipe.repository.IngredientRepository;

@RestController
@RequestMapping("/api/v1/ingredients")
public class IngredientController {
	
	@Autowired
	private IngredientRepository ingredientService;
	
	public List<Ingredient> getAll(){
		List<Ingredient> ingredients=ingredientService.getAllIngredients();
		return ingredients;
	}
	
	@GetMapping(value = "/{id}")
	public Ingredient getById(@PathVariable Long id) {
		return ingredientService.getIngredientById(id);
	}
	
	@PostMapping
	public void create(@RequestBody IngredientDto ingredient) {
		ingredientService.addIngredient(RecipeMapper.mapToIngredient(ingredient));
	}
	
	@PutMapping
	public void update(@RequestBody IngredientDto ingredient) {
		ingredientService.updateIngredient(RecipeMapper.mapToIngredient(ingredient));
	}
	
	@DeleteMapping
	public void deletById(long id) {
		ingredientService.deleteIngredient(id);
	}

}
