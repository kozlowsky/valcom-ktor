package wi.ktor.api

import io.ktor.application.Application
import io.ktor.routing.routing
import wi.ktor.api.path.authorRoutes
import wi.ktor.api.path.songRoutes


fun Application.setupRoutes() {
    routing {
        songRoutes()
        authorRoutes()
    }
}