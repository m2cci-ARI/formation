package fr.excilys.recipe.dto;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

import fr.excilys.recipe.model.RecipeIngredient;
public class RecipeDto {
	private Long id;
	private String name;
	private String picture;
	private String description;
	private Set<RecipeIngredient> ingredients = new HashSet<>();
	private Set<String> instructions = new HashSet<>();

	public RecipeDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<RecipeIngredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<RecipeIngredient> ingredients) {
		this.ingredients = ingredients;
	}

	public Set<String> getInstructions() {
		return instructions;
	}

	public void setInstructions(Set<String> instructions) {
		this.instructions = instructions;
	}

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
