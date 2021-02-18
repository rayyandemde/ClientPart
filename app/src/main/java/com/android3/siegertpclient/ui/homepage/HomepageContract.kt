import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.ui.base.BaseView

interface HomepageContract {

    interface IHomepageView : BaseView {

        fun navigateToInvitationActivity()

        fun navigateToUserActivity()

        fun navigateToCreateTournamentActivity()

        fun navigateToCreateTeamActivity()

        //Will not be Implemented
        fun showFeedFragment()

        //Will not be implemenetd
        fun showJoinTeamFragment()

        //Open tournament feature will not be implemented
        fun showSearchResult(tournaments: List<Tournament>)
    }

    interface IHomepagePresenter {

        fun onMailBtnClicked()

        //Will not be implemented
        fun onHomeBtnClicked()

        fun onCreateTournamentBtnClicked()

        fun onCreateTeamBtnClicked()

        //Will not be implemented
        fun onJoinTeamBtnClicked()

        fun onUserBtnClicked()

        fun onTournamentOverviewClicked()

        fun loadTournamentOverviews()
    }
}