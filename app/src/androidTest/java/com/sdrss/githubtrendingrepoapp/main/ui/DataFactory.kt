package com.sdrss.githubtrendingrepoapp.main.ui

import com.sdrss.githubtrendingrepoapp.data.remote.response.RepositoriesResponse
import java.util.concurrent.ThreadLocalRandom

object DataFactory {

    fun singleRepositoryData(): RepositoriesResponse =
        RepositoriesResponse(
            author = "Author ${randomInt()}",
            name = "Name ${randomInt()}",
            stars = randomInt() * 2,
            forks = randomInt() * 2,
            language = getLanguage()
        )

    private fun randomInt(): Int = ThreadLocalRandom.current().nextInt(0, 1000 + 1)

    private fun getLanguage(): String? {
        val languages = arrayListOf<String?>(
            "Java",
            "Kotlin",
            null,
            "JavaScript",
            "Python",
            null,
            "Go",
            "C",
            "Dart",
            null,
            "C++"
        )

        languages.shuffle()
        return languages[0]
    }
}