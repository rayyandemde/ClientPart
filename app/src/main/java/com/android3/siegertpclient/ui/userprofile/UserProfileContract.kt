import com.android3.siegertpclient.ui.base.BaseView

interface UserProfileContract {

    interface IUserProfileView : BaseView {

        fun showMyTournamentsFragment()

        fun showMyTeamsFragment()

        fun navigateToHomepageActivity()

        fun navigateToSettingActivity()
    }

    interface IUserProfilePresenter {

        fun onSettingBtnClicked()

        fun onHomeBtnClicked()

        fun onMyTournamentBtnClicked()

        fun onMyTeamsBtnClicked()

        fun getTournaments()

        fun getTeams()
    }
}