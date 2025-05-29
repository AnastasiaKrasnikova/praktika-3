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
