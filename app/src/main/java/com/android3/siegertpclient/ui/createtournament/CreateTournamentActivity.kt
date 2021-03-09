package com.android3.siegertpclient.ui.createtournament

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import com.android3.siegertpclient.R
import com.android3.siegertpclient.R.*
import com.android3.siegertpclient.R.id.*
import com.android3.siegertpclient.databinding.ActivityCreatetournamentBinding
import com.android3.siegertpclient.databinding.ActivityLoginBinding
import com.android3.siegertpclient.databinding.ActivityRegisterBinding
import com.android3.siegertpclient.ui.base.BaseActivity
import com.android3.siegertpclient.ui.forgotpassword.ForgotPasswordPresenter
import com.android3.siegertpclient.ui.homepage.HomepageActivity
import com.android3.siegertpclient.ui.login.LoginActivity
import com.android3.siegertpclient.ui.login.LoginPresenter
import com.android3.siegertpclient.ui.register.RegisterActivity
import com.android3.siegertpclient.ui.register.RegisterPresenter

import com.android3.siegertpclient.ui.tournament.TournamentActivity
import java.util.*

import android.widget.Spinner as Spinner

/**
 * This class is to implement the activity to create the tournament.
 */
class CreateTournamentActivity : BaseActivity(), CreateTournamentContract.ICreateTournamentView, DatePickerDialog.OnDateSetListener {
    private lateinit var binding: ActivityCreatetournamentBinding
    //The presenter that to create the tournament.
    private lateinit var createTournamentPresenter: CreateTournamentPresenter

    var day = 0
    var month = 0
    var year = 0

    var savedDay = 0
    var savedMonth = 0
    var savedYear = 0

    //This method is to create the view of the createTournament page.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCreatetournamentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createTournamentPresenter = CreateTournamentPresenter(this)

        val nameEt = binding.etTournamentName
        val typeOfGameEt = binding.etTypeOfGame

        binding.spMatchType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //Dummy implementation
                val dummyString = adapterView?.getItemAtPosition(position).toString()
                Toast.makeText(this@CreateTournamentActivity, "You choose the Game :: ".plus(dummyString), Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        binding.spTournamentType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //Dummy implementation
                val dummyString = adapterView?.getItemAtPosition(position).toString()
                Toast.makeText(this@CreateTournamentActivity, "You choose the Tournament  :: ".plus(dummyString), Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        binding.spParticipantForm.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //Dummy implementation
                val dummyString = adapterView?.getItemAtPosition(position).toString()
                Toast.makeText(this@CreateTournamentActivity, "You choose the Participant  :: ".plus(dummyString), Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        binding.btnRegistrationDeadline.setOnClickListener {
            getDateCalendar()
            DatePickerDialog(this, this, year, month, day).show()
            binding.btnRegistrationDeadline.text = "$savedYear-$savedMonth-$savedDay"
        }

        binding.btnStartTime.setOnClickListener {

        }

        binding.btnEndTime.setOnClickListener {

        }

        val locationEt = binding.etLocation
        val maxPlayersEt = binding.etMaxPlayer

        binding.btnCreateTournament.setOnClickListener{
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

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        savedDay = dayOfMonth
        savedMonth = month
        savedYear = year
    }

    private fun getDateCalendar() {
        val cal = Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)
    }
}