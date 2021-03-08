package com.android3.siegertpclient.ui.createtournament

import android.content.Intent
import android.os.Bundle
import android.widget.*
import com.android3.siegertpclient.R
import com.android3.siegertpclient.R.*
import com.android3.siegertpclient.R.id.*
import com.android3.siegertpclient.ui.base.BaseActivity
import com.android3.siegertpclient.ui.forgotpassword.ForgotPasswordPresenter
import com.android3.siegertpclient.ui.homepage.HomepageActivity
import com.android3.siegertpclient.ui.login.LoginActivity
import com.android3.siegertpclient.ui.register.RegisterActivity

import com.android3.siegertpclient.ui.tournament.TournamentActivity

import android.widget.Spinner as Spinner

/**
 * This class is to implement the activity to create the tournament.
 */
class CreateTournamentActivity : BaseActivity(), CreateTournamentContract.ICreateTournamentView{

    //The presenter that to create the tournament.
    private val createTournamentPresenter: CreateTournamentPresenter = CreateTournamentPresenter()

    //This method is to create the view of the createTournament page.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_createtournament)

        val NameEt: EditText = findViewById()

        val DateEt: EditText = findViewById(Date)

        val MaxPlayerEt: EditText = findViewById(MaxPlayer)

        val LocationEt: EditText = findViewById(Location)

        val DeadlineEt: EditText = findViewById(Regideadline)

        val PrizeEt: EditText = findViewById(Prize)

       val ParticipanttypeSpinner : Spinner = findViewById(ParticipantForm)
        ArrayAdapter.createFromResource(
            this,
            array.Participanttypes_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            ParticipanttypeSpinner.adapter = adapter
        }

        val GametypeSpinner : Spinner = findViewById(TypeOfGame1)
        ArrayAdapter.createFromResource(
            this,
            array.TypeOfGame_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            ParticipanttypeSpinner.adapter = adapter
        }

        val TournamenttypeSpinner : Spinner = findViewById(TournamentType)
        ArrayAdapter.createFromResource(
            this,
            array.Tournamenttypes_array,
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

    //To start the instance state.
    override fun onResume() {
        super.onResume()
        createTournamentPresenter.onAttach(this)
    }

    //To destroy the instance state.
    override fun onDestroy() {
        super.onDestroy()
        createTournamentPresenter.onDetach()
    }

    override fun navigateToHomepageActivity() {
        val hIntent = Intent(this, HomepageActivity::class.java)
        startActivity(hIntent)
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

    override fun showNoInternetConnection() {
        TODO("Not yet implemented")
    }
}