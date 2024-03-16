package lr2;

public class Example7 {
    public interface Output {
        void deposit(double amount);
        void withdraw(double amount);
        double getBalance();
        void setBalance(double balance);
    }

    public class BankAccount implements Output {
        private double balance;
        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }
        @Override
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Успешно зачислено: " + amount);
            } else {
                System.out.println("Не удалось зачислить");
            }
        }
        @Override
        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Снятие успешно: " + amount);
            } else {
                System.out.println("Ошибка при снятии");
            }
        }
        @Override
        public double getBalance() {
            return balance;
        }
        @Override
        public void setBalance(double balance) {
            this.balance = balance;
        }
    }
}
