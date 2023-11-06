package com.example.services

import com.example.models.Film

class FilmService(films: MutableList<Film> = mutableListOf()): CRUDService<Film>(films) {
    init {
        for(i in 1 .. 100){
            list.add(Film(i,"testfilm $i"))
        }
    }

    override fun add(entity: Film){
        list.add(entity)
    }

    override fun readAll(): List<Film> = list

    override fun read(id: Int) = list.find { it.id == id }

    override fun update(id: Int, entity: Film){
        if(list.any { it.id == id }){
            val index = list.indexOfFirst {
                it.id == id
            }
            list[index] = entity
        }
    }

    override fun delete(id: Int){
        if(list.any { it.id == id }){
            list.removeIf { it.id == id }
        }
    }
}