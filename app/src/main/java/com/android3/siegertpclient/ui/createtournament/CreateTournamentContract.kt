import com.android3.siegertpclient.ui.base.BaseView

interface CreateTournamentContract {

    interface ICreateTournamentView : BaseView {
        fun showIncompleteInput()

        fun navigateToHomepageActivity()

        fun navigateToTournamentActivity()
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