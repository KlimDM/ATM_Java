import java.util.*;

public class Bank {

    /**
     * Название банка
     **/
    private String name;

    /**
     * Список клиентов банка
     **/
    private ArrayList<User> users;

    /**
     * Список всех счетов в банке
     **/
    private ArrayList<Account> accounts;

    public String getNewUserUUID() {
        String uuid = "";
        Random rng = new Random();
        int len = 6;
        boolean nonUnique;

        do {
            uuid = "";
            for (int c = 0; c < len; c++) {
                uuid += ((Integer) rng.nextInt(10)).toString();
            }
            nonUnique = false;
            for (User u : this.users) {
                if (uuid.compareTo(u.getUUID()) == 0) {
                    nonUnique = true;
                    break;
                }

            }

        } while (nonUnique);
        return uuid;
    }



    public String getNewAccountUUID() {
        String uuid = "";
        Random rng = new Random();
        int len = 10;
        boolean nonUnique;

        do {
            uuid = "";
            for (int c = 0; c < len; c ++) {
                uuid += ((Integer)rng.nextInt(10)).toString();
            }
            nonUnique = false;
            for (Account a : this.accounts) {
                if (uuid.compareTo((a.getUUID())) == 0) {
                    nonUnique = true;
                    break;
                }

            }

        } while (nonUnique);

        return uuid;
    }

    public void addAccount(Account anAcct) {
        this.accounts.add(anAcct);
    }

    public User addUser(String firstName, String lastName, String pin) {
        User newUser = new User(firstName, lastName, pin, this);
        this.users.add(newUser);

        // Создадим счет для нового клиента
        Account newAcc = new Account("Savings", newUser, this);
        newUser.addAccount(newAcc);
        this.addAccount(newAcc);

        return newUser;

    }

    /**
     *
     * @param UserID
     * @param pin
     * @return
     */
    public User Login(String UserID, String pin) {
        for (User user : this.users) {
            if ((user.getUUID().compareTo(UserID) == 0) && user.validatePin(pin)) {
                return user;
            }
        }
        return null;
    }
}

