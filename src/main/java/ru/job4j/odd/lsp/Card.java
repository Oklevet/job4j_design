package ru.job4j.odd.lsp;

public class Card {
    double balance;
    double service;
    double limit;
    double tariffComiss;
    Double minSum;
    String size;

    public Card(double limit, double tariffComiss, Double minSum, String size) {
        this.limit = limit;
        this.tariffComiss = tariffComiss;
        this.minSum = minSum;
        this.size = size;
    }

    /**
     * пользователь вводит сумму на экране АТМ
     */
    public void withdrawCash() {
        if (balance < tariffComiss + minSum) {
            throw new IllegalArgumentException("You cant withdraw cash. Min sum of withdraw "
                    + minSum + ". Min comiss " + tariffComiss + ".");
        }
        int sum = 0;

        if (balance + limit < sum) {
            throw new IllegalArgumentException("insufficient funds");
        }
    }

    public class DebetCard extends Card {
        public DebetCard(double limit, double tariffComiss, Double minSum, String size) {
            super(limit, tariffComiss, minSum, size);
        }

        @Override
        public void withdrawCash() {
            super.withdrawCash();
        }
    }

    public class CreditCard extends Card {
        public CreditCard(double limit, double tariffComiss, Double minSum, String size) {
            super(limit, tariffComiss, minSum, size);
        }

        @Override
        public void withdrawCash() {
            super.withdrawCash();
        }
    }
}
