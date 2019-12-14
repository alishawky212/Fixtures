package com.example.fixturesapplication.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.useCases.getMatches.GetMatchesStrategy

import com.example.fixturesapplication.R
import com.example.fixturesapplication.model.ListItem
import com.example.fixturesapplication.model.UIState
import com.example.fixturesapplication.setDivider
import com.example.fixturesapplication.view.adapters.MatchesAdapter
import com.example.fixturesapplication.viewModel.MatchesViewModel
import com.example.fixturesapplication.viewModel.ViewModelFactory
import com.facebook.shimmer.Shimmer
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_matches.*
import javax.inject.Inject


private const val TYPE = "type"

class MatchesFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var matchesAdapter: MatchesAdapter

    private var type:GetMatchesStrategy.Factory.Type = GetMatchesStrategy.Factory.Type.FULL

    private lateinit var viewModel: MatchesViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[MatchesViewModel::class.java]
        arguments?.let {
            type = it.getSerializable(TYPE) as GetMatchesStrategy.Factory.Type
        }
        viewModel.type = type
        if (savedInstanceState == null)
            viewModel.getMatches()
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.matches_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMatchesRecyclerView()

        viewModel.matchesLiveData.observe(viewLifecycleOwner, matchesObserver)
    }

    private val matchesObserver = Observer<UIState<ListItem>> {
        render(it)
    }

    private fun render(it: UIState<ListItem>?) {
        when (it) {
            UIState.LoadingState -> {
                rcMatches.isVisible = false
                shimmer_view.isVisible = true
                val builder = Shimmer.AlphaHighlightBuilder()
                builder.setDuration(1250)
                builder.setDirection(Shimmer.Direction.LEFT_TO_RIGHT)
                shimmer_view.setShimmer(builder.build())
                shimmer_view.startShimmer()
            }
            is UIState.SuccessState -> showData(it.data)
            is UIState.ErrorState -> {
                shimmer_view.isVisible = false
                shimmer_view.stopShimmer()
                rcMatches.isVisible = true
                Toast.makeText(context, "There is an Issue", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showData(data:List<ListItem>){
        shimmer_view.isVisible = false
        rcMatches.isVisible = true
        shimmer_view.stopShimmer()
        matchesAdapter.setMatchesList(data)
    }

    private fun initMatchesRecyclerView(){
        rcMatches.layoutManager = LinearLayoutManager(context)
        rcMatches.adapter = matchesAdapter
        rcMatches.setDivider(R.drawable.divider)
        runLayoutAnimation()
        matchesAdapter.favoriteClickHandler = { uiModel, isFavorite ->
            if (isFavorite)
                viewModel.favoriteMatch(uiModel)
            else
                viewModel.unFavoriteMatch(uiModel)

        }
    }

    private fun runLayoutAnimation() = rcMatches.apply {
        layoutAnimation = AnimationUtils.loadLayoutAnimation(context,R.anim.layout_animation_from_bottom)
        scheduleLayoutAnimation()
        layoutAnimationListener = object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                layoutManager?.findViewByPosition(0)?.clearAnimation()
            }
            override fun onAnimationEnd(animation: Animation?) = Unit
            override fun onAnimationRepeat(animation: Animation?) = Unit
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(type:GetMatchesStrategy.Factory.Type) =
            MatchesFragment().apply {
              this.arguments = Bundle().also {
                    it.putSerializable(TYPE,type)
                }
            }
    }
}
