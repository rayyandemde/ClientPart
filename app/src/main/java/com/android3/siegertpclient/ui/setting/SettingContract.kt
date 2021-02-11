import com.android3.siegertpclient.ui.base.BaseView

interface SettingContract {

    interface IInvitationView : BaseView {

        fun navigateToUserProfileActivity()

        fun showMessageOnPage(message: String)

        fun navigateToLoginActivity()
    }

    interface IInvitationPresenter {

        fun onBackBtnClicked()

        fun onSaveBtnClicked()

        fun onLogoutBtnClicked()
    }
}