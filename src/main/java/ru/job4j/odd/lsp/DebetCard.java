package ru.job4j.odd.lsp;

/**
 * WRONG EXAMPLE
 */

public class DebetCard {
    double balance;
    double service;
    final String size = "85,6 × 53,98 мм";

    public DebetCard() {
    }

    public void withdrawCash() {
        if (balance < 80) {
            throw new IllegalArgumentException("You cant withdraw cash. Min sum of withdraw 50."
                    + " Min comiss 30");
        }
        int sum = 0;    //пользователь вводит сумму на экране АТМ

        if (balance < sum) {
            throw new IllegalArgumentException("insufficient funds");
        }
    }

    public class CreditCard extends DebetCard {

        /**
         * try init smartCard. Size can be different. ERROR.
         */
        public CreditCard(String size) {
            //super("50 × 35 мм");
        }

        public void withdrawCash() {
            /**
             * comiss on credit card higher. Minimum comiss sum = 100. ERROR.
             */
            if (balance < 80) {
                throw new IllegalArgumentException("You cant withdraw cash. Min sum of withdraw 50."
                        + " Min comiss 30");
            }
            int sum = 0;    //пользователь вводит сумму на экране АТМ

            /**
             * credit card can has balance under 0. ERROR.
             */
            if (balance < sum) {
                throw new IllegalArgumentException("insufficient funds");
            }
        }
    }
}
