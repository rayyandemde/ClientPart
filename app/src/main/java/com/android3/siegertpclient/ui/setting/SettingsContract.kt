import com.android3.siegertpclient.ui.base.BaseView

interface SettingsContract {

    interface ISettingView : BaseView {

        fun navigateToUserProfileActivity()

        fun navigateToLoginActivity()
    }

    interface ISettingPresenter {

        fun onBackBtnClicked()

        fun onChangeLanguageBtnClicked()

        fun onSaveBtnClicked(
            changedUsername: String,
            changedForename: String,
            changedSurname: String
        )

        fun onLogoutBtnClicked()
    }
}