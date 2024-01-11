import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {

        Employee nada = new Employee(123, "Nada", "IT", 4000.0);

        double overtime = 6;
        double bonus = 1500;
        double deductions = 50;

        double totalSalary = calculateTotalSalary(nada, overtime, bonus, deductions);
        System.out.println(
                "Employee ID: " + nada.getId() + ", Name: " + nada.getName() + " Position: " + nada.getPosition()
                        + ", Total Salary: " + totalSalary);

        double paymentAmount = 5000;
        String paymentMethod = "Deposit";
        addPayment(nada, new Date(), paymentAmount, paymentMethod);

        // showPaymentHistory(nada);
    }

    private static double calculateTotalSalary(Employee employee, double overtime, double bonus, double deductions) {
        double overtimeRate = overtime * (employee.getBasicSalary() / 15);
        double totalSalary = employee.getBasicSalary() + overtimeRate + bonus - deductions;
        return totalSalary;
    }

    private static double addPayment(Employee employee, Date date, double amount, String paymentMethod) {
        Payment payment = new Payment(date, amount, paymentMethod);
        employee.setPaymentHistory(payment);
        return amount;
    }

    // private static void showPaymentHistory(Employee employee) {
    // System.out.println("Payment History for " + employee.getName() + " ID# " +
    // employee.getId());
    // Payment payment = employee.getPaymentHistory();
    // System.out.println("Date: " + payment.getDate() + ", Amount: " +
    // payment.getAmount() + ", Payment Method: "
    // + payment.getPaymentMethod());

    // }

}
