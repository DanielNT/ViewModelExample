package com.danielnt.pruebasmaterial.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.danielnt.pruebasmaterial.R
import kotlinx.android.synthetic.main.main_fragment.*


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val view = inflater.inflate(R.layout.main_fragment, container, false)

        with(view) {
            findViewById<Button>(R.id.bt_A3).setOnClickListener { addScoreForTeam("A", 3) }
            findViewById<Button>(R.id.bt_A2).setOnClickListener { addScoreForTeam("A", 2) }
            findViewById<Button>(R.id.bt_A1).setOnClickListener { addScoreForTeam("A", 1) }
            findViewById<Button>(R.id.bt_reset).setOnClickListener { resetScore() }
            findViewById<Button>(R.id.bt_B3).setOnClickListener { addScoreForTeam("B", 3) }
            findViewById<Button>(R.id.bt_B2).setOnClickListener { addScoreForTeam("B", 2) }
            findViewById<Button>(R.id.bt_B1).setOnClickListener { addScoreForTeam("B", 1) }
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
        displayForTeamA(viewModel.scoreTeamA)
        displayForTeamB(viewModel.scoreTeamB)
    }

    private fun addScoreForTeam(team: String, score: Int) {
        when (team) {
            "A" -> {
                viewModel.scoreTeamA += score
                displayForTeamA(viewModel.scoreTeamA)
            }
            "B" -> {
                viewModel.scoreTeamB += score
                displayForTeamB(viewModel.scoreTeamB)
            }
            else -> {
            }
        }
    }

    /**
     * Resets the score for both teams back to 0.
     */
    private fun resetScore() {
        viewModel.scoreTeamA = 0
        viewModel.scoreTeamB = 0
        displayForTeamA(viewModel.scoreTeamA)
        displayForTeamB(viewModel.scoreTeamB)
    }

    /**
     * Displays the given score for Team A.
     */
    private fun displayForTeamA(score: Int) {
        team_a_score.text = score.toString()
    }

    /**
     * Displays the given score for Team B.
     */
    private fun displayForTeamB(score: Int) {
        team_b_score.text = score.toString()
    }

}
