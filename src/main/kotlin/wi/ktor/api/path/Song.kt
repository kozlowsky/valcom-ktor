package wi.ktor.api.path

import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route
import wi.ktor.model.Song
import java.util.*

fun Route.songRoutes() {
    route("/song") {
        get("/{name}") {
            val song = Song(UUID.randomUUID(), call.parameters["name"] as String)
            call.respond(song)
        }
    }
}