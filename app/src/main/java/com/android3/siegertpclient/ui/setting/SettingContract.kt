import com.android3.siegertpclient.ui.base.BaseView

interface SettingContract {

    interface ISettingView : BaseView {

        fun navigateToUserProfileActivity()

        fun showMessageOnPage(message: String)

        fun navigateToLoginActivity()
    }

    interface ISettingPresenter {

        fun onBackBtnClicked()

        fun onSaveBtnClicked()

        fun onLogoutBtnClicked()
    }
}