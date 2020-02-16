package wi.ktor

import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import wi.ktor.api.setupRoutes

fun main(args: Array<String>) {
    embeddedServer(Netty, 8069) {
        installFeatures()
        setupRoutes()
    }.start(wait = true)
}

