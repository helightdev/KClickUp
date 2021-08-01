package dev.helight.kclickup.test

import dev.helight.kclickup.ClickUp

fun main() {
    val client = ClickUp.personal(System.getenv("CLICKUP_TOKEN"))
}
