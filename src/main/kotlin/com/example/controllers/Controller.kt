package com.example.controllers

import com.example.services.CRUDService

abstract class Controller<T>(val service: CRUDService<T>){
    abstract fun getAll(): List<T>
    abstract fun get(id: Int): T?
    abstract fun add(entity: T)
    abstract fun update(id: Int, entity: T)
    abstract fun delete(id: Int)
}