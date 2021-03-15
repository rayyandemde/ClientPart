import com.android3.siegertpclient.ui.base.BaseView

interface SettingsContract {

    interface ISettingView : BaseView {

        fun navigateToUserProfileActivity()

        fun navigateToLoginActivity()

        fun setTestUserText()
    }

    interface ISettingPresenter {

        fun onBackBtnClicked()

        fun onChangeLanguageSpinnerSelected()

        fun onSaveBtnClicked(
            changedUsername: String,
            changedForename: String,
            changedSurname: String
        )

        fun onLogoutTextClicked()
    }
}