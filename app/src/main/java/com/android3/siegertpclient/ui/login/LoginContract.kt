import com.android3.siegertpclient.ui.base.BaseView

interface LoginContract {

    interface ILoginView : BaseView {

        fun showIncompleteInput()

        fun showErrorOnEmail()

        fun navigateToHomepageActivity()

        fun navigateToForgotPasswordActivity()

        fun navigateToRegisterActivity()
    }

    interface ILoginPresenter {

        fun onLoginBtnClicked(email: String, password: String)

        fun onForgotPasswordTextClicked()

        fun onRegisterTextClicked()
    }
}