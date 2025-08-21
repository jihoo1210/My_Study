package hambuger;

import java.sql.Timestamp;

public class Dto_Data_transfer_Object {
	private int id;
	private String size;
	private String ingredients;
	private String drink;
	private String request;
	private Timestamp createdAt;
	private int total;
		
		public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getSize() {
			return size;
		}
		public void setSize(String size) {
			this.size = size;
		}
		public String getIngredients() {
			return ingredients;
		}
		public void setIngredients(String ingredients) {
			this.ingredients = ingredients;
		}
		public String getDrink() {
			return drink;
		}
		public void setDrink(String drink) {
			this.drink = drink;
		}
		public String getRequest() {
			return request;
		}
		public void setRequest(String request) {
			this.request = request;
		}
		public Timestamp getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Timestamp createdAt) {
			this.createdAt = createdAt;
		}
		
		@Override
		public String toString() {
			return "Dto_Data_transfer_Object [id=" + id + ", size=" + size + ", ingredients=" + ingredients + ", drink="
					+ drink + ", request=" + request + ", createdAt=" + createdAt + "]";
		}
		
}
