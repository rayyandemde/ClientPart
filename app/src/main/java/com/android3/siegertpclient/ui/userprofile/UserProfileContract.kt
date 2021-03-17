import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.ui.base.BaseView

interface UserProfileContract {

    interface IUserProfileView : BaseView {

        fun showMyTeams(myTeams: List<Team>?)

        fun navigateToHomepageActivity()

        fun navigateToSettingActivity()

        fun navigateToTeamActivity()
    }

    interface IUserProfilePresenter {

        fun userTeamClicked(position: Int)

        fun onSettingBtnClicked()

        fun onHomeBtnClicked()

        fun onTournamentsRefresh()

        fun onTeamsRefresh()
    }
}