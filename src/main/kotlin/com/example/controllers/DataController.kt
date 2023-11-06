package com.example.controllers

import com.example.models.Data
import com.example.services.DataService


class DataController(dataService: DataService): Controller<Data>(dataService) {
    override fun getAll(): List<Data> = service.readAll()

    override fun get(id: Int): Data? = service.read(id)

    override fun delete(id: Int) = service.delete(id)

    override fun update(id: Int, entity: Data) = service.update(id, entity)

    override fun add(entity: Data) = service.add(entity)
}