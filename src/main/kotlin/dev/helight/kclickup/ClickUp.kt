package dev.helight.kclickup

class ClickUp {

    companion object {

        fun personal(apiToken: String, endpoint: Endpoint = Endpoint.Production): ClickUpClient {
            return PersonalClickUpClient(apiToken, endpoint)
        }

        fun combinedUrl(endpoint: Endpoint, apis: Apis, params: Map<String,String> = mapOf(), vararg format: String): String {
            return (endpoint.location + "/" + apis.location).format(*format) + when(params.isEmpty()) {
                true -> ""
                false -> "?" + params.map { it.key + "=" + it.value }.joinToString("&")
            }
        }
    }

    enum class Endpoint(var location: String) {
        Production("https://api.clickup.com/api/v2"),
        Mock("https://private-anon-d220f54e2c-clickup20.apiary-mock.com/api/v2"),
        DebuggingProxy("https://private-anon-d220f54e2c-clickup20.apiary-proxy.com/api/v2")
    }

    enum class Apis(vararg parts: String) {
        Workspace("team"),
        Spaces("team", "%s", "space"),
        Space("space", "%s"),
        Folders("space", "%s", "folder"),
        Lists("folder", "%s", "list"),
        List("list", "%s"),
        FolderlessList("space", "%s", "list"),
        Tasks("list", "%s", "task"),
        WorkspaceTasks("team", "%s", "task"),
        Task("task", "%s"),
        Goals("team", "%s", "goal"),
        Goal("goal", "%s"),
        KeyResults("goal", "%s", "key_result"),
        KeyResult("key_result", "%s");

        val location = parts.joinToString("/") { it }

    }

}