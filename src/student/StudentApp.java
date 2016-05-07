package student;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Display reminders of students having a birthday soon.
 * @author Tunya Wittayasiripaiboon 5810546676
 */
public class StudentApp {

	/**
	 * Print the names (and birthdays) of students having a birtday in the
	 * specified month.
	 * @param students list of students.
	 * @param filter predicate of students.
	 * @param action consumer of students.
	 * @param byName compare of students by name.
	 * 
	 */
	public void filterAndPrint(  List<Student> students, Predicate<Student> filter , Consumer<Student> action , Comparator<Student> byName ) {
		students.stream().filter(filter).sorted(byName).forEach(action);

	}

	/**
	 * Create the parameter and pass to filterAndPrint to get the result.
	 * @param args
	 */
	public static void main(String[] args) {
		List<Student> students = Registrar.getInstance().getStudents();
		LocalDate date = LocalDate.now();
		Predicate<Student> filter = s -> s.getBirthdate().getMonthValue() == date.getMonthValue();
		Consumer<Student> action = s -> System.out.printf("%s %s will have birthday on %d %s. \n",s.getFirstname(),s.getLastname(),s.getBirthdate().getDayOfMonth(),s.getBirthdate().getMonth());
		Comparator<Student> byName =  ( a , b ) -> a.getFirstname().charAt(0) - b.getFirstname().charAt(0);
		Comparator<Student> byBirthday = ( a , b ) -> a.getBirthdate().getDayOfMonth() - b.getBirthdate().getDayOfMonth();
		Predicate<Student> predict = s -> s.getBirthdate().getDayOfYear() - date.getDayOfYear()  == 13 ;
		StudentApp app = new StudentApp();
		app.filterAndPrint(students, filter, action , byBirthday  );
		
	}
}
