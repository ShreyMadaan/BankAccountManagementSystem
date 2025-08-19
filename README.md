# Bank Account Management System (Console, Java)

A simple console-based banking application demonstrating SOLID principles and basic design patterns (Factory, Repository, Service layer) in plain Java.

This project lets a user create an account, log in with a PIN, check balance, deposit, and withdraw — using an in-memory repository for persistence during runtime.

## Features
- Create a new account with auto-generated account number
- 4-digit PIN verification on login
- Check balance, deposit with validation, withdraw with insufficient-funds handling
- In-memory repository for storing accounts during app lifetime
- Clean separation of concerns using SOLID:
  - IAccount interface (SRP/LSP)
  - AccountService (business logic) (SRP)
  - AccountRepository + InMemoryAccountRepository (DIP)
  - AccountFactory (Factory pattern)
  - Main (UI and orchestration only)

## Project Structure
```
BankAccountManagementSystem.iml
out/production/BankAccountManagementSystem/...   # compiled classes (generated)
src/
  AccountFactory.java
  AccountRepository.java
  AccountService.java
  BankAccount.java
  IAccount.java
  InMemoryAccountRepository.java
  Main.java
README.md
LICENSE
```

## Requirements
- Java 11+ (works with newer JDKs as well)
- A terminal or an IDE (e.g., IntelliJ IDEA)

## Build and Run (Windows PowerShell)
From the project root:

1) Compile
```
javac -d out src\*.java
```

2) Run
```
java -cp out Main
```

If you use IntelliJ IDEA, you can open the project (the `.iml` file is present), mark `src` as the Sources root if needed, and run `Main`.

## Usage
When you run the application, you will see a menu like:

```
--- Welcome to Bank Application ---
1. Create a New Account
2. Login
0. Exit
Enter choice: 
```

- Create a New Account: enter your name, choose a 4-digit PIN, and an initial deposit (>= 0). The app returns your account number.
- Login: enter your account number and PIN to access the account menu.
- Account Menu includes:
  - Check Balance
  - Deposit (amount must be > 0)
  - Withdraw (amount must be > 0; fails if insufficient funds)
  - Logout

Errors (e.g., invalid amounts or PIN format) are reported with clear messages.

## Design Notes (SOLID & Patterns)
- IAccount: abstraction for account operations; enables LSP and testing/mocking.
- BankAccount: concrete implementation of IAccount; validates inputs; returns boolean on withdraw for insufficient funds instead of printing from domain logic.
- AccountRepository: abstraction; InMemoryAccountRepository provides a simple HashMap-backed store.
- AccountFactory: validates and constructs new accounts (Factory pattern).
- AccountService: orchestrates business logic and interacts with repository; UI delegates to this service (SRP, DIP).
- Main: console I/O only; depends on abstractions and calls AccountService.

## Extending
- Persistence: replace `InMemoryAccountRepository` with a file- or DB-backed implementation without changing the UI or service code.
- Validation/Rules: enhance logic inside `AccountService` or specialized validators.
- Multiple Account Types: add new implementations of `IAccount` and update `AccountFactory` accordingly.

## License
This project is licensed under the MIT License — see the LICENSE file for details.
