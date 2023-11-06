package com.example.controllers

import com.example.models.Zal
import com.example.services.ZalService


class ZalController(zalService: ZalService): Controller<Zal>(zalService) {
    override fun getAll(): List<Zal> = service.readAll()

    override fun get(id: Int): Zal? = service.read(id)

    override fun delete(id: Int) = service.delete(id)

    override fun update(id: Int, entity: Zal) = service.update(id, entity)

    override fun add(entity: Zal) = service.add(entity)
}