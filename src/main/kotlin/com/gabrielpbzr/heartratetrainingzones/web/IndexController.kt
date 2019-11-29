package com.gabrielpbzr.heartratetrainingzones.web

import io.javalin.http.Context

class IndexController {    
    fun renderIndexPage(ctx : Context) {
        ctx.render("views/index.vm", mapOf("title" to "Início"))
    }
}