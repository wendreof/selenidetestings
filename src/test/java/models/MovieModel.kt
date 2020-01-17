package models

data class MovieModel(
        var title: String,
        var status: String,
        var year: String,
        var releaseDate: String,
        var cast: List<String>,
        var plot: String,
        var cover: String)

fun coverPath(): String {
    var executionPath = System.getProperty("user.dir")
    var os = System.getProperty("os.name")

    executionPath += when {
        os.contains("Windows") -> {
            "\\src\\main\\resources\\cover\\"
        }
        else -> {
            "/src/main/resources/cover/"
        }
    }
    return executionPath
}