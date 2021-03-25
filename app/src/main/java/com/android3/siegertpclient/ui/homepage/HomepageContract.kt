import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.ui.base.BaseView

interface HomepageContract {

    interface IHomepageView : BaseView {

        fun showFeed(feed: List<Tournament>?)

        fun showSuccess(message: String)

        fun showIncompleteInput()

        fun navigateToInvitationActivity()

        fun navigateToUserActivity()

        fun navigateToCreateTournamentActivity()

        fun navigateToCreateTeamActivity()

        fun navigateToTournamentActivity()
    }

    interface IHomepagePresenter {

        fun onInvitationBtnClicked()

        fun onCreateTournamentBtnClicked()

        fun onCreateTeamBtnClicked()

        fun onUserBtnClicked()

        fun onFeedRefresh()

        fun onJoinTeamBtnClicked(teamName: String, password: String)

        fun onTournamentOverviewClicked(position : Int)
    }
}