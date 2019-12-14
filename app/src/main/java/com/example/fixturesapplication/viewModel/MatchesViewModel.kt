package com.example.fixturesapplication.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.useCases.RemoveMatchFromFavoriteUseCase
import com.example.domain.useCases.AddMatchToFavoriteUseCase
import com.example.domain.useCases.getMatches.GetMatchesStrategy
import com.example.fixturesapplication.model.UIState
import com.example.fixturesapplication.di.modules.IO_SCHEDULER
import com.example.fixturesapplication.model.ListItem
import com.example.fixturesapplication.model.MatchUIModel
import com.example.fixturesapplication.model.mappers.MatchUIMapper
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Named

class MatchesViewModel @Inject constructor(
    private val factory:GetMatchesStrategy.Factory,
    private val saveMatchUseCase: AddMatchToFavoriteUseCase,
    private val removeMatchUseCase: RemoveMatchFromFavoriteUseCase,
    private val matchUIMapper: MatchUIMapper,
    @Named(value = IO_SCHEDULER) private val ioScheduler: Scheduler
) : ViewModel(){

    lateinit var matchesStrategy: GetMatchesStrategy

    private val compositeDisposable = CompositeDisposable()

    var type: GetMatchesStrategy.Factory.Type? = null
        set(value) {
            field = value
            value?.let {
                matchesStrategy = factory.get(value)
            }
        }

    private val matches = MutableLiveData<UIState<ListItem>>()


    val matchesLiveData:LiveData<UIState<ListItem>>
        get() = matches



    fun getMatches(){
        compositeDisposable.add(matchesStrategy.get()
            .doOnSubscribe { matches.postValue(UIState.LoadingState)}
            .subscribeOn(ioScheduler)
            .observeOn(ioScheduler)
            .map { matchUIMapper.mapToPresentation(it) }
            .subscribe({
                matches.postValue(UIState.SuccessState(it))
            },{
                matches.postValue(UIState.ErrorState(it.localizedMessage))
            }))
    }

    fun favoriteMatch(match: MatchUIModel){
        compositeDisposable.add(saveMatchUseCase.favoriteMatch(matchUIMapper.mapToDomain(match))
            .doOnError {
                Log.d("",it.localizedMessage)
            }
            .subscribeOn(ioScheduler)
            .observeOn(ioScheduler).subscribe())
    }

    fun unFavoriteMatch(match: MatchUIModel){
        compositeDisposable.add(removeMatchUseCase.removeMatch(matchUIMapper.mapToDomain(match))
            .doOnError {
                Log.d("",it.localizedMessage)
            }
            .subscribeOn(ioScheduler)
            .observeOn(ioScheduler)
            .subscribe())
    }

}