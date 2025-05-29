import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        AuthController authController = new AuthController();
        VotingController votingController = new VotingController();
        ConsoleView view = new ConsoleView();
        
        while (true) {
            System.out.println("1. Вход");
            System.out.println("2. Регистрация");
            System.out.println("3. Выход");
            int choice = view.getMenuChoice();
            
            switch (choice) {
                case 1:
                    String[] credentials = view.getCredentials();
                    User user = authController.login(credentials[0], credentials[1]);
                    if (user != null) {
                        userMenu(user, view, votingController);
                    } else {
                        System.out.println("Неверные учетные данные");
                    }
                    break;
                case 2:
                    String[] regData = view.getVoterRegistrationData();
                    boolean success = authController.registerVoter(
                        regData[0], regData[1], regData[2], 
                        LocalDate.parse(regData[3]), regData[4]);
                    System.out.println(success ? "Регистрация успешна" : "Пользователь уже существует");
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
    
    private static void userMenu(User user, ConsoleView view, VotingController votingController) {
        while (true) {
            view.showUserMenu(user);
            int choice = view.getMenuChoice();
            
            if (user instanceof Admin) {
                handleAdminMenu((Admin)user, choice);
            } else if (user instanceof CEC) {
                handleCECMenu((CEC)user, choice, votingController);
            } else if (user instanceof Candidate) {
                handleCandidateMenu((Candidate)user, choice);
            } else if (user instanceof Voter) {
                handleVoterMenu((Voter)user, choice, votingController);
            }
        }
    }
    
    // Методы для обработки меню разных ролей
    private static void handleAdminMenu(Admin admin, int choice) {
        // Реализация пунктов меню администратора
    }
    
    private static void handleCECMenu(CEC cec, int choice, VotingController votingController) {
        // Реализация пунктов меню ЦИК
    }
    
    private static void handleCandidateMenu(Candidate candidate, int choice) {
        // Реализация пунктов меню кандидата
    }
    
    private static void handleVoterMenu(Voter voter, int choice, VotingController votingController) {
        // Реализация пунктов меню избирателя
    }
}
