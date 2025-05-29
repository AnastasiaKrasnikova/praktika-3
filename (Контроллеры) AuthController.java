import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AuthController {
    private List<User> users;
    
    public AuthController() {
        this.users = new ArrayList<>();
        // Добавляем тестового администратора
        users.add(new Admin("admin", "admin123", "Администратор Системы", 
                          LocalDate.of(1980, 1, 1), "000-000-000 00"));
    }
    
    public User login(String username, String password) {
        return users.stream()
            .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
            .findFirst()
            .orElse(null);
    }
    
    public boolean registerVoter(String username, String password, String fullName, 
                               LocalDate birthDate, String snils) {
        if (users.stream().anyMatch(u -> u.getUsername().equals(username))) {
            return false;
        }
        users.add(new Voter(username, password, fullName, birthDate, snils));
        return true;
    }
}
