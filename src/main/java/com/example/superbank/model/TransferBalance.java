package com.example.superbank.model;

import lombok.Data;

import java.math.BigDecimal;

public class TransferBalance {
        private Long from;
        private  Long to;
        private Integer amount;

        public TransferBalance(Long from, Long to, Integer amount) {
                this.from = from;
                this.to = to;
                this.amount = amount;
        }

        public Long getFrom() {
                return from;
        }

        public void setFrom(Long from) {
                this.from = from;
        }

        public Long getTo() {
                return to;
        }

        public void setTo(Long to) {
                this.to = to;
        }

        public Integer getAmount() {
                return amount;
        }

        public void setAmount(Integer amount) {
                this.amount = amount;
        }
}
