package com.example.domain.useCases

import com.example.domain.models.Match
import com.example.domain.repository.FavoriteRepository
import io.reactivex.Completable
import javax.inject.Inject

class AddMatchToFavoriteUseCase @Inject constructor(
    private val localRepository: FavoriteRepository) {
    fun favoriteMatch(match:Match):Completable{
        return localRepository.insertMatch(match)
    }
}