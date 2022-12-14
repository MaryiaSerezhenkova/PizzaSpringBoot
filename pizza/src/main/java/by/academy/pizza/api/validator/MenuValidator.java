package by.academy.pizza.api.validator;


import java.util.ArrayList;
import java.util.List;

import by.academy.pizza.api.dto.MenuDTO;
import by.academy.pizza.api.exceptions.ValidationException;

public class MenuValidator implements IValidator<MenuDTO> {
	public void validate(MenuDTO menuDTO) throws ValidationException {
		List<String> errors = new ArrayList<>();

		if (menuDTO.getName() == null || menuDTO.getName().isEmpty()) {
			errors.add("Menu name is required");
		}

		if (menuDTO.isEnabled() == false) {
			errors.add("Menu active is required");
		}

		if (errors.size() > 0) {
			throw new ValidationException(String.join(", ", errors));
		}
	}
}