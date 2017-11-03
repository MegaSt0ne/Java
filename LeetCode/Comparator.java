	public class CompanyHiredCountComparator implements Comparator<Company>{

		@Override
		public int compare(Company c1, Company c2) {
			return Integer.compare(c1.hiredCount, c2.hiredCount);
		}
	}
	
		public class StudentCompanyComparator implements Comparator<Student>{

		@Override
		public int compare(Student s1, Student s2) {
			return s1.companyName.compareTo(s2.companyName);
		}

	}