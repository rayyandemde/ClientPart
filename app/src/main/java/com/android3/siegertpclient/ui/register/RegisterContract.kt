import com.android3.siegertpclient.ui.base.BaseView

interface RegisterContract {

    interface IRegisterView : BaseView {

        fun showErrorOnEmail(message: String)

        fun showErrorOnPassword(message: String)

        fun showErrorOnUsername(message: String)

        fun navigateToHomepageActivity()

        fun navigateToLoginActivity()
    }

    interface IRegisterPresenter {

        fun onRegisterBtnClicked(email: String, password: String, username: String)

        fun onBackBtnClicked()
    }
}