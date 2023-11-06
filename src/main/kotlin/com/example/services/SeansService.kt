package com.example.services

import com.example.models.Film
import com.example.models.Seans

class SeansService(seanses: MutableList<Seans> = mutableListOf()): CRUDService<Seans>(seanses){

    init {

            list.add(Seans(1,1,1,1,350))

    }

    override fun add(entity: Seans) {
        list.add(entity)
    }

    override fun update(id: Int, entity: Seans) {
        if(list.any { it.id == id }){
            val index = list.indexOfFirst {
                it.id == id
            }
            list[index] = entity
        }
    }

    override fun delete(id: Int) {
        if(list.any { it.id == id }){
            list.removeIf { it.id == id }
        }
    }

    override fun read(id: Int) = list.find { it.id == id }


    override fun readAll(): List<Seans> = list

}