import com.android3.siegertpclient.ui.base.BaseView

interface TeamContract {

    interface ITeamView : BaseView {
        
    }

    interface ITeamPresenter {

        fun onBackBtnClicked()

        fun onMemberBtnClicked()

        fun onTeamTournamentBtnClicked()

        fun checkIfAdmin(userId: String)
    }

    interface ITeamMembersPresenter {

    }

    interface ITeamTournamentsPresenter {

    }

    interface ITeamInvitationsPresenter {

    }
}