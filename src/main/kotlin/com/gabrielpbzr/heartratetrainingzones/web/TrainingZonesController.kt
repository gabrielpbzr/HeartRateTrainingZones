package com.gabrielpbzr.heartratetrainingzones.web

import com.gabrielpbzr.heartratetrainingzones.domain.Gender
import com.gabrielpbzr.heartratetrainingzones.usecases.CalculateHeartRateTrainingZones
import io.javalin.http.Context
import io.javalin.http.Handler
import org.slf4j.Logger
import java.lang.IllegalArgumentException
import java.time.LocalDate
import java.time.Period

class TrainingZonesController {

    fun renderFormTrainingZones(ctx : Context) {
        ctx.render("views/calcular.vm", mapOf("title" to "Calcular", "csrfToken" to ""))
    }

    fun getTrainingZones(ctx : Context) {
        val logger = ctx.attribute<Logger>("logger")
        try {
            val useCase = CalculateHeartRateTrainingZones()
            val birthDate = LocalDate.parse(ctx.formParam("birthdate"))
            val gender = when (ctx.formParam("gender")) {
                "M" -> Gender.MALE
                "F" -> Gender.FEMALE
                else -> {
                    throw IllegalArgumentException("Gender unknown")
                }
            }

            val age = Period.between(birthDate, LocalDate.now()).years
            val trainingZones = useCase.calculateTrainingZonesForUser(birthDate, gender)
            val params = mapOf("zones" to trainingZones, "title" to "Resultados", "age" to age, "gender" to ctx.formParam("gender"))
            //ctx.json(params);
            ctx.render("views/trainingzones.vm", params)
        } catch (re : RuntimeException) {
            ctx.res.sendError(400, re.message)
        } catch(e:Exception) {
            logger?.error(e.message)
            ctx.res.sendError(503)
        }
    }
}