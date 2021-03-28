package com.android3.siegertpclient.ui.createtournament

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import com.android3.siegertpclient.R.*
import com.android3.siegertpclient.R.id.*
import com.android3.siegertpclient.databinding.ActivityCreatetournamentBinding
import com.android3.siegertpclient.ui.base.BaseActivity
import com.android3.siegertpclient.ui.homepage.HomepageActivity

import com.android3.siegertpclient.ui.tournament.TournamentActivity
import java.util.*

/**
 * This class is to implement the activity to create the tournament.
 */
class CreateTournamentActivity : BaseActivity(), CreateTournamentContract.ICreateTournamentView {
    private lateinit var binding: ActivityCreatetournamentBinding

    //The presenter that to create the tournament.
    private lateinit var createTournamentPresenter: CreateTournamentPresenter

    var day = 0
    var month = 0
    var year = 0

    //This method is to create the view of the createTournament page.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCreatetournamentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createTournamentPresenter = CreateTournamentPresenter(this)

        val nameEt = binding.etTournamentName
        val typeOfGameEt = binding.etTypeOfGame

        var matchType = ""
        binding.spMatchType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                matchType = adapterView?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        var tournamentType = ""
        binding.spTournamentType.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    adapterView: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    tournamentType = adapterView?.getItemAtPosition(position).toString()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }
            }

        var participantForm = ""
        binding.spParticipantForm.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    adapterView: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    participantForm = adapterView?.getItemAtPosition(position).toString()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }
            }

        binding.btnRegistrationDeadline.setOnClickListener {
            getDateCalendar()
            DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    var monthCalibrate = monthOfYear + 1
                    val monthFix = if (monthCalibrate <= 10) "0$monthCalibrate" else monthCalibrate.toString()
                    val dayFix = if (dayOfMonth <= 10) "0$dayOfMonth" else dayOfMonth.toString()
                    binding.btnRegistrationDeadline.text = "$year-$monthFix-$dayFix"
                },
                year,
                month,
                day
            ).show()
        }

        binding.btnStartDate.setOnClickListener {
            getDateCalendar()
            DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    var monthCalibrate = monthOfYear + 1
                    val monthFix = if (monthCalibrate <= 10) "0$monthCalibrate" else monthCalibrate.toString()
                    val dayFix = if (dayOfMonth <= 10) "0$dayOfMonth" else dayOfMonth.toString()
                    binding.btnStartDate.text = "$year-$monthFix-$dayFix"
                },
                year,
                month,
                day
            ).show()
        }

        binding.btnEndDate.setOnClickListener {
            getDateCalendar()
            DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    var monthCalibrate = monthOfYear + 1
                    val monthFix = if (monthCalibrate <= 10) "0$monthCalibrate" else monthCalibrate.toString()
                    val dayFix = if (dayOfMonth <= 10) "0$dayOfMonth" else dayOfMonth.toString()
                    binding.btnEndDate.text = "$year-$monthFix-$dayFix"
                },
                year,
                month,
                day
            ).show()
        }

        val locationEt = binding.etLocation
        binding.etMaxPlayer.setText("0")

        binding.btnCreate.setOnClickListener {
            val name = editTextTrimmer(nameEt)
            val typeOfGame = editTextTrimmer(typeOfGameEt)
            val registrationDeadline = binding.btnRegistrationDeadline.text.toString()
            val startTime = binding.btnStartDate.text.toString()
            val endTime = binding.btnEndDate.text.toString()
            val location = editTextTrimmer(locationEt)
            val maxParticipantNumber = binding.etMaxPlayer.text.toString().toInt()

            createTournamentPresenter.onCreateBtnClicked(
                name,
                typeOfGame,
                matchType,
                tournamentType,
                participantForm,
                registrationDeadline,
                startTime,
                endTime,
                location,
                maxParticipantNumber
            )
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

    override fun showIncompleteInput() {
        doToast("Please input all of the field")
    }

    override fun showSuccess() {
        doToast("Your tournament has been successfully created")
    }

    override fun navigateToHomepageActivity() {
        val intent = Intent(this@CreateTournamentActivity, HomepageActivity::class.java)
        startActivity(intent)
    }

    override fun navigateToTournamentActivity() {
        val intent = Intent(this@CreateTournamentActivity, TournamentActivity::class.java)
        startActivity(intent)
    }

    override fun showProgress() {
        binding.pbRequest.visibility = View.VISIBLE
        binding.btnCreate.isEnabled = false
    }

    override fun hideProgress() {
        binding.pbRequest.visibility = View.GONE
        binding.btnCreate.isEnabled = true
    }

    override fun showError(errorMessage: String) {
        doToast(errorMessage)
    }

    override fun showNoInternetConnection() {
        doToast("There's no internet connection to make the request.")
    }

    private fun getDateCalendar() {
        val cal = Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)
    }

    private fun editTextTrimmer(editText: EditText): String {
        return editText.text.toString().trim { it <= ' ' }
    }

    private fun doToast(message: String) {
        Toast.makeText(this@CreateTournamentActivity, message, Toast.LENGTH_LONG).show()
    }
}