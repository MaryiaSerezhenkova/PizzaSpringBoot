package by.academy.pizza.api;


import java.time.LocalDateTime;

/**
 * Описание этапа выполнения заказа
 */
public interface IStage {
	/**
	 * Описание этапа
	 * 
	 * @return
	 */
	String getDescription();

	void setDescription(String description);

	/**
	 * Когда этап был начат
	 * 
	 * @return
	 */
	LocalDateTime getTime();

	void setTime(LocalDateTime time);
}
