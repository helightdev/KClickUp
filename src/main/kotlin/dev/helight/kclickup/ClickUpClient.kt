package dev.helight.kclickup

import Extensions.executeAndParse
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dev.helight.kclickup.models.*
import dev.helight.kclickup.models.requests.CreateKeyResultRequest
import dev.helight.kclickup.models.requests.UpdateKeyResultRequest
import dev.helight.kclickup.models.requests.TaskCreateRequest
import dev.helight.kclickup.models.requests.TaskUpdateRequest
import dev.helight.kclickup.models.responses.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody

interface ClickUpClient {

    val client: OkHttpClient
    val endpoint: ClickUp.Endpoint


    fun getWorkspaces(): List<Workspace> = Request.Builder()
        .get()
        .url(ClickUp.combinedUrl(endpoint, ClickUp.Apis.Workspace))
        .build()
        .executeAndParse<WorkspaceList>(client).teams

    fun getSpaces(workspaceId: Int): List<Space> = Request.Builder()
        .get()
        .url(ClickUp.combinedUrl(endpoint, ClickUp.Apis.Spaces, mapOf(), workspaceId.toString()))
        .build()
        .executeAndParse<SpaceList>(client).spaces

    fun getSpace(id: String): Space = Request.Builder()
        .get()
        .url(ClickUp.combinedUrl(endpoint, ClickUp.Apis.Space, mapOf(), id))
        .build()
        .executeAndParse(client)

    fun getFolders(spaceId: String): List<Folder> = Request.Builder()
        .get()
        .url(ClickUp.combinedUrl(endpoint, ClickUp.Apis.Folders, mapOf(), spaceId))
        .build()
        .executeAndParse<FolderList>(client).folders

    fun getList(id: Int): CList = Request.Builder()
        .get()
        .url(ClickUp.combinedUrl(endpoint, ClickUp.Apis.List, mapOf(), id.toString()))
        .build()
        .executeAndParse(client)

    fun getLists(folderId: String): List<CList> = Request.Builder()
        .get()
        .url(ClickUp.combinedUrl(endpoint, ClickUp.Apis.Lists, mapOf(), folderId))
        .build()
        .executeAndParse<ListList>(client).lists

    fun getFolderlessLists(workspaceId: String): List<CList> = Request.Builder()
        .get()
        .url(ClickUp.combinedUrl(endpoint, ClickUp.Apis.FolderlessList, mapOf(), workspaceId.toString()))
        .build()
        .executeAndParse<ListList>(client).lists


    fun getTasksPaginated(listId: Int, subtasks: Boolean = false): List<Task> {
        val result = mutableListOf<Task>()
        var next = true
        var index = 0
        while (next) {
            val cur = getTasks(listId, page = index, subtasks = subtasks)
            result.addAll(cur)
            if (cur.size < 100) next = false
            index++
        }
        return result
    }

    fun getTasks(listId: Int, page: Int = 0, subtasks: Boolean = false): List<Task> = Request.Builder()
        .get()
        .url(ClickUp.combinedUrl(endpoint, ClickUp.Apis.Tasks, mapOf(
            "page" to page.toString(),
            "subtasks" to subtasks.toString()
        ), listId.toString()))
        .build()
        .executeAndParse<TaskList>(client).tasks

    fun getAllTasks(workspaceId: String, page: Int = 0, subtasks: Boolean = false): List<Task> = Request.Builder()
        .get()
        .url(ClickUp.combinedUrl(endpoint, ClickUp.Apis.WorkspaceTasks, mapOf(
            "page" to page.toString(),
            "subtasks" to subtasks.toString()
        ), workspaceId))
        .build()
        .executeAndParse<TaskList>(client).tasks

    fun getAllTasksPaginated(workspaceId: String, subtasks: Boolean = false): List<Task> {
        val result = mutableListOf<Task>()
        var next = true
        var index = 0
        while (next) {
            val cur = getAllTasks(workspaceId, page = index, subtasks = subtasks)
            result.addAll(cur)
            if (cur.size < 100) next = false
            index++
        }
        return result
    }

    fun createTask(listId: Int, taskCreateRequest: TaskCreateRequest): Task = Request.Builder()
        .post(gson.toJson(taskCreateRequest).toRequestBody("application/json".toMediaType()))
        .url(ClickUp.combinedUrl(endpoint, ClickUp.Apis.Tasks, mapOf(), listId.toString()))
        .build()
        .executeAndParse(client)

    fun updateTask(id: String, taskUpdateRequest: TaskUpdateRequest): Task = Request.Builder()
        .put(gson.toJson(taskUpdateRequest).toRequestBody("application/json".toMediaType()))
        .url(ClickUp.combinedUrl(endpoint, ClickUp.Apis.Task, mapOf(), id))
        .build()
        .executeAndParse(client)

    fun deleteTask(id: String) = client.newCall(Request.Builder()
        .delete()
        .url(ClickUp.combinedUrl(endpoint, ClickUp.Apis.Task, mapOf(), id))
        .build()).execute()

    fun getGoals(workspaceId: String): List<Goal> = Request.Builder()
        .get()
        .url(ClickUp.combinedUrl(endpoint, ClickUp.Apis.Goals, mapOf(), workspaceId))
        .build()
        .executeAndParse<GoalsGet>(client).goals.map { it.renew(this) }

    fun getGoal(id: String) = Request.Builder()
        .get()
        .url(ClickUp.combinedUrl(endpoint, ClickUp.Apis.Goal, mapOf(), id))
        .build()
        .executeAndParse<SingleGoalGet>(client).goal

    fun getKeyResults(goalId: String) = getGoal(goalId).keyResults!!

    fun createKeyResult(goalId: String, createKeyResultRequest: CreateKeyResultRequest) =    Request.Builder()
        .post(gson.toJson(createKeyResultRequest).toRequestBody("application/json".toMediaType()))
        .url(ClickUp.combinedUrl(endpoint, ClickUp.Apis.KeyResults, mapOf(), goalId))
        .build()
        .executeAndParse<SingleKeyResultGet>(client).keyResult

    fun updateKeyResult(id: String, editKeyResultRequest: UpdateKeyResultRequest) = client.newCall(
        Request.Builder()
            .put(gson.toJson(editKeyResultRequest).toRequestBody("application/json".toMediaType()))
            .url(ClickUp.combinedUrl(endpoint, ClickUp.Apis.KeyResult, mapOf(), id))
            .build()
    ).execute()

    fun deleteKeyResult(id: String) = client.newCall(
        Request.Builder()
            .delete()
            .url(ClickUp.combinedUrl(endpoint, ClickUp.Apis.KeyResult, mapOf(), id))
            .build()
    ).execute()


    companion object {
        val gson: Gson = GsonBuilder().create()
    }

}