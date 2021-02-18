package com.android3.siegertpclient.ui.createtournament

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import com.android3.siegertpclient.R
import com.android3.siegertpclient.ui.base.BaseActivity
import com.android3.siegertpclient.ui.forgotpassword.ForgotPasswordPresenter

class CreateTournamentActivity : BaseActivity() {

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

        val createBtn: Button = findViewById(R.id.buttoncreate)
        createBtn.setOnClickListener{
            createTournamentPresenter.onCreateBtnClicked()
        }
    }

    override fun onResume() {
        super.onResume()
        CreateTournamentPresenter.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        CreateTournamentPresenter.onDetach()
    }
    override fun showProgress() {
        TODO("Not yet implemented")
    }

    override fun hideProgress() {
        TODO("Not yet implemented")
    }

    override fun showError(errorMessage: String) {
        TODO("Not yet implemented")
    }

    override fun showError(errorId: Int) {
        TODO("Not yet implemented")
    }
}