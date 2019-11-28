package com.gabrielpbzr.heartratetrainingzones.web

import com.gabrielpbzr.heartratetrainingzones.domain.Gender
import com.gabrielpbzr.heartratetrainingzones.usecases.CalculateHeartRateTrainingZones
import io.javalin.Javalin;
import io.javalin.apibuilder.ApiBuilder.*
import org.slf4j.LoggerFactory
import java.lang.IllegalArgumentException
import java.time.LocalDate

class Application {
    fun run() {
        val logger = LoggerFactory.getLogger("HeartTrainingZonesApp")
        val app = Javalin.create();

        app.routes {
            get("/") { ctx -> ctx.render("views/main-layout.vm") }

            get("/trainingzones") { ctx ->
                try {
                    val useCase = CalculateHeartRateTrainingZones()
                    val birthDate = LocalDate.parse(ctx.queryParam("birthdate"))
                    val gender = when (ctx.queryParam("gender")) {
                        "M" -> Gender.MALE
                        "F" -> Gender.FEMALE
                        else -> {
                            throw IllegalArgumentException("Gender unknown")
                        }
                    }
                    val trainingZones = useCase.calculateTrainingZonesForUser(birthDate, gender)
                    val params = mapOf("zones" to trainingZones, "title" to "Resultados")
                    //ctx.json(params);
                    ctx.render("views/trainingzones.vm", params)
                } catch (re : RuntimeException) {
                    ctx.res.sendError(400, re.message)
                } catch(e:Exception) {
                    logger.error(e.message)
                }

            }

            app.start(getDesignatedPort())
        }
    }

    private fun getDesignatedPort(): Int {
        if (!System.getenv("PORT").isNullOrEmpty()) {
            return Integer.parseInt(System.getenv("PORT"))
        }
        return 9000
    }
}