import com.android3.siegertpclient.ui.base.BaseView

interface TournamentContract {

    interface ITournamentView : BaseView {

        fun showTournamentDetailsFragment()

        fun showTournamentParticipantsFragment()

        fun showTournamentScheduleFragment()

        fun showResultFragment()

        fun showTournamentUpdatesFragment()

        fun navigateToHomepageActivity()
    }

    interface ITeamPresenter {

        fun checkIfAdmin(userId: String)

        fun checkAlreadyJoined(uerId: String)

        fun onBackBtnClicked()

        fun onTournamentDetailsTabClicked()

        fun onParticipantListTabClicked()

        fun onScheduleTabClicked()

        fun onStageSliderClicked()

        fun onMatchesSliderClicked()

        fun onTournamentUpdatesTabClicked()
    }
}