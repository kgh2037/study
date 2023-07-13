package study05;

	public class Person1 {
		private int age;
		public String name;
		protected int height;
		private int weight;
		
		
		public int getage() {
			return age;
		}
		
		public void setage(int age) {
			this.age = age;
		}
		
		public int getWeight() {
			return weight;
		}
		
		public void setWeight(int weight) {
			if (weight < 0 || weight > 300) {
				weight = 0;
			}
			this.weight = weight;
		}
	}
	
