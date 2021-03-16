import com.android3.siegertpclient.ui.base.BaseView

interface CreateTournamentContract {

    interface ICreateTournamentView : BaseView {

        fun navigateToHomepageActivity()

        fun navigateToTournamentActivity()

        fun showErrorOnTournamentName(message: String)

        fun showErrorOnLocation(message: String)

        fun showErrorOnTime(message: String)

        fun showErrorOnMaxPlayers(message: String)

        fun showErrorOnRegistrationTime(message: String)
    }

    interface ICreateTournamentPresenter {

        fun onBackBtnClicked()

        fun onCreateBtnClicked(
            name: String,
            typeOfGame: String,
            matchType: String,
            tournamentType: String,
            participantForm: String,
            registrationDeadline: String,
            startTime: String,
            endTime: String,
            location: String,
            maxParticipantNumber: Int
        )
    }
}