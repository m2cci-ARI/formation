package fr.excilys.recipe.dto;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import fr.excilys.recipe.model.Ingredient;
import fr.excilys.recipe.model.Recipe;
public class RecipeMapper {
	
	private static ModelMapper modelMapper;

	static {
		modelMapper = new ModelMapper();
		}
	public static RecipeDto mapToRecipeDto(Recipe receipe) {
		return modelMapper.map(receipe, RecipeDto.class);
		}

		public static IngredientDto mapToIngredientDto(Ingredient ingredient) {
		return modelMapper.map(ingredient, IngredientDto.class);
		}

		public static Recipe mapToRecipe(RecipeDto receipeDto) {
		return modelMapper.map(receipeDto, Recipe.class);
		}

		public static Ingredient mapToIngredient(IngredientDto ingredientDto) {
		return modelMapper.map(ingredientDto, Ingredient.class);
		}

		public static List<IngredientDto> mapAllIngredients(List<Ingredient> ingredients) {
		        return ingredients.stream()
		                .map(entity -> mapToIngredientDto(entity))
		                .collect(Collectors.toList());
		}

		public static List<RecipeDto> mapAllReciepes(List<Recipe> recipes) {
		        return recipes.stream()
		                .map(entity -> mapToRecipeDto(entity))
		                .collect(Collectors.toList());
		}

		
	
}
