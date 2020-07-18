package com.learn.core.java.codelity;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;




public class Solution {




    private static final Scanner INPUT_READER = new Scanner(System.in);
    private static final DigitalWalletTransaction DIGITAL_WALLET_TRANSACTION = new DigitalWalletTransaction();

    private static final Map<String, DigitalWallet> DIGITAL_WALLETS = new HashMap<>();

    public static void main(String[] args) {
        int numberOfWallets = Integer.parseInt(INPUT_READER.nextLine());
        while (numberOfWallets-- > 0) {
            String[] wallet = INPUT_READER.nextLine().split(" ");
            DigitalWallet digitalWallet;

            if (wallet.length == 2) {
                digitalWallet = new DigitalWallet(wallet[0], wallet[1]);
            } else {
                digitalWallet = new DigitalWallet(wallet[0], wallet[1], wallet[2]);
            }

            DIGITAL_WALLETS.put(wallet[0], digitalWallet);
        }

        int numberOfTransactions = Integer.parseInt(INPUT_READER.nextLine());
        while (numberOfTransactions-- > 0) {
            String[] transaction = INPUT_READER.nextLine().split(" ");
            DigitalWallet digitalWallet = DIGITAL_WALLETS.get(transaction[0]);

            if (transaction[1].equals("add")) {
                try {
                    DIGITAL_WALLET_TRANSACTION.addMoney(digitalWallet, Integer.parseInt(transaction[2]));
                    System.out.println("Wallet successfully credited.");
                } catch (TransactionException ex) {
                    System.out.println(ex.getErrorCode() + ": " + ex.getMessage() + ".");
                }
            } else {
                try {
                    DIGITAL_WALLET_TRANSACTION.payMoney(digitalWallet, Integer.parseInt(transaction[2]));
                    System.out.println("Wallet successfully debited.");
                } catch (TransactionException ex) {
                    System.out.println(ex.getErrorCode() + ": " + ex.getMessage() + ".");
                }
            }
        }

        System.out.println();

        DIGITAL_WALLETS.keySet()
                .stream()
                .sorted()
                .map((digitalWalletId) -> DIGITAL_WALLETS.get(digitalWalletId))
                .forEachOrdered((digitalWallet) -> {
                    System.out.println(digitalWallet.getWalletId()
                            + " " + digitalWallet.getUsername()
                            + " " + digitalWallet.getWalletBalance());
                });
    }
}

class  TransactionException extends Exception {


    private String errorCode;
    TransactionException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}

class DigitalWalletTransaction {
    public void addMoney(DigitalWallet digitalWallet, int amount) throws TransactionException{
        validateTransaction(digitalWallet,amount,"add");
        synchronized (digitalWallet) {
            digitalWallet.setWalletBalance(digitalWallet.getWalletBalance() + amount);
        }
    }

    public void payMoney(DigitalWallet digitalWallet, int amount) throws TransactionException{
        validateTransaction(digitalWallet,amount,"pay");
        synchronized (digitalWallet) {
            digitalWallet.setWalletBalance(digitalWallet.getWalletBalance() - amount);
        }
    }

    private void validateTransaction(DigitalWallet digitalWallet, int amount, String operation) throws TransactionException{
        if(digitalWallet.getUserAccessCode()==null || digitalWallet.equals("")) {
            throw new TransactionException("USER_NOT_AUTHORIZED","User not authorized");
        }
        if(amount<1) {
            throw new TransactionException("INVALID_AMOUNT","Amount should be greater than zero.");

        }
        if("pay".equalsIgnoreCase(operation) && digitalWallet.getWalletBalance()-amount<0)  {
            throw new TransactionException("INSUFFICIENT_BALANCE","Insufficient Balance");
        }

    }

}

class DigitalWallet{

    private final String walletId;
    private final String username;
    private String userAccessCode;
    private int walletBalance;

    DigitalWallet(String walletId, String walletName) {
        this(walletId, walletName,null);
    }

    DigitalWallet(String walletId, String username, String userAccessCode) {
        this.walletId = walletId;
        this.username = username;
        this.userAccessCode = userAccessCode;
    }

    public String getWalletId() {
        return walletId;
    }

    public String getUsername() {
        return username;
    }

    public String getUserAccessCode() {
        return userAccessCode;
    }

    public void setUserAccessCode(String userAccessCode) {
        this.userAccessCode = userAccessCode;
    }

    public int getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(int walletBalance) {
        this.walletBalance = walletBalance;
    }
}