package com.jcg.examples.bean;

import java.io.Serializable;

public class Person implements Serializable
{

		private static final long serialVersionUID = -8243145429438016231L;

		public enum Gender{Male, Female}
		
		private String id;
		
		private String name;
		
		private Gender gender;
		
		private int age;

		public String getId()
		{
				return id;
		}

		public void setId(String id)
		{
				this.id = id;
		}

		public String getName()
		{
				return name;
		}

		public void setName(String name)
		{
				this.name = name;
		}

		public Gender getGender()
		{
				return gender;
		}

		public void setGender(Gender gender)
		{
				this.gender = gender;
		}

		public int getAge()
		{
				return age;
		}

		public void setAge(int age)
		{
				this.age = age;
		}
		
		@Override
		public int hashCode()
		{
				final int prime = 31;
				int result = 1;
				result = prime * result + age;
				result = prime * result + ((gender == null) ? 0 : gender.hashCode());
				result = prime * result + ((id == null) ? 0 : id.hashCode());
				result = prime * result + ((name == null) ? 0 : name.hashCode());
				return result;
		}

		@Override
		public boolean equals(Object obj)
		{
				if (this == obj)
						return true;
				if (obj == null)
						return false;
				if (getClass() != obj.getClass())
						return false;
				Person other = (Person) obj;
				if (age != other.age)
						return false;
				if (gender == null)
				{
						if (other.gender != null)
								return false;
				}
				else if (!gender.equals(other.gender))
						return false;
				if (id == null)
				{
						if (other.id != null)
								return false;
				}
				else if (!id.equals(other.id))
						return false;
				if (name == null)
				{
						if (other.name != null)
								return false;
				}
				else if (!name.equals(other.name))
						return false;
				return true;
		}

		@Override
		public String toString()
		{
				return "Person [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + "]";
		}
		
		
		
}
