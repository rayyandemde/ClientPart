import com.android3.siegertpclient.ui.base.BaseView

interface SettingsContract {

    interface ISettingView : BaseView {
        fun setCurrentUserEt(username: String, forename: String, surname: String)

        fun navigateToUserProfileActivity()

        fun navigateToLoginActivity()
    }

    interface ISettingPresenter {
        fun initCurrentUserEt()

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