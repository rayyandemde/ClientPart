import com.android3.siegertpclient.ui.base.BaseView

interface CreateTeamContract {

    interface ICreateTeamView : BaseView {

        fun showErrorOnPassword(message: String)

        fun navigateToHomepageActivity()

        fun navigateToTeamActivity()
    }

    interface ICreateTeamPresenter {

        fun onBackBtnClicked()

        fun onCreateBtnClicked()
    }
}