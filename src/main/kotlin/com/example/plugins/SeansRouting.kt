package com.example.plugins


import com.example.controllers.SeansController
import com.example.models.Seans
import com.example.services.SeansService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.doublereceive.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureSeansRouting() {

    val seansController = SeansController(SeansService())

    routing {
        route("/seans/readall"){
            get{


                call.parameters["id"]?.let { id->
                    seansController.get(id.toInt())?.let {
                        call.respond(HttpStatusCode.OK,
                            seansController.get(id.toInt())!!)
                    }?:call.respond(HttpStatusCode.NoContent)
                } ?: call.respond(HttpStatusCode.OK,
                    seansController.getAll())
            }
            post("/seans/add"){

                val seans = call.receive<Seans>()
                seansController.get(seans.id)?.let {
                    call.respond(HttpStatusCode.Conflict)
                    return@post
                }
                seansController.add(seans)
                call.respond(HttpStatusCode.Created,"Seans created")
            }
        }
    }
}