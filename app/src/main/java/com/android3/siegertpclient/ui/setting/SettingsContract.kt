import com.android3.siegertpclient.ui.base.BaseView

interface SettingsContract {

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