package fr.excilys.recipe.dto;
import org.apache.commons.lang3.builder.ToStringBuilder;
import fr.excilys.recipe.model.Ingredient;
public class RecipeIngredientDto {
	private Long id;
    private Ingredient ingredient;
    private Long quantity;
    private String unit;
	
    public RecipeIngredientDto() {
		super();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
