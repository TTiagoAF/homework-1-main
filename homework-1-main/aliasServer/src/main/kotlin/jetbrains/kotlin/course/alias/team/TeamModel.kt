package jetbrains.kotlin.course.alias.team

data class Team(
    val id: Int,
    var points: Int,
    val name: String,
    val members: List<String>
)

data class JsTeam(
    val id: Int,
    val points: Int,
    val name: String
)
