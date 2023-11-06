package com.example.controllers

import com.example.models.Film
import com.example.services.FilmService


class FilmController(filmService: FilmService): Controller<Film>(filmService) {
    override fun getAll(): List<Film> = service.readAll()

    override fun get(id: Int): Film? = service.read(id)

    override fun delete(id: Int) = service.delete(id)

    override fun update(id: Int, entity: Film) = service.update(id, entity)

    override fun add(entity: Film) = service.add(entity)
}