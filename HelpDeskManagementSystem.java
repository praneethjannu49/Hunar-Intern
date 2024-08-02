import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HelpDeskManagementSystem {

    static class User {
        int id;
        String username;
        String password;

        User(int id, String username, String password) {
            this.id = id;
            this.username = username;
            this.password = password;
        }
    }

    static class Ticket {
        int id;
        int userId;
        String description;
        String status;

        Ticket(int id, int userId, String description) {
            this.id = id;
            this.userId = userId;
            this.description = description;
            this.status = "Open";
        }
    }

    static class SupportStaff {
        int id;
        String username;
        String password;

        SupportStaff(int id, String username, String password) {
            this.id = id;
            this.username = username;
            this.password = password;
        }
    }

    static class Admin {
        int id;
        String username;
        String password;

        Admin(int id, String username, String password) {
            this.id = id;
            this.username = username;
            this.password = password;
        }
    }

    static List<User> users = new ArrayList<>();
    static List<Ticket> tickets = new ArrayList<>();
    static List<SupportStaff> supportStaffs = new ArrayList<>();
    static Admin admin = new Admin(1, "admin", "admin");

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. User Registration");
            System.out.println("2. User Login");
            System.out.println("3. Admin Login");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    userLogin();
                    break;
                case 3:
                    adminLogin();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }

    private static void registerUser() {
        System.out.println("Enter username:");
        String username = scanner.next();
        System.out.println("Enter password:");
        String password = scanner.next();
        int id = users.size() + 1;
        users.add(new User(id, username, password));
        System.out.println("User registered successfully!");
    }

    private static void userLogin() {
        System.out.println("Enter username:");
        String username = scanner.next();
        System.out.println("Enter password:");
        String password = scanner.next();
        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                System.out.println("Login successful!");
                userMenu(user);
                return;
            }
        }
        System.out.println("Invalid credentials!");
    }

    private static void userMenu(User user) {
        while (true) {
            System.out.println("1. Submit Ticket");
            System.out.println("2. View Tickets");
            System.out.println("3. Logout");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    submitTicket(user);
                    break;
                case 2:
                    viewTickets(user);
                    break;
                case 3:
                    return;
            }
        }
    }

    private static void submitTicket(User user) {
        System.out.println("Enter ticket description:");
        scanner.nextLine();  // Consume newline
        String description = scanner.nextLine();
        int id = tickets.size() + 1;
        tickets.add(new Ticket(id, user.id, description));
        System.out.println("Ticket submitted successfully!");
    }

    private static void viewTickets(User user) {
        System.out.println("Your tickets:");
        for (Ticket ticket : tickets) {
            if (ticket.userId == user.id) {
                System.out.println("ID: " + ticket.id + ", Description: " + ticket.description + ", Status: " + ticket.status);
            }
        }
    }

    private static void adminLogin() {
        System.out.println("Enter admin username:");
        String username = scanner.next();
        System.out.println("Enter admin password:");
        String password = scanner.next();
        if (admin.username.equals(username) && admin.password.equals(password)) {
            System.out.println("Login successful!");
            adminMenu();
        } else {
            System.out.println("Invalid credentials!");
        }
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("1. View All Tickets");
            System.out.println("2. Manage Users");
            System.out.println("3. Logout");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    viewAllTickets();
                    break;
                case 2:
                    manageUsers();
                    break;
                case 3:
                    return;
            }
        }
    }

    private static void viewAllTickets() {
        System.out.println("All tickets:");
        for (Ticket ticket : tickets) {
            System.out.println("ID: " + ticket.id + ", User ID: " + ticket.userId + ", Description: " + ticket.description + ", Status: " + ticket.status);
        }
    }

    private static void manageUsers() {
        System.out.println("All users:");
        for (User user : users) {
            System.out.println("ID: " + user.id + ", Username: " + user.username);
        }
    }
}
