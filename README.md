# ATM Simulator (Java)

I made this project to understand how classes work in a real example. It works like a basic ATM.

**Demo PIN: 1234** (starting balance is 5000)

## What it does
- Login with PIN — wrong PIN stops the program
- Check balance
- Deposit and withdraw money (withdraw checks if balance is enough)
- Mini statement — shows the transactions done in this session

## Concepts I used
- Classes and objects — an `Account` class with its own data and methods
- Encapsulation in a simple way — balance changes only through deposit/withdraw methods
- `ArrayList` to store transaction history
- Conditions for PIN check and low balance

## How to run
```
javac AtmSimulator.java
java AtmSimulator
```

## What I want to add later
- More than one account
- Change PIN option
- Saving balance in a file
