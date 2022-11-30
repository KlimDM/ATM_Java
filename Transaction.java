import java.util.*;

public class Transaction {

    /**
     * Сумма транзакции
     **/
    private double amount;

    /**
     * Точное время транзакции
     **/
    private Date timestamp;

    /**
     * Соответствующая запись для транзации
     **/
    private String memory;

    /**
     * Счет, совершивий транзакцию
     **/
    private Account inAccount;

    /**
     *
     * @param amount
     * @param inAcct
     */
    public Transaction(double amount, Account inAcct) {
        this.amount = amount;
        this.inAccount = inAcct;
        this.timestamp = new Date();
        this.memory = "";
    }

    /**
     *
     * @param amount
     * @param memory
     * @param inAcct
     */
    public Transaction(double amount, String memory, Account inAcct) {
        this(amount, inAcct);
        this.memory = memory;
    }
}