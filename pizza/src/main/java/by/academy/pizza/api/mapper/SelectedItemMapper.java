package by.academy.pizza.api.mapper;

import by.academy.pizza.api.core.SelectedItem;

public class SelectedItemMapper {
	
//	public static ISelectedItem selectedItemInputMapping(SelectedItemDTO selectedItemDTO) {
//		return new SelectedItem(selectedItemDTO.getRowId(), selectedItemDTO.getCount(), selectedItemDTO.getOrderId());
//	}

	public static SelectedItem selectedItemOutputMapping(SelectedItem selectedItem) {
		return new SelectedItem(selectedItem.getRow(), selectedItem.getCount());
	}

}
