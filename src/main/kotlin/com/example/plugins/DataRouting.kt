package com.example.plugins


import com.example.controllers.DataController
import com.example.models.Data
import com.example.services.DataService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.doublereceive.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureDataRouting() {

    val dataController = DataController(DataService())

    routing {
        route("/data"){
            get{

                call.parameters["id"]?.let { id->
                    dataController.get(id.toInt())?.let {
                        call.respond(HttpStatusCode.OK,
                            dataController.get(id.toInt())!!)
                    }?:call.respond(HttpStatusCode.NoContent)
                } ?: call.respond(HttpStatusCode.OK,
                    dataController.getAll())
            }
            post("/data"){

                val data = call.receive<Data>()
                dataController.get(data.id)?.let {
                    call.respond(HttpStatusCode.Conflict)
                    return@post
                }
                dataController.add(data)
                call.respond(HttpStatusCode.Created,"Data created")
            }
        }
    }
}