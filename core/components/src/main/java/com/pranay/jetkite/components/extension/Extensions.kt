package com.pranay.jetkite.components.extension

fun Float.isPositive(): Boolean {
    return this >= 0
}
fun Float.toDisplayValue(): String {
    return if (this.isPositive()) "+$this" else "-$this"
}
