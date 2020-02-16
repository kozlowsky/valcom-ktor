package wi.ktor.api.path

import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route
import wi.ktor.model.Author
import java.util.*

fun Route.authorRoutes() {
    route("/author") {
        get("/{name}") {
            call.respond(Author(UUID.randomUUID(), call.parameters["name"] as String))
        }
    }
}