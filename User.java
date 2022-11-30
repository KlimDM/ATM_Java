import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User {

    /**
     *Имя пользователя
     **/
    private String firstName;

    /**
     *Фамилия пользователя
     **/
    private String lastName;

    /**
     *Уникальный номер пользвателя в системе
     **/
    private String uuid;

    /**
     *MD5-хэшированный пароль пользователя
     **/
    private byte pinHash[];

    /**
     *Список всех счетов пользователя
     **/
    private ArrayList<Account> accounts;

    /**
     * Create a new user
     * @param firstName
     * @param lastName
     * @param pin
     * @param theBank
     */

    public User(String firstName, String lastName, String pin, Bank theBank) {
        // Вводим имя и фамилию пользователя
        this.firstName = firstName;
        this.lastName = lastName;

        // Записываем MD5 хэш пароля пользователя
        try {
            MessageDigest mg = MessageDigest.getInstance("MD5");
            this.pinHash = mg.digest(pin.getBytes());
        } catch (NoSuchAlgorithmException e) {
            System.err.println("error, caught NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }

        // Создадим UUID для пользователя
        this.uuid = theBank.getNewUserUUID();

        // Создадим список счетов пользователя
        this.accounts = new ArrayList<Account>();

        System.out.printf("New user %s, %s with ID %s created.\n", lastName, firstName, this.uuid);

    }
        public void addAccount(Account anAcct) {
            this.accounts.add(anAcct);
        }

        public String getUUID() {
        return this.uuid;
        }
    }