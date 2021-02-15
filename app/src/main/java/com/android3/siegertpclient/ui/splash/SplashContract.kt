import com.android3.siegertpclient.ui.base.BaseView

interface SplashContract {

    interface ISplashView : BaseView {

        fun navigateToLoginActivity()

        fun navigateToHomepageActivity()
    }

    interface ISplashPresenter {

    }
}