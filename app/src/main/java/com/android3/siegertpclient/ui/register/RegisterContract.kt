import com.android3.siegertpclient.ui.base.BaseView

interface RegisterContract {

    interface IRegisterView : BaseView {

        fun showIncompleteInput()

        fun showErrorOnEmail()

        fun showErrorOnPassword()

        fun showErrorOnUsername()

        fun navigateToHomepageActivity(userId: String, token: String)

        fun navigateToLoginActivity()
    }

    interface IRegisterPresenter {

        fun onRegisterBtnClicked(
            email: String, password: String, retypePassword: String, surname: String,
            forename: String, username: String
        )

        fun onLoginTxtClicked()
    }
}