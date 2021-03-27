import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.ui.base.BaseView

interface InvitationContract {

    interface IInvitationView : BaseView {

        fun showTournamentInvitation(invitations: List<Invitation>)

        fun navigateToHomepageActivity()

        fun navigateToTournamentActivity()
    }

    interface IInvitationPresenter {
        fun onBackBtnClicked()

        fun onInvitationRefresh()

        fun onAcceptBtnClicked(tournament: Tournament)

        fun onDeclineBtnClicked(tournament: Tournament)

        fun onInvitationItemClicked(position : Int)
    }
}