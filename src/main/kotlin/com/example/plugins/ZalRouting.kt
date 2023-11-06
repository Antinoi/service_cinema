package com.example.plugins
import com.example.controllers.ZalController
import com.example.models.Zal
import com.example.services.ZalService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.doublereceive.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureZalRouting() {

    val zalController = ZalController(ZalService())

    routing {
        route("/zal/readall"){
            get{


                call.parameters["id"]?.let { id->
                    zalController.get(id.toInt())?.let {
                        call.respond(HttpStatusCode.OK,
                            zalController.get(id.toInt())!!)
                    }?:call.respond(HttpStatusCode.NoContent)
                } ?: call.respond(HttpStatusCode.OK,
                    zalController.getAll())
            }
            post("/zal"){

                val zal = call.receive<Zal>()
                zalController.get(zal.id)?.let {
                    call.respond(HttpStatusCode.Conflict)
                    return@post
                }
                zalController.add(zal)
                call.respond(HttpStatusCode.Created,"Data created")
            }
        }
    }
}