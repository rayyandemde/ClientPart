import com.android3.siegertpclient.ui.base.BaseView

interface SettingsContract {

    interface ISettingView : BaseView {
        fun setCurrentUserEt()

        fun showSuccessful()

        fun navigateToUserProfileActivity()

        fun navigateToLoginActivity()
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