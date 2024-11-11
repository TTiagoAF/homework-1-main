package jetbrains.kotlin.course.alias.results

import alias.JsTeam
import jetbrains.kotlin.course.alias.util.toGameResult
import org.springframework.web.bind.annotation.*

class GameJsResult : ArrayList<JsTeam>()

@RestController
@RequestMapping("/api/results/")
class GameResultsResource(val service: GameResultsService) {
    @CrossOrigin
    @PostMapping("/save")
    fun saveGameResults(@RequestBody result: GameJsResult) = service.saveGameResults(result.toGameResult())

    @CrossOrigin
    @GetMapping("/all")
    fun getAllGameResults() = service.getAllGameResults()
}
data class GameResult(
    val id: Int,
    val playerName: String,
    val score: Int,
    val date: String
)

data class Team(
    val id: Int,
    var points: Int,
    val name: String,
    val members: List<String>
)

object TeamService {
    val teamsStorage: MutableMap<Int, Team> = mutableMapOf()
}


