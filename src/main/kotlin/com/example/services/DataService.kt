package com.example.services

import com.example.models.Data


class DataService(datas: MutableList<Data> = mutableListOf()): CRUDService<Data>(datas) {
    init {

        for(i in 1 .. 100) {

                list.add(Data(i, i, Pair(i, i)))


        }

    }

    override fun add(entity: Data){
        list.add(entity)
    }

    override fun readAll(): List<Data> = list

    override fun read(id: Int) = list.find { it.id == id }

    override fun update(id: Int, entity: Data){
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