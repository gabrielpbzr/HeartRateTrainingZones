package com.gabrielpbzr.heartratetrainingzones.web

import com.gabrielpbzr.heartratetrainingzones.domain.Gender
import com.gabrielpbzr.heartratetrainingzones.usecases.CalculateHeartRateTrainingZones
import io.javalin.Javalin;
import io.javalin.apibuilder.ApiBuilder.*
import io.javalin.plugin.rendering.template.JavalinVelocity
import org.apache.velocity.app.VelocityEngine
import org.slf4j.LoggerFactory
import java.lang.IllegalArgumentException
import java.time.LocalDate
import java.time.Period

class Application {
    fun run() {
        //initTemplateEngine()
        val logger = LoggerFactory.getLogger("HeartTrainingZonesApp")
        val app = Javalin.create() {
            javalinConfig -> javalinConfig.addStaticFiles("static")
        };

        app.routes {
            get("/") { ctx -> ctx.render("views/index.vm", mapOf("title" to "Início")) }
            get("/calcular") {ctx -> ctx.render("views/calcular.vm", mapOf("title" to "Calcular", "csrfToken" to ""))}
            post("/zonas") { ctx ->
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

    private fun initTemplateEngine() {
        val velocityEngine = VelocityEngine()
        velocityEngine.setProperty("velocimacro.library", "src/main/resources/views/main-layout.vm")
        velocityEngine.init()
        JavalinVelocity.configure(velocityEngine)
    }
}