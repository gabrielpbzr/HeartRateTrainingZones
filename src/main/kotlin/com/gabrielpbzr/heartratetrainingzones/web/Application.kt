package com.gabrielpbzr.heartratetrainingzones.web

import com.gabrielpbzr.heartratetrainingzones.domain.Gender
import com.gabrielpbzr.heartratetrainingzones.usecases.CalculateHeartRateTrainingZones
import io.javalin.Javalin;
import io.javalin.apibuilder.ApiBuilder.*
import io.javalin.http.Context
import io.javalin.plugin.rendering.template.JavalinVelocity
import org.apache.velocity.app.VelocityEngine
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.lang.IllegalArgumentException
import java.time.LocalDate
import java.time.Period

class Application {
    fun run() {
        val app = Javalin.create() {
            javalinConfig -> javalinConfig.addStaticFiles("static")
        };

        val trainingZonesController = TrainingZonesController()
        val indexController = IndexController()

        app.routes {
            get("/", indexController::renderIndexPage)
            get("/calcular", trainingZonesController::renderFormTrainingZones)
            post("/zonas", trainingZonesController::getTrainingZones)

            app.before(this::registerComponents)
            app.start(getDesignatedPort())
        }
    }

    private fun getDesignatedPort(): Int {
        if (!System.getenv("PORT").isNullOrEmpty()) {
            return Integer.parseInt(System.getenv("PORT"))
        }
        return 9000
    }

    private fun registerComponents(ctx : Context) {
        val logger = LoggerFactory.getLogger("HeartTrainingZonesApp")
        ctx.register(Logger::class.java, logger)
    }
}
