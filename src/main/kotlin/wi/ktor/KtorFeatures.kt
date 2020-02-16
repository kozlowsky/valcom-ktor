package wi.ktor

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.content.TextContent
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.StatusPages
import io.ktor.gson.gson
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.withCharset
import io.ktor.response.respond
import org.slf4j.event.Level

fun Application.installFeatures() {
    install(CallLogging) {
        level = Level.INFO
    }

    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
        }
    }

    install(StatusPages) {
        status(HttpStatusCode.NotFound) {
            call.respond(
                    TextContent(
                            "${it.value} - Following path ${call.request.local.uri} does not exist",
                            ContentType.Text.Plain.withCharset(Charsets.UTF_8))
            )
        }
    }
}