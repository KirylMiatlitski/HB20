package by.epam.course.basic.sax.tags;

public enum TagName {
	SPORTPRODUCT, NAME, DESCRIPTION, OWNER_ID, STATUS, ITEMS;

	public static TagName getElementTagName(String element) {
		switch (element) {
		case "SportProduct":
			return SPORTPRODUCT;
		case "name":
			return NAME;
		case "description":
			return DESCRIPTION;
		case "Owner_ID":
			return OWNER_ID;
		case "status":
			return STATUS;
		case "items":
			return ITEMS;
		default:
			throw new EnumConstantNotPresentException(TagName.class, element);
		}
	}
}
