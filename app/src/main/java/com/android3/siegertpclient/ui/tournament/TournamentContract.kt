import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.data.tournament.Game
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.ui.base.BaseView

interface TournamentContract {

    interface ITournamentView : BaseView {
        fun showCurrentTournamentDetails(
            tournamentName: String,
            typeOfGame: String,
            matchType: String,
            tournamentType: String,
            participantForm: String,
            registrationDeadline: String,
            startDate: String,
            endDate: String,
            location: String,
            maxPlayer: Int
        )

        fun disableEdits()

        fun showIncompleteInput()

        fun initParticipantAdapter(participantForm: String)

        fun showSingleParticipants(participants: List<User>?)

        fun showTeamParticipants(participants: List<Team>?)

        fun showSchedules(schedules: List<Game>?)

        fun showGames(games: List<Game>?)

        fun navigateToHomepageActivity()
    }

    interface ITeamPresenter {
        fun initTournamentDetails()

        fun checkEditRights()

        fun onUpdateBtnClicked(
            tournamentName: String,
            registrationDeadline: String,
            startTime: String,
            endTime: String,
            location: String,
        )

        fun onHomeBtnClicked()

        fun initParticipantAdapter()

        fun onParticipantRefresh()

        fun onAddParticipantBtnClicked()

        fun onScheduleRefresh()

        fun onGameRefresh()

        fun checkCreateGameRights()

        fun onCreateGameBtnClicked()

        fun onCancelTournamentBtnClicked()

        fun isAdmin() : Boolean
    }
}