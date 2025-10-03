package com.bank.bank_management.config;

import com.bank.bank_management.model.entity.Account;
import com.bank.bank_management.model.entity.Customer;
import com.bank.bank_management.model.entity.Transaction;
import com.bank.bank_management.model.entity.User;
import com.bank.bank_management.repository.AccountRepository;
import com.bank.bank_management.repository.CustomerRepository;
import com.bank.bank_management.repository.TransactionRepository;
import com.bank.bank_management.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public DataInitializer(UserRepository userRepository, 
                          CustomerRepository customerRepository,
                          AccountRepository accountRepository,
                          TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Only initialize if database is empty
        if (userRepository.count() == 0) {
            initializeData();
        }
    }

    private void initializeData() {
        // Create Users
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("admin123");
        admin.setRole("ADMIN");
        userRepository.save(admin);

        User johnUser = new User();
        johnUser.setUsername("John Doe");
        johnUser.setPassword("John123");
        johnUser.setRole("USER");
        userRepository.save(johnUser);

        User aliceUser = new User();
        aliceUser.setUsername("Alice Smith");
        aliceUser.setPassword("Alice123");
        aliceUser.setRole("USER");
        userRepository.save(aliceUser);

        User bobUser = new User();
        bobUser.setUsername("Bob Johnson");
        bobUser.setPassword("Bob123");
        bobUser.setRole("USER");
        userRepository.save(bobUser);

        User ashaUser = new User();
        ashaUser.setUsername("Asha");
        ashaUser.setPassword("Asha123");
        ashaUser.setRole("USER");
        userRepository.save(ashaUser);

        User pavanaUser = new User();
        pavanaUser.setUsername("Pavana");
        pavanaUser.setPassword("Pavana123");
        pavanaUser.setRole("USER");
        userRepository.save(pavanaUser);

        // Create Customers
        Customer john = new Customer();
        john.setName("John Doe");
        john.setEmail("john@example.com");
        john.setPhone("1234567890");
        customerRepository.save(john);

        Customer alice = new Customer();
        alice.setName("Alice Smith");
        alice.setEmail("alice@example.com");
        alice.setPhone("9876543210");
        customerRepository.save(alice);

        Customer bob = new Customer();
        bob.setName("Bob Johnson");
        bob.setEmail("bob@example.com");
        bob.setPhone("5556667777");
        customerRepository.save(bob);

        // Create Accounts
        Account johnSavings = new Account();
        johnSavings.setCustomer(john);
        johnSavings.setAccountType("SAVINGS");
        johnSavings.setBalance(5000.0);
        accountRepository.save(johnSavings);

        Account aliceCurrent = new Account();
        aliceCurrent.setCustomer(alice);
        aliceCurrent.setAccountType("CURRENT");
        aliceCurrent.setBalance(3000.0);
        accountRepository.save(aliceCurrent);

        Account bobSavings = new Account();
        bobSavings.setCustomer(bob);
        bobSavings.setAccountType("SAVINGS");
        bobSavings.setBalance(7000.0);
        accountRepository.save(bobSavings);

        Account johnCurrent = new Account();
        johnCurrent.setCustomer(john);
        johnCurrent.setAccountType("CURRENT");
        johnCurrent.setBalance(2000.0);
        accountRepository.save(johnCurrent);

        // Create Initial Transactions
        createTransaction(johnSavings, "DEPOSIT", 5000.0);
        createTransaction(aliceCurrent, "DEPOSIT", 3000.0);
        createTransaction(bobSavings, "DEPOSIT", 7000.0);
        createTransaction(johnSavings, "WITHDRAW", 1000.0);
        createTransaction(aliceCurrent, "WITHDRAW", 500.0);
        createTransaction(johnCurrent, "DEPOSIT", 2000.0);
        createTransaction(bobSavings, "WITHDRAW", 2000.0);
        createTransaction(johnSavings, "DEPOSIT", 1500.0);
        createTransaction(aliceCurrent, "DEPOSIT", 1200.0);
        createTransaction(bobSavings, "DEPOSIT", 800.0);

        System.out.println("✅ Initial data loaded successfully!");
    }

    private void createTransaction(Account account, String type, Double amount) {
        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setType(type);
        transaction.setAmount(amount);
        transaction.setDate(LocalDateTime.now());
        transactionRepository.save(transaction);
    }
}