
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.ui.base.BaseView

interface HomepageContract {

    interface IHomepageView : BaseView {

        fun navigateToInvitationActivity()

        fun navigateToUserActivity()

        fun navigateToCreateTournamentActivity()

        fun showFeedFragment()

        fun showJoinTeamFragment()

        fun showSearchResult(tournaments: List<Tournament>)
    }

    interface IHomepagePresenter {

        fun onMailBtnClicked()

        fun onHomeBtnClicked()

        fun onCreateTournamentBtnClicked()

        fun onCreateTeamBtnClicked()

        fun onJoinTeamBtnClicked()

        fun onUserBtnClicked()

        fun onTournamentOverviewClicked()

        fun loadTournamentOverviews()
    }
}