package by.epam.course.basic.beans;

public class SportProduct {
	private String name;
	private String desctiption;
	private int Owner_ID = -1;
	private Status status = Status.IN_STOCK;

	public SportProduct() {
	}

	public SportProduct(String name, String description) {
		this.name = name;
		this.desctiption = description;
	}

	public SportProduct(String name, String desctiption, int owner_ID, String status) {
		super();
		this.name = name;
		this.desctiption = desctiption;
		Owner_ID = owner_ID;
		this.status = Status.valueOf(status);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDesctiption(String desctiption) {
		this.desctiption = desctiption;
	}

	public int getOwner_ID() {
		return Owner_ID;
	}

	public void setOwner_ID(int owner_ID) {
		Owner_ID = owner_ID;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public String getDesctiption() {
		return desctiption;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Owner_ID;
		result = prime * result + ((desctiption == null) ? 0 : desctiption.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SportProduct other = (SportProduct) obj;
		if (Owner_ID != other.Owner_ID)
			return false;
		if (desctiption == null) {
			if (other.desctiption != null)
				return false;
		} else if (!desctiption.equals(other.desctiption))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sport Item: \n\t Name: " + name + ", Desctiption: " + desctiption;
	}

}
