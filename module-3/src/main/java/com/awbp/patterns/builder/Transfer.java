package com.awbp.patterns.builder;

/** Банковский перевод. */
public class Transfer {

    private final String from;
    private final String to;
    private final int amount;
    private final String currency;
    private final String purpose;
    private final String comment;

    private Transfer(Builder builder) {
        this.from = builder.from;
        this.to = builder.to;
        this.amount = builder.amount;
        this.currency = builder.currency;
        this.purpose = builder.purpose;
        this.comment = builder.comment;
    }

    /** Строитель банковского перевода. */
    public static class Builder {

        private String from;
        private String to;
        private int amount;
        private String currency;
        private String purpose;
        private String comment;

        public Builder from(String from) {
            this.from = from;
            return this;
        }

        public Builder to(String to) {
            this.to = to;
            return this;
        }

        public Builder amount(int amount) {
            this.amount = amount;
            return this;
        }

        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }

        public Builder purpose(String purpose) {
            this.purpose = purpose;
            return this;
        }

        public Builder comment(String comment) {
            this.comment = comment;
            return this;
        }

        public Transfer build() {
            return new Transfer(this);
        }
    }


}
