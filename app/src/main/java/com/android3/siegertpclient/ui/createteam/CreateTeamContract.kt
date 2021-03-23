import com.android3.siegertpclient.ui.base.BaseView

interface CreateTeamContract {
    interface ICreateTeamView : BaseView {
        fun showIncompleteInput()

        fun navigateToHomepageActivity()

        fun navigateToTeamActivity()
    }

    interface ICreateTeamPresenter {
        fun onCreateBtnClicked(teamName: String, teamPassword: String)
    }
}