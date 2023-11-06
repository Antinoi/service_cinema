package com.example.plugins

import com.example.controllers.FilmController
import com.example.models.Film
import com.example.services.FilmService
import com.example.controllers.DataController
import com.example.models.Data
import com.example.services.DataService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.doublereceive.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    val filmController = FilmController(FilmService())
    val dataController = DataController(DataService())
    install(DoubleReceive)
    routing {
        route("/film/readall"){
            get{


                call.parameters["id"]?.let { id->
                    filmController.get(id.toInt())?.let {
                        call.respond(HttpStatusCode.OK,
                            filmController.get(id.toInt())!!)
                    }?:call.respond(HttpStatusCode.NoContent)
                } ?: call.respond(HttpStatusCode.OK,
                            filmController.getAll())
            }
            post("/film/add"){
                val film = call.receive<Film>()
                    filmController.get(film.id)?.let {
                        call.respond(HttpStatusCode.Conflict)
                        return@post
                    }
                    filmController.add(film)
                    call.respond(HttpStatusCode.Created,"Film created")


            }
        }
    }
}
