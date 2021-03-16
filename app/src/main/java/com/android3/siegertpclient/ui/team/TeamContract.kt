import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.ui.base.BaseView

interface TeamContract {

    interface ITeamView : BaseView {
        fun navigateToTournamentActivity()

        fun showMembers(teamMembers: List<User>)
    }

    interface ITeamPresenter {
        fun onMembersRefresh()

        fun onTournamentsRefresh()

        fun onInvitationRefresh()

        fun onAddBtnClicked()

        fun onHomeBtnClicked()
    }
}