package annotation;

public class UserService {
    @Authorized(role = "ADMIN")
    public void deleteUser() {
        System.out.println("Deleting user...");
    }

    @Authorized(role = "USER")
    public void updateUser() {
        System.out.println("Updating user...");
    }

    public void viewUser() {
        System.out.println("Viewing user...");
    }
}
