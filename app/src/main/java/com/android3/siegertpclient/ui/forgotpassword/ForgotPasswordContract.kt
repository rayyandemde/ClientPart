import com.android3.siegertpclient.ui.base.BaseView

interface ForgotPasswordContract {

    interface IForgotPasswordView : BaseView {

        fun showErrorOnEmail()

        fun showSuccess()

        fun navigateToLoginActivity()
    }

    interface IForgotPasswordPresenter {

        fun onBackBtnClicked()

        fun onSendBtnClicked(email: String)
    }
}