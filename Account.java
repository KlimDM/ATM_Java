import java.util.*;

public class Account {

    /**
     * Название счета
     **/
    private String name;

    /**
     * Уникальный идентификатор счета
     **/
    private String uuid;

    /**
     * Владелец счета
     **/
    private User holder;

    /**
     * Список транзакций для счета
     **/
    private ArrayList<Transaction> transactions;

    /**
     * Создаем новый счет
     * @param name
     * @param holder
     * @param theBank
     */
    public Account(String name, User holder, Bank theBank) {
        // Вводим имя счета и его владельца
        this.name = name;
        this.holder = holder;

        // Получаем уникальный идентификатор счета
        this.uuid = theBank.getNewAccountUUID();

        // Инициализируем список операций по счету
        this.transactions = new ArrayList<Transaction>();

        // Добавляем счет в список счетов владельца и список всех счетов в банке
        holder.addAccount(this);
        theBank.addAccount(this);

    }

    public String getUUID() {
        return this.uuid;
    }


}