import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner;
    
    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }
    
    public String[] getCredentials() {
        System.out.print("Логин: ");
        String username = scanner.nextLine();
        System.out.print("Пароль: ");
        String password = scanner.nextLine();
        return new String[]{username, password};
    }
    
    public void showUserMenu(User user) {
        user.showMenu();
    }
    
    public int getMenuChoice() {
        System.out.print("Выберите пункт меню: ");
        return Integer.
            parseInt(scanner.nextLine());
    }
    
    public String[] getVoterRegistrationData() {
        System.out.print("ФИО: ");
        String fullName = scanner.nextLine();
        System.out.print("Дата рождения (ГГГГ-ММ-ДД): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());
        System.out.print("СНИЛС: ");
        String snils = scanner.nextLine();
        System.out.print("Логин: ");
        String username = scanner.nextLine();
        System.out.print("Пароль: ");
        String password = scanner.nextLine();
        return new String[]{username, password, fullName, birthDate.toString(), snils};
    }
}
