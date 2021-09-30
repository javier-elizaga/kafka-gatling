package com.je.demo.app.processor

interface Processor<T> {
    fun process(event: T)
}

