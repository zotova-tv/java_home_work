package lesson5;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Иванов Иван Иванович", "Директор", "ivanovii@mail.ru", "+71111111111", 100000, 50);
        employees[1] = new Employee("Петров Петр Петрович", "Бухгалтер", "petrovpp@mail.ru", "+72222222222", 80000, 35);
        employees[2] = new Employee("Александрова Александра Александровна", "Продавец", "aleksandrovaaa@mail.ru", "+73333333333", 30000, 27);
        employees[3] = new Employee("Денисов Денис Денисович", "Кассир", "dinisovdd@mail.ru", "+74444444444", 40000, 45);
        employees[4] = new Employee("Михайлов Михаил Михайлович", "Сотрудник склада", "mikhailovmm@mail.ru", "+75555555555", 30000, 32);

        for (Employee employee : employees) {
            if (employee.getAge() > 40) {
                employee.printInfo();
            }
        }
    }
}
