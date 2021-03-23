import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.ui.base.BaseView

interface HomepageContract {

    interface IHomepageView : BaseView {

        fun showFeed(feed: List<Tournament>?)

        fun navigateToInvitationActivity()

        fun navigateToUserActivity()

        fun navigateToCreateTournamentActivity()

        fun navigateToCreateTeamActivity()

        fun navigateToTournamentActivity()

        //Open tournament feature will not be implemented
        fun showSearchResult(tournaments: List<Tournament>)
    }

    interface IHomepagePresenter {

        fun onInvitationBtnClicked()

        fun onCreateTournamentBtnClicked()

        fun onCreateTeamBtnClicked()

        fun onUserBtnClicked()

        fun onFeedRefresh()

        fun onJoinTeamBtnClicked()
    }
}