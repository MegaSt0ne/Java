
public class Student implements Comparable<Student>{

	char section;
	String firstName;
	String lastName;
	String middleinitial;
	String andrewID;
	int companyRank;
	String companyName;
	/**
	 * @param section
	 * @param firstName
	 * @param lastName
	 * @param middleinitial
	 * @param andrewID
	 * @param companyRank
	 * @param companyName
	 */
	public Student(char section, String firstName, String lastName, String middleinitial, String andrewID,
			int companyRank, String companyName) {
		this.section = section;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleinitial = middleinitial;
		this.andrewID = andrewID;
		this.companyRank = companyRank;
		this.companyName = companyName;
	}

	@Override
	public int compareTo(Student s) {
		return andrewID.compareTo(s.andrewID);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((andrewID == null) ? 0 : andrewID.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (andrewID == null) {
			if (other.andrewID != null)
				return false;
		} else if (!andrewID.equals(other.andrewID))
			return false;
		return true;
	}
}
