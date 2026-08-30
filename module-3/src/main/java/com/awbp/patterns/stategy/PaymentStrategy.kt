package com.awbp.patterns.stategy

interface PaymentStrategy {
    fun pay(amount: Int)
}