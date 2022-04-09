package lesson9;

public class AccountLauncher {

    public static void main(String[] args) {

        Account myAccoount = new Account("Ivanov Vitaliy");
        myAccoount.activated();
        myAccoount.deposit(10000);
        myAccoount.withdraw(1000);
        myAccoount.deposit(5000);
        System.out.println("Состояние счета " + myAccoount.getBalance());

        PersonalAccount clientAccount = new PersonalAccount("Арнольд Шварценнегер");
        clientAccount.activated();
        clientAccount.deposit(1_000_000);

        CompanyAccount companyAccount = new CompanyAccount("IT Park");
        companyAccount.activated();
        companyAccount.deposit(10_000_000);

        CompanyAccount anotherCompanyAccount = new CompanyAccount("Рога и копыта");
        anotherCompanyAccount.activated();
        anotherCompanyAccount.deposit(10_000_000);

        CompanyAccount vtbCompanyAccount = new CompanyAccount("ВТБ");
        vtbCompanyAccount.activated();
        vtbCompanyAccount.deposit(10_000_000);

        System.out.println("Количество открытых расчетных счетов составляет " + CompanyAccount.COUNT);

        System.out.println(PersonalAccount.getBic());

    }
}
