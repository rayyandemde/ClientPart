import com.android3.siegertpclient.ui.base.BaseView

interface CreateTournamentContract {

    interface ICreateTournamentView : BaseView {

        fun navigateToHomepageActivity()

        fun navigateToLoginActivity()

        fun navigateToTournamentActivity()

        fun showErrorOnTournamentName(message: String)

        fun showErrorOnLocation(message: String)

        fun showErrorOnTime(message: String)

        fun showErrorOnMaxPlayers(message: String)

        fun showErrorOnRegistrationTime(message: String)

        fun showErrorOnPrize(message: String)
    }

    interface ICreateTournamentPresenter {

        fun onBackBtnClicked()

        fun onCreateBtnClicked()

    }
}