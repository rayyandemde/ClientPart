import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.ui.base.BaseView

interface InvitationContract {

    interface IInvitationView : BaseView {

        fun showTournamentInvitation(tournaments: List<Tournament>)

        fun navigateToHomepageActivity()
    }

    interface IInvitationPresenter {
        fun onBackBtnClicked()

        fun onInvitationRefresh()

        fun onAcceptBtnClicked(tournament: Tournament)

        fun onDeclineBtnClicked(tournament: Tournament)
    }
}