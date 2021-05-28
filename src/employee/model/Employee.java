package employee.model;

public  class  Employee {
         private int id;
         private String name;
         private String type;
         private String department;
         private String address;
         private String gender;
         private int age;
         
         
         
		public Employee(int id, String name, String type, String department ,String address, String gender, int age) {
			this.id = id;
			this.name = name;
			this.setType(type);
			this.setDepartment(department);
			this.address = address;
			this.gender = gender;
			this.age = age;
		}
		
		
		public Employee(String name, String type, String department, String address, String gender, int age) {
			super();
			this.name = name;
			this.setType(type);
			this.setDepartment(department);
			this.address = address;
			this.gender = gender;
			this.age = age;
		}

  //Getters and Setters
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		} 
		
		public String getDepartment() {
			return department;
		}
        public void setDepartment(String department) {
			this.department = department;
		}

         
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}

         
         
}
