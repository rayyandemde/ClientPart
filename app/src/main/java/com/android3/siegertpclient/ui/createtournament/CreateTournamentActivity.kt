package com.android3.siegertpclient.ui.createtournament

import android.content.Intent
import android.os.Bundle
import android.widget.*
import com.android3.siegertpclient.R
import com.android3.siegertpclient.ui.base.BaseActivity
import com.android3.siegertpclient.ui.forgotpassword.ForgotPasswordPresenter
import com.android3.siegertpclient.ui.homepage.HomepageActivity
import com.android3.siegertpclient.ui.login.LoginActivity
import com.android3.siegertpclient.ui.register.RegisterActivity
import com.android3.siegertpclient.ui.tournament.TournamentActivity

class CreateTournamentActivity : BaseActivity(), CreateTournamentContract.ICreateTournamentView{

    private val createTournamentPresenter: CreateTournamentPresenter = CreateTournamentPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_createtournament)

        val NameEt: EditText = findViewById(R.id.Name)

        val DateEt: EditText = findViewById(R.id.Date)

        val MaxPlayerEt: EditText = findViewById(R.id.MaxPlayer)

        val LocationEt: EditText = findViewById(R.id.Location)

        val DeadlineEt: EditText = findViewById(R.id.Regideadline)

        val PrizeEt: EditText = findViewById(R.id.Prize)

       val ParticipanttypeSpinner :Spinner = findViewById(R.id.ParticipantForm)
        ArrayAdapter.createFromResource(
            this,
            R.array.Participanttypes_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            ParticipanttypeSpinner.adapter = adapter
        }

        val TournamenttypeSpinner :Spinner = findViewById(R.id.TournamentType)
        ArrayAdapter.createFromResource(
            this,
            R.array.Tournamenttypes_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            TournamenttypeSpinner.adapter = adapter
        }

        val createBtn: Button = findViewById(R.id.buttonCreateTournament)
        createBtn.setOnClickListener{
            createTournamentPresenter.onCreateBtnClicked()
        }
    }

    override fun onResume() {
        super.onResume()
        createTournamentPresenter.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        createTournamentPresenter.onDetach()
    }

    override fun navigateToHomepageActivity() {
        //Will not be implemented
    }

    override fun navigateToLoginActivity() {
        //Will not be implemented
    }

    override fun navigateToTournamentActivity() {
        val tIntent = Intent(this, TournamentActivity::class.java)
        startActivity(tIntent)
    }

    override fun showErrorOnTournamentName(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }

    override fun showErrorOnLocation(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }

    override fun showErrorOnTime(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }

    override fun showErrorOnMaxPlayers(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }

    override fun showErrorOnRegistrationTime(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }

    override fun showErrorOnPrize(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }

    override fun showProgress() {
        TODO("Not yet implemented")
    }

    override fun hideProgress() {
        TODO("Not yet implemented")
    }

    override fun showError(errorMessage: String) {
        Toast.makeText(applicationContext, errorMessage, Toast.LENGTH_LONG).show()
    }

    override fun showError(errorId: Int) {
        Toast.makeText(applicationContext, errorId, Toast.LENGTH_LONG).show()
    }
}