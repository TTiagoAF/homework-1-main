package jetbrains.kotlin.course.alias.team

import org.springframework.stereotype.Service

@Service
class TeamService {

    object TeamStorage : ArrayList<Team>()

    fun generateTeamsForOneRound(teamsNumber: Int): List<Team> = TODO()
}
