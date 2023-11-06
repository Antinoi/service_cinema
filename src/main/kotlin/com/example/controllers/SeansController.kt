package com.example.controllers

import com.example.models.Seans
import com.example.services.SeansService


class SeansController(seansService: SeansService): Controller<Seans>(seansService) {
    override fun getAll(): List<Seans> = service.readAll()

    override fun get(id: Int): Seans? = service.read(id)

    override fun delete(id: Int) = service.delete(id)

    override fun update(id: Int, entity: Seans) = service.update(id, entity)

    override fun add(entity: Seans) = service.add(entity)
}