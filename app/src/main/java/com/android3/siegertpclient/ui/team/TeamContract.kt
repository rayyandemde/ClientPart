import com.android3.siegertpclient.ui.base.BaseView

interface TeamContract {

    interface ITeamView : BaseView {

        fun showAdminFragment()

        fun showMemberFragment()

        fun showTeamTournamentsFragment()
    }

    interface ITeamPresenter {

        fun onBackBtnClicked()

        fun onMemberBtnClicked()

        fun onTeamTournamentBtnClicked()

        fun checkIfAdmin(userId: String)
    }
}