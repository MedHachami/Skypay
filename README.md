# Bank Account Kata

## 🎯 Overview
This technical test implements a simple bank account system that handles deposits, withdrawals, and can print account statements. The implementation follows clean code principles, SOLID design patterns, and is thoroughly tested.

## 🏗️ Project Structure
```
bank2kata/
├── src/
│   ├── main/java/com/skypay/bank2kata/
│   │   ├── entities/
│   │   │   ├── Transaction.java
│   │   │   └── enums/
│   │   │       └── TransactionType.java
│   │   ├── interfaces/
│   │   │   └── AccountService.java
│   │   ├── service/
│   │   │   └── Account.java
│   │   ├── utils/
│   │   │   └── Utils.java
│   │   └── App.java
│   └── test/java/com/skypay/bank2kata/
│       └── AccountTest.java
├── pom.xml
└── run-app.sh
```

## 🚀 Features
- Deposit money into an account
- Withdraw money from an account
- Print account statements with transaction history
- Handle transactions with date validation
- Prevent negative amounts and future dates
- Format dates consistently
- Track running balance

## 🛠️ Technical Requirements
- Java 11 or higher
- Maven 3.6 or higher
- Bash shell (for running the script)

## ⚙️ Installation & Running
1. Clone the repository
```bash
git clone [repository-url]
cd bank2kata
```

2. Build and run using Maven
```bash
./run-app.sh
```

Or manually:
```bash
mvn clean package
mvn exec:java -Dexec.mainClass="com.skypay.bank2kata.App"
```

## 🧪 Running Tests
```bash
mvn test
```

## 📝 Usage Example
```java
Account account = new Account();
account.deposit(1000, LocalDate.of(2012, 1, 10));
account.deposit(2000, LocalDate.of(2012, 1, 13));
account.withdraw(500, LocalDate.of(2012, 1, 14));
System.out.println(account.printStatement());
```

Expected output:
```
Date || Amount || Balance
14/01/2012 || -500 || 2500
13/01/2012 || 2000 || 3000
10/01/2012 || 1000 || 1000
```

## 🎯 Design Decisions
- **Immutable Transactions**: All transactions are immutable to ensure data integrity
- **Single Responsibility**: Each class has a single, well-defined purpose
- **Interface Segregation**: Clear interfaces defining the contract for account operations
- **Validation**: Robust input validation for dates and amounts
- **Clean Code**: Meaningful naming, clear structure, and comprehensive testing

## 🧪 Test Coverage
The application includes tests for:
- Zero amount transactions
- Same-date transactions
- Negative balance scenarios
- Input validation (null dates, future dates, negative amounts)


## 📄 License
This project is part of a technical test and is not licensed for public use.