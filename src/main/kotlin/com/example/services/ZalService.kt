package com.example.services




import com.example.models.Seans
import com.example.models.Zal

class ZalService(zals: MutableList<Zal> = mutableListOf()): CRUDService<Zal>(zals){

    init {

        list.add(Zal(1, "крутой"))

    }

    override fun add(entity: Zal) {
        list.add(entity)
    }

    override fun update(id: Int, entity: Zal) {
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


    override fun readAll(): List<Zal> = list

}