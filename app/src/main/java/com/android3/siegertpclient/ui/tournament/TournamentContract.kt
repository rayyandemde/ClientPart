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

        fun navigateToHomepageActivity()
    }

    interface ITeamPresenter {
        fun initTournamentDetails()

        fun checkIfAdmin(userId: String)

        fun onBackBtnClicked()
    }
}