package jetbrains.kotlin.course.alias.team

import jetbrains.kotlin.course.alias.util.Identifier
import jetbrains.kotlin.course.alias.util.IdentifierFactory
import org.springframework.stereotype.Service

@Service
class TeamService(private val identifierFactory: IdentifierFactory = IdentifierFactory()) {


    object TeamStorage : MutableMap<Identifier, Team> by mutableMapOf()

    fun generateTeamsForOneRound(teamsNumber: Int): List<Team> {
        val newTeams = mutableListOf<Team>()
        repeat(teamsNumber) {
            val id = identifierFactory.uniqueIdentifier()
            val team = Team(id)
            newTeams.add(team)
            TeamStorage[id] = team
        }
        return newTeams
    }
}
