import model.City;
import model.Employee;
import service.CityDAO;
import service.CityDAOImpl;
import service.EmployeeDAO;
import service.EmployeeDAOImpl;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        CityDAO cityDAO = new CityDAOImpl();
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        City cityTest = new City("Gorod");
        cityDAO.addCity(cityTest);
        Employee employee1 = new Employee("Test1", "Test1", "male", 25, cityTest);
        Employee employee2 = new Employee("Test2", "Test2", "female",20 , cityTest);

        List<Employee> emp = cityTest.getEmployee();
        emp.add(employee1);
        emp.add(employee2);
        cityTest.setEmployee(emp);
        cityDAO.updateCity(cityTest);
        employeeDAO.getAllEmployee().forEach(System.out::println);

        Employee employee = employeeDAO.getById(3);
        City city = employee.getCity();

        System.out.println(city);
        employee.setAge(85);
        employee.setGender("female");
        employee.setFirstName("Test3");
        employee.setLastName("Test3");
        employeeDAO.updateEmployee(employee);
        employeeDAO.getAllEmployee().forEach(System.out::println);
        cityDAO.deleteCity(cityTest);
        employeeDAO.getAllEmployee().forEach(System.out::println);
    }
}
