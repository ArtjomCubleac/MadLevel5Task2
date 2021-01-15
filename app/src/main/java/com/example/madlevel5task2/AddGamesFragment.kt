package com.example.madlevel5task2

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.madlevel5task2.Game.Game
import com.example.madlevel5task2.Game.GameRepository
import com.example.madlevel5task2.Game.GameViewModel
import kotlinx.android.synthetic.main.fragment_games_add.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddGamesFragment : Fragment() {

    private lateinit var gameRepository: GameRepository
    private val mainScope = CoroutineScope(Dispatchers.Main)

    private val gameViewModel: GameViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_games_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().invalidateOptionsMenu()

        gameRepository = GameRepository(requireContext())

        fabSaveGame.setOnClickListener {
            saveGame()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.findItem(R.id.action_delete_all_games).isVisible = false
    }

    @SuppressLint("SimpleDateFormat")
    private fun dateInputFormat(): Date {
        val dateString: String = etGameDay.text.toString() +
                etGameMonth.text.toString() +
                etGameYear.text.toString()

        return SimpleDateFormat("dMyyyy").parse(dateString)
    }

    private fun saveGame() {
        val game = Game(
            title = etGameTitle.text.toString(),
            platform = etGamePlatform.text.toString(),
            date = dateInputFormat()
        )

        gameViewModel.insertGame(game)
        findNavController().navigate(R.id.action_addGamesFragment_to_gameListFragment)
    }


}