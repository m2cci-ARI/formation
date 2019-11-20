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
import fr.excilys.recipe.dto.RecipeDto;
import fr.excilys.recipe.service.RecipeService;

@RestController
@RequestMapping("/api/v1/recipes")
public class RecipeController {
	@Autowired
	private RecipeService recipeService;
	
	
	@GetMapping
	public List<RecipeDto> getAll(){
		List<RecipeDto> recipes=recipeService.getAll();
		return recipes;
	}
	
	@GetMapping(value = "/{id}")
	public RecipeDto getById(@PathVariable Long id) {
		return recipeService.getById(id);
	}
	
	@PostMapping
	public void create(@RequestBody RecipeDto recipeDto) {
		
		recipeService.create(recipeDto);
	}
	
	@PutMapping
	public void update(@RequestBody RecipeDto recipeDto) {
		recipeService.update(recipeDto);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		recipeService.deleteRecipe(id);
	}
	@DeleteMapping
	public void deleteall() {
		recipeService.deleteall();
	}

}
