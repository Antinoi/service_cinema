package com.example.services

abstract class CRUDService<T>(val list: MutableList<T> = mutableListOf()){
    abstract fun add(entity: T)
    abstract fun update(id: Int, entity: T)
    abstract fun delete(id: Int)
    abstract fun read(id: Int): T?
    abstract fun readAll(): List<T>
}